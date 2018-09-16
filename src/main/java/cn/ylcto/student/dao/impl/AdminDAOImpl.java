package cn.ylcto.student.dao.impl;

import cn.ylcto.student.dao.IAdminDAO;
import cn.ylcto.student.vo.Admin;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;
//不需要写工厂

@Repository
public class AdminDAOImpl extends SqlSessionDaoSupport implements IAdminDAO {//实现接口
    @Autowired
    public AdminDAOImpl(SqlSessionFactory sqlSessionFactory){
        super.setSqlSessionFactory(sqlSessionFactory);
    }
    //构造器中生成sqlSessionFactory
    @Override
    public Admin findLogin(Admin vo) throws SQLException {
        return super.getSqlSession().selectOne("AdminNS.findLogin",vo);
        //访问最近的一个父类中的getSqlSession方法中的selectOne方法。
        //调用AdminNS这个Mapper,使用其中的findLogin映射
    }


    @Override
    public boolean doCreate(Admin vo) throws SQLException {
        return false;
    }

    @Override
    public boolean doUpdate(Admin vo) throws SQLException {
        //更新最后一次登陆日期
        //返回判断结果
        return super.getSqlSession().update("AdminNS.doUpdateLastDate",vo)>0;

    }

    @Override
    public boolean doRemove(Set<?> ids) throws SQLException {
        return false;
    }

    @Override
    public Admin findById(String id) throws SQLException {
        return null;
    }

    @Override
    public List<Admin> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<Admin> findAllBySplit(String column, String keyWord, Integer currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public Integer getAllCount(String column, String keyWord) throws SQLException {
        return null;
    }
}
