package mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.Catalog;

public interface CatalogMapper {
	int insert(Catalog catalog);
    int update(Catalog catalog);
    int delete(String TNo, String DisciplineNum, String SecondaryNum);
    Catalog selectByPrimaryKey(String TNo, String DisciplineNum, String SecondaryNum);
    List<Catalog>selectAll();
    String checkQualification(@Param("TNo") String TNo, @Param("DisciplineNum") String DisciplineNum, @Param("SecondaryNum") String SecondaryNum);
}