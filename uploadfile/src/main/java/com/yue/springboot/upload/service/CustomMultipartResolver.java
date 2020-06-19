package com.yue.springboot.upload.service;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

public class CustomMultipartResolver extends CommonsMultipartResolver {
    @Override
    public String toString() {
        return "重写commons-fileupload的解析器";
    }

    @Autowired
    private UploadProgressListener uploadProgressListener;

    @Override
    protected MultipartParsingResult parseRequest(HttpServletRequest request) throws MultipartException {
        boolean multipart = isMultipart(request);
        if (!multipart) {
            return null;
        }
        String encoding = determineEncoding(request);
        FileUpload fileUpload = prepareFileUpload(encoding);
        fileUpload.setSizeMax(-1);
        fileUpload.setFileSizeMax(-1);
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setRepository(new File("D:/tmp"));
//        factory.setFileCleaningTracker();
        fileUpload.setFileItemFactory(factory);
        uploadProgressListener.setSession(request.getSession());//问文件上传进度监听器设置session用于存储上传进度
        fileUpload.setProgressListener(uploadProgressListener);//将文件上传进度监听器加入到 fileUpload 中
        try {
            List<FileItem> fileItems = ((ServletFileUpload) fileUpload).parseRequest(request);
            return parseFileItems(fileItems, encoding);
        } catch (FileUploadBase.SizeLimitExceededException ex) {
            throw new MaxUploadSizeExceededException(fileUpload.getSizeMax(), ex);
        } catch (FileUploadBase.FileSizeLimitExceededException ex) {
            throw new MaxUploadSizeExceededException(fileUpload.getFileSizeMax(), ex);
        } catch (FileUploadException ex) {
            throw new MultipartException("Failed to parse multipart servlet request", ex);
        }
    }
}