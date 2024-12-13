package controller;

import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import entity.TeacherIndex;

import mappers.StudentSelectedMapper;
import mappers.TeacherIndexMapper;

@WebServlet ("/firstselect")
public class firstSelect extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String[] examNos=request.getParameterValues("ExamNo");
		System.out.println(examNos.length);
		//更新老师指标数
		TeacherIndex newteacherIndex=(TeacherIndex)request.getSession().getAttribute("teacherIndex");
		if (newteacherIndex != null) {
			if (examNos != null) {
			    int cnt = newteacherIndex.getIndexNo() - examNos.length;
			    newteacherIndex.setIndexNo(cnt);
			}
			
		    request.getSession().setAttribute("teacherIndex", newteacherIndex);
		} else {
		    // 处理 teacherIndex 为 null 的情况，可能是记录日志、返回错误信息等
			System.out.println("老师指标数是空的");
		}
		
		try(SqlSession session=getSqlSessionFactory().openSession()){
			
			//把被选中的学生的状态全部改成true
			StudentSelectedMapper studentSelectedMapper=session.getMapper(StudentSelectedMapper.class);
			for(String examNo:examNos) {
				studentSelectedMapper.update(examNo);
				session.commit();
			}
			
			//更新老师指标数的内容
			TeacherIndexMapper teacherIndexMapper=session.getMapper(TeacherIndexMapper.class);
			teacherIndexMapper.update(newteacherIndex);
			session.commit();
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("selectsuccess.jsp").forward(request, response);
	}
	
	private static SqlSessionFactory getSqlSessionFactory() throws Exception {
        // 指定全局配置文件
		String resource="mybatis-config.xml";
		
		//读取配置文件
		InputStream inputStream=Resources.getResourceAsStream(resource);
		
		// 构建sqlSessionFactory
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		
        return sqlSessionFactory;
    }

}
