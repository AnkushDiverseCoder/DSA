package graph;

public class WordSearch {

    public static boolean search(char[][] board, boolean[][] vis, String word, int stri, int i, int j) {
        if (stri == word.length()) {
            return true;
        }
        
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || vis[i][j] || board[i][j] != word.charAt(stri)) {
            return false;
        }
        
        
        vis[i][j] = true;
         boolean found =
        search(board, vis, word, stri + 1, i + 1, j) ||
        search(board, vis, word, stri + 1, i - 1, j) ||
        search(board, vis, word, stri + 1, i, j + 1) ||
        search(board, vis, word, stri + 1, i, j - 1);

    vis[i][j] = false;
    return found;

    }

    public static void main(String[] args) {
        String word = "ABCCED";
        boolean result = false;
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boolean[][] vis = new boolean[board.length][board[0].length];
                if (board[i][j] == word.charAt(0)) {
                    result = search(board, vis, word, 0, i, j);
                    if (result) {
                        System.out.println(true);
                        return;
                    };
                }
            }
        }
            System.out.println(false);
    }
}
