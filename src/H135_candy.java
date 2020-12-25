public class H135_candy {
    public int candy(int[] ratings) {
        if (ratings.length == 0)
            return 0;
        int now = 1;
        int total = 1;
        int asc = 1;
        int desc = 0;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                desc = 0;
                now = ratings[i] == ratings[i - 1] ? 1 : now + 1;
                total += now;
                asc = now;
            } else {
                desc++;
                if (desc == asc)
                    desc++;
                total += desc;
                now = 1;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[] ratings = {1, 0, 2};
        System.out.println(new H135_candy().candy(ratings));
    }
}
