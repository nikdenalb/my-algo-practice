package block4.contest12.task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * -<br>
 * no tries<br>
 * 36 min
 */
public class Main {

    boolean solve(char[][] board) {
        int cnt1 = 4;
        int cnt2 = 3;
        int cnt3 = 2;
        int cnt4 = 1;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int tempi = i;
                int tempj = j;


                if (board[i][j] == '.') continue;

                boolean row = false;
                boolean col = false;

                if (i + 1 < 10 && board[i + 1][j] == '#') col = true;

                if (j + 1 < 10 && board[i][j + 1] == '#') row = true;

                if (row && col) return false;

                int ai = Math.max(0, i - 1);
                int aj = Math.max(0, j - 1);
                int bi = -1;
                int bj = -1;

                if (!row && !col) {
                    board[i][j] = '.';
                    bi = Math.min(9, i + 1);
                    bj = Math.min(9, j + 1);
                    cnt1--;
                } else if (row) {
                    board[i][j] = '.';
                    int cnt = 1;
                    while (j < 10 && board[i][j + 1] == '#') {
                        cnt++;
                        j++;
                        board[i][j] = '.';
                    }
                    if (cnt > 4) return false;
                    switch (cnt) {
                        case 2 -> cnt2--;
                        case 3 -> cnt3--;
                        case 4 -> cnt4--;
                    }
                    bi = Math.min(9, i + 1);
                    bj = Math.min(9, j + 1);
                } else {
                    int cnt = 1;
                    while (i < 10 && board[i + 1][j] == '#') {
                        cnt++;
                        i++;
                        board[i][j] = '.';
                    }
                    if (cnt > 4) return false;
                    switch (cnt) {
                        case 2 -> cnt2--;
                        case 3 -> cnt3--;
                        case 4 -> cnt4--;
                    }
                    bi = Math.min(9, i + 1);
                    bj = Math.min(9, j + 1);
                }

                for (int k = ai; k <= bi; k++) {
                    for (int m = aj; m <= bj; m++) {
                        if (board[k][m] == '#') return false;
                    }
                }

                i = tempi;
                j = tempj;
            }
        }

        return cnt1 == 0 && cnt2 == 0 && cnt3 == 0 && cnt4 == 0;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        char[][] board = new char[10][10];

        for (int i = 0; i < 10; i++) {
            board[i] = reader.readLine().toCharArray();
        }

        writer.write(new Main().solve(board) ? "YES" : "NO");

        reader.close();
        writer.close();
    }
}
