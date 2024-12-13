package mappers;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.StudentSelected;

public interface StudentSelectedMapper {
	int update(@Param("examNo")String examNo);
    StudentSelected findStudentSelectedByExamNo(@Param("examNo") String examNo);
    List<StudentSelected> findUnselectedStudents();
    void updateStudentSelection(@Param("examNo") String examNo);
}
