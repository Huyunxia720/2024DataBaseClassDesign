package service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import mappers.CatalogMapper;

public class CatalogService {

    private SqlSessionFactory sqlSessionFactory;

    public CatalogService(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public String checkQualification(String TNo, String DisciplineNum, String SecondaryNum) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            CatalogMapper mapper = session.getMapper(CatalogMapper.class);
            return mapper.checkQualification(TNo, DisciplineNum, SecondaryNum);
        }
    }
}