package training10.block1.taskh;

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
 * <a href="https://new.contest.yandex.ru/contests/97106/problems?id=30404%2F2023_01_18%2FEJ31cTOEJL">
 * Гистограмма и прямоугольник
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

    long solve(int[] h) {
        int n = h.length;
        int[] l = new int[n];
        int[] r = new int[n];
        Deque<Integer> st = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && h[st.peek()] > h[i]) r[st.pop()] = i;
            st.push(i);
        }
        while (!st.isEmpty()) r[st.pop()] = n;

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && h[st.peek()] > h[i]) l[st.pop()] = i;
            st.push(i);
        }
        while (!st.isEmpty()) l[st.pop()] = -1;

        long out = 0;
        for (int i = 0; i < n; i++) out = Math.max(out, (long) h[i] * (r[i] - l[i] - 1));

        return out;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] h = Arrays.stream(reader.readLine().split(" ")).skip(1).mapToInt(Integer::parseInt).toArray();

        writer.write(String.valueOf(new Main().solve(h)));

        reader.close();
        writer.close();
    }
}
