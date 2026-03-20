package block1.practice.contest1.task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/89533/problems?id=30404%2F2026_03_01%2FP9YvSLqof7&contestId=89533">
 * Standing wave (Yandex Contest)
 * </a>
 */
public class MainRefined {

    /**
     * Calculates the contribution of the event to the segment.
     *
     * @param l the left bound of the event
     * @param r the right bound of the event
     * @param x the magnitude of the event
     * @param q the segment to which the contribution is calculated
     * @return the contribution of the event to the segment
     */
    int solve(int l, int r, int x, int q) {
        if (q < l || q > r) return 0;

        if ((q - l) % 2 == 0) return x;
        else return -x;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        MainRefined sol = new MainRefined();

        int[] nm = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[][] events = new int[nm[0]][3];

        for (int i = 0; i < nm[0]; i++)
            events[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        StringBuilder out = new StringBuilder();

        for (int i = 0; i < nm[1]; i++) {
            int q = Integer.parseInt(reader.readLine());
            int ans = 0;
            for (int[] event : events) ans += sol.solve(event[0], event[1], event[2], q);
            out.append(ans).append("\n");
        }

        if (!out.isEmpty()) out.setLength(out.length() - 1);

        writer.write(out.toString());

        reader.close();
        writer.close();
    }
}
