package c_58;

public class Course2 {
    public int calculateExtraNum(int totalNum, int exchangeNum) {
        int res = 0;
        int ree = 0;
        int count = 0;
        while (totalNum >= exchangeNum) {
            res = totalNum / exchangeNum;
            ree = totalNum % exchangeNum;
            count += res;
            totalNum = res + ree;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Course2().calculateExtraNum(31, 3));
    }
}
