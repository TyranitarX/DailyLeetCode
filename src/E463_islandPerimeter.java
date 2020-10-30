public class E463_islandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int total = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int count = 0;
                    if (i - 1 >= 0 && grid[i - 1][j] == 1)
                        count += 1;
                    if (j - 1 >= 0 && grid[i][j - 1] == 1)
                        count += 1;
                    if (i + 1 < grid.length && grid[i + 1][j] == 1)
                        count += 1;
                    if (j + 1 < grid[i].length && grid[i][j + 1] == 1)
                        count += 1;
                    total += 4 - count;
                }
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };
        System.out.println(new E463_islandPerimeter().islandPerimeter(grid));
    }
}
