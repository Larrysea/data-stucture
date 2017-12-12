package data_stucture;

/**
 * Created by Larry-sea on 2017/10/7.
 */
public class SortUtil {

    public static void main(String[] ags) {
        int[] array = {7, 5, 93, 12};
        printArray(array);
    }

    public static void printArray(int[] array) {
        if (array.length > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int number : array) {
                stringBuilder.append(number + "  ");
            }
            System.out.println(stringBuilder.toString());

        }
    }
}
