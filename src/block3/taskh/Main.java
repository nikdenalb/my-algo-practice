package block3.taskh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/89524/problems?id=30404%2F2025_08_24%2FAdlDZ8GJ7Q">
 * Friendship won (Yandex Contest)
 * </a>
 */
public class Main {

    /**
     * Constraints (from statement):<br>
     * - 2 &lt;= n &lt;= 10<sup>6</sup><br>
     * - 1 &lt;= a<sub>i</sub> &lt;= 10<sup>9</sup><br>
     * - choose indices l and r with l &lt; r so Vasya eats tables [1..l], Masha eats [n..r]<br>
     * - time limit 6 s, memory 512 MB<br>
     * <br>
     * Goal: minimize absolute difference between eaten sums and output
     * that minimum together with one suitable pair (l, r).<br>
     * <br>
     * Approach in this implementation: two pointers from both ends.
     * Keep current difference SDV - SDM and move the side with larger current sum,
     * updating the best absolute value and corresponding indices.<br>
     *
     * @param n number of tables
     * @param a cheeses per table
     * @return array [minimum difference, left index, right index] in 0-based indices
     */
    int[] solve(int n, int[] a) {
        int l = 0, r = n - 1;
        int sumD = a[r] - a[l];
        int[] out = new int[]{Math.abs(sumD), l, r};
        while (l < r - 1) {
            if (sumD >= 0) sumD -= a[++l];
            else sumD += a[--r];

            if (Math.abs(sumD) < out[0]) {
                out[0] = Math.abs(sumD);
                out[1] = l;
                out[2] = r;
            }
        }
        return out;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int[] a = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] out = new Main().solve(n, a);
        writer.write(out[0] + " " + (out[1] + 1) + " " + (out[2] + 1));

        reader.close();
        writer.close();
    }
}
