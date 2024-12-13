package mappers;

import entity. SecStudent;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface SecStudentMapper {
    
    void insert(SecStudent secStudent);

    
    void update(SecStudent secStudent);

    
    SecStudent selectByExamNo(@Param("examNo") String examNo);

    
    void delete(@Param("examNo") String examNo);
}
