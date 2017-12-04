package testproblem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Larry-sea on 2017/3/2.
 * <p>
 * 测试
 */
public class TestString {

    public static void main(String[] args) {

//        String str1="aa";
//        String str2="aa";
//        System.out.println((str1==str2));
//
//        String str3="aa";
//        String str4="aa";
//        System.out.println(str3.equals(str4));
//
//
//        String str5 = "aaaa" + "bbbbb"+ "aaaa";
//
//        String aaa ="aaaaaa\\[dd".replaceAll("\\[","c");

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("f");
        stringBuilder.append("a");
        stringBuilder.append("c");
        stringBuilder.delete(0, stringBuilder.length());
        System.out.println(stringBuilder.toString());

        List<String> nameList = new ArrayList<>();
        for (String temp : nameList) {
            System.out.println(temp);
        }
    }


}
