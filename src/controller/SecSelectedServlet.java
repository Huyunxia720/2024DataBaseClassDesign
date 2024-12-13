package controller;

import entity.StudentSelected;
import entity.TeacherIndex;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mappers.PublicityMapper;
import mappers.StudentSelectedMapper;
import mappers.TeacherIndexMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.io.Resources;

@WebServlet(name = "SecSelectedServlet", value = "/SecSelectedServlet")
public class SecSelectedServlet extends HttpServlet {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to get resource for SqlSessionFactory", e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "showBoth"; // Default action
        }

        switch (action) {
            case "showTeacherInfo":
                showTeacherInfo(request, response);
                break;
            case "showStudentList":
                showStudentList(request, response);
                break;
            case "showBoth":
                showBoth(request, response);
                break;
            default:
                showBoth(request, response);
                break;
        }
    }

    private void showTeacherInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        showOnly(request, response, true, false);
    }

    private void showStudentList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        showOnly(request, response, false, true);
    }

    private void showBoth(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        showOnly(request, response, true, true);
    }

    private void showOnly(HttpServletRequest request, HttpServletResponse response, boolean showTeachers, boolean showStudents) throws ServletException, IOException {
        SqlSession sessionMyBatis = sqlSessionFactory.openSession();
        try {
            if (showTeachers) {
                TeacherIndexMapper tim = sessionMyBatis.getMapper(TeacherIndexMapper.class);
                List<TeacherIndex> teacherIndices = tim.findIndicesWithGreaterThanZero(null); // Pass null to fetch all records
                request.setAttribute("teacherIndices", teacherIndices);
            }

            if (showStudents) {
                StudentSelectedMapper ssm = sessionMyBatis.getMapper(StudentSelectedMapper.class);
                List<StudentSelected> students = ssm.findUnselectedStudents();
                request.setAttribute("students", students);
            }
        } finally {
            sessionMyBatis.close();
        }

        request.getRequestDispatcher("/secselected1.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tNo = request.getParameter("tNo");
        String examNo = request.getParameter("selectedStudent");
        String disciplineNum = request.getParameter("disciplineNum");
        String secondaryNum = request.getParameter("secondaryNum");

        if (tNo == null || examNo == null || disciplineNum == null || secondaryNum == null) {
            response.sendRedirect(request.getContextPath() + "/SecSelectedServlet?error=missingParameters");
            return;
        }

        SqlSession session = sqlSessionFactory.openSession();
        try {
            PublicityMapper pm = session.getMapper(PublicityMapper.class);
            pm.insertPublicityRecord(tNo, examNo, disciplineNum, secondaryNum);

            // Update the selected status of the student
            StudentSelectedMapper ssm = session.getMapper(StudentSelectedMapper.class);
            ssm.updateStudentSelection(examNo); // Update the student's selected status to 1

            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("<script>alert('数据库操作失败: " + e.getMessage() + "');</script>");
            response.getWriter().write("<script>location.href='secselected1.jsp';</script>");
            session.rollback();
        } finally {
            session.close();
        }

        // Show confirmation message
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write("<script>alert('已完成选择！');</script>");
        response.getWriter().write("<script>location.href='secselected1.jsp';</script>");
    }
}