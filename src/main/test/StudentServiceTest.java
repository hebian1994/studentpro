import cn.ylcto.student.service.IClassesService;
import cn.ylcto.student.service.IStudentService;
import cn.ylcto.student.vo.Classes;
import cn.ylcto.student.vo.Student;
import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class StudentServiceTest {
    private static ApplicationContext ctx ;
    private static IStudentService studentService;

    static {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        studentService = ctx.getBean("studentServiceImpl",IStudentService.class);
    }
    //插入学生
  @Test
    public void insert()throws Exception{
        for (int x = 1;x <50;x++) {
            Student vo = new Student();
            vo.setSid(""+x);
            vo.setName("李"+x);
            vo.setAge(19+x);
            vo.setSex(1); // 1.表示男 ，0.表示女
            vo.setAddress("xxxxxxxxxx路"+x+"号");
            Classes classes = new Classes();
            classes.setCid(5);
            vo.setClasses(classes);
            TestCase.assertTrue(this.studentService.insert(vo));
        }
  }
  //分页查找学生，并且显示总人数
  @Test
  public void list() throws Exception {
      Map<String,Object> map = this.studentService.listSplit(1,5);
      System.out.println( map.get("allStudent"));
      System.out.println( map.get("studentCount"));
      TestCase.assertTrue(map.size() == 2);
  }

  //根据sid更新学生信息
  @Test
    public void update()throws Exception{
        Student vo = new Student();
        vo.setName("王五");
        vo.setAge(20);
        vo.setSex(1);
        vo.setAddress("联系地址");
        vo.setSid("YLCTo832");
        Classes classes = new Classes();
        classes.setCid(5);
        vo.setClasses(classes);
        TestCase.assertTrue(this.studentService.update(vo));
  }
  //根据id删除学生
    @Test
    public void delete() throws Exception{
        List<String> all=new ArrayList<>();
        all.add("15");
        if(this.studentService.delete(all)){
            System.out.println("删除成功");
        }
    }

}
