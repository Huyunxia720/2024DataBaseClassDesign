package mappers;
import entity.Teacher;
import java.util.List;

public interface TeacherMapper {
    int insert(Teacher teacher);
    int update(Teacher teacher);
    int delete(String tNo);
    Teacher selectByPrimaryKey(String tNo);
    List<Teacher>selectAll();
}