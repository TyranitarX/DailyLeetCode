public class M130_SroundingArea {
    public void solve(char[][] board) {
        if (board.length == 0)
            return;
        int l = board.length;
        int l2 = board[0].length;
        if (l == 1 || l2 == 1 || l == 2 || l2 == 2)
            return;
        for (int i = 0; i < l2; i++) {
            board = dfs(board, 0, i);
            board = dfs(board, l - 1, i);
        }
        for (int i = 0; i < l; i++) {
            board = dfs(board, i, 0);
            board = dfs(board, i, l2 - 1);
        }
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l2; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == 'S') board[i][j] = 'O';
            }
        }
    }

    public char[][] dfs(char[][] board, int i, int j) {
        if (i >= 0 && j >= 0 && i < board.length && j < board[0].length && board[i][j] == 'O') {
            board[i][j] = 'S';
            dfs(board, i - 1, j);
            dfs(board, i + 1, j);
            dfs(board, i, j - 1);
            dfs(board, i, j + 1);
        }
        return board;
    }

    public static void main(String[] args) {
        char[][] map = {
                {'X', 'O', 'X', 'O', 'X', 'O' },
                {'O', 'X', 'O', 'X', 'O', 'X' },
                {'X', 'O', 'X', 'O', 'X', 'O' },
                {'O', 'X', 'O', 'X', 'O', 'X' },
        };
        new M130_SroundingArea().solve(map);
    }
}
