package com.rau.leetcode.test;

import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;

public class ImageDownloadTest implements Runnable{
    String fileName = "wallpaper";
    String URL = "https://cdn.pixabay.com/photo/2015/12/01/20/28/road-1072823_960_720.jpg";
    int j =0;
    @Override
    public void run() {
        imageDownLoad(URL,fileName+j+".jpg");
    }

    public static void main(String[] args) throws Exception{
        System.out.println(LocalDateTime.now());
        ImageDownloadTest obj = new ImageDownloadTest();
        Thread t=null;
        for (int i=0;i<5;i++) {
            t = new Thread(obj);
            t.start();
            obj.j = i;
        }
        t.join();
        System.out.println("*************Main end****************");
        System.out.println(LocalDateTime.now());
    }
    public void imageDownLoad(String URL, String fileName) {
        try(InputStream in = new URL(URL).openStream()){
            Files.copy(in, Paths.get(fileName));
        }catch (Exception ex){
            System.out.println(ex);
        }
        System.out.println("File "+fileName+" downlaod in current working directory");
    }
}
