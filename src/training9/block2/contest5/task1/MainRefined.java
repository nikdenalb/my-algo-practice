package block2.contest5.task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/89537/problems?id=30404%2F2026_03_01%2F3aTS4WcGaP">
 * Rover search (Yandex Contest)
 * </a>
 * <br><br>
 * Constraints:<br>
 * - 1 &lt;= n &lt;= 10<sup>5</sup><br>
 * - 0 &lt;= x<sub>i</sub>, d<sub>i</sub> &lt;= 10<sup>9</sup><br>
 * - time limit 1 s, memory 256 MB<br>
 * <br>
 * Output: the largest integer X consistent with all stations, or -1 if impossible<br>
 * <br>
 * Solution idea:<br>
 * - each (x<sub>i</sub>, d<sub>i</sub>) means |X - x<sub>i</sub>| &lt;= d<sub>i</sub>, so X lies in [x<sub>i</sub> - d<sub>i</sub>, x<sub>i</sub> + d<sub>i</sub>]<br>
 * - intersect intervals: L = max of left ends, R = min of right ends; if L &gt; R output -1, else output R<br>
 */
public class MainRefined {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int[] xd = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            max = Math.min(max, xd[0] + xd[1]);
            min = Math.max(min, xd[0] - xd[1]);
        }
        writer.write(String.valueOf(min > max ? -1 : max));

        reader.close();
        writer.close();
    }
}
