import java.io.*;

public class FileCopy {
    public static void main(String[] args) throws IOException{
        String srcPath = "src.png";
        String destPath = "dest.png";

        File srcFile=new File(srcPath);
        if (!srcFile.exists()){
            System.out.println("源文件不存在");
            return;
        }

        if (srcFile.isDirectory()){
            System.out.println("源文件是目录");
            return;
        }

        File destFile=new File(destPath);
        if (destFile.exists()){
            if (!srcFile.exists()){
                System.out.println("目标文件已经存在");
                return;
            }
        }

        try(InputStream is=new FileInputStream(srcFile)){
                try(OutputStream os=new FileOutputStream(destFile)){
                    byte[]buffer=new byte[2048];
                    while (true){
                        int len=is.read(buffer,0,2048);
                        if (len==-1){
                            break;
                        }
                        os.write(buffer,0,len);
                    }
                    os.flush();
                }
        }
    }
}
