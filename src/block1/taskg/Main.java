package block1.taskg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/89515/problems?id=30404%2F2021_08_20%2FivtVjWoF0V&contestId=89515">
 * Houses and shops (Yandex Contest)
 * </a>
 */
public class Main {

    /**
     * Returns the maximum distance from a house to its nearest shop.
     * <br>
     * Constraints: length(arr) = 10; values are in {0, 1, 2}; at least one house and one shop.<br>
     * <br>
     * Example: [2, 0, 1, 1, 0, 1, 0, 2, 1, 2]→3
     *
     * @param arr array of building types (0 office, 1 house, 2 shop)
     * @return maximum distance from any house to the nearest shop
     */
    int solve(int[] arr) {
        int out = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                int l = Integer.MAX_VALUE, r = Integer.MAX_VALUE;
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] == 2) {
                        r = j - i;
                        break;
                    }
                }
                for (int j = i - 1; j >= 0; j--) {
                    if (arr[j] == 2) {
                        l = i - j;
                        break;
                    }
                }
                out = Math.max(out, Math.min(l, r));
            }
        }
        return out;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Main sol = new Main();
        writer.write(String.valueOf(sol.solve(arr)));

        reader.close();
        writer.close();
    }
}
