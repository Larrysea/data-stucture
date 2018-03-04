package data_stucture;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Larry-sea on 2017/10/14.
 */
public class PrintUtil {

    public static void println(String params) {
        System.out.println(params);
    }

    public static void print(String params) {
        System.out.print(params);
    }

    public static void print(int params) {
        System.out.println(params);
    }


    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> child = new ArrayList();
        child.add(1);
        child.add(2);
        child.add(3);
        result.add(child);
        List<Integer> child1 = new ArrayList<>();
        child1.add(4);
        child1.add(5);
        child1.add(6);
        result.add(child1);
        print(result);
    }


    public static void print(List<List<Integer>> integerList) {
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < integerList.size(); i++) {
            result.add(integerList.get(i).toString());
        }
        for (String params : result) {
            System.out.println(params);
        }

    }

    public static void printList(List<Integer> list) {
        for (Integer param : list) {
            System.out.println(param);
        }
    }


    public static void printlnStringList(List<String> list) {
        if (list == null) {
            return;
        }
        for (String param : list) {
            System.out.println(param);
        }
    }


    public static void printStringList(List<String> list) {
        if (list == null) {
            return;
        }
        for (String param : list) {
            System.out.print(param + " ");
        }
    }

    public static void printArray(final int[] array) {
        if (array != null && array.length > 0) {
            for (int index = 0; index < array.length; index++) {
                System.out.print(" " + array[index]);
            }
        }
        System.out.println();
    }


    /**
     * @param matrix
     */
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

    }

    public static void printMatrix(boolean[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }


    public static void printStringListList(List<List<String>> list) {
        for (List<String> sonList : list) {
            printStringList(sonList);
            System.out.println();

        }
    }

    public static void isTrue(boolean bool) {
        if (bool) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }


    public static void print(double params) {
        System.out.println(params);
    }
}

