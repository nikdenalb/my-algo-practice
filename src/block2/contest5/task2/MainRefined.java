package block2.contest5.task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/89537/problems?id=30404%2F2026_03_01%2FQa3Z4KPTDR">
 * Non-overlapping substrings (Yandex Contest)
 * </a>
 */
public class MainRefined {

    /**
     * Constraints (from statement):<br>
     * - 1 &lt;= |s| &lt;= 10<sup>5</sup><br>
     * - s consists of lowercase Latin letters only<br>
     * - time limit 1 s, memory 256 MB<br>
     * <br>
     * Goal: among substrings t of s, first maximize how many pairwise <b>non-overlapping</b> occurrences of t can be placed in s;<br>
     * among those with the maximum such count, maximize the length of t. Output that maximum length.<br>
     * <br>
     * Approach in this implementation: count letters; track the set of letters with global maximum frequency; start with length
     * k = 1 and scan, shrinking the set and comparing substrings to later positions to try increasing k.<br>
     *
     * @param s input string
     * @return maximum substring length per the optimality rule above
     */
    int solve(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        int freq = map.values().stream().max(Integer::compareTo).get();
        Set<Character> set = map.keySet().stream().filter(e -> map.get(e) == freq).collect(Collectors.toSet());

        int k = 1;
        for (int i = 0; i < s.length() && set.size() > k; i++) {
            if (set.contains(s.charAt(i))) {
                set.remove(s.charAt(i));

                for (int j = i + 1; j < s.length() && set.size() > j - i - k && set.contains(s.charAt(j)); j++) {
                    if (k > j - i) continue;

                    boolean isBetter = true;
                    for (int x = j + 1; x < s.length(); x++) {

                        if (    s.charAt(x) == s.charAt(i) && (x + k >= s.length() ||
                                !s.substring(x, x + k + 1).equals(s.substring(i, j + 1)))
                        ) {
                            isBetter = false;
                            break;
                        }
                    }

                    if (isBetter) k++;
                }
            }
        }
        return k;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        writer.write(String.valueOf(new MainRefined().solve(reader.readLine())));

        reader.close();
        writer.close();
    }
}
