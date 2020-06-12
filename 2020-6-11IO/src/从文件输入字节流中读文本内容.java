import java.io.*;

public class 从文件输入字节流中读文本内容 {

    public static void main(String[] args) throws IOException {

        try (InputStream is = new FileInputStream("没有中文的文件.txt")) {
           int len=0;
           byte[]buffer=new byte[1024];
           StringBuilder sb=new StringBuilder();
           while (true){
               int read=is.read(buffer);
               if (read==-1){
                   break;
               }
               len+=read;
               for(int i=0;i<len;i++){
                   sb.append((char) buffer[i]);
               }
           }
           System.out.println("文件大小为：" +len);
           System.out.println(sb.toString());
        }
        System.out.println("========================");
        try (InputStream is = new FileInputStream("有中文的文件.txt")) {
            int len=0;
            byte[]buffer=new byte[1024];
            StringBuilder sb=new StringBuilder();
            while (true){
                int read=is.read(buffer);
                if (read==-1){
                    break;
                }
                len+=read;
                sb.append(new String(buffer,0,read,"UTF-8"));
            }
            System.out.println("文件大小为：" +len);
            System.out.println(sb.toString());
        }

        try (InputStream in = new FileInputStream("有中文的文件.txt");
             OutputStream os=new FileOutputStream("写入的文件.txt")){
                byte[]buffer=new byte[1024];
                while (true){
                    int read=in.read(buffer);
                    if (read==-1){
                        break;
                    }
                    os.write(buffer,0,read);
                }
        }

    }


}
