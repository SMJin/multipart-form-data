package com.fileupload.multipart.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Collections;

@Slf4j
@RestController
public class MultipartController {
//    ef="/servlet/v1/upload">서블릿 파일 업로드1</a></li>
//            <li><a href="/servlet/v2/upload">서블릿 파일 업로드2</a></li>
//            <li><a href="/spring/upload">스프링 파일 업로드</a></li>
//            <li><a href="/items/new">상품

    @PostMapping("/upload")
    public void upload (HttpServletRequest request) throws ServletException, IOException {
        log.info("request = {}", request);

        log.info("request.getContentType = {}", request.getContentType());
        Part part = request.getPart("file");
        for (String header : part.getHeaderNames()) {
            log.info("part.getHeader({}) = {}", header, part.getHeader(header));
        }

        //데이터 읽기
        InputStream inputStream = part.getInputStream();
        String body = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        log.info("body={}", body);

        //파일에 저장하기
        if (StringUtils.hasText(part.getSubmittedFileName())) {
            String fullPath = "C:\\Users\\82104\\Documents\\" + part.getSubmittedFileName();
            log.info("파일 저장 fullPath={}", fullPath);
            part.write(fullPath);
        }
    }

    @PostMapping("/springUpload")
    public void springUpload(@RequestParam String filename,
                             @RequestParam MultipartFile multipartFile) throws IOException {
        log.info("filename = {}", filename);
        log.info("multipartFile.getName = {}", multipartFile.getName());
        log.info("multipartFile.getOriginalFilename = {}", multipartFile.getOriginalFilename());
        multipartFile.transferTo(new File("C:\\Users\\82104\\Documents\\" + filename));
    }

}
