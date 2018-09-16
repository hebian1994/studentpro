package cn.ylcto.student.action;

import cn.ylcto.student.service.IClassesService;
import cn.ylcto.student.vo.Classes;
import cn.ylcto.util.action.DefaultAction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

@Controller
@RequestMapping(value = "/pages/back/classes/*")
public class ClassesAction extends DefaultAction{
    /*
    /@resource注解就是把一个bean注入到当前的类中，可以不必通过配置文件或者导包的方式注入就可以使用该bean，默认是ByName的方式注入，如：
@resource（name=“personDaoBean”）
private personDaoBean personDaobean;
这样就可以直接使用personDaoBean这个Bean，以及其setter和getter方法。
     */
    //将IClassesService装配为spring的一个bean，方便调用
    @Resource
    private IClassesService classesService;
//查询所有班级
    @RequestMapping(value = "classes_list")
    public void list(HttpServletResponse response){
        try {
            //该方法会向前端返回一个JSONObject，里面包含了取出来的数据
            super.printObjectToList(response,"allClasses",this.classesService.list());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//插入班级
    @RequestMapping(value = "classes_insert")
    public ModelAndView insert(Classes vo){
        ModelAndView mav = new ModelAndView(super.getResource("pages.forward"));//跳转到资源文件Pages.properties中的pages.forward=/pages/forward.jsp
        try {
            if (this.classesService.insert(vo)){
                //如果插入成功，出现提示信息msg，并且进行跳转
                super.setMsgAndPath(mav,"classes.insert.success","classes.login.success");
            }else{
                super.setMsgAndPath(mav,"classes.insert.failure","classes.login.failure");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }



    @Override
    public String getText() {
        return "班级";
    }
}
