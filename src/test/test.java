package test;

import data_stucture.PrintUtil;
import sun.rmi.runtime.Log;

import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Set;

/**
 * gsgs
 *
 * @author
 * @create 2018-01-31 上午11:32
 **/
public class test {

    public static void main(String[] args) {
        Set<Integer> testSet = new HashSet<>();
        testSet.add(1);
        testSet.add(2);
        testSet.add(1);
        testSet.add(2);
        System.out.println(testSet.size());
        Integer a = 60;
        Integer b = 50;
        Integer c = null;
        c = a;
        a = b;
        b = c;
        System.out.println(a + "  " + b + " " + c);
        try {
            String out = new String("u9a8c\\u8bc1\\u7801\\u8f93\\u5165\\u9519\\u8bef".getBytes(),"UTF-8");
            System.out.println(out);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
