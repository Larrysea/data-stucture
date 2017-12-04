package leetcode;

/**
 * Created by Larry-sea on 2016/12/14.
 * <p>
 * <p>
 * leetcode 6
 */
public class ZigZag {

    String resultString = "PAHNAPLSIIGYIR";

    static public String converToZigZagString(String inputString, int row) {
        String result = "";
        int incIndex = 0;
        if (row == 1) {
            return inputString;
        }
        for (int position = 0; position < row; position++) {
            incIndex = position;
            if (position == 0 || position == row - 1) {
                while (incIndex < inputString.length()) {
                    result += inputString.charAt(incIndex);
                    incIndex += (2 * row - 2);

                }
            } else {
                while (incIndex < inputString.length()) {
                    result += inputString.charAt(incIndex);
                    incIndex += (row - 1);
                }
            }

        }
        System.out.println(result);
        return result;
    }


    public String convertZigzagString(String inputString)
    {

         return null;
    }
}
