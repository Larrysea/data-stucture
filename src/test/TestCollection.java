package test;

import data_stucture.PrintUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Larry-sea on 2017/6/10.
 * <p>
 * 测试集合内容
 */
public class TestCollection {


    public static void main(String[] args) {


        List<Integer> integers = new ArrayList<>();
        integers.add(0);
        integers.add(1);
        integers.add(2);
        integers.add(3);

        List<Integer> integers1 = new ArrayList<>();
        integers1.add(4);
        integers1.add(5);
        integers1.add(6);
        integers1.add(7);


        PrintUtil.println(integers.contains(0) + "");

        List<Integer> emptyNumbers = new LinkedList<>();

        for (int i = 0; i < emptyNumbers.size(); i++) {
            System.out.println(emptyNumbers.get(i));

        }

        for (Integer number : emptyNumbers) {
            System.out.println(number);
        }


    }

}
