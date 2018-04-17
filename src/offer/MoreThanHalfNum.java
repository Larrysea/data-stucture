package offer;

import data_stucture.PrintUtil;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 找到数组中数字出现超过一半的数
 *
 * @author
 * @create 2018-04-17 下午11:03
 **/
public class MoreThanHalfNum {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int[] testCase = {1, 2, 3, 2, 4, 2, 5, 2, 3};
        int[] testCase2 = {1};
        PrintUtil.print(MoreThanHalfNum_Solution(testCase2));
    }


    public static int MoreThanHalfNum_Solution(int[] array) {
        HashMap<Integer, Integer> numberCountMap = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            if (numberCountMap.containsKey(array[i])) {
                numberCountMap.put(array[i], numberCountMap.get(array[i]) + 1);
            } else {
                numberCountMap.put(array[i], 1);
            }
        }

        Set<Map.Entry<Integer, Integer>> entry = numberCountMap.entrySet();

        for (Map.Entry<Integer, Integer> map : entry) {
            if (map.getValue() > array.length / 2) {
                return map.getKey();
            }
        }


        return 0;

    }
}
