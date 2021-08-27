public class M200_numIslands {
    int count = 0;
    int[] posx = {-1, 1, 0, 0};
    int[] posy = {0, 0, -1, 1};

    public int numIslands(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] map, int a, int b) {
        map[a][b] = 'x';
        boolean sign = true;
        for (int i = 0; i < posx.length; i++) {
            int newposx = a + posx[i];
            int newposy = b + posy[i];
            if (newposx >= 0 && newposx < map.length && newposy >= 0 && newposy < map[0].length) {
                if (map[newposx][newposy] == '1') {
                    sign = false;
                }
            }
        }
        if (sign)
            return;
        for (int i = 0; i < posx.length; i++) {
            int newposx = a + posx[i];
            int newposy = b + posy[i];
            if (newposx >= 0 && newposx < map.length && newposy >= 0 && newposy < map[0].length && map[newposx][newposy] == '1')
                dfs(map, a + posx[i], b + posy[i]);
        }
    }

    public static void main(String[] args) {

    }
}
