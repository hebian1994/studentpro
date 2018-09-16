public class TestMD5Code {
    public static void main(String[] args) {
        String email = "ylcto@163.com";
        String password = "ylcto";
        System.out.println(new cn.ylcto.util.MD5Code().getMD5ofStr(password+email));
        //MD5Code的作用就是投入一个字符串再返回一个加密完成的字符串
    }
}
