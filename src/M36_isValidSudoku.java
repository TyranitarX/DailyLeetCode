/**
 * Author : TyranitarX
 * Date : 2021-9-17 9:01
 */
public class M36_isValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][][] boxes = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char now = board[i][j];
                if (now != '.') {
                    rows[i][now - '0' - 1]++;
                    cols[j][now - '0' - 1]++;
                    boxes[i / 3][j / 3][now - '0' - 1]++;
                    if (rows[i][now - '0' - 1] > 1 || cols[j][now - '0' - 1] > 1 || boxes[i / 3][j / 3][now - '0' - 1] > 1)
                        return false;
                }
            }
        }
        return true;
    }
}
