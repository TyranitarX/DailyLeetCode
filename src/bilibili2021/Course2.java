package bilibili2021;

public class Course2 {
    static int count = 0;
    static int[] posx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] posy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) {
        int[][] map = {{1, 1, 1, 1, 0}, {1, 1, 0, 1, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 0, 0}};
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 1) {
                    dfs(map, i, j);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static void dfs(int[][] map, int a, int b) {
        map[a][b] = -1;
        for (int i = 0; i < posx.length; i++) {
            int newposx = a + posx[i];
            int newposy = b + posy[i];
            if (newposx >= 0 && newposx < map.length && newposy >= 0 && newposy < map[0].length && map[newposx][newposy] == 1)
                dfs(map, a + posx[i], b + posy[i]);
        }
    }
}
