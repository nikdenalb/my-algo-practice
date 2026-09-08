package block4.contest10.task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * OK<br>
 * 1st try<br>
 * 33 min
 */
public class Main {

    int solve(int n, int m, char[][] mtx) {
        int cnt = 0;
        boolean[][] vstd = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mtx[i][j] != '#' || vstd[i][j]) continue;
                cnt++;
                int k = 1;
                while (i + k < n && j + k < m) {
                    int x = i + k;
                    int y = j + k;
                    boolean flag = true;

                    for (int yy = j; yy < y; yy++) {
                        if (mtx[x][yy] != '#' || vstd[x][yy]) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        for (int xx = i; xx <= x; xx++) {
                            if (mtx[xx][y] != '#' || vstd[xx][y]) {
                                flag = false;
                                break;
                            }
                        }
                    }
                    if (!flag) break;
                    k++;
                }

                for (int x = i; x < i + k; x++) {
                    for (int y = j; y < j + k; y++) {
                        vstd[x][y] = true;
                    }
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] mn = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        char[][] m = new char[mn[0]][];
        for (int i = 0; i < mn[0]; i++) {
            m[i] = reader.readLine().replaceAll(" ", "").toCharArray();
        }
        writer.write(String.valueOf(new Main().solve(mn[0], mn[1], m)));

        reader.close();
        writer.close();
    }
}
