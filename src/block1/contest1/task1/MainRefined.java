package block1.contest1.task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/89533/problems?id=30404%2F2026_03_01%2FddXXToAYxk&contestId=89533">
 * Domino placement (Yandex Contest)
 * </a>
 */
public class MainRefined {

    /**
     * @param n    number of rows
     * @param m    number of columns
     * @param grid grid rows; '.' = free, '#' = occupied
     * @return number of ways to place one domino
     */
    int solve(int n, int m, String[] grid) {
        int cnt = 0;

        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < m; j++)
                if (grid[i].charAt(j) == '.' && grid[i + 1].charAt(j) == '.')
                    cnt++;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m - 1; j++)
                if (grid[i].charAt(j) == '.' && grid[i].charAt(j + 1) == '.')
                    cnt++;

        return cnt;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nm = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String[] grid = new String[nm[0]];
        for (int i = 0; i < nm[0]; i++) grid[i] = reader.readLine();

        writer.write(String.valueOf(new MainRefined().solve(nm[0], nm[1], grid)));

        reader.close();
        writer.close();
    }
}
