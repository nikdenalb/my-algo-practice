package training10.contest2.task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/97117/problems?id=30404%2F2026_08_02%2FJfz1oqzhEZ">
 * XML-строка
 * </a>
 */
public class MainRefined {

    String solve(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) map.merge(ch, 1, Integer::sum);

        int a = map.getOrDefault('<', 0);
        int b = map.getOrDefault('>', 0);
        int c = map.getOrDefault('/', 0);
        if (c == 0 || a != 2 * c || b != 2 * c) return "Impossible";

        map.remove('<');
        map.remove('>');
        map.remove('/');

        int cnt = c;
        StringBuilder out = new StringBuilder();
        StringBuilder last = new StringBuilder();

        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            int val = e.getValue();
            if (val % 2 != 0) return "Impossible";
            val /= 2;

            int use = Math.min(val, cnt - 1);

            char ch = e.getKey();
            for (int i = 0; i < use; i++) {
                out.append("<").append(ch).append(">").append("</").append(ch).append(">");
            }

            cnt -= use;

            last.repeat(ch, val - use);
        }

        if (cnt > 1 || last.isEmpty()) return "Impossible";

        out.append("<").append(last).append(">").append("</").append(last).append(">");

        return out.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        writer.write(new MainRefined().solve(reader.readLine()));

        reader.close();
        writer.close();
    }
}
