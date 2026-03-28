package block2.contest4.task1;

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
 * 16 min
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        Map<String, Long> map = new HashMap<>();
        long a = 0;
        long b = 0;
        for (int i = 0; i < n; i++) {
            String name = reader.readLine();
            map.put(name, 0L);
        }
        int m = Integer.parseInt(reader.readLine());
        for (int i = 0; i < m; i++) {
            String[] line = reader.readLine().split(" ");
            String name = line[1];
            String[] ab2 = line[0].split(":");
            long a2 = Long.parseLong(ab2[0]);
            long b2 = Long.parseLong(ab2[1]);
            map.put(name, map.get(name) + (a2 - a) + (b2 - b));
            a = a2;
            b = b2;
        }
        long max = map.values().stream().max(Long::compareTo).get();
        String outName = map.entrySet().stream().filter(e -> e.getValue().equals(max)).findAny().get().getKey();

        writer.write(outName + " " + max);

        reader.close();
        writer.close();
    }
}
