package mockreview;

import java.util.Scanner;

/**
 * 今日头条18 2 批面试题https://www.nowcoder.com/test/question/done?tid=14835892&qid=141047
 *
 * @author
 * @create 2018-04-04 上午1:34
 **/
public class FindKCount {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int peopleCount = scanner.nextInt();
        int[] peopleData = new int[peopleCount];
        for (int i = 0; i < peopleCount; i++) {
            peopleData[i] = scanner.nextInt();
        }
        int searchCount = scanner.nextInt();
        int[][] searchData = new int[searchCount][3];
        for (int i = 0; i < searchCount; i++) {
            for (int j = 0; j < 3; j++) {
                searchData[i][j] = scanner.nextInt();
            }
        }
//        int[] peopleData1 = {1, 2, 3, 3, 5};
//        int[][] searchData1 = {{1, 2, 1}, {2, 4, 5}, {3, 5, 3}};

        int[] resultArray = getHowPeopleLike(searchData, peopleData,searchCount);

        for (int i = 0; i < resultArray.length; i++) {
            System.out.println(resultArray[i]);
        }
    }


    public static int[] getHowPeopleLike(int[][] sourceData, int[] peopleData, int searchCount) {
        int searchColumnCount = sourceData[2][0];
        int[] resultArray = new int[searchCount];
        for (int i = 0; i < searchCount; i++) {
            resultArray[i] = getCount(sourceData[i], peopleData);
        }
        return resultArray;
    }




    private static int getCount(int[] column, int[] peopleLikeData) {
        int startIndex = column[0];
        int endIndex = column[1];
        int result = 0;

        int key = column[2];
        for (int i = startIndex - 1; i < endIndex && i < peopleLikeData.length; i++) {
            if (key == peopleLikeData[i]) {
                result++;
            }
        }
        return result;
    }
}
