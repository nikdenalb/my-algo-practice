package block3.taskc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/89523/problems?id=7%2F2020_11_06%2FoQhYgpLhih">
 * Maximal Sum (Yandex Contest)
 * </a>
 * <br><br>
 * Constraints:<br>
 * - 1 &lt;= n &lt;= 3 * 10<sup>5</sup><br>
 * - -10<sup>9</sup> &lt;= a_i &lt;= 10<sup>9</sup><br>
 * - time limit 3 s, memory 256 MB<br>
 */
public class Main {

    /**
     * Finds the maximum sum over all non-empty contiguous subarrays.
     * <br>
     * Approach: Kadane algorithm. Keep the best prefix ending at current position;
     * reset current sum to zero when it becomes negative; track global maximum.
     * <br>
     * Works correctly for all-negative arrays because the initial answer is a[0].
     *
     * @param a input array
     * @return maximal segment sum
     */
    long solve(int[] a) {
        long out = a[0];
        long sum = 0;
        for (int i : a) {
            sum += i;
            out = Math.max(out, sum);
            if (sum < 0) sum = 0;
        }
        return out;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        reader.readLine(); // int n = Integer.parseInt(reader.readLine());
        int[] a = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        writer.write(String.valueOf(new Main().solve(a)));

        reader.close();
        writer.close();
    }
}
