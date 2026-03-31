package block3.taske;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/89523/problems?id=30404%2F2024_10_27%2F2rqPnG0bip">
 * Sum of triple products (Yandex Contest)
 * </a>
 */
public class Main {

    /**
     * Constraints (from statement):<br>
     * - 3 &lt;= n &lt;= 10<sup>6</sup><br>
     * - 0 &lt;= a<sub>i</sub> &lt;= 10<sup>6</sup><br>
     * - answer is required modulo 1000000007<br>
     * - time limit 2 s, memory 512 MB<br>
     * <br>
     * Goal: compute sum of a[i] * a[j] * a[k] over all indices i &lt; j &lt; k.<br>
     * <br>
     * Approach in this implementation:<br>
     * - for every position j as the middle index, keep prefix sum of elements before j
     *   and suffix sum of elements after j.<br>
     * - contribution of j is a[j] * prefixSum(j) * suffixSum(j), all modulo 1000000007.<br>
     * - sum contributions for all j from 1 to n-2.<br>
     *
     * @param n array length
     * @param a input sequence
     * @return required triple-products sum modulo 1000000007
     */
    int solve(int n, int[] a) {
        int[] prev = new int[n];
        for (int i = 1; i < n - 1; i++) prev[i] = (prev[i - 1] + a[i - 1]) % mod;

        int[] suff = new int[n];
        for (int i = n - 2; i > 0; i--) suff[i] = (suff[i + 1] + a[i + 1]) % mod;

        int out = 0;
        for (int i = 1; i < n - 1; i++) {
            int supref = (int) (((long) suff[i] * prev[i]) % mod);
            out = (int) ((out + (long) a[i] * supref) % mod);
        }
        return out;
    }

    int mod = 1000000007;


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int[] a = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        writer.write(String.valueOf(new Main().solve(n, a)));

        reader.close();
        writer.close();
    }
}
