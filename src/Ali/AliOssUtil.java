package Ali;

import com.aliyun.oss.*;
import com.aliyun.oss.internal.OSSUtils;
import com.aliyun.oss.model.PutObjectRequest;
import com.mysql.jdbc.log.Log;
import org.apache.commons.logging.LogFactory;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.logging.Logger;

public class AliOssUtil {
    private String endpoint = "http://oss-cn-beijing.aliyuncs.com";
    private String accessKeyId = "1";
    private String accessKeySecret = "2";
    private String urlFile;
    private OSS ossClient;
    private String objectPath;

    /**
     * @param objectPath 文件在阿里云oss上存储的位置以及文件名
     * @param urlFile    文件在本地的存储路径
     * */
    public AliOssUtil(String objectPath,String urlFile){
        this.ossClient =  new OSSClientBuilder().build(endpoint,accessKeyId,accessKeySecret);
        this.urlFile = urlFile;
        this.objectPath = objectPath;
    }

    /**
     * <p>上传指定路径的文件</>
     * */

    public void uploadFile(){
        PutObjectRequest putObjectRequest = new PutObjectRequest("shixunimageandvideo",objectPath,new File(urlFile));
        ossClient.putObject(putObjectRequest);
        ossClient.shutdown();
    }

    /**
     * <p>删除指定的文件或文件夹</>
     * */

    public void deleteFile(){
        ossClient.deleteObject("shixunimageandvideo",objectPath);
        ossClient.shutdown();
    }
    /**
     * <p>获取阿里云oss中的字符串</>
     * */

    public String getUrl(){
        Date expiration = new Date(new Date().getTime()+3600l*1000*24*365*10);
        String url = ossClient.generatePresignedUrl("shixunimageandvideo",objectPath,expiration).toString();
        return url;
    }
}
