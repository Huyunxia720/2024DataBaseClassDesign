package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tno = request.getParameter("tno"); // 获取导师号
        HttpSession session = request.getSession(); // 获取session对象
        session.setAttribute("TNo", tno); // 将导师号存储到session中
        response.sendRedirect("TutorPage.jsp"); // 重定向到导师页面
    }
}