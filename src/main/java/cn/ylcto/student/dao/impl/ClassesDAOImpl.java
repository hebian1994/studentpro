package cn.ylcto.student.dao.impl;

import cn.ylcto.student.dao.IClassesDAO;
import cn.ylcto.student.vo.Classes;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;
@Repository
public class ClassesDAOImpl extends SqlSessionDaoSupport implements IClassesDAO {
    //构造器中从连接池中取出一个连接，并且建立一个会话工厂
    @Autowired
    public ClassesDAOImpl(SqlSessionFactory sqlSessionFactory){
        super.setSqlSessionFactory(sqlSessionFactory);
    }
    //插入班级
    @Override
    public boolean doCreate(Classes vo) throws SQLException {
        //从会话工厂中取出一个会话，并且通过该会话执行插入一条记录的操作。此处spring→maybatis
        return super.getSqlSession().insert("classesNS.doCreate", vo) > 0;
    }
    //查询所有班级
    @Override
    public List<Classes> findAll() throws SQLException {
        return super.getSqlSession().selectList("classesNS.findAll");
    }

    @Override
    public boolean doUpdate(Classes vo) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<?> ids) throws SQLException {
        return false;
    }

    @Override
    public Classes findById(Integer id) throws SQLException {
        return null;
    }



    @Override
    public List<Classes> findAllBySplit(String column, String keyWord, Integer currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public Integer getAllCount(String column, String keyWord) throws SQLException {
        return null;
    }

    @Override
    public Classes findByCname(String cname) throws SQLException {
        return super.getSqlSession().selectOne("classesNS.findByCname",cname);
    }
}
