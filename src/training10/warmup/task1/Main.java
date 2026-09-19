package training10.warmup.task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/97116/problems?id=30404%2F2026_07_31%2F5GncEbBVCJ">
 * Счётчик
 * </a>
 * <br><br>
 * The contest deadline was missed. This is the refined solution.<br>
 */
public class Main {

    int solve(int m, int a, int b) {
        for (int cnt = 0; ; cnt++) {
            if (a == b) return cnt;
            a++;
            if (a == m + 1) a = 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int m = Integer.parseInt(reader.readLine());
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());

        writer.write(String.valueOf(new Main().solve(m, a, b)));

        reader.close();
        writer.close();
    }
}
