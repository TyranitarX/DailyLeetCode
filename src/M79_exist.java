public class M79_exist {
    public boolean exist(char[][] board, String word) {
        int h = board.length;
        int w = board[0].length;
        boolean[][] visited = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                boolean flag = dfs(visited, board, word, 0, i, j);
                if (flag)
                    return true;
            }
        }
        return false;
    }

    public boolean dfs(boolean[][] visited, char[][] board, String word, int pos, int i, int j) {
        if (board[i][j] != word.charAt(pos))
            return false;
        else if (pos == word.length() - 1)
            return true;
        visited[i][j] = true;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;
        for (int[] direction : directions) {
            int nexti = i + direction[0];
            int nextj = j + direction[1];
            if (nexti >= 0 && nextj >= 0 && nexti < board.length && nextj < board[0].length && !visited[nexti][nextj]) {
                boolean flag = dfs(visited, board, word, pos + 1, nexti, nextj);
                if (flag) {
                    result = true;
                    break;
                }

            }
        }
        visited[i][j] = false;
        return result;
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "SEE";
        System.out.println(new M79_exist().exist(board, word));
    }
}
