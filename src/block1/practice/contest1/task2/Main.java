package block1.practice.contest1.task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * OK<br>
 * 1st try<br>
 * 32 min
 */
public class Main {

    int solve(int l, int r, int x, int coord) {
        if (coord >= l && coord <= r) {
            if ((coord - l) % 2 == 0) {
                return x;
            } else {
                return -x;
            }
        }
        return 0;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Main sol = new Main();

        int[] nm = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[][] events = new int[nm[0]][3];

        for (int i = 0; i < nm[0]; i++) {
            events[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        StringBuilder out = new StringBuilder();

        for (int i = 0; i < nm[1]; i++) {
            int j = Integer.parseInt(reader.readLine());
            long ans = 0;
            for (int[] event : events) {
                ans += sol.solve(event[0], event[1], event[2], j);
            }
            out.append(ans).append("\n");
        }

        if (!out.isEmpty()) out.setLength(out.length() - 1);

        writer.write(out.toString());

        reader.close();
        writer.close();
    }
}
