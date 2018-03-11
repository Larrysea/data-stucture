package ninechapter.towpointer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 两数之和的数据结构设计
 *
 * @author
 * @create 2018-03-11 下午3:47
 **/
public class TwoSumDataStructure {


    private List<Integer> list = new ArrayList<Integer>();

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void add(int number) {
        // write your code here
        list.add(number);
    }

    /*
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        // write your code here
        Map<Integer, Integer> resultMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < list.size(); i++) {
            if (resultMap.get(list.get(i)) != null) {
                return true;
            }

            resultMap.put(value - list.get(i), i);

        }

        return false;

    }

}


