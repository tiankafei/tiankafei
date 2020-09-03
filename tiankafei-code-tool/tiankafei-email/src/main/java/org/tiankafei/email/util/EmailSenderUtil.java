package org.tiankafei.email.util;

import java.util.Properties;
import org.tiankafei.base.exceptions.BaseException;
import org.tiankafei.base.util.PropertiesUtil;
import org.tiankafei.email.dto.EmailSenderDTO;

/**
 * 发送邮件工具类
 *
 * @author tiankafei
 */
public class EmailSenderUtil {

    private EmailSenderUtil() {

    }

    /**
     * 发送邮件
     *
     * @param subject         邮件主题
     * @param content         右键内容
     * @param reciverUsername 接收用户
     * @return 发送成功返回true, 发送失败返回false
     * @throws BaseException 自定义异常
     */
    public static boolean senderEmail(String subject, String content, String reciverUsername) throws BaseException {
        try {
            Properties emailProperties = PropertiesUtil.getInstance("email.properties");

            // 这个类主要是设置邮件
            EmailSenderDTO emailSenderDTO = new EmailSenderDTO();
            emailSenderDTO.setMailServerHost(emailProperties.getProperty("emailHost"));
            emailSenderDTO.setMailServerPort(emailProperties.getProperty("emailHostPort"));
            emailSenderDTO.setValidate(true);

            String senderUsername = emailProperties.getProperty("senderUsername");
            String senderPassword = emailProperties.getProperty("senderPassword");

            emailSenderDTO.setUserName(senderUsername);
            // 您的邮箱密码
            emailSenderDTO.setPassword(senderPassword);
            emailSenderDTO.setFromAddress(senderUsername);
            emailSenderDTO.setToAddress(reciverUsername);
            emailSenderDTO.setSubject(subject);
            emailSenderDTO.setContent(content);

            // 这个类主要来发送邮件
            EmailContentSenderUtil sms = new EmailContentSenderUtil();
            // 发送文体格式
            return sms.sendTextMail(emailSenderDTO);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BaseException(e.getMessage());
        }
    }

}
