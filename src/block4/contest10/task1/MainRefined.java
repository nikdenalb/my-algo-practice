package block4.contest10.task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/89542/problems?id=30404%2F2026_03_01%2F4ZbscdEIOI">
 * Counting squares (Yandex Contest)
 * </a>
 */
public class MainRefined {

    /**
     * Constraints (from statement):<br>
     * - 1 &lt;= n, m &lt;= 500<br>
     * - grid cells are '#' (bacteria) or '.' (empty)<br>
     * - every bacterium is a filled axis-aligned square; sides are parallel to image borders<br>
     * - time limit 1 s, memory 256 MB<br>
     * <br>
     * Goal: count the number of square bacteria in the image.<br>
     * <br>
     * Approach:<br>
     * - scan the matrix left-to-right, top-to-bottom; the first true cell of an unseen bacterium is its top-left corner.<br>
     * - from that corner, increase side length while the next bottom row segment and right column segment stay filled.<br>
     * - when expansion stops, erase that whole square from the matrix (set to false) so it is never counted again.<br>
     * - each bacterium is counted exactly once at its top-left corner.<br>
     *
     * @param n row count
     * @param m column count
     * @param mtx true for '#', false for '.'
     * @return number of square bacteria
     */
    int solve(int n, int m, boolean[][] mtx) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mtx[i][j]) {
                    cnt++;
                    int k = 1;
                    while (i + k < n && j + k < m) {
                        int eX = i + k;
                        int eY = j + k;
                        boolean flag = true;
                        for (int y = j; y < eY; y++) {
                            if (!mtx[eX][y]) {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            for (int x = i; x <= eX; x++) {
                                if (!mtx[x][eY]) {
                                    flag = false;
                                    break;
                                }
                            }
                        }
                        if (!flag) break;
                        k++;
                    }
                    for (int x = i; x < i + k; x++) for (int y = j; y < j + k; y++) mtx[x][y] = false;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] mn = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean[][] m = new boolean[mn[0]][mn[1]];
        for (int i = 0; i < mn[0]; i++) {
            String s = reader.readLine().replace(" ", "");
            for (int j = 0; j < mn[1]; j++) m[i][j] = s.charAt(j) == '#';
        }
        writer.write(String.valueOf(new MainRefined().solve(mn[0], mn[1], m)));

        reader.close();
        writer.close();
    }
}
