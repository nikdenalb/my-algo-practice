package warmup.task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/89606/problems?id=30404%2F2026_02_06%2F1U5A7PMMJk">
 * Oligopoly (Yandex Contest)
 * </a>
 */
public class MainRefined {

    /**
     * Determines for each company whether it can theoretically become a winner
     * in the "Oligopoly" game with the given starting capitals.
     * <br>
     * Constraints: 1 ≤ N ≤ 1e5, 1 ≤ a[i] ≤ 1e9, the array is given in
     * non-decreasing order.
     *
     * @param arr non-decreasing array of company capitals
     * @return the same array instance where each element is replaced by 1 or 0:
     * 1 if the corresponding company can become a winner, 0 otherwise
     */
    int[] solve(int[] arr) {
        int needed = 0;
        long sum = 0;

        for (int curr : arr) {
            if (sum <= curr) {
                if (needed == curr) needed++;
                else needed = curr;
            }
            sum += curr;
        }

        for (int i = 0; i < arr.length; i++) {
            if (needed <= arr[i]) arr[i] = 1;
            else arr[i] = 0;
        }

        return arr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        reader.readLine(); // skip N
        int[] arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        MainRefined sol = new MainRefined();

        writer.write(Arrays.stream(sol.solve(arr))
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(System.lineSeparator())));

        reader.close();
        writer.close();
    }
}
