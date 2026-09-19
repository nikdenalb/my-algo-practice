package training10.warmup.task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/97116/problems?id=30404%2F2026_07_31%2FZS55UtlGQH">
 * Матрица-палиндром
 * </a>
 * <br><br>
 * The contest deadline was missed. This is the refined solution.<br>
 */
public class Main {

    int solve(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int out = 0;

        for (int i1 = 0; i1 < (n + 1) / 2; i1++) {
            for (int j1 = 0; j1 < (m + 1) / 2; j1++) {
                int i2 = n - 1 - i1;
                int j2 = m - 1 - j1;

                int a = matrix[i1][j1];
                int b = matrix[i1][j2];
                int c = matrix[i2][j1];
                int d = matrix[i2][j2];

                /*
                    a(11)   b(12)

                    c(21)   d(22)
                */

                if (i1 == i2 && j1 == j2) out += cntChanges(a);
                else if (i1 == i2) out += cntChanges(a, b);
                else if (j1 == j2) out += cntChanges(a, c);
                else out += cntChanges(a, b, c, d);
            }
        }
        return out;
    }

    int cntChanges(int... nums) {
        int len = nums.length;
        Arrays.sort(nums);

        int maxSame = 0, cnt = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] == nums[i - 1]) cnt++;
            else {
                maxSame = Math.max(maxSame, cnt);
                cnt = 1;
            }
        }
        maxSame = Math.max(maxSame, cnt);

        return len - maxSame;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nm = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix = new int[nm[0]][];
        for (int i = 0; i < nm[0]; i++)
            matrix[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        writer.write(String.valueOf(new Main().solve(matrix)));

        reader.close();
        writer.close();
    }
}
