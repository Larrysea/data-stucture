package testproblem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static java.lang.Float.NaN;
import static javax.swing.text.html.parser.DTDConstants.NAMES;
import static jdk.nashorn.internal.objects.Global.undefined;

/**
 * Created by Larry-sea on 2017/1/22.
 */
public class test {

    public static void main(String ss[]) {
        String token="userId_7482304724";
        getUserId(token);

    }


    public static void addProperty(Person person) {
        person.setFlag(true);
        person.setAge(21);
        person.setName("dahfhlaskdf");
        // return person;
    }


    public static String getUserId(String token) {
        int endIndex = 0;
        if (token != null) {
            endIndex = token.indexOf('_');
            return token.substring(0, endIndex);

        }
        return null;
    }

}
