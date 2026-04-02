package block3.contest7.task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Map;

/**
 * OK<br>
 * 1st try<br>
 * ~ 17 min<br>
 * I switched to this task after getting stuck on another one. The recorded time is approximate.
 */
public class Main {

    int solve(int n, int[] p) {
        int out = 0;
        int i = 0;
        Map<Integer, Integer> map = new java.util.HashMap<>();
        for (int j = 0; j < n; j++) {
            map.put(p[j], map.getOrDefault(p[j], 0) + 1);
            while (map.size() > 2) {
                int v = map.get(p[i]);
                if (v == 1) map.remove(p[i]);
                else map.put(p[i], v - 1);
                i++;
            }

            if (map.size() == 2) {
                out = Math.max(out, j - i + 1);
            }
        }
        return out;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int[] p = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        writer.write(String.valueOf(new Main().solve(n, p)));

        reader.close();
        writer.close();
    }
}
