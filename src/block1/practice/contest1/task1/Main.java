package block1.practice.contest1.task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * OK<br>
 * 1st try<br>
 * 12 min
 */
public class Main {

    int solve(int n, int m, String[] arr) {
        int out = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i].charAt(j) == '.' && arr[i + 1].charAt(j) == '.') {
                    out++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m - 1; j++) {
                if (arr[i].charAt(j) == '.' && arr[i].charAt(j + 1) == '.') {
                    out++;
                }
            }
        }


        return out;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nm = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String[] arr = new String[nm[0]];

        for (int i = 0; i < nm[0]; i++) {
            arr[i] = reader.readLine();
        }

        Main sol = new Main();

        writer.write(String.valueOf(sol.solve(nm[0], nm[1], arr)));

        reader.close();
        writer.close();
    }
}
