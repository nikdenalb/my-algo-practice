package block2.contest4.task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/89536/problems?id=30404%2F2026_03_01%2FsI2vS9YmUm">
 * Desktop basketball (Yandex Contest)
 * </a>
 * <br><br>
 * Constraints:<br>
 * - 1 &lt;= n &lt;= 50 players<br>
 * - each name length 1..15, Latin letters only<br>
 * - 1 &lt;= m &lt;= 500 score lines; format {@code a:b name} (points in ring 1 and 2, then player)<br>
 * - initial score 0:0<br>
 * <br>
 * Output:<br>
 * - player name with maximum total points scored and that total (space-separated); any if tie<br>
 * <br>
 * Solution idea:<br>
 * - total points per shot = a + b; add to the named player the increment from the previous total (delta scoring)<br>
 * - then pick any player with maximum accumulated sum<br>
 */
public class MainRefined {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(reader.readLine(), 0);
        int m = Integer.parseInt(reader.readLine());
        int score = 0;
        for (int i = 0; i < m; i++) {
            String[] tokens = reader.readLine().split(" ");
            int currScore = Arrays.stream(tokens[0].split(":")).mapToInt(Integer::parseInt).sum();
            String name = tokens[1];
            map.put(name, map.get(name) + currScore - score);
            score = currScore;
        }
        int max = map.values().stream().mapToInt(Integer::intValue).max().getAsInt();
        String outName = map.entrySet().stream()
                .filter(e -> e.getValue() == max)
                .findAny().get().getKey();

        writer.write(outName + " " + max);

        reader.close();
        writer.close();
    }
}
