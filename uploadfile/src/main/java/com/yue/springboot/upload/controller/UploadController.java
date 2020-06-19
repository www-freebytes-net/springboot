package com.yue.springboot.upload.controller;


import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/uploadProgress")
public class UploadController {

    @RequestMapping(value = "/showUpload1", method = RequestMethod.HEAD)
    public String showUpload1() {
        return "dsddsdsddsddsdds";
    }

    @RequestMapping(value = "/showUpload", method = RequestMethod.GET)
    public ModelAndView showUpload() {
        return new ModelAndView("/UploadProgressDemo");
    }

    @RequestMapping("/upload")
    @ResponseBody
    public void uploadFile(HttpServletRequest request) {
        System.out.println(request.getSession().getId());
    }


    @RequestMapping("/upload_back")
    @ResponseBody
    public void upload_back(HttpServletRequest request) {
        System.out.println(request.getSession().getId());
    }

    @RequestMapping("/upload1")
    @ResponseBody
    public void uploadFile1(HttpServletRequest request) throws IOException, ServletException {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setRepository(new File("D:/tmp"));
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> fileItems;
        FileItem fileItem;
        try {
            fileItems = upload.parseRequest(new ServletRequestContext(request));
            fileItem = fileItems.get(0);
            System.out.println(fileItem.getName());
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }


}