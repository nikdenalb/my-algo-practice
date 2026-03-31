package block3.taskd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/89523/problems?id=30404%2F2019_04_20%2FX5XQ74CADd">
 * Sum of numbers (Yandex Contest)
 * </a>
 */
public class Main {

    /**
     * Constraints (from statement):<br>
     * - 1 &lt;= N &lt;= 100000<br>
     * - 1 &lt;= K &lt;= 10<sup>9</sup><br>
     * - each number is in [1, 999]<br>
     * - time limit 1 s, memory 64 MB<br>
     * <br>
     * Counts contiguous segments with sum exactly k.
     * <br>
     * Since all numbers are positive, a two-pointers window works:
     * expand right border, shrink left while sum is too large,
     * and count each time sum becomes exactly k.
     *
     * @param arr parking numbers
     * @param k target sum
     * @return number of valid contiguous segments
     */
    int solve(int[] arr, int k) {
        int cnt = 0;
        int i = 0;
        int sum = 0;
        for (int v : arr) {
            sum += v;
            while (sum > k) sum -= arr[i++];
            if (sum == k) {
                cnt++;
                sum -= arr[i++];
            }
        }
        return cnt;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] NK = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        writer.write(String.valueOf(new Main().solve(nums, NK[1])));

        reader.close();
        writer.close();
    }
}
