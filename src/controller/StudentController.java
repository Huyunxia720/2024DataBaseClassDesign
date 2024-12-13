package controller;

import service.StudentService;
import utils.MyBatisUtil;
import entity.Student;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSessionFactory;

@WebServlet("/allStudents")
public class StudentController extends HttpServlet {
    private StudentService studentService;

    public StudentController() {
        SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
        this.studentService = new StudentService(sqlSessionFactory);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> students = studentService.getAllStudents();
        request.setAttribute("students", students);
        request.getRequestDispatcher("allStudents.jsp").forward(request, response);
    }
}