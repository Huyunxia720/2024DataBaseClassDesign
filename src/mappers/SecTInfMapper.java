package mappers;

import entity. SecTInf;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface SecTInfMapper{
     void insert(SecTInf secTInfMapper);
     void update(SecTInf secTInfMapper);


     SecTInf selectByExamNo(@Param("examNo") String examNo);


     void delete(@Param("examNo") String examNo);
}
