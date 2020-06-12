import java.io.*;
import java.util.Scanner;

public class 从文件输入字符流中读文件内容 {

    public static void main(String[] args) throws IOException {

        try(InputStream is=new FileInputStream("有中文的文件.txt")){
            try(Reader reader=new InputStreamReader(is,"UTF-8")){
               StringBuilder sb=new StringBuilder();
                while (true){
                    int read=reader.read();
                    if (read==-1){
                        break;
                    }
                    sb.append((char)read);
                }
                System.out.println(sb.toString());
            }
        }
        System.out.println("===================================");


        try(InputStream is=new FileInputStream("有中文的文件.txt")){
            try(Reader reader=new InputStreamReader(is,"UTF-8")){
                StringBuilder sb=new StringBuilder();
                char[]buffer=new char[1024];
                while (true){
                    int read=reader.read(buffer);
                    if (read==-1){
                        break;
                    }
                    sb.append(buffer);
                }
                System.out.println(sb.toString());
            }
        }
        System.out.println("===================================");


        try (InputStream is = new FileInputStream("有中文的文件.txt")) {
            try (Reader reader = new InputStreamReader(is, "UTF-8")) {
                try (Scanner scanner = new Scanner(reader)) {
                    while (scanner.hasNext()) {
                        System.out.println(scanner.next());
                    }
                }
            }
        }
    }

}
