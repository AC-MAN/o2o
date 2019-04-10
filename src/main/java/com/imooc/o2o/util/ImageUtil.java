package com.imooc.o2o.util;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


public class ImageUtil {
    private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    private static final SimpleDateFormat sDateFromat = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final Random r = new Random();
    public static String generateThumbnail(CommonsMultipartFile thumbnail,String tagetAddr){
        //获取系统随机给图片生成的文件名
        String realFileName = getRandomFileName();
        String extension = getFileExtension(thumbnail);

        makeDirPath(tagetAddr);
        String relativeAddr = tagetAddr + realFileName + extension;
        File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
        try {
            Thumbnails.of(thumbnail.getInputStream()).size(200,200).watermark(Positions.BOTTOM_RIGHT,ImageIO.read(new File(basePath + "/watermark.png")), 0.75f).outputQuality(0.8f).toFile(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return realFileName;
    }

    /**
     * 创建目标路径所涉及到的目录，即/home/work/xiangze/xx.jpg
     * 那么home work xiangze这三个文件夹都得自动创建
     *
     * @param tagetAddr
     */
    private static void makeDirPath(String tagetAddr) {
        String realFileParentPath = PathUtil.getImgBasePath() + tagetAddr;
        File dirPath = new File(realFileParentPath);
        if (!dirPath.exists()){
            dirPath.mkdir();
        }
    }

    /**
     * 获取输入文件流的扩展名
     * @param
     * @return
     */
    private static String getFileExtension(CommonsMultipartFile cFile) {
        String originalFileName = cFile.getOriginalFilename();
        return originalFileName.substring(originalFileName.lastIndexOf("."));
    }

    /**
     * 生成随机的文件，当前年月日分钟秒钟+五位随机数
     */

    private static String getRandomFileName() {
        int rannum = r.nextInt(89999) + 10000;
        String nowTimeStr = sDateFromat.format(new Date());
        return nowTimeStr + rannum;
    }
    
    

    //加水印
    public static void main(String[] args) throws IOException {

        Thumbnails.of(new File("C:/Users/13050/Desktop/naicha.jpg")).size(500, 500)
                .watermark(Positions.BOTTOM_RIGHT,ImageIO.read(new File(basePath + "/watermark.png")), 0.75f).outputQuality(0.8f).toFile("C:/Users/13050/Desktop/naichanew.jpg");
    }
}
