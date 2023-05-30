package com.example.imagetest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/")
public class MyController {
    @PostMapping("/file")
    public String getFile(HttpSession session, MultipartFile file) throws IOException {
        String path = session.getServletContext().getRealPath("upload");
        File realPathFile = new File(path);
        if (!realPathFile.exists()) {
            realPathFile.mkdir();
        }
        String realPath = session.getServletContext().getRealPath("/upload");
        String originalFilename = file.getOriginalFilename();
        String systemFilename = UUID.randomUUID()+"_"+originalFilename;
        File savedFile = new File(realPath + "/" + systemFilename);
        file.transferTo(savedFile);
        Image image = new ImageIcon(savedFile.toString()).getImage();
        System.out.println("image.Height = " + image.getHeight(null));
        System.out.println("image.Width = " + image.getWidth(null));
        return "file";
    }
}
