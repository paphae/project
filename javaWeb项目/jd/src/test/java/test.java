import com.alibaba.fastjson.JSON;
import com.jd.domain.Cart;
import com.jd.domain.Category;
import com.jd.util.DButil;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test {
    public static void main(String[] args) throws UnsupportedEncodingException {
        Map<Integer, Cart> map = new HashMap<Integer, Cart>();
        map.put(1,new Cart(1,2,10));
        String s = JSON.toJSONString(map, true);
//        s = URLEncoder.encode(s,"utf-8");
        System.out.println(s);
//        String value = URLDecoder.decode(s, "utf-8");
        Map<String ,Cart> carts = (Map<String, Cart>) JSON.parse(s);
        for (String key:carts.keySet()) {
            System.out.println(carts.get(key));
            JSON.parseObject(String.valueOf(carts.get(key)),Cart.class);
        }

    }
}
