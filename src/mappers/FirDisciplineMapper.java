package mappers;

import entity.FirDiscipline;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface FirDisciplineMapper {
    
    void insert(FirDiscipline firDiscipline);

    
    void update(FirDiscipline firDiscipline);

    
    FirDiscipline selectByDisciplineNum(@Param("disciplineNum") String disciplineNum);

    
    void delete(@Param("disciplineNum") String disciplineNum);
}