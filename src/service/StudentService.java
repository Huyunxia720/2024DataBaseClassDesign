package service;

import mappers.StudentMapper;
import entity.Student;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class StudentService {
    private final StudentMapper studentMapper;

    public StudentService(SqlSessionFactory sqlSessionFactory) {
        this.studentMapper = sqlSessionFactory.openSession().getMapper(StudentMapper.class);
    }

    public List<Student> getAllStudents() {
        return studentMapper.selectAllStudents();
    }

    public Student getStudentByExamNo(String examNo) {
        return studentMapper.selectStudentByExamNo(examNo);
    }
}