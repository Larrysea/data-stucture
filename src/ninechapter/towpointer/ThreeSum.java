package ninechapter.towpointer;

import data_stucture.PrintUtil;

import java.util.*;

/**
 * 找出数组中三个数之和为0的结果集。
 *
 * @author
 * @create 2018-03-11 下午9:54
 **/
public class ThreeSum {


    public static void main(String[] args) {
        int[] testCase1 = {-1, 0, 1, 2, -1, -4};
//        PrintUtil.print(threeSum(testCase1));
        int[] testCase2 = {-1, 1, 0};

//        PrintUtil.print(twoSum(testCase1, 1, 1));
//        PrintUtil.print(threeSum(testCase2));

        int[] testCase3 = {1, 0, -1, -1, -1, -1, 0, 1, 1, 1};

        int[] testCase4 = {-2, -3, 5, -1, -4, 5, -11, 7, 1, 2, 3, 4, -7, -1, -2, -3, -4, -5};

        int[] testCase5 = {-2, -3, -4, -5, -100, 99, 1, 4, 4, 4, 5, 1, 0, -1, 2, 3, 4, 5};
//        PrintUtil.print(twoSum(testCase3, 2, 0));

        PrintUtil.print(threeSum(testCase3));
    }

    //三数之和为0 但是结果没有按照大小排序
    public static List<List<Integer>> threeSum(int[] numbers) {
        // write your code here

        // 3 sum的题目，将3sum分解为two sum 然后尽心继续求解
        if (numbers == null || numbers.length == 0) {
            return new ArrayList<List<Integer>>();
        }

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Arrays.sort(numbers);

        int lastNumber = Integer.MIN_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            if (lastNumber == numbers[i]) {
                continue;
            }
            lastNumber = numbers[i];
            List<List<Integer>> twoSumResult = twoSumII(numbers, -numbers[i], i + 1);
            //代表找打了结果集

            for (int index = 0; index < twoSumResult.size(); index++) {
                twoSumResult.get(index).add(numbers[i]);
                Collections.sort(twoSumResult.get(index));
                result.add(twoSumResult.get(index));
            }
        }
        return result;


    }

    private static List<List<Integer>> twoSum(int nums[], int target, int startIndex) {
        if (nums.length == 0) {
            return new ArrayList<List<Integer>>();
        }

        HashMap<Integer, Integer> resultMap = new HashMap<>();


        ArrayList<List<Integer>> twoResult = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = startIndex; i < nums.length - 1; i++) {
            if (nums[i + 1] == nums[i]) {
                continue;
            }
            if (resultMap.get(nums[i]) != null) {
                List<Integer> result = new ArrayList<>();
                result.add(resultMap.get(nums[i]));
                result.add(nums[i]);
                twoResult.add(result);
            }
            resultMap.put(target - nums[i], nums[i]);
        }
        return twoResult;
    }


    //通过指针法来寻找twosum
    public static List<List<Integer>> twoSumII(int[] numbers, int target, int startIndex) {

        if (numbers == null || numbers.length == 0) {
            return new ArrayList<>();
        }

        int left = startIndex;
        int right = numbers.length - 1;

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(numbers);

        while (left < right) {
            // 如果结果最终等于target
            if (numbers[left] + numbers[right] == target) {
                List<Integer> arrayList = new ArrayList<>();
                arrayList.add(numbers[left]);
                arrayList.add(numbers[right]);
                result.add(arrayList);
                right--;
                left++;
                //去除左边重复,与操作进行以前的上一个数进行比较
                while (left < right && numbers[left] == numbers[left - 1]) {
                    left++;
                }
                //去除右边重复
                while (left < right && numbers[right] == numbers[right + 1]) {
                    right--;
                }
            }
            //如果查找的数结果大于target 减小最大的数
            else if (numbers[left] + numbers[right] > target) {
                right--;
            }
            //如果查找的数小于 则增加最小的数
            else {
                left++;
            }

        }
        return result;
    }
}
