package shiro.trigger;

import com.alibaba.fastjson.JSONArray;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

    @Test
    public void testRegex() {
//        Pattern p = Pattern.compile("\\$\\{[A-Za-z0-9]+\\.[A-Za-z0-9.@]+\\}");
//        Pattern p = Pattern.compile("\\$\\{mail\\.[A-Za-z0-9.@]+\\}");
//        Matcher m = p.matcher("${mail.chenzb@broada.com}");
//        m.find();
//        String s = m.group();
//        System.out.println(s);
        String s = "${mail.chenzb@broada.com}";
        String s1 = s.substring(s.indexOf(".") + 1, s.indexOf("}"));
        System.out.println(s1);


//        String[] ss = s1.split("\\.", 2);
//        System.out.println(ss.length);
//
//        for (String s2 : ss) {
//            System.out.println(s2);
//        }


    }

    @Test
    public void testReplace() {
        String s = "${project.pm}";
        s = s.replace(s, "12321");
        System.out.println(s);
    }

    @Test
    public void testJSONArray() {
        JSONArray a = new JSONArray();
        a.add("1");
        a.add("2");

    }
}
