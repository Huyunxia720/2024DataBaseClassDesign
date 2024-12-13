package mappers;
import entity.TeacherIndex;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TeacherIndexMapper {
	void update(TeacherIndex teacherIndex);
	List<TeacherIndex> selectAll();
	TeacherIndex selectByPrimaryKey(@Param("TNo")String tNo,@Param("DisciplineNum")String disciplineNum,@Param("SecondaryNum")String secondaryNum);
	List<TeacherIndex> findIndicesWithGreaterThanZero(@Param("tNo") String tNo);

}
