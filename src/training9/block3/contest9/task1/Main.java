package block3.contest9.task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * OK<br>
 * 1st try<br>
 * 31 min
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = reader.readLine();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        char min = map.keySet().stream().max(Comparator.naturalOrder()).get();
        int sum = map.entrySet().stream()
                .mapToInt(e -> (e.getKey() - 'A') * e.getValue())
                .sum();
        int out = min - 'A' - 1;
        if (out < 0) out = 0;

        int mid = (sum % s.length()) * 2 > s.length() ? sum / s.length() + 1 : sum / s.length();

        out = Math.max(out, mid);
        writer.write((char) (out + 'A'));


        reader.close();
        writer.close();
    }
}
