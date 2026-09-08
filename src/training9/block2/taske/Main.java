package block2.taske;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/89519/problems?id=175943%2F2016_10_12%2FuEI76U0GdB">
 * Turtles (Yandex Contest)
 * </a>
 * <br><br>
 * Constraints:<br>
 * - 1 <= N <= 10000<br>
 * - |a<sub>i</sub>|, |b<sub>i</sub>| <= 10000<br>
 * <br>
 * Each of the N turtles says: “There are a<sub>i</sub> turtles in front of me and b<sub>i</sub> turtles behind me”.<br>
 * Output the maximum number of turtles who can be telling the truth.<br>
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(reader.readLine());

        Set<Pair> set = new HashSet<>(N);
        for (int i = 0; i < N; i++) {
            int[] ab = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (ab[0] >= 0 && ab[1] >= 0 && ab[0] + ab[1] == N - 1) set.add(new Pair(ab[0], ab[1]));
        }

        writer.write(String.valueOf(set.size()));

        reader.close();
        writer.close();
    }

    record Pair(int a, int b) {}
}
