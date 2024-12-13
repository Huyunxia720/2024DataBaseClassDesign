package controller;

import service.CatalogService;
import service.IsSelectedService;
import utils.MyBatisUtil;
import entity.IsSelected;
import entity.Student;
import entity.TeacherIndex;
import mappers.StudentMapper;
import mappers.TeacherIndexMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/firstRoundSelection")
public class FirstRoundSelection extends HttpServlet {
    private CatalogService catalogService = new CatalogService(MyBatisUtil.getSqlSessionFactory());
    private IsSelectedService isSelectedService = new IsSelectedService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String TNo = (String) session.getAttribute("user");
        IsSelected unselected = isSelectedService.findFirstUnselected();
        if (unselected != null) {
            String disciplineNum = unselected.getDisciplineNum();
            String secondaryNum = unselected.getSecondaryNum();
            String isQualification = catalogService.checkQualification(TNo, disciplineNum, secondaryNum);
            if ("0".equals(isQualification)) { // 确保比较的是字符串"0"
                response.sendRedirect("NoStudent.jsp");
            } else {
                session.setAttribute("DisciplineNum", disciplineNum);
                session.setAttribute("SecondaryNum", secondaryNum);
                try (SqlSession session1 = MyBatisUtil.getSqlSessionFactory().openSession()) {
        	    	//获取在登录servlet页面存的teacher
        	    	String tno=(String)request.getSession().getAttribute("user");
        	    	
        	    	//获取该导师的该研究方向的指标数
        	    	TeacherIndexMapper teacherIndexMapper=session1.getMapper(TeacherIndexMapper.class);
        	    	TeacherIndex teacherIndex=teacherIndexMapper.selectByPrimaryKey(tno, disciplineNum, secondaryNum);
        	    	session1.commit();
        	    	//把指标数存到session里面
        	    	request.getSession().setAttribute("teacherIndex", teacherIndex);
        	    	
        	    	StudentMapper studentMapper=session1.getMapper(StudentMapper.class);
        	    	
        	    	List<Student>choice1=studentMapper.selectByChoice1(tno, disciplineNum, secondaryNum);
        	    	List<Student>choice2=studentMapper.selectByChoice2(tno, disciplineNum, secondaryNum);
        	    	List<Student>choice3=studentMapper.selectByChoice3(tno, disciplineNum, secondaryNum);
        	    	
        	    	request.getSession().setAttribute("choice1", choice1);
        	    	request.getSession().setAttribute("choice2", choice2);
        	    	request.getSession().setAttribute("choice3", choice3);
        	    	
        	    }catch(Exception e)
        	    {
        	    	e.printStackTrace();
        	    }
        	    request.getRequestDispatcher("firstselect.jsp").forward(request, response);

                
            }
        } else {
            // 弹窗提示“第一轮选择已结束，请进入复选”
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().println(
                "<script type='text/javascript'>" +
                "alert('第一轮选择已结束，请进入复选');" +
                "history.back();" + // 后退到上一个页面
                "</script>"
            );
        }
    }
}