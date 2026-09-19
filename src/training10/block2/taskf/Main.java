package training10.block2.taskf;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/97109/problems?id=40119%2F2021_06_15%2F99tiG1bl65">
 * Минимум в окне
 * </a>
 * <br><br>
 * Блок 2. Очереди, деки, кучи.<br>
 * Lecture: <a href="https://youtu.be/szs0GafJbR0">YouTube</a>,
 * <a href="https://vkvideo.ru/video-220652761_456240268">VK Video</a>.<br>
 * Editorial: <a href="https://youtu.be/UHKqJVWKT6A">YouTube</a>,
 * <a href="https://vkvideo.ru/video-220652761_456240270">VK Video</a>.<br>
 * Practice: <a href="https://new.contest.yandex.ru/contests/97109">Тренировки 10.0 - 2.2. Дек, минимум в окне</a>.
 */
public class Main {

    int[] solve(int[] a, int k) {
        int n = a.length;
        int[] out = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && dq.peekFirst() > a[i]) dq.removeFirst();
            dq.addFirst(a[i]);
        }
        out[0] = dq.peekLast();
        for (int i = k; i < n; i++) {
            while (!dq.isEmpty() && dq.peekFirst() > a[i]) dq.removeFirst();
            dq.addFirst(a[i]);
            if (a[i - k] == dq.peekLast()) dq.removeLast();
            out[i - k + 1] = dq.peekLast();
        }
        return out;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nk = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] a = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        writer.write(
                Arrays.stream(new Main().solve(a, nk[1]))
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(System.lineSeparator()))
        );

        reader.close();
        writer.close();
    }
}
