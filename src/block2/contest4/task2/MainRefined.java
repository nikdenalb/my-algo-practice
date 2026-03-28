package block2.contest4.task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/89536/problems?id=30404%2F2026_03_01%2Fxu67mpn1rH">
 * Paired k-prefixes (Yandex Contest)
 * </a>
 */
public class MainRefined {

    /**
     * Constraints (from statement):<br>
     * - 1 &lt;= n &lt;= 2 &middot; 10<sup>5</sup>, n even<br>
     * - all words same length; total number of characters &lt;= 2 &middot; 10<sup>6</sup><br>
     * <br>
     * Goal: maximum k such that the words can be split into pairs with at least k equal first characters in each pair.<br>
     * <br>
     * Approach in this implementation: sort {@code arr}, pair consecutive entries, and shrink the answer by each pair&apos;s common prefix length.<br>
     *
     * @param arr all n words (equal length)
     * @return maximum feasible k
     */
    int solve(String[] arr) {
        Arrays.sort(arr);
        int k = arr[0].length();
        for (int i = 0; i < arr.length; i += 2) {
            for (int j = 0; j < k; j++) {
                if (arr[i].charAt(j) != arr[i + 1].charAt(j)) {
                    k = j;
                    break;
                }
            }
        }
        return k;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) arr[i] = reader.readLine();
        writer.write(String.valueOf(new MainRefined().solve(arr)));

        reader.close();
        writer.close();
    }
}
