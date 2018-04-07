package mockreview.tencent;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 有趣的数字
 *
 * @author https://www.nowcoder.com/question/next?pid=1725829&qid=44803&tid=14929475
 * @create 2018-04-07 下午7:04
 * 时间复杂度优化以后答案错误，需要再检查
 *
 **/
public class InterestNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberCount = scanner.nextInt();
        int[] array = new int[numberCount];
        System.out.println("");

        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }

        int[] pair = new int[4];

        int minDiff = Integer.MAX_VALUE;
        HashMap<Integer, Integer> numberMap = new HashMap<>();
        Arrays.sort(array);

        //存放差最大的pair
        pair[0] = array[0];
        pair[1] = array[array.length - 1];

        for (int i = 0; i < numberCount; i++) {
            if (i != 0 && array[i] - array[i - 1] < minDiff && array[i] != array[i - 1]) {
                pair[2] = array[i - 1];
                pair[3] = array[i];
                minDiff = Math.abs(array[i] - array[i - 1]);
            }
            if (numberMap.get(array[i]) != null) {
                numberMap.put(array[i], numberMap.get(array[i]) + 1);
            } else {
                numberMap.put(array[i], 1);
            }
        }


        System.out.println(numberMap.get(pair[2]) * numberMap.get(pair[3]) + " " + numberMap.get(pair[0]) * numberMap.get(pair[1]));


    }


}
