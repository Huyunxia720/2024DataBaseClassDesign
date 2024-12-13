package test;

//import service.CatalogService;
import service.TeacherService;
//import entity.Catalog;
import entity.Teacher;
import entity.FirDiscipline;
import entity.SecDiscipline;
import mappers.FirDisciplineMapper;
import mappers.SecDisciplineMapper;
import mappers.TeacherMapper;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class test {
	public static void main(String[] args) throws Exception {
		// 指定全局配置文件
		String resource = "mybatis-config.xml";

		// 读取配置文件
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 构建sqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		try (SqlSession session = sqlSessionFactory.openSession()) {
			// 新设一个导师，一级学科，二级学科
			Teacher t1 = new Teacher();
			t1.setTNo("19980526");
			t1.settN("张三");
			t1.setTitle("副教授");
			t1.settEmail("19875@qq.com");
			t1.settNumber("19874561236");

			FirDiscipline f1 = new FirDiscipline();
			f1.setDisciplineNum("000001");

			SecDiscipline s1 = new SecDiscipline();
			s1.setDisciplineNum("000001");
			s1.setSecondaryNum("01");

			// 测试导师
			TeacherService ts = new TeacherService();
			ts.addTeacher(t1, session);
			List<Teacher> tt = (List<Teacher>) ts.getAllTeachers(session);
			for (Teacher t : tt) {
				System.out.println(t.toString());
			}

			t1.settEmail("123@abc.com");

			ts.updateTeacher(t1, session);

			System.out.println(ts.getTeacher(t1.getTNo(), session).toString());

			// 测试一级学科，二级学科

			
			  FirDisciplineMapper fm=session.getMapper(FirDisciplineMapper.class); 
			  fm.insert(f1);
			  session.commit();
			  
			 System.out.println(fm.selectByDisciplineNum(f1.getDisciplineNum()).toString()
			 );
			 
			  f1.setDisType("学术型学科"); fm.update(f1);
			 System.out.println(fm.selectByDisciplineNum(f1.getDisciplineNum()).toString()
			  );
			  
			
			 SecDisciplineMapper sm=session.getMapper(SecDisciplineMapper.class);
			 sm.insert(s1);
			 session.commit();
			 System.out.println(sm.selectByDisciplineNumAndSecondaryNum(s1.
			 getDisciplineNum(),s1.getSecondaryNum()).toString());
			 s1.setSecDisName("计算机"); sm.update(s1);
			 System.out.println(sm.selectByDisciplineNumAndSecondaryNum(s1.
			 getDisciplineNum(),s1.getSecondaryNum()).toString());
			 
			 
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
