package block2.taskg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.TreeMap;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/89520/problems?id=175943%2F2016_10_09%2F92iLVtk3Sf">
 * Sales (Yandex Contest)
 * </a>
 * <br><br>
 * Input:<br>
 * - lines of purchases in format: buyer product amount.<br>
 * <br>
 * Output:<br>
 * - buyers in lexicographical order;<br>
 * - for each buyer, products in lexicographical order with total amount.<br>
 * <br>
 * Solution idea:<br>
 * - outer TreeMap stores buyer -> (products map), inner TreeMap stores product -> total amount.<br>
 * - each line updates accumulated amount, then printing TreeMap gives required sorted order.<br>
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, Map<String, Long>> map = new TreeMap<>();
        for (String line = reader.readLine(); line != null && !line.isEmpty(); line = reader.readLine()) {
            String[] tokens = line.split(" ");
            String buyer = tokens[0];
            String good = tokens[1];
            long amount = Long.parseLong(tokens[2]);
            if (map.containsKey(buyer)) {
                Map<String, Long> inMap = map.get(buyer);
                inMap.put(good, inMap.getOrDefault(good, 0L) + amount);
            } else {
                Map<String, Long> inMap = new TreeMap<>();
                inMap.put(good, amount);
                map.put(buyer, inMap);
            }
        }

        StringBuilder out = new StringBuilder();

        map.forEach((k, v) -> {
            out.append(k).append(':').append("\n");
            v.forEach((k1, v1) -> out.append(k1).append(' ').append(v1).append("\n"));
        });
        out.setLength(out.length() - 1);
        writer.write(out.toString());

        reader.close();
        writer.close();
    }
}
