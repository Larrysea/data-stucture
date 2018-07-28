package mockreview.bytedance;

import java.util.*;

/**
 * 判断是否是多边形
 *
 * @author
 * @create 2018-05-01 4:19 PM
 **/
public class IsPolygen {

    public static void main(String[] args) {
        judegeIsPolygen();
    }


    private static int INSERT = 1;

    private static int DELETE = 2;

    //判断是否是多边形
    public static void judegeIsPolygen() {


        Scanner scanner = new Scanner(System.in);


        int n = scanner.nextInt();

        if (n <= 0) {
            return;
        }

        int INSERT = 1;

        int DELETE = 2;

        List<Integer> queue = new LinkedList<Integer>();


        for (int i = 0; i < n; i++) {

            int type = scanner.nextInt();

            int number = scanner.nextInt();

            //如果类型为1
            if (type == INSERT) {
                judge(INSERT, queue, number);
            }
            //如果类型为2
            else if (type == DELETE) {
                judge(DELETE, queue, number);
            }

        }

    }


    private static void judge(int type, List<Integer> queue, int number) {
        System.out.println(number);
        if (type == INSERT && queue != null && queue.size() + 1 <= 2) {

            queue.add(number);
            Collections.sort(queue);

            System.out.println("No");
            return;
        }

        if (type == DELETE && queue != null && queue.size() - 1 <= 2) {
            queue.remove((Integer) number);
            Collections.sort(queue);
            System.out.println("No");
            return;
        }

        if (queue != null) {
            //如果插入为1
            if (type == INSERT) {
                queue.add(number);
                Collections.sort(queue);

                int minSum = queue.get(1) + queue.get(0);

                //最小的和大于第三边
                if (number < minSum) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");

                }


            } else if (type == DELETE) {

                queue.remove((Integer) number);
                Collections.sort(queue);

                int minSum = queue.get(1) + queue.get(0);

                int maxLength = queue.get(queue.size() - 1);

                if (maxLength < minSum) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }

            }

        }


    }


}
