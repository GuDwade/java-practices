import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class 从文件输入字节流中读 {
    public static void main(String[] args) throws IOException {
        //一个一个读
        try (InputStream is = new FileInputStream("板书.png")) {
            long count = 0;
            long len = 0;
            while (true) {
                count++;
                int b = is.read();
                if (b == -1) {
                    break;
                }

                len++;
            }

            System.out.printf("循环 %d 次%n", count);
            System.out.printf("板书.png 的文件长度为 %d 字节%n", len);
        }
        System.out.println("====================================");

        //一次多个
        try (InputStream is = new FileInputStream("板书.png")) {

            byte[] buffer = new byte[1024];
            long len = 0;
            long count = 0;

            while (true) {
                count++;
                int read = is.read(buffer);     // 一次最多读 1024 字节上，把读到的数据，放到 buffer 数组
                // 返回的 read，代表真正读到多少字节
                if (read == -1) {
                    break;
                }

                len += read;
            }

            System.out.printf("循环 %d 次%n", count);
            System.out.printf("板书.png 的文件长度为 %d 字节%n", len);
        }
    }

}

