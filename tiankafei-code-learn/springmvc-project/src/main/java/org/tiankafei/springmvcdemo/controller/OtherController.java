package org.tiankafei.springmvcdemo.controller;

import java.io.FileInputStream;
import java.net.URLEncoder;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OtherController {

    @RequestMapping("/testHttpEntity")
    public String testRequestBody(HttpEntity<String> httpEntity){
        System.out.println(httpEntity);
        return "success";
    }

    @RequestMapping("/testResponseEntity")
    public ResponseEntity<String> testResponseEntity(){

        String body = "<h1>hello</h1>";
        MultiValueMap<String,String> header = new HttpHeaders();
        header.add("Set-Cookie","name=zhangsan");
        return  new ResponseEntity<String>(body,header, HttpStatus.OK);
    }

    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取要下载文件的路径及输入流对象
        ServletContext servletContext = request.getServletContext();
        String fileName = "filter-servlet-inteceptor-controller执行顺序图.png";
        String realPath = servletContext.getRealPath("/images/" + fileName);
        FileInputStream fileInputStream = new FileInputStream(realPath);

        byte[] bytes = new byte[fileInputStream.available()];
        fileInputStream.read(bytes);
        fileInputStream.close();
        //将要下载文件内容返回
        HttpHeaders httpHeaders = new HttpHeaders();
        fileName = URLEncoder.encode(fileName,"utf-8");
        httpHeaders.set("Content-Disposition","attachment;filename=" + fileName);

        response.setCharacterEncoding("UTF-8");
        response.setContentType("multipart/form-data");

        return  new ResponseEntity<byte[]>(bytes,httpHeaders,HttpStatus.OK);
    }

}