package training10.block3.taskb;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/97112/problems?id=4105%2F2015_01_14%2F9DYI7g2bpQ">
 * Быстрая сортировка
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

    int[] solve(int[] a) {
        quickSort(a, 0, a.length - 1);
        return a;
    }

    void quickSort(int[] a, int l, int r) {
        int x = a[l + (int) (Math.random() * (r - l + 1))];
        int j = l, i = r;

        while (j <= i) {

            while (a[j] < x) j++;
            while (a[i] > x) i--;

            if (j <= i) {
                int t = a[j];
                a[j] = a[i];
                a[i] = t;
                j++;
                i--;
            }
        }
        if (l < i) quickSort(a, l, i);
        if (j < r) quickSort(a, j, r);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(reader.readLine());
        if (N > 0) {
            int[] a = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            writer.write(
                    Arrays.stream(new Main().solve(a))
                            .mapToObj(String::valueOf)
                            .collect(Collectors.joining(" "))
            );
        }

        reader.close();
        writer.close();
    }
}