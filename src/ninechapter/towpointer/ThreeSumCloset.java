package ninechapter.towpointer;

import data_stucture.PrintUtil;

import java.util.Arrays;

/**
 * 三个数中求最接近target的数。
 *
 * @author
 * @create 2018-03-17 下午11:28
 **/
public class ThreeSumCloset {

    public static void main(String[] args) {

        int[] testCase1 = {-1, 2, 1, -4};
        int target = 1;

        int[] testCase2 = {2, 7, 11, 15};
//        PrintUtil.print(threeSumClosest(testCase2, 3));


        int[] testCase3 = {-2, -3, -4, -5, -100, 99, 1, 4, 4, 4, 5, 1, 0, -1, 2, 3, 4, 5};


        PrintUtil.print(threeSumClosestII(testCase3, 77));
    }




    //计算出三数加起来最小的和
    public static int threeSumClosestII(int[] numbers, int target) {

        if (numbers == null || numbers.length < 3) {
            return 0;
        }

        Arrays.sort(numbers);
        int bestSum = numbers[0] + numbers[1] + numbers[2];
        for (int i = 0; i < numbers.length; i++) {
            int left = i + 1;
            int right = numbers.length - 1;

            while (left < right) {
                int sum = numbers[i] + numbers[left] + numbers[right];
                //计算最小和
                if (Math.abs(target - bestSum) > Math.abs(target - sum)) {
                    bestSum = sum;
                }
                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return bestSum;

    }


}
