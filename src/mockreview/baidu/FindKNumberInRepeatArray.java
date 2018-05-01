package mockreview.baidu;

import data_stucture.PrintUtil;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author 找出数组中排名第三的帽子
 * @create 2018-05-01 8:22 PM
 **/
public class FindKNumberInRepeatArray {


    public static void main(String[] args) {

        PrintUtil.print(findThePrice());
    }


    //找出价格第三的帽子
    public static int findThePrice() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] array = new int[n];


        HashSet<Integer> numberSet = new HashSet<Integer>();

        int count = 0;


        for (int i = 0; i < n; i++) {
            int temp = scanner.nextInt();
            if (!numberSet.contains(temp)) {
                array[count++] = temp;
                numberSet.add(temp);
            }
        }

        quickSort(array, 0, count - 1);

        if (count >= 3) {
            return array[2];

        }

        return -1;
    }


    private static void quickSort(int[] array, int low, int hig) {
        if (low >= hig) {
            return;
        }

        int partition = paration(array, low, hig);

        quickSort(array, low, partition - 1);
        quickSort(array, partition + 1, hig);

    }

    private static boolean less(int number1, int number2) {

        return number1 < number2;
    }


    private static void exchange(int array[], int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    private static int paration(int[] array, int low, int hig) {

        int i = low;
        int j = hig + 1;
        int val = array[low];

        while (true) {

            while (less(array[++i], val)) if (i == hig) break;
            while (less(val, array[--j])) if (j == low) break;

            if (i >= j) {
                break;
            }

            exchange(array, i, j);

        }

        exchange(array, low, j);

        return j;
    }


}
