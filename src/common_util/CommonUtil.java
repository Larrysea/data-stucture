package common_util;

/**
 * Created by Larry-sea on 2017/12/14.
 */
public class CommonUtil {
    public static void printArray(final int[] array) {
        if (array != null && array.length > 0) {
            for (int index = 0; index < array.length; index++) {
                System.out.print(" " + array[index]);
            }
        }
    }

}
