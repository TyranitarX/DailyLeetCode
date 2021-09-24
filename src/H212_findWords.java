import java.util.*;

public class H212_findWords {
    Set<String> res = new HashSet<>();
    int[][] pos = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public List<String> findWords(char[][] board, String[] words) {

        int m = board.length;
        int n = board[0].length;
        boolean[][] visit;
        for (String word : words) {
            visit = new boolean[m][n];
            for (int j = 0; j < m; j++) {
                Arrays.fill(visit[0], false);
            }
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    dfs(board, visit, j, k, word, 0);
                }
            }
        }
        return new ArrayList<>(res);
    }

    void dfs(char[][] board, boolean[][] visit, int i, int j, String word, int k) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visit[i][j])
            return;
        visit[i][j] = true;
        if (board[i][j] == word.charAt(k)) {
            if (k == word.length() - 1) {
                res.add(word);
            } else {
                for (int[] po : pos) {
                    dfs(board, visit, i + po[0], j + po[1], word, k + 1);
                }
            }
        }
        visit[i][j] = false;
    }

    public static void main(String[] args) {
        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = {"eat", "oath", "rain", "pea"};
        System.out.println(new H212_findWords().findWords(board, words));

    }
}
