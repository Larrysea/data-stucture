package test;

import data_stucture.PrintUtil;
import sun.rmi.runtime.Log;

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
    }

}
