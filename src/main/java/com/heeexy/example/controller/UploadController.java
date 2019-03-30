package com.heeexy.example.controller;

import com.heeexy.example.config.YmlConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public void uploadFile () {
        ymlConfig.getDir();
    }
}
