package service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import entity.IsSelected;
import mappers.IsSelectedMapper;
import utils.MyBatisUtil;

public class IsSelectedService {
    private SqlSessionFactory sqlSessionFactory;
    private IsSelectedMapper isSelectedMapper;

    public IsSelectedService() {
        this.sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
        this.isSelectedMapper = sqlSessionFactory.openSession().getMapper(IsSelectedMapper.class);
    }

    public IsSelected findFirstUnselected() {
        return isSelectedMapper.findFirstUnselected();
    }

    public boolean allSelected() {
        int result = isSelectedMapper.allSelected();
        return result == 1;
    }
}