package org.mikudd3.controller;

/**
 * @project:
 * @author: mikudd3
 * @version: 1.0
 */

import org.mikudd3.common.R;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * @project: 文件上传合下载
 * @author: mikudd3
 * @version: 1.0
 */

@RestController
@RequestMapping("/common")
public class CommonController {

    @Value("${mikudd3.path}")
    private String basePath;

    /**
     * 文件上传
     *
     * @param file 必须与表单的name属性保持一致
     * @return
     */
    @PostMapping("/upload")
    public R<String> upload(MultipartFile file) {
        //原始文件名
        String originalFilename = file.getOriginalFilename();
        //截取后缀
        String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
        //使用UUID重新生成文件名，防止文件覆盖
        String filename = UUID.randomUUID().toString() + substring;
        //创建一个目录对象
        File dir = new File(basePath);
        //如果目录不存在
        if (!dir.exists()) {
            //目录不存在则创建新目录
            dir.mkdir();
        }
        try {
            file.transferTo(new File(basePath + filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.success(filename);
    }


    /**
     * 文件下载
     *
     * @param name
     * @param response
     */
    @GetMapping("/download")
    public void download(String name, HttpServletResponse response) {

        try {
            //输入流读取文件内容
            FileInputStream fi = new FileInputStream(new File(basePath + name));

            //输出流，通过输出流将文件写回浏览器，在浏览器中展示图片
            ServletOutputStream sos = response.getOutputStream();

            response.setContentType("image/.jpeg");
            int len = 0;
            byte[] bytes = new byte[1024];

            while ((len = fi.read(bytes)) != -1) {
                sos.write(bytes, 0, len);
                sos.flush();
            }

            //关闭资源
            fi.close();
            sos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
