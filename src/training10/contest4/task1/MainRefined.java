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
 */
public class MainRefined {

    long solve(long x, long y) {
        long out = 0;

        while (y > 0) {
            out += x / y;
            long tmp = y;
            y = x % y;
            x = tmp;
        }

        return out;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        long[] xy = Arrays.stream(reader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        writer.write(String.valueOf(new MainRefined().solve(xy[0], xy[1])));

        reader.close();
        writer.close();
    }
}
