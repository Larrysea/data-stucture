package testproblem;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Larry-sea on 2017/2/1.
 */
public class StorageStudent {
    static List<student> studentList = new LinkedList<>();

   public  class student {
        String name;    //学生姓名
        int age;        //学生年龄

        public student(String userName, int age) {
            if (userName.isEmpty()) {
                System.out.println("姓名不能为空");
                return;
            }
            if (age <= 0 || age > 140) {
                System.out.println("请输入合法的年龄");
                return;
            }
            this.name = userName;
            this.age = age;
        }
    }

    /**
     * @param student  存储学生信息
     */
    public void storageStudent(student student) {
        studentList.add(student);
    }


}
