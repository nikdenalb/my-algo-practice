package training10.contest4.task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/97119/problems?id=30404%2F2026_08_02%2FprFyQvaxz1">
 * Закраска квадратами (Yandex Contest)
 * </a>
 * <br><br>
 * Solve time 00:11. No submit errors.<br>
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        long[] xy = Arrays.stream(reader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long a = Math.max(xy[0], xy[1]);
        long b = Math.min(xy[0], xy[1]);

        long out = 0;

        while ( b > 0) {
            out += a / b;
            long t = b;
            b = a % b;
            a = t;
        }

        writer.write(out + "");

        reader.close();
        writer.close();
    }
}
