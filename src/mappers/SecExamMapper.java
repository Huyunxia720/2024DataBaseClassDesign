package mappers;

import entity.SecExam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface SecExamMapper {
    
    void insert(SecExam secExam);

    
    void update(SecExam secExam);

   
    SecExam selectByExamNo(@Param("examNo") String examNo);

   
    void delete(@Param("examNo") String examNo);
}