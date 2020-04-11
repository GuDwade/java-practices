import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CreateAndDelate {

    public static void main(String[] args) throws IOException {
        //createFile();
        //deleteFile();
        //createFiles();
        deleteFiles();
    }

    public  static  void createFile() throws IOException {
        Scanner scan=new Scanner(System.in);

        //只是创建对象，还没有创建文件
        File file=new File("gu.txt");

        System.out.println("输入回车，创建文件");

        scan.nextLine();

        file.createNewFile();

        System.out.println("创建文件成功");

    }

    public static void deleteFile() throws IOException {

        Scanner scanner=new Scanner(System.in);
        File file=new File("haha.txt");

        file.createNewFile();

        System.out.println("文件创建成功");

        System.out.println("回车删除文件");

        scanner.nextLine();

        //file.delete();
        file.deleteOnExit();
        scanner.nextLine();
        System.out.println("删除成功");

    }

    public  static  void createFiles(){
        Scanner scanner=new Scanner(System.in);

        File file=new File("123/456");
        //File file=new File("123");

        System.out.println("输入回车，创建文件夹");

        scanner.nextLine();

        file.mkdirs();
        //file.mkdir();

        System.out.println("创建文件夹成功");

    }

    public  static  void deleteFiles(){
        Scanner scanner=new Scanner(System.in);


        File file=new File("123");

        file.mkdirs();

        System.out.println("文件夹成功，输入回车删除文件夹");

        scanner.nextLine();

        file.delete();

        System.out.println("删除文件夹成功");
    }

}
