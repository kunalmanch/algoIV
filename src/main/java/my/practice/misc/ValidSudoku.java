package my.practice.misc;

/**
 * Validate a Sudoku game
 */
public class ValidSudoku {

    public static boolean isValid(char[][] mat) {
        //check for each row
        for (int i = 0; i < mat.length; i++) {
            boolean[] a = new boolean[mat.length];
            for (int j = 0; j < mat.length; j++) {
                if (mat[i][j] != '.') {
                    if (a[(int) mat[i][j] - '1']) {
                        return false;
                    }
                    a[(int) mat[i][j] - '1'] = true;
                }
            }
        }

        //check for each column
        for (int j = 0; j < mat.length; j++) {
            boolean[] a = new boolean[mat.length];
            for (int i = 0; i < mat.length; i++) {
                if (mat[i][j] != '.') {
                    if (a[(int) mat[i][j] - '1']) {
                        return false;
                    }
                    a[(int) mat[i][j] - '1'] = true;
                }
            }
        }

        //check for each 3 * 3 sub-matrix
        for (int block = 0; block < 9; block++) {
            boolean[] a = new boolean[mat.length];
            for (int i = block / 3 * 3; i < block / 3 * 3 + 3; i++) {
                for (int j = block % 3 * 3; j < block % 3 * 3 + 3; j++) {
                    if (mat[i][j] != '.') {
                        if (a[(int) mat[i][j] - '1']) {
                            return false;
                        }
                        a[(int) mat[i][j] - '1'] = true;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
