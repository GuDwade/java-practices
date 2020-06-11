import java.io.*;

public class Iconv{
    //字符集转换
    public static void main(String[] args)throws IOException {
        iconv("源文件-utf-8.txt","目标文件-gbk.txt","UTF-8","GBK");
    }

    public static void iconv(String srcPath,String destPath,String fromCharset,String toCharset)throws IOException {
        try(Reader reader=new InputStreamReader(new FileInputStream(srcPath),fromCharset)){
            try(Writer writer=new OutputStreamWriter(new FileOutputStream(destPath),toCharset)){
                char[]buffer=new char[1024];
                int len=0;
                while (true){
                    if(reader.read(buffer)==-1){
                        break;
                    }
                    writer.write(buffer);
                }
                writer.flush();
            }
        }
    }
}
