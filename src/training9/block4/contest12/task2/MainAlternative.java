package block4.contest12.task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainAlternative {

    boolean solve(char[][] board) {
        int cnt1 = 4, cnt2 = 3, cnt3 = 2, cnt4 = 1;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (board[i][j] == '.') continue;
                int ti = i, tj = j;

                int cnt = 1;
                board[i][j] = '.';
                boolean flag;
                do {
                    flag = false;
                    int ai = Math.max(0, i - 1), aj = Math.max(0, j - 1);
                    int bi = Math.min(9, i + 1), bj = Math.min(9, j + 1);
                    for (int i1 = ai; i1 <= bi; i1++) {
                        for (int j1 = aj; j1 <= bj; j1++) {
                            if (flag && board[i1][j1] == '#') return false;
                            if (board[i1][j1] == '#') {
                                if (i1 == i || j1 == j) {
                                    i = i1;
                                    j = j1;
                                    cnt++;
                                    board[i][j] = '.';
                                    flag = true;
                                } else return false;
                            }
                        }
                    }
                } while (flag);

                if (cnt > 4) return false;
                switch (cnt) {
                    case 1 -> cnt1--;
                    case 2 -> cnt2--;
                    case 3 -> cnt3--;
                    case 4 -> cnt4--;
                }

                i = ti;
                j = tj;
            }
        }

        return cnt1 == 0 && cnt2 == 0 && cnt3 == 0 && cnt4 == 0;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        char[][] board = new char[10][10];

        for (int i = 0; i < 10; i++) board[i] = reader.readLine().toCharArray();

        writer.write(new MainAlternative().solve(board) ? "YES" : "NO");

        reader.close();
        writer.close();
    }
}
