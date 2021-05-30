package java语法练习之文件复制;

import java.io.*;
import java.nio.channels.FileChannel;

public class CopyFiles {
    public static void main(String[] args) throws Exception {
         copy(new File("D:\\我的自学Java项目\\yu_yang89757-SSM-master.zip"),new File("D:\\翔龙的学习环境\\java的文件操作\\SSM整合项目.zip"));
    }

    //文件的复制,利用字符流进行写入
    public static void copyFile(File srcFile, File destFile) {
        try(
                // 1.创建一个低级的字节输入流与源文件接通
                InputStream is = new FileInputStream(srcFile);
                BufferedInputStream bis = new BufferedInputStream(is);
                // 2.创建一个敌机的字节输出流管道与目标文件接通
                OutputStream os = new FileOutputStream(destFile);
                BufferedOutputStream bos = new BufferedOutputStream(os);
        ){
            // 3.定义一个字节数组存储字节
            byte[] buffer = new byte[1024];
            // 定义一个变量存储每次读取的字节数量。
            int len ;
            while((len = bis.read(buffer))!=-1){
                bos.write(buffer,0,len);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //基于管道的复制
    public static void copy(File oldFile,File newFile) throws Exception {
        // 1、字节输入管道
        //FileInputStream is = new FileInputStream("D:\\我的自学Java项目\\yu_yang89757-SSM-master.zip");
        FileInputStream is = new FileInputStream(oldFile);
        FileChannel isChannel = is.getChannel();
        // 2、字节输出流管道
        //FileOutputStream fos = new FileOutputStream("D:\\翔龙的学习环境\\java的文件操作\\SSM整合项目.zip");
        FileOutputStream fos = new FileOutputStream(newFile);
        FileChannel osChannel = fos.getChannel();
        // 3、复制数据
        // osChannel.transferFrom(isChannel , isChannel.position() , isChannel.size());
        isChannel.transferTo(isChannel.position() , isChannel.size() , osChannel);
        isChannel.close();
        osChannel.close();
        System.out.println("完成复制！");
    }


}
