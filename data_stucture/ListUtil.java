package data_stucture;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Larry-sea on 2017/10/14.
 */
public class ListUtil {

    public static List initList(int[] array) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int position = 0; position < array.length; position++) {
            linkedList.add(array[position]);
        }
        return linkedList;
    }


}
