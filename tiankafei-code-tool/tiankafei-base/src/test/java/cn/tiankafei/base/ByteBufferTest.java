package cn.tiankafei.base;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import org.junit.Test;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class ByteBufferTest {

    @Test
    public void testBuffer() throws Exception {
        RandomAccessFile accessFile = new RandomAccessFile("D:\\test1.txt", "rw");

        accessFile.write("hello world\nhello mashibing\ngood idea".getBytes());
        //在指定文件偏移量的位置添加ooxx，原来的数据被替换
        accessFile.seek(3);
        accessFile.write("ooxx".getBytes());

        //在堆上分配空间（在java进程里面，受Xmx配置的影响）
        ByteBuffer.allocate(4096);
        //在堆外分配空间（在java进程里面）
        ByteBuffer.allocateDirect(4096);

        FileChannel fileChannel = accessFile.getChannel();
        // 在堆外的MMAP上分配（在java进程外面）（只有文件才可以分配这样的区域）
        MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 13, 4096);
        // 会直接落到文件：从给指定偏移的位置开始添加，会替换要添加数据的长度的位置
        // 1、如果要添加的数据长度超过了4096，就会报java.nio.BufferOverflowException
        // 2、如果小于4096且大于原文件从偏移位置到文件末尾的长度，则会替换从偏移位置开始到文件末尾的所有数据，并从偏移位置开始占有4096个字节
        // 3、如果小于4096且小于源文件从偏移位置到文件末尾的长度，则会替换从偏移位置开始，到数据长度的位置结束，后面的不会替换，但是从偏移位置开始仍然占有4096个字节
        mappedByteBuffer.put("xxx".getBytes());
    }

    @Test
    public void testCal() {
        System.out.println(4 & 6);
        System.out.println(6 & 4);
        System.out.println(4 & 8);
        System.out.println(4 & 12);
        System.out.println(4 & 16);
        System.out.println(4 & 5);
        System.out.println(3 & 5);
        System.out.println(3 << 3);
        System.out.println(10 >> 3);
        System.out.println(16 >> 3);

    }

}
