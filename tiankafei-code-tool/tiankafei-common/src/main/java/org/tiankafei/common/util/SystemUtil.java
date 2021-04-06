package org.tiankafei.common.util;

import com.google.common.collect.Lists;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import org.tiankafei.common.enums.BaseEnum;
import org.tiankafei.common.exceptions.CommonException;

/**
 * 系统工具处理类
 *
 * @Author tiankafei
 * @Date 2019/10/22
 * @Version V1.0
 **/
public class SystemUtil {

    private static Properties systemProperties;

    static {
        try {
            systemProperties = System.getProperties();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private SystemUtil() {

    }

    public static void main(String[] args) {
        String ip = SystemUtil.getIp();
        System.out.println(ip);
    }

    /**
     * 获取IP
     *
     * @return 返回当前IP
     */
    public static String getIp() {
        InetAddress inetAddress = getLocalHostLanAddress();
        return inetAddress.getHostAddress();
    }

    /**
     * 获取用户计算机名称
     *
     * @return 返回当前计算机名称
     */
    public static String getHostName() {
        InetAddress inetAddress = getLocalHostLanAddress();
        return inetAddress.getHostName();
    }

    /**
     * 获取mac地址
     *
     * @return 当回当前MAC地址
     */
    public static String getMac() {
        try {
            InetAddress inetAddress = getLocalHostLanAddress();
            NetworkInterface networkInterface = NetworkInterface.getByInetAddress(inetAddress);
            byte[] byteArray = networkInterface.getHardwareAddress();
            return getMacFromBytes(byteArray);
        } catch (SocketException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取本机ip地址
     *
     * @return 本机ip地址
     */
    private static InetAddress getLocalHostLanAddress() {
        try {
            InetAddress candidateAddress = null;
            // 遍历所有的网络接口
            for (Enumeration ifaces = NetworkInterface.getNetworkInterfaces(); ifaces.hasMoreElements(); ) {
                NetworkInterface iface = (NetworkInterface) ifaces.nextElement();
                if (iface.getDisplayName().toLowerCase().contains("vir")) {
                    //排出虚拟机ip
                    continue;
                }
                // 在所有的接口下再遍历IP
                for (Enumeration inetAddrs = iface.getInetAddresses(); inetAddrs.hasMoreElements(); ) {
                    InetAddress inetAddr = (InetAddress) inetAddrs.nextElement();
                    // 排除loopback类型地址
                    if (!inetAddr.isLoopbackAddress()) {
                        if (inetAddr != null && inetAddr instanceof Inet4Address && !BaseEnum.LOCAL_IP_DEFAULT.getValue().equals(inetAddr.getHostAddress())) {
                            // 如果是site-local地址，就是它了
                            return inetAddr;
                        } else if (candidateAddress == null) {
                            // site-local类型的地址未被发现，先记录候选地址
                            candidateAddress = inetAddr;
                        }
                    }
                }
            }
            if (candidateAddress != null) {
                return candidateAddress;
            }
            // 如果没有发现 non-loopback地址.只能用最次选的方案
            return InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            throw new CommonException("未知的主机！");
        } catch (SocketException e) {
            e.printStackTrace();
            throw new CommonException("连接失败！");
        }
    }

    /**
     * 获取系统名称
     *
     * @return 返回当前系统名称
     */
    public static String getSystemName() {
        return systemProperties.getProperty("os.name");
    }

    /**
     * 获取系统版本
     *
     * @return 返回系统版本
     */
    public static String getSystemVerison() {
        return systemProperties.getProperty("os.version");
    }

    /**
     * 执行linux命令
     *
     * @param fileName linux命令的文件
     * @param flag     为true返回读取控制台信息，为false返回空集合
     * @return 返回执行命令后的结果集
     */
    public static List<String> executionLinuxCommand(String fileName, boolean flag) {
        try {
            List<String> list = Lists.newArrayList();
            String a = "/bin/sh";
            String b = "-c";
            String c = "xterm -e /bin/bash -c '/bin/sh " + fileName + "; sleep 1'";
            String[] cmd = {a, b, c};
            Process process = Runtime.getRuntime().exec(cmd);
            if (flag) {
                list = readConsoleInfo(process);
            }
            process.waitFor();
            process.destroy();
            File file = new File(fileName);
            if (file.exists()) {
                file.delete();
            }
            return list;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new CommonException("执行过程中发生中断！");
        } catch (IOException e) {
            e.printStackTrace();
            throw new CommonException("访问数据失败！");
        }
    }

    /**
     * 执行windows命令
     *
     * @param command window命令
     * @param flag    为true返回读取控制台信息，为false返回空集合
     * @return 返回执行命令后的结果集
     */
    public static List<String> executionWindowsCommand(String command, boolean flag) {
        try {
            List<String> list = Lists.newArrayList();
            Process process = Runtime.getRuntime().exec("cmd.exe /c start " + command);
            if (flag) {
                list = readConsoleInfo(process);
            }
            process.waitFor();
            process.destroy();
            return list;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new CommonException("执行过程中发生中断！");
        } catch (IOException e) {
            e.printStackTrace();
            throw new CommonException("访问数据失败！");
        }
    }

    /**
     * 读取执行完命令后，控制台输出的信息
     *
     * @param process
     * @return 返回执行命令后的结果集
     */
    private static List<String> readConsoleInfo(Process process) {
        InputStreamReader ir = null;
        LineNumberReader input = null;
        try {
            List<String> list = Lists.newArrayList();
            ir = new InputStreamReader(process.getInputStream());
            input = new LineNumberReader(ir);
            String line;
            while ((line = input.readLine()) != null) {
                list.add(line);
            }
            process.destroy();
            return list;
        } catch (IOException e) {
            e.printStackTrace();
            throw new CommonException("访问数据失败！");
        } finally {
            DataStreamUtil.closeReader(input);
            DataStreamUtil.closeReader(ir);
        }
    }

    /**
     * 字节转换mac地址
     *
     * @param byteArray
     * @return 返回mac地址
     */
    private static String getMacFromBytes(byte[] byteArray) {
        StringBuffer mac = new StringBuffer();
        byte currentByte;
        boolean first = false;
        for (int i = 0, lem = byteArray.length; i < lem; i++) {
            byte bytes = byteArray[i];
            if (first) {
                mac.append("-");
            }
            currentByte = (byte) ((bytes & 240) >> 4);
            mac.append(Integer.toHexString(currentByte));
            currentByte = (byte) (bytes & 15);
            mac.append(Integer.toHexString(currentByte));
            first = true;
        }
        return mac.toString().toUpperCase();
    }

}
