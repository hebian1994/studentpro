package cn.ylcto.student.service.impl;

import cn.ylcto.student.dao.IAdminDAO;
import cn.ylcto.student.service.IAdminService;
import cn.ylcto.student.vo.Admin;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class AdminServiceImpl implements IAdminService {
    @Resource
    private IAdminDAO adminDAO;
    @Override
    public Admin login(Admin vo) throws Exception {
        Admin admin = this.adminDAO.findLogin(vo);
        if (admin != null){ // 表示登录成功
            vo.setLastdate(new Date());//更新登陆日期
            this.adminDAO.doUpdate(vo);
            System.out.println("登录成功,数据库中有该用户");
        }
        return admin;
    }
}
