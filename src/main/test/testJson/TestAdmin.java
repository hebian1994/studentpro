package testJson;

import cn.ylcto.student.vo.Admin;
import cn.ylcto.util.ObjectToJSON;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestAdmin {
    public static void main(String[] args) {
        List<Admin> all = new ArrayList<>();
        for (int x = 0;x < 5 ;x++) {
            Admin vo = new Admin();
            vo.setEmail("ylcto@163.com");
            vo.setPassword("11111111");
            vo.setLastdate(new Date());
            all.add(vo);
        }
        System.out.println(ObjectToJSON.convertorListToJson("allAdmin",all));
    }
}

