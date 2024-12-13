package mappers;

import entity.SecDiscipline;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface SecDisciplineMapper {
    
    void insert(SecDiscipline secDiscipline);

   
    void update(SecDiscipline secDiscipline);

    
    SecDiscipline selectByDisciplineNumAndSecondaryNum(@Param("disciplineNum") String disciplineNum, @Param("secondaryNum") String secondaryNum);

   
    void delete(@Param("disciplineNum") String disciplineNum, @Param("secondaryNum") String secondaryNum);
}
