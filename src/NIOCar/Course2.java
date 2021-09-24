package NIOCar;

public class Course2 {
    int[] posx = {0, 0, 1, -1};
    int[] posy = {-1, 1, 0, 0};

    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O')
                board = dfs(board, i, 0);
        }
        for (int i = 0; i < board.length; i++) {
            if (board[i][board[0].length - 1] == 'O')
                board = dfs(board, i, board[0].length - 1);
        }
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O')
                board = dfs(board, 0, i);
        }
        for (int i = 0; i < board[0].length; i++) {
            if (board[board.length - 1][i] == 'O')
                board = dfs(board, board.length - 1, i);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'Q')
                    board[i][j] = 'O';
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }

    public char[][] dfs(char[][] board, int i, int j) {
        board[i][j] = 'Q';
        for (int k = 0; k < 4; k++) {
            if (i + posx[k] >= 0 && i + posx[k] < board.length &&
                    j + posy[k] >= 0 && j + posy[k] < board[0].length &&
                    board[i + posx[k]][j + posy[k]] == 'O') {
                board = dfs(board, i + posx[k], j + posy[k]);
            }
        }
        return board;
    }

    public static void main(String[] args) {
        char[][] map = {{'O', 'X', 'X', 'O'},
                {'X', 'O', 'O', 'X'},
                {'X', 'O', 'O', 'X'},
                {'O', 'X', 'X', 'O'},
        };
        new Course2().solve(map);
        System.out.println(1);
    }
}
