package cn.ylcto.student.dao;

import cn.ylcto.student.vo.Admin;

import java.sql.SQLException;

public interface IAdminDAO extends IDAO<String,Admin> {//继承父类接口，并增加了了admin特有的findLogin方法
    /**
     * 实现登录查询操作
     * @param vo 包含要执行查询的字段：（email password）
     * @return 成功返回最后一次登录日期
     * @throws SQLException
     */
    public Admin findLogin(Admin vo)throws SQLException;
}
