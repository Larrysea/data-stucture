package data_stucture;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Larry-sea on 2017/10/14.
 */
public class data3_1answer {

    public static void main(String args[]) {
        int[] arrayL = {1, 2, 3, 4, 5};
        int[] arrayP = {2, 7, 8, 10};
        List<Integer> listL = ListUtil.initList(arrayL);
        List<Integer> listP = ListUtil.initList(arrayP);
        printLots(listL, listP);
    }


    //总的时间复杂度为O(n^2)
    public static void printLots(List<Integer> l, List<Integer> p) {
        Iterator<Integer> iterator = l.iterator();
        int position = 1;
        //外层循环时间复杂度为O(n)
        while (iterator.hasNext()) {
            int number = iterator.next();
            //时间复杂度为O(n)
            if (p.contains(position)) {
                System.out.println(number);
            }
            position++;
        }
    }

}
