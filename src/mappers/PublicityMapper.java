package mappers;

import entity.Publicity;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

public interface PublicityMapper {
    // ��ѯ���й�ʾ��Ϣ
    List<Publicity> selectAll();
    
    // ���ݽ̹��Ų�ѯ��ʾ��Ϣ
    Publicity selectByTNo(String tNo);
    
    //��ѡ���빫ʾ��
    void insertPublicityRecord(@Param("tNo") String tNo,
            @Param("examNo") String examNo,
            @Param("disciplineNum") String disciplineNum,
            @Param("secondaryNum") String secondaryNum);
}