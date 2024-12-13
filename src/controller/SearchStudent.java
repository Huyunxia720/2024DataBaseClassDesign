package controller;

import service.StudentService;
import entity.Student;
import utils.MyBatisUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/searchStudent")
public class SearchStudent extends HttpServlet {
    private StudentService studentService;

    public SearchStudent() {
        super();
        this.studentService = new StudentService(MyBatisUtil.getSqlSessionFactory());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String examNo = request.getParameter("examNo");
        Student student = studentService.getStudentByExamNo(examNo);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        if (student == null) {
            // ���û���ҵ�ѧ���������������
            out.println("<script type='text/javascript'>");
            out.println("alert('δ�ҵ���ѧ������������ȷ��׼��֤��');");
            out.println("window.history.back();");
            out.println("</script>");
        } else {
            // ����ҵ�ѧ����ת����JSPҳ��
            request.setAttribute("student", student);
            request.getRequestDispatcher("allStudents.jsp").forward(request, response);
        }
    }
}