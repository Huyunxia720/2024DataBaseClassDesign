package controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import mappers.TeacherIndexMapper;
import entity.TeacherIndex;

@WebServlet("/administorServlet")
public class administorServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String TNo=request.getParameter("tno");
		String disciplineNum=request.getParameter("disciplineNum");
		String secondaryNum=request.getParameter("secondaryNum");
		int indexNo=Integer.parseInt(request.getParameter("indexNo"));
		try(SqlSession session=getSqlSessionFactory().openSession()){
			TeacherIndexMapper teacherIndexMapper=session.getMapper(TeacherIndexMapper.class);
			TeacherIndex teacherIndex=teacherIndexMapper.selectByPrimaryKey(TNo, disciplineNum, secondaryNum);
			teacherIndex.setIndexNo(indexNo);
			teacherIndexMapper.update(teacherIndex);
			
			List<TeacherIndex> newteacherIndexs=teacherIndexMapper.selectAll();
			
			session.commit();
			request.getSession().setAttribute("teacherIndexs",newteacherIndexs);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("111.jsp").forward(request, response);
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
