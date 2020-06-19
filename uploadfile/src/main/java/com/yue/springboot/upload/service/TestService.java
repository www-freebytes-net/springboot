package com.yue.springboot.upload.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.net.URL;

/**
 * Created by 千里明月 on 2018/7/25.
 */
@Service
public class TestService {

    private UploadProgressListener progressListener;

    public void tests(){
        System.out.println(progressListener);
    }

    @PostConstruct
    public   void testJar(){
        URL resource = this.getClass().getResource("/pom.properties");
        System.out.println(resource.getFile());
    }
}
