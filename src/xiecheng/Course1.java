package xiecheng;

import java.util.Scanner;

/**
 * 作者：hit_zt
 * 链接：https://www.nowcoder.com/discuss/737778?type=all&order=time&pos=&page=1&ncTraceId=&channel=-1&source_id=search_all_nctrack
 * 来源：牛客网
 * <p>
 * 【时间限制】： 3000MS 内存限制： 589824KB
 * 【题目描述】： 你需要编写一个程序来模拟目录的操作，一开始，你在根目录"\"，一共有两种命令：  ●  cd s: s为一个目录名，表示从当前工作目录的路径进入名为s的目录。
 * 特别地，"cd .."(即s=="..")表示返回上一级目录，若当前已为根目录，则无视该次操作。数据保证若s不为".."，则一定为小写字母组成的长度不超过10的字符串。  ● pwd: 表示查看当前工作目录的路径，你需要输出这个路径。    【输入描述】 第一个行是一个整数n，表示一共会有n个操作。  接下来每行是一条命令，命令的种类为问题描述中的二种之一。  注意，测试用例中cd s的操作，中间有空格。  输出描述 对于每个"pwd"命令，你需要单行输出当前的工作路径。   【样例输入】 7 cd a cd b pwd cd .. pwd cd .. pwd
 * 【样例输出】 \a\b \a \  （提示 1<=n<=300）
 */
public class Course1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        StringBuilder now = new StringBuilder("\\");
        String pre = "";
        for (int i = 0; i < n; i++) {
            String[] command = in.nextLine().split(" ");
            if (command.length > 1) {
                if (command[1].equals("..")) {
                    if (!now.toString().equals("\\")) {
                        int waittodelete = now.lastIndexOf("\\");
                        now.delete(waittodelete, now.length());
                        if (now.length() == 0)
                            now.append("\\");
                    }
                } else {
                    if (!command[1].equals(pre)) {
                        if (now.length() != 1)
                            now.append("\\");
                        now.append(command[1]);
                        pre = command[1];
                    }
                }
            } else {
                System.out.println(now);
            }
        }
    }
}
