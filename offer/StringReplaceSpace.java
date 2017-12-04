package offer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Larry-sea on 2017/1/21.
 * <p>
 * 替换字符中的空格
 */
public class StringReplaceSpace {

   /* static public String replaceSpace(StringBuffer sourceBuffer) throws Exception {
        if (sourceBuffer == null) {
            throw new Exception("source buffer cant empty");
        }

        for (int position = 0; position < sourceBuffer.length(); position++) {
            if (sourceBuffer.substring(position, position + 1).equals(" ")) {
                sourceBuffer.replace(position, position + 1, "%20");
            }

        }
        return sourceBuffer.toString();
    }*/

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("we are happy");
        try {

            System.out.println(replaceSpace(stringBuffer));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static public String replaceSpace(StringBuffer sourceBuffer) throws Exception {
        if (sourceBuffer == null) {
            throw new Exception("source buffer cant empty");
        }

        for (int position = 0; position < sourceBuffer.length(); position++) {
            if (sourceBuffer.charAt(position) == ' ') {
                sourceBuffer.delete(position, position + 1);
                sourceBuffer.insert(position, '%');
                sourceBuffer.insert(position + 1, '2');
                sourceBuffer.insert(position + 2, '0');
            }

        }
        return sourceBuffer.toString();
    }

    public void receiveFromClient() throws IOException {
        int assignPort = 80;                                    //指定的接受端口,这个端口号不是固定的是和客户端协定的
        ServerSocket serverSocket = new ServerSocket(assignPort);
        serverSocket.setReuseAddress(true);                    //设置地址可以复用
        serverSocket.setSoTimeout(2000);                       //设置连接的超时时间
        Socket inputSocket = serverSocket.accept();            //这个是一个阻塞方法等待客户端连接
        inputSocket.getInputStream();                          //获取输入流中的数据
        serverSocket.close();                                  //关闭服务端
        inputSocket.close();                                   //关闭输入流

    }
}
