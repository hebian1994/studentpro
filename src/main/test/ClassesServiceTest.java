import cn.ylcto.student.service.IClassesService;
import cn.ylcto.student.vo.Classes;
import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ClassesServiceTest {
    private static ApplicationContext ctx ;
    private static IClassesService classesService;

    static {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        classesService = ctx.getBean("classesServiceImpl",IClassesService.class);
    }
  @Test
    public void insert()throws Exception{
      Classes vo = new Classes();
      vo.setCname("YL015");
      vo.setNote("这是一个新开的Java培训班");
      if(this.classesService.insert(vo)){
          System.out.println("成功添加班级"+vo);
      }else{System.out.println("添加失败，已经存在该班级");};
  }
  @Test
    public void findAll() throws Exception{
        System.out.println("所有班级如下："+this.classesService.list());
  }
}
