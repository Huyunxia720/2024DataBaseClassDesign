package mappers;

import entity.Publicity;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

public interface PublicityMapper {
    // 查询所有公示信息
    List<Publicity> selectAll();
    
    // 根据教工号查询公示信息
    Publicity selectByTNo(String tNo);
    
    //复选加入公示表
    void insertPublicityRecord(@Param("tNo") String tNo,
            @Param("examNo") String examNo,
            @Param("disciplineNum") String disciplineNum,
            @Param("secondaryNum") String secondaryNum);
}