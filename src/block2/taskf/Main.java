package block2.taskf;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/89520/problems?id=175943%2F2016_10_09%2FDsLn6vwVnE">
 * Dictionary of synonyms (Yandex Contest)
 * </a>
 * <br><br>
 * Input:<br>
 * - N pairs of synonymous words, then one query word.<br>
 * <br>
 * Output:<br>
 * - the synonym of the query word.<br>
 * <br>
 * Solution idea:<br>
 * - store both directions in one map: a -> b and b -> a.<br>
 * - then answer in O(1) average time with map.get(query).<br>
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(reader.readLine());

        Map<String,String> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String[] line = reader.readLine().split(" ");
            map.put(line[0], line[1]);
            map.put(line[1], line[0]);
        }
        String word = reader.readLine();
        writer.write(map.get(word));

        reader.close();
        writer.close();
    }
}
