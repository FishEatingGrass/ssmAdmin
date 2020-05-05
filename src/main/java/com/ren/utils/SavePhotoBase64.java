package com.ren.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sun.misc.BASE64Decoder;

public class SavePhotoBase64 {

	private static final Logger logger = LoggerFactory.getLogger(SavePhotoBase64.class);
	
	/**
     * besa64保存图片
     * @param photo 图片base64数据，带type类型
     * @param realPath 绝对路径
     * @param filePath 文件保存路径
     * @param fileName 文件名
     * @return boolean true 成功 & false 失败
     */
    public boolean save(String photo,String realPath,String filePath,String fileName){
    	String[] newPhoto = photo.split(",");
    	
    	File dir = new File(realPath + filePath);
    	boolean isDirs = false;
    	if(!dir.exists()){
    		isDirs = dir.mkdirs();
    	}else{
    		isDirs = true;
    	}
    	if(isDirs){
    		String path = realPath + filePath + fileName;
        	BASE64Decoder decoder = new BASE64Decoder();
    		try{  
                //Base64解码  
                byte[] b = decoder.decodeBuffer(newPhoto[1]);
                for(int i=0;i<b.length;++i){
                    if(b[i]<0){//调整异常数据
                        b[i]+=256;  
                    }
                }
                OutputStream out = null;
                try {
                	out = new FileOutputStream(path);      
                    out.write(b);  
                    out.flush();
    			} finally {
    				if(out != null){
    					out.close();
    				}
    			}
               return true;
            }catch (Exception e){ 
            	return false;
            }
    	}else{
    		return false;
    	}
		
    }
}
