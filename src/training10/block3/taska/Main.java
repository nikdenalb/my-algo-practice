package training10.block3.taska;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/97112/problems?id=4105%2F2015_01_14%2FBJQFReu5iY">
 * Partition
 * </a>
 * <br><br>
 * Блок 3. Сортировки.<br>
 * Lecture: <a href="https://youtu.be/xkDlmHcmEvE">YouTube</a>,
 * <a href="https://vkvideo.ru/video-220652761_456240277">VK Video</a>.<br>
 * Editorial: <a href="https://youtu.be/OuL-u6yQ7cs">YouTube</a>,
 * <a href="https://vkvideo.ru/video-220652761_456240273">VK Video</a>.<br>
 * Practice: <a href="https://new.contest.yandex.ru/contests/97112">Тренировки 10.0 - 3.1. Быстрая сортировка</a>.
 */
public class Main {

    int solve(int[] a, int x) {
        int out = 0;
        for (int e : a) if (e < x) out++;
        return out;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(reader.readLine());
        if (N == 0) reader.readLine();
        int[] a = N == 0 ? new int[0]
                : Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int x = Integer.parseInt(reader.readLine());
        StringBuilder out = new StringBuilder();
        int less = new Main().solve(a, x);
        out.append(less).append(System.lineSeparator()).append(N - less);
        writer.write(out.toString());

        reader.close();
        writer.close();
    }
}
