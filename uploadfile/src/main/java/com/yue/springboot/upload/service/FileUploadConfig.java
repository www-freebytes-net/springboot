//package com.yue.springboot.upload.service;
//
//import org.springframework.boot.autoconfigure.web.MultipartProperties;
//import org.springframework.web.multipart.MultipartResolver;
//
////@EnableAutoConfiguration(exclude = {MultipartAutoConfiguration.class})
////@Configuration
////@EnableConfigurationProperties(MultipartProperties.class)
//public class FileUploadConfig {
//    private final MultipartProperties multipartProperties;
//
//    public FileUploadConfig(MultipartProperties multipartProperties) {
//        this.multipartProperties = multipartProperties;
//    }
//
//    /**
//     * 注册解析器
//     *
//     * @return
//     */
////    @Bean(name = DispatcherServlet.MULTIPART_RESOLVER_BEAN_NAME)
////    @ConditionalOnMissingBean(MultipartResolver.class)
//    public MultipartResolver multipartResolver() {
//        CustomMultipartResolver multipartResolver = new CustomMultipartResolver();
//        multipartResolver.setResolveLazily(multipartProperties.isResolveLazily());
//        return multipartResolver;
//    }
//
//    /**
//     * 上传配置
//     *
//     * @return
//     */
////    @Bean
////    @ConditionalOnMissingBean
////    public MultipartConfigElement multipartConfigElement() {
////        return this.multipartProperties.createMultipartConfig();
////    }
//}