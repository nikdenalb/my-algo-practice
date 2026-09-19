package training10.block1.taskg;

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
 * <a href="https://new.contest.yandex.ru/contests/97106/problems?id=30404%2F2023_01_18%2Fm3PAau25IW">
 * Великое Лайнландское переселение
 * </a>
 * <br><br>
 * Блок 1. Стеки.<br>
 * Lecture: <a href="https://youtu.be/WWFwpOlGSzc">YouTube</a>,
 * <a href="https://vkvideo.ru/video-220652761_456240261">VK Video</a>.<br>
 * Editorial: <a href="https://youtu.be/gdFUxanXF-E">YouTube</a>,
 * <a href="https://vkvideo.ru/video-220652761_456240262">VK Video</a>.<br>
 * Practice: <a href="https://new.contest.yandex.ru/contests/97106">Тренировки 10.0 - 1.3. Монотонный стек</a>.
 */
public class Main {

    int[] solve(int[] a) {
        int n = a.length;
        Deque<Integer> st = new ArrayDeque<>();
        int[] out = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && a[st.peek()] > a[i]) out[st.pop()] = i;
            st.push(i);
        }
        while (!st.isEmpty()) out[st.pop()] = -1;
        return out;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        reader.readLine(); // N
        int[] a = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        writer.write(Arrays.stream(new Main().solve(a)).mapToObj(String::valueOf).collect(Collectors.joining(" ")));

        reader.close();
        writer.close();
    }
}
