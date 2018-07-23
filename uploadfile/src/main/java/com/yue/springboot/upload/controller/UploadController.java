package com.yue.springboot.upload.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/uploadProgress")
public class UploadController {

    @RequestMapping(value = "/showUpload", method = RequestMethod.GET)
    public ModelAndView showUpload() {
        return new ModelAndView("/UploadProgressDemo");
    }

    @RequestMapping("/upload")
    @ResponseBody
    public void uploadFile(MultipartFile file) {
        System.out.println(file.getOriginalFilename());
    }

    @RequestMapping("/upload1")
    @ResponseBody
    public void uploadFile1(MultipartFile file) {
        System.out.println(file.getSize());

    }
}