package testproblem;

/**
 * Created by Larry-sea on 2017/3/19.
 * <p>
 * 将整型数字转换为字符串
 */
public class IntegerToString {

    public static void main(String[] args) {

        String result = intergerToString(-999);
        System.out.println(result.toString());
    }


    /**
     * @param parm 输入的整型参数转换为String类型
     * @return 返回这个整型的string形式
     */
    public static String intergerToString(int parm) {
        char intArray[] = new char[12];

        int arrayLength = 0;
        boolean isLessZero = false;
        if (parm < 0) {
            isLessZero = true;
            intArray[0] = '-';
            arrayLength++;
            parm = -1 * parm;
        }
        try {
            while (parm != 0) {

                intArray[arrayLength] = intToChar(parm % 10);
                parm = parm / 10;
                arrayLength++;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return new String(intArray);

    }


    public static char intToChar(int number) throws Exception {
        if (number <= 9 && number >= 0) {

        } else {
            throw new IllegalArgumentException("number illegal exception");
        }
        char result = 'e';
        switch (number) {
            case 0:
                result = '0';
                break;
            case 1:
                result = '1';
                break;
            case 2:
                result = '2';
                break;
            case 3:
                result = '3';
                break;
            case 4:
                result = '4';
                break;
            case 5:
                result = '5';
                break;
            case 6:
                result = '6';
                break;
            case 7:
                result = '7';
                break;
            case 8:
                result = '8';
                break;
            case 9:
                result = '9';
                break;

        }
        return result;

    }

}
