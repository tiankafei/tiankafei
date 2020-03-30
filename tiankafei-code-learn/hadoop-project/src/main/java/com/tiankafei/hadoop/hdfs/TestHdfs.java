package com.tiankafei.hadoop.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.BlockLocation;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URI;

/**
 * @Author 魏双双
 * @Date 2019/12/13
 * @Version V1.0
 **/
public class TestHdfs {

    private FileSystem fs = null;
    public Configuration conf = new Configuration(true);


    @Before
    public void before() throws Exception {
        URI url = new URI("hdfs://mycluster");
        fs = FileSystem.get(url, conf, "root");
    }

    @Test
    public void mkdir() throws Exception {
        Path path = new Path("/user/root");
        if (fs.exists(path)) {
            fs.delete(path, true);
        }
        fs.mkdirs(path);
    }

    @Test
    public void upload() throws Exception {
        Path remoteFilePath = new Path("/user/root/hadoop-2.9.2.tar.gz");
        if (fs.exists(remoteFilePath)) {
            fs.delete(remoteFilePath, true);
        }
        FileInputStream fileInputStream = null;
        BufferedInputStream bufferedInputStream = null;
        try {
            fileInputStream = new FileInputStream(new File("G:\\developmentTools\\linux-software\\hadoop-2.9.2.tar.gz"));
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            FSDataOutputStream outputStream = fs.create(remoteFilePath);

            IOUtils.copyBytes(bufferedInputStream, outputStream, conf, true);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
        }
    }

    @Test
    public void getFileBlock() throws Exception {
        Path remoteFilePath = new Path("/user/root/hadoop-2.9.2.tar.gz");
        FileStatus fileStatus = fs.getFileStatus(remoteFilePath);
        BlockLocation[] blockLocations = fs.getFileBlockLocations(fileStatus, 0, fileStatus.getLen());
        for (BlockLocation blockLocation : blockLocations) {
            System.out.println(blockLocation);
        }
    }

    @After
    public void after() throws Exception {
        fs.close();
    }

}
