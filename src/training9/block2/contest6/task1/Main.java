package block2.contest6.task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.TreeMap;

/**
 * OK<br>
 * 1st try<br>
 * 32 min
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = reader.readLine();
        Map<Long, Long> map = new TreeMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(Long.parseLong(s.charAt(i) + ""), map.getOrDefault(Long.parseLong(s.charAt(i) + ""), 0L) + 1);
        }
        long sum = map.keySet().stream().map(e -> e * map.get(e)).reduce(0L, Long::sum);
        StringBuilder out = new StringBuilder();
        if (sum % 3 == 0) {
            map.forEach((k, v) -> out.append(String.valueOf(k).repeat(v.intValue())));
            writer.write(out.reverse().toString());
            reader.close();
            writer.close();
            return;
        } else if (sum % 3 == 1) {
            if (!tryAndRemove(map, rem1)) {
                tryAndRemove(map, rem2);
                tryAndRemove(map, rem2);
            }
        } else {
            if (!tryAndRemove(map, rem2)) {
                tryAndRemove(map, rem1);
                tryAndRemove(map, rem1);
            }
        }

        map.forEach((k, v) -> out.append(String.valueOf(k).repeat(v.intValue())));
        writer.write(out.reverse().toString());

        reader.close();
        writer.close();
    }

    static long[] rem1 = {1, 4, 7};
    static long[] rem2 = {2, 5, 8};


    static boolean tryAndRemove(Map<Long, Long> map, long[] digs) {
        for (long d : digs) {
            if (removeDig(map, d)) return true;
        }
        return false;
    }

    static boolean removeDig(Map<Long, Long> map, long dig) {
        long v = map.getOrDefault(dig, 0L);
        if (v == 0) return false;
        if (v == 1) map.remove(dig);
        else map.put(dig, v - 1);
        return true;
    }
}
