package data_stucture;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Larry-sea on 2017/10/8.
 */
public class TestCorruntException {

    static List<Integer> evenNumber = new ArrayList<>();

    public static void main(String[] args) {

        evenNumber.add(1);
        evenNumber.add(2);
        evenNumber.add(3);
        evenNumber.add(4);
        evenNumber.add(5);
        for (Integer number : evenNumber) {
            if (number % 2 == 0) {
                evenNumber.remove(number);
            }
        }
    }
}
