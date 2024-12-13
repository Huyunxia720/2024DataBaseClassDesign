package service;
import mappers.TeacherMapper;

import entity.Teacher;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
public class TeacherService {
	private TeacherMapper teacherMapper;

	public void addTeacher(Teacher teacher,SqlSession session) {
		teacherMapper=session.getMapper(TeacherMapper.class);
	    teacherMapper.insert(teacher);
	    session.commit();
	}

	public void updateTeacher(Teacher teacher,SqlSession session) {
		teacherMapper=session.getMapper(TeacherMapper.class);
	    teacherMapper.update(teacher);
	    session.commit();
	}

	public void deleteTeacher(String tNo,SqlSession session) {
		teacherMapper=session.getMapper(TeacherMapper.class);
	    teacherMapper.delete(tNo);
	    session.commit();
	}

	public Teacher getTeacher(String tNo,SqlSession session) {
		teacherMapper=session.getMapper(TeacherMapper.class);
		session.commit();
	    return teacherMapper.selectByPrimaryKey(tNo);
	    
	}

	public List<Teacher> getAllTeachers(SqlSession session) {
		teacherMapper=session.getMapper(TeacherMapper.class);
		session.commit();
	    return teacherMapper.selectAll();
	}
}
