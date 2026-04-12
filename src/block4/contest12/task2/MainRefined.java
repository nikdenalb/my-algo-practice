package block4.contest12.task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/89544/problems?id=30404%2F2026_03_01%2F9vXvmMMKCU">
 * Ship placement (Yandex Contest)
 * </a>
 */
public class MainRefined {

    /**
     * Constraints (from statement):<br>
     * - fixed 10 × 10 grid; each cell is # (ship) or . (water)<br>
     * - fleet: one ship of four cells in a straight line, two of length three, three of length two, four single-cell ships (10 ships total), each axis-aligned<br>
     * - ship cells form a solid 1 × k or k × 1 rectangle; distinct ships may not touch even at a corner<br>
     * - answer YES if the pattern is a valid placement, otherwise NO<br>
     * - time limit 1 s, memory 256 MB<br>
     * <br>
     * Approach:<br>
     * - scan the grid; at each unvisited # treat it as the top-left anchor of one ship, determine horizontal vs vertical vs singleton, reject L-shapes or mixed directions.<br>
     * - erase the ship cells, map segment length to the remaining fleet quota for that size, and verify the axis-aligned bounding neighborhood of the ship contains no other # (no side or corner contact).<br>
     * - after processing all ships, accept only if every quota is exactly exhausted.<br>
     *
     * @param board mutable 10 × 10 grid of # and .
     * @return true if the board is a valid Battleship placement
     */
    boolean solve(char[][] board) {
        int cnt1 = 4, cnt2 = 3, cnt3 = 2, cnt4 = 1;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int tempi = i, tempj = j;

                if (board[i][j] == '.') continue;

                boolean row = false;
                boolean col = false;

                if (i + 1 < 10 && board[i + 1][j] == '#') col = true;
                if (j + 1 < 10 && board[i][j + 1] == '#') row = true;

                if (row && col) return false;

                int ai = Math.max(0, i - 1);
                int aj = Math.max(0, j - 1);
                int bi;
                int bj;

                if (!row && !col) {
                    board[i][j] = '.';
                    bi = Math.min(9, i + 1);
                    bj = Math.min(9, j + 1);
                    cnt1--;

                } else if (row) {
                    board[i][j] = '.';
                    int cnt = 1;
                    while (j + 1 < 10 && board[i][j + 1] == '#') {
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
                    board[i][j] = '.';
                    int cnt = 1;
                    while (i + 1 < 10 && board[i + 1][j] == '#') {
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

        for (int i = 0; i < 10; i++) board[i] = reader.readLine().toCharArray();

        writer.write(new MainRefined().solve(board) ? "YES" : "NO");

        reader.close();
        writer.close();
    }
}
