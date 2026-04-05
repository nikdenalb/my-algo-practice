package block3.contest9.task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/89541/problems?id=30404%2F2025_04_26%2Fp1ZF4rAZuN">
 * Vasya's unlucky number (Yandex Contest)
 * </a>
 */
public class MainRefined {

    /**
     * Constraints (from statement):<br>
     * - 1 &lt;= N, K &lt;= 10<sup>5</sup><br>
     * - each prize value a<sub>i</sub> satisfies -10<sup>6</sup> &lt;= a<sub>i</sub> &lt;= 10<sup>6</sup><br>
     * - Vasya picks a contiguous block of prizes; the block sum must not be divisible by K; empty choice is allowed and yields 0<br>
     * - time limit 1 s, memory 256 MB<br>
     * <br>
     * Goal: maximize the total value of a chosen contiguous segment whose sum is not divisible by K, or 0 if no positive answer exists.<br>
     * <br>
     * Approach:<br>
     * - use prefix sums along the array; any segment sum is current prefix minus an earlier prefix at a cut before the segment.<br>
     * - scan left to right, keeping prefix sums and two best candidate prefix values to subtract so that the remainder of
     *   (current prefix minus chosen prefix) modulo K is nonzero when possible; update the running maximum of valid segment sums.<br>
     *
     * @param a prize values in order
     * @param K unlucky divisor
     * @return maximum achievable segment sum under the divisibility rule
     */
    long solve(int[] a, int K) {
        long sum = 0, min1 = 0, min2 = 100_000_000_000L, out = 0;

        for (int e : a) {
            sum += e;
            if ((sum - min1) % K != 0) out = Math.max(out, sum - min1);
            else out = Math.max(out, sum - min2);

            if ((sum - min1) % K == 0) min1 = Math.min(min1, sum);
            else if (sum < min1) {
                min2 = min1;
                min1 = sum;
            } else min2 = Math.min(min2, sum);
        }

        return out;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] NK = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] a = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        writer.write(String.valueOf(new MainRefined().solve(a, NK[1])));

        reader.close();
        writer.close();
    }
}
