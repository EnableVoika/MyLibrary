import cn.hutool.crypto.digest.MD5;
import cn.hutool.json.JSONUtil;
import cn.hutool.poi.excel.sax.AttributeName;
import com.voika.infrastructure.config.StringUtil;

import java.util.HashMap;

import static cn.hutool.poi.excel.sax.AttributeName.s;

public class Test {

    public static void main(String[] args) {
        MD5 md5 = new MD5();
        String time = md5.digestHex16(String.valueOf(System.currentTimeMillis()));
        HashMap<String, Object> data = new HashMap<String, Object>(){{
            put("username","luni");
            put("password","123");
            put("salt",time);
        }};
        String s = JSONUtil.toJsonStr(data);
        System.out.println(md5.digestHex16(md5.digestHex16(md5.digestHex16(s))));
    }




}
class User {

}
class user extends User{

}
class Son extends user {

}