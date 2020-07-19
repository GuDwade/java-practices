package gu;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

//servlet项目开发步骤
//1.创建lib文件夹 导入需要的架包
//2.创建web文件夹（静态文件）
//   2.1 WEB-INF(配置文件)
//          web.xml
//   2.2 静态资源
//3.facets --- Artifacts部署

public class Hello  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        {
            String method=req.getMethod();
            System.out.println("请求方法： " +method);
        }

        {

            String requestURI = req.getRequestURI();
            System.out.println("完整的路径 " + requestURI + " getRequestURI()");
            String servletPath = req.getServletPath();
            System.out.println("排除 Context Path 的路径 " + servletPath + " getServletPath()");
            String contextPath = req.getContextPath();
            System.out.println("Context Path " + contextPath + " getContextPath()");
        }

        {
            String protocol = req.getProtocol();
            System.out.println(protocol);
        }

        {
            Enumeration<String> headerNames = req.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String key = headerNames.nextElement();
                String value = req.getHeader(key);
                System.out.println("Header: " + key + " = " + value);
            }
        }

        {
            ServletInputStream inputStream = req.getInputStream();
            // 通过读取 inputStream 来获取 Body 部分的内容
        }
    }
}
