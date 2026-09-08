package block2.taskd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/89519/problems?id=175943%2F2016_10_05%2FDuMNHdcUda">
 * Polyglots (Yandex Contest)
 * </a>
 * <br><br>
 * Constraints:<br>
 * - 1 <= N <= 1000<br>
 * - 1 <= M_i <= 500<br>
 * - number of distinct languages <= 1000<br>
 * - length of each language name <= 1000<br>
 * <br>
 * For each of N students, reads M_i language names. Outputs:<br>
 * 1) languages known by all students<br>
 * 2) languages known by at least one student<br>
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(reader.readLine());

        Set<String> set = new HashSet<>();
        Set<String> retainSet = new HashSet<>();

        for (int i = 0; i < N; i++) {
            int M = Integer.parseInt(reader.readLine());
            Set<String> addSet = new HashSet<>();
            for (int j = 0; j < M; j++) {
                String lang = reader.readLine();
                addSet.add(lang);
            }
            set.addAll(addSet);
            if (i > 0) retainSet.retainAll(addSet);
            else retainSet.addAll(addSet);
        }

        StringBuilder out = new StringBuilder();

        if (!retainSet.isEmpty()) {
            out.append(retainSet.size()).append("\n");
            retainSet.forEach(l -> out.append(l).append("\n"));
        } else out.append(0).append("\n");
        out.append(set.size()).append("\n");
        set.forEach(l -> out.append(l).append("\n"));
        out.setLength(out.length() - 1);
        writer.write(out.toString());

        reader.close();
        writer.close();
    }
}
