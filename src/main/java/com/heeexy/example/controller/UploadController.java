package com.heeexy.example.controller;

import com.heeexy.example.config.YmlConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;

/**
 * Created By HJ on 2019-30-30 11:30:54
 *
 * 说明:上传功能Controller
 */



@RestController
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private YmlConfig ymlConfig;


    @PostMapping("/uploadPic")
    public String uploadPic (HttpServletRequest request, HttpServletResponse response) {
        InputStream is;
        FileOutputStream fos;
//        String key = null;
        String fileName = null;
        String path = ymlConfig.getUploadDir();
        System.out.println("path的地址是："+path);
        File targetFile = null;
        String fileStringPath = "";
        try {
            Collection<Part> parts = request.getParts();
            Iterator<Part> iterator = parts.iterator();
            while (iterator.hasNext()) {
                Part part = iterator.next();
                //文件名
                String fileF = part.getSubmittedFileName();

                System.out.println("类型名称===="+ part.getName());
                System.out.println("=====类型===="+ part.getContentType());
                System.out.println("========提交的类型名称+++++"+ part.getSubmittedFileName());
                System.out.println("流++++++"+ part.getInputStream());

                //获取今天缓存图片的地址。否则创建（地址以年月日开头创建文件夹）
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                String fileAdd = sdf.format(new Date());
                File todayPathDir = new File(path + "/upload/" + fileAdd);
                if(!todayPathDir .exists()  && !todayPathDir .isDirectory()){
                    todayPathDir .mkdir();
                }

                //保存的文件名
                fileName=new Date().getTime()+"_"+new Random().nextInt(1000)+fileF;

//                保存在数据库的地址String
                if (StringUtils.isEmpty(fileStringPath)){
                    fileStringPath += ("/upload/" + fileAdd + "/" + fileName);
                }else{
                    fileStringPath = fileStringPath + "," + ("/upload/" + fileAdd + "/" + fileName);
                }

                targetFile = new File(todayPathDir,fileName);
                is = part.getInputStream();
                fos = new FileOutputStream(targetFile);
                try{
                    int b = 0;
                    while((b = is.read())!=-1){
                        fos.write(b);
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }finally {
                    fos.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileStringPath;
    }
}
