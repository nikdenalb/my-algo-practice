package block2.contest4.task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * OK<br>
 * 1st try<br>
 * 19 min
 */
public class Main {

    int solve(String[] arr) {
        int len = arr[0].length();
        Arrays.sort(arr);
        int out = len;
        for (int i = 0; i < arr.length; i += 2) {
            int j = 0;

            while (j < out && arr[i].charAt(j) == arr[i + 1].charAt(j)) {
                j++;
            }
            out = Math.min(out, j);
        }

        return out;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = reader.readLine();
        }

        writer.write(String.valueOf(new Main().solve(arr)));

        reader.close();
        writer.close();
    }
}
