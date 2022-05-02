package com.pjboy.riddler_reserve.service.util;

import com.pjboy.riddler_reserve.exception.CustomExceptionType;
import com.pjboy.riddler_reserve.exception.RrException;
import com.pjboy.riddler_reserve.model.ResourceDO;
import com.pjboy.riddler_reserve.model.util.ResourceTargetEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Repository
public class UploadTools {
    @Value("${file.img.imgList}")
    private List<String> list;
    @Value("${file.img.goodsCoverImgSource}")
    private String goodsCoverImgSource;


    /**
     * 上传图片
     *
     * @param uploadFolder 上传路径
     * @param file         文件
     * @param newFileName  新文件的名字
     * @return 是否上传成功
     */
    public boolean uploadImg(String uploadFolder, MultipartFile file, String newFileName) {
//        System.out.println("uploadFolder " + uploadFolder);
//        System.out.println("newFileName " + newFileName);
        String fileName = file.getOriginalFilename();
        if (StringUtils.isBlank(fileName))
            throw new RrException(CustomExceptionType.FILE_IS_NULL, "检测到上传的文件为空，请求失败！");
        String extensionName = fileName.substring(fileName.lastIndexOf("."));
        if (!list.contains(extensionName))
            throw new RrException(CustomExceptionType.FILE_IS_NULL, "检测到上传的文件类型错误，请求失败！");
        try {
            file.transferTo(new File(uploadFolder, newFileName));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RrException(CustomExceptionType.REQUEST_REFUSE, "上传文件失败！");
        }
        return true;
    }


    public void deleteFileByResources(List<ResourceDO> resources) {
        for (ResourceDO resource : resources) {
            ResourceTargetEnum type = ResourceTargetEnum.getResourceTargetEnumByValue(resource.getTargetType());
            if (type != null) {
                if (type == ResourceTargetEnum.GOODS) {
                    String url = goodsCoverImgSource + resource.getUrl();
                    File file = new File(url);
                    if (file.delete())
                        System.out.println("删除图片 " + resource.getUrl() + "成功");
                    else
                        System.err.println("删除图片 " + resource.getUrl() + "失败, 未找到该图片");
                }
            }

        }
    }
}
