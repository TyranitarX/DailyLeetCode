package NIOCar;

public class Course3 {
    int count = 0;

    public int countPath(int[][] map, int n, int m) {
        int a = 0, b = 0, x = 0, y = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 1) {
                    a = i;
                    b = j;
                }
                if (map[i][j] == 2) {
                    x = i;
                    y = j;
                }
            }
        }
        dfs(map, a, b, x, y);
        return count;
    }

    void dfs(int[][] map, int a, int b, int x, int y) {
        if (a == x && b == y) {
            count++;
            return;
        }
    }
}
