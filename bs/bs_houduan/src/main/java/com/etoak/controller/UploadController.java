package com.etoak.controller;

import com.etoak.utils.JsonResponse;
import com.etoak.utils.ResultStatus;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 文件上传
 */
@RestController
@Slf4j
public class UploadController {

  /** 读取application.yml的配置项 */
  @Value("${image.dir}")
  private String uploadDir;

  /** 读取application.yml的配置项 */
  @Value("${image.path}")
  private String pathPrefix;

  /** JPG图片类型的Content-Type */
  public static final String JPG = "image/jpeg";

  /** PNG图片类型的Content-Type */
  public static final String PNG = "image/png";

  /**
   * 文件上传接口   post /upload
   * @param file
   * @return
   */
  @PostMapping("/fileUpload")
  public JsonResponse upload(MultipartFile file) {
    /* 1. 判断文件是否为空 */
    if (ObjectUtils.isEmpty(file) || file.getSize() <= 0) {
      return ResultStatus.error("文件不能为空！");
    }

    /* 2. 判断文件类型 */
    String contentType = file.getContentType();
    if (!StringUtils.equalsAnyIgnoreCase(contentType, PNG, JPG)) {
      return ResultStatus.error("仅支持JPG或PNG格式的图片！");
    }

    /* 3. 修改文件名称 */
    String originalFilename = file.getOriginalFilename();

    // 文件扩展名称
    String extension = FilenameUtils.getExtension(originalFilename);
    String uuid = UUID.randomUUID().toString().replace("-", "");
    String newFilename = StringUtils.join(uuid, ".", extension);

    /* 4. 创建目标文件夹 */
    File destDir = new File(this.uploadDir);
    if (!destDir.exists()) {
      destDir.mkdirs();
    }

    /* 5. 创建目标文件 */
    File destFile = new File(destDir, newFilename);

    /* 6. 上传文件 */
    try {
      file.transferTo(destFile);
    } catch (IOException e) {
      log.error(e.getMessage(), e);
      return ResultStatus.error("图片上传失败！");
    }

    // 图片访问地址: /files/xxx.jpg
    String path = pathPrefix.endsWith("/") ?
        StringUtils.join(pathPrefix, newFilename) :
        StringUtils.join(pathPrefix, "/", newFilename);

    return ResultStatus.suc(path);
  }

}
