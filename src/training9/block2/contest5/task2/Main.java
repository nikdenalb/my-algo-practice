package block2.contest5.task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * WA<br>
 * 1 try<br>
 * 51 + 1 min
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
        int cnt = map.values().stream().max(Integer::compareTo).get();

        Set<Character> set = map.entrySet().stream()
                .filter(e -> e.getValue() == cnt)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());

        int len = s.length();
        int lim = len / cnt;
        int out = 1;

        for (Character c : set) {
            int a = 0;
            int b = 0;
            for (int i = 0; i < len; i++) {
                if (s.charAt(i) == c) {
                    a = i;
                    break;
                }
            }
            for (int i = a + 1; i < len; i++) {
                if (s.charAt(i) == c) {
                    b = i;
                    lim = Math.min(lim, b - a);
                    a = b;
                }
            }
        }

        for (int i = lim; i > 1; i--) {
            for (int i1 = 0; i1 < len; i1++) {
                Set<Character> set1 = new HashSet<>();
                if (set.contains(s.charAt(i1)) && !set1.contains(s.charAt(i1))) {
                    set1.add(s.charAt(i1));
                    String word = s.substring(i1, i1 + lim);
                    int curr = 1;
                    for (int j = i1; j < len - lim; j++) {
                        if (s.substring(j, j + lim).equals(word)) {
                            curr++;
                        }
                    }
                    if (curr == cnt) {
                        writer.write(String.valueOf(i));
                        reader.close();
                        writer.close();
                        return;
                    }
                }
            }
        }


        writer.write("1");

        reader.close();
        writer.close();
    }
}
