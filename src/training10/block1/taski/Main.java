package training10.block1.taski;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/97107/problems?id=175943%2F2016_09_21%2FOyTG5tZF4H">
 * Быстрое возведение в степень
 * </a>
 * <br><br>
 * Блок 1. Стеки.<br>
 * Lecture: <a href="https://youtu.be/olxDjlTfB2E">YouTube</a>,
 * <a href="https://vkvideo.ru/video-220652761_456240263">VK Video</a>.<br>
 * Editorial: <a href="https://youtu.be/dJN5uCSk-fE">YouTube</a>,
 * <a href="https://vkvideo.ru/video-220652761_456240264">VK Video</a>.<br>
 * Practice: <a href="https://new.contest.yandex.ru/contests/97107">Тренировки 10.0 - 1.4. Рекурсия и механизм запуска функций</a>.
 */
public class Main {

    double solve(double a, long n) {
        if (n == 0) return 1;
        if (n % 2 == 0) return solve(a * a, n / 2);
        return a * solve(a, n - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        double a = Double.parseDouble(reader.readLine());
        long n = Long.parseLong(reader.readLine());
        writer.write(String.valueOf(new Main().solve(a, n)));

        reader.close();
        writer.close();
    }
}
