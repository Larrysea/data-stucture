package ninechapter.common_datastructure;

import data_stucture.PrintUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 子数组和为0 的结果。
 *
 * @author
 * @create 2018-04-11 下午11:50
 **/
public class SubArraySum {


    public static void main(String[] args) {
        int[] array = {-3, 1, 2, -3, 4};
        int[] array2 = {-5, 10, 5, -3, 1, 1, 1, -2, 3, -4};
        int[] array3 = {4, 10, 13, 4, -1, 0, 3, 3,};
        PrintUtil.printList(subarraySum(array));
    }

    public static List<Integer> subarraySum(int[] nums) {
        // write your code here
        int start = 0;
        int end = 0;
        int currentSum = 0;
        int position = -1;

        for (int i = 0; i < nums.length; i++) {
            currentSum = 0;
            currentSum += nums[i];
            if (nums[i] == 0) {
                position = i;
            }
            for (int j = i + 1; j < nums.length; j++) {
                currentSum += nums[j];
                if (currentSum == 0) {
                    start = i;
                    end = j;
                    break;
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        if (start == end && nums[start] + nums[end] != 0) {
            end = start = position;
        }
        result.add(start);
        result.add(end);
        return result;
    }


    //超时的
    public List<Integer> subarraySumII(int[] nums) {

        //算法思想，如果数组中的结果一直不停的加，但是加到某个时候这个值又出现了，说明这里面有子数组的和为0，并且是从这个数
        HashMap<Integer, Integer> numberMap = new HashMap<>();
        numberMap.put(0, -1);

        List<Integer> result = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (numberMap.containsKey(sum)) {
                result.add(numberMap.get(sum) + 1);
                result.add(i);
                return result;
            }
            numberMap.put(sum, i);
        }

        return result;
    }


}
