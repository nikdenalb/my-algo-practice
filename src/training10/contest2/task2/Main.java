package training10.contest2.task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    String solve(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        if (!map.containsKey('<')) return "Impossible";
        if (!map.containsKey('>')) return "Impossible";
        if (!map.containsKey('/')) return "Impossible";

        int a = map.get('<');
        int b = map.get('>');
        int c = map.get('/');

        if (a != 2 * c || b != 2 * c) return "Impossible";

        map.remove('<');
        map.remove('>');
        map.remove('/');

        int cnt = c;

        StringBuilder out = new StringBuilder();
        StringBuilder last = new StringBuilder();

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int val = entry.getValue();
            if (val % 2 != 0) return "Impossible";
            val /= 2;

            while (val > 0 && cnt > 1) {
                char ch = entry.getKey();
                out.append("<").append(ch).append(">").append("</").append(ch).append(">");
                cnt--;
                val--;
            }
            last.repeat(entry.getKey(), val);
        }

        if (cnt > 1 || last.isEmpty()) return "Impossible";

        out.append("<").append(last).append(">").append("</").append(last).append(">");

        return out.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        writer.write(new Main().solve(reader.readLine()));

        reader.close();
        writer.close();
    }
}
