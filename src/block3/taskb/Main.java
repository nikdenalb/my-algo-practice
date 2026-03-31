package block3.taskb;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/89523/problems?id=928%2F2026_02_18%2F6ruPHNt9QT">
 * Range sum without updates (Yandex Contest)
 * </a>
 * <br><br>
 * Constraints:<br>
 * - 1 &lt;= N &lt;= 10<sup>5</sup><br>
 * - 0 &lt;= A_i &lt;= 10<sup>9</sup><br>
 * - 1 &lt;= Q &lt;= 10000<br>
 * - 0 &lt;= X0 &lt;= 10<sup>9</sup><br>
 * - random generator: X_i = (11173 * X_(i-1) + 1) mod 1000000007<br>
 * - time limit 1 s, memory 256 MB<br>
 */
public class Main {

    int[] pref;

    void prep(int[] arr) {
        pref = new int[arr.length + 1];
        for (int i = 1; i < pref.length; i++) pref[i] = (arr[i - 1] + pref[i - 1]) % mod;
    }

    /**
     * Returns sum on inclusive segment [L, R] using prepared prefix sums.
     *
     * @param L left index
     * @param R right index
     * @return segment sum modulo 1000000007
     */
    int sumLR(int L, int R) {
        return (pref[R + 1] - pref[L] + mod) % mod;
    }

    static int mod = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(reader.readLine());
        int[] A = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Main sol = new Main();
        sol.prep(A);

        int Q = Integer.parseInt(reader.readLine());
        int X0 = Integer.parseInt(reader.readLine());
        int[] X = new int[2 * Q];
        X[0] = X0;
        for (int i = 1; i < X.length; i++) X[i] = (int) ((11173L * X[i - 1] + 1) % mod);

        int sum = 0;
        for (int i = 0; i < Q; i++) {
            int L = Math.min(X[2 * i] % N, X[2 * i + 1] % N);
            int R = Math.max(X[2 * i] % N, X[2 * i + 1] % N);
            sum = (sum + sol.sumLR(L, R)) % mod;
        }
        writer.write(String.valueOf(sum));

        reader.close();
        writer.close();
    }
}
