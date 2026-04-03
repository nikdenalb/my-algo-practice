package block3.contest8.task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * OK<br>
 * 1st try<br>
 * 38 min
 */
public class Main {

    //[][][][][][][][][][][]
    //[][][][][][][][][][][]
    int solve(int[] t, int[] k, int d) {
        int len = t.length;
        long[] kurr = new long[len];
        kurr[0] = k[0];
        int out = len;

        for (int i = 1; i < len; i++) {
            kurr[i] = kurr[i - 1] + k[i];
        }

        for (int i = len - 1; i >= 0 && t[i] - (i > 0 ? kurr[i - 1] : 0) >= d; i--) out = i;

        return out;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int cases = Integer.parseInt(reader.readLine());
        StringBuilder out = new StringBuilder();
        Main sol = new Main();

        for (int i = 0; i < cases; i++) {
            int[] nd = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] t = new int[nd[0]];
            int[] k = new int[nd[0]];
            for (int j = 0; j < nd[0]; j++) {
                int[] tk = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                t[j] = tk[0];
                k[j] = tk[1];
            }
            out.append(sol.solve(t, k, nd[1]) + 1).append("\n");
        }
        out.setLength(out.length() - 1);
        writer.write(out.toString());

        reader.close();
        writer.close();
    }
}
