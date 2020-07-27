package gu;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Scanner;

@WebServlet("/upload")
@MultipartConfig    // 不加注解，Tomcat 不会解析 Multipart 内容
public class UploadServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        // 执行一些初始化操作
    }

    @Override
    public void destroy() {
        // 执行一些销毁操作
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        System.out.println(username);
        String password = req.getParameter("password");
        System.out.println(password);

        Collection<Part> parts = req.getParts();
        for (Part part : parts) {
            System.out.println("==========================================");
            System.out.println(part.getName());
            System.out.println(part.getContentType());
            Collection<String> headerNames = part.getHeaderNames();
            for (String headerName : headerNames) {
                System.out.println(part.getHeader(headerName));
            }
            System.out.println(part.getSize());
            System.out.println(part.getSubmittedFileName());
            InputStream inputStream = part.getInputStream();
            Scanner scanner = new Scanner(inputStream, "UTF-8");
            System.out.println(scanner.next());
        }
    }
}
