package test;

import Ali.AliOssUtil;

public class Test_aliUpload {
    public static void main(String args[]){
        AliOssUtil aliOssUtil = new AliOssUtil("video/test.mp4","/Users/lzy/Downloads/测试文件/3blue1brown/145676706-1-208.mp4");
        aliOssUtil.uploadFile();
    }
}
