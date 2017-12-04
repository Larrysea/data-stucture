package offer;

/**
 * Created by Larry-sea on 2017/1/24.
 * 剑指offer上的获取旋转数组中的最小数字
 */
public class minNumberInRotateArray {
    static public int minNumberInRotateArray(int[] array) throws Exception {
        int lastValue;
        if (array.length == 0) {
            return 0;
        }
        lastValue = array[0];
        for (int position = 1; position < array.length; position++) {
            if (lastValue > array[position]) {
                return array[position];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int array[] = {3, 4, 5, 1, 2};
        try {
            minNumberInRotateArray(array);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
