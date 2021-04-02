public class H面试题1721_trap {
    public int trap(int[] height) {
        int n = height.length;
        int i = 0;
        int total = 0;
        while (i < n - 2) {
            if (height[i + 1] < height[i]) {
                int j = i + 2;
                int maxj = j;
                for (int k = j; k < n; k++) {
                    if (height[k] > height[maxj])
                        maxj = k;
                    if (height[maxj] > height[i])
                        break;
                }
                while (height[i + 1] > height[maxj])
                    i++;
                int nowtotal = Math.min(height[maxj], height[i]) * (maxj - i - 1);
                for (int k = i + 1; k < maxj; k++)
                    nowtotal -= height[k];
                total += nowtotal;
                i = maxj;
            } else
                i++;
        }
        return total;
    }

    public static void main(String[] args) {
        int[] height = {5, 5, 4, 7, 8, 2, 6, 9, 4, 5};
        System.out.println(new H面试题1721_trap().trap(height));
    }
}
