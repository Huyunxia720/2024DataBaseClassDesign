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
        String tno = request.getParameter("tno"); // ��ȡ��ʦ��
        HttpSession session = request.getSession(); // ��ȡsession����
        session.setAttribute("TNo", tno); // ����ʦ�Ŵ洢��session��
        response.sendRedirect("TutorPage.jsp"); // �ض��򵽵�ʦҳ��
    }
}