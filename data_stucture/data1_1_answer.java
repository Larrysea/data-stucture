package data_stucture;

/**
 * Created by Larry-sea on 2017/10/7.
 * <p>
 * data stucture answer
 * <p>
 * select problem: give the n number,select the k=n/2
 * <p>
 * thought setup:
 * <p>
 * 1 first define the n number array
 * <p>
 * 2 second define the sort method
 * <p>
 * 3 third ergodic the array of 0,k
 */
public class data1_1_answer {

    static int[] testArray1 = {1, 9, 8, 2, 6, 7, 1};

    static int[] testArray2 = {4, 2, 5, 1};

    static int[] testArray3 = {2147483647, 1, 4, 2, -10, -214748648};

    static int[] testArray4 = {};

    public static void main(String[] args) {
        System.out.println("测试数据");
    }


    /**
     * @param array ready to sort array
     * @param isAsc is asc or dsc sort
     */
    //冒泡排序
    public static void bubbleSort(int array[], boolean isAsc) {
        if (array.length == 0) {
            throw new IllegalArgumentException("array is empty,no need to sort");
        }
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                boolean isNeedSort = false;
                if (isAsc) {
                    if (array[j] > array[j + 1]) {
                        isNeedSort = true;
                    }
                } else {
                    if (array[j] < array[j + 1]) {
                        isNeedSort = true;
                    }
                }
                if (isNeedSort) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }


    /**
     * use bubble sort
     *
     * @param k
     */
    public static int selectProblem1(int[] numberArray, int k) {
        if (k > numberArray.length || k < 0) {
            throw new IllegalArgumentException("k is out of bounds");
        }
        bubbleSort(numberArray, true);
        return numberArray[k];
    }

    public void selectProblem2(int[] numberArray, int k) {
        if (k > numberArray.length || k < 0) {
            throw new IllegalArgumentException("k is out of bounds");
        }
        int kArray[] = new int[k];
        for (int i = 0; i < k; i++) {
            kArray[i] = numberArray[i];
        }
        bubbleSort(kArray, false);
    }


}
