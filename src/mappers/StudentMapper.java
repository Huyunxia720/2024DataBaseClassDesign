package mappers;

import entity.Student;
import java.util.List;

import org.apache.ibatis.annotations.Param;


public interface StudentMapper {
        void insert(Student student);

     void update(Student student);

    Student selectByExamNo(@Param("examNo") String examNo);

    void delete(@Param("examNo") String examNo);
    List<Student> selectAllStudents();
    Student selectStudentByExamNo(@Param("examNo") String examNo);
    List<Student> selectByChoice1(@Param("tno")String tno,@Param("disciplineNum")String disciplineNum,@Param("secondaryNum")String secondaryNum);
    List<Student> selectByChoice2(@Param("tno")String tno,@Param("disciplineNum")String disciplineNum,@Param("secondaryNum")String secondaryNum);
    List<Student> selectByChoice3(@Param("tno")String tno,@Param("disciplineNum")String disciplineNum,@Param("secondaryNum")String secondaryNum);

}