package ninechapter.binarysearch;

import data_stucture.PrintUtil;

import java.io.CharArrayReader;
import java.lang.reflect.Array;

/**
 * 在一个足够长的未排序数组中找到第一个查找数的下标
 *
 * @author
 * @create 2018-01-20 下午10:22
 **/
public class SearchBigSortedArray {


    public static void main(String [] args)
    {
        PrintUtil.print(searchBigSortedArray(new ArrayReader(),87));
    }


    /*
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return: An integer which is the first index of target.
     */
    public static int searchBigSortedArray(ArrayReader reader, int target) {

        if (reader == null) {
            return -1;
        }


        // write your code here
        int start = 0;
        int end = 1;

        while (reader.get(end) < target) {
            end *= 2;
        }

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (reader.get(mid) == target) {
                end = mid;
            } else if (reader.get(mid) > target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (reader.get(start) == target) {
            return start;
        }

        if (reader.get(end) == target) {
            return end;
        }

        return -1;


    }


    public static class ArrayReader {

        static int array[] = {1, 2, 4, 4, 5, 6, 87,87, 89};

        public int get(int k) {
            return array[k];
        }
    }


}
