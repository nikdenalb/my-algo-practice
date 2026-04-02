package block3.contest7.task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * OK<br>
 * 1st try<br>
 * ~ 29 min<br>
 * I found this task difficult, switched to another one, solved it, and then came back to this one.
 * The time is approximate, since I can’t say exactly when I switched.
 */
public class Main {
    long solve(int n, String s) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int ab = 0;
        long out = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') ab++;
            else ab--;

            int abcnt = map.getOrDefault(ab, 0);
            out += abcnt;
            map.put(ab, abcnt + 1);
        }
        return out;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        String s = reader.readLine();
        writer.write(String.valueOf(new Main().solve(n, s)));

        reader.close();
        writer.close();
    }
}
