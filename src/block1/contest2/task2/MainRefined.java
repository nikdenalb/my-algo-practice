package block1.contest2.task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/89534/problems?id=30404%2F2026_03_01%2F2ND2RB8F4R&contestId=89534">
 * Sheet packing (Yandex Contest)
 * </a>
 */
public class MainRefined {

    /**
     * @param n sheet side length (cm)
     * @param m sheet side length (cm)
     * @param h packet side length (cm)
     * @param w packet side length (cm)
     * @return minimum number of folds to fit sheet in packet (1 ≤ n,m,h,w ≤ 10<sup>18</sup>)
     */
    int solve(long n, long m, long h, long w) {
        return Math.min(
                pack(n, m, h, w),
                pack(m, n, h, w));
    }

    int pack(long n, long m, long h, long w) {
        int cnt = 0;
        while (n > h) {
            n = (n + 1) / 2;
            cnt++;
        }
        while (m > w) {
            m = (m + 1) / 2;
            cnt++;
        }
        return cnt;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        long[] nmhw = Arrays.stream(reader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        writer.write(String.valueOf(new MainRefined().solve(nmhw[0], nmhw[1], nmhw[2], nmhw[3])));

        reader.close();
        writer.close();
    }
}
