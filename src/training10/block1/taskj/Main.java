package training10.block1.taskj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/97107/problems?id=175943%2F2016_09_21%2FJ7HdYdllwN">
 * Ханойские башни
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

    StringBuilder out = new StringBuilder();

    String solve(int n) {
        move(n, 1, 3);
        return out.toString();
    }

    void move(int n, int x, int y) {
        if (n == 0) return;
        move(n - 1, x, 6 - x - y);
        out.append(n).append(' ').append(x).append(' ').append(y).append(System.lineSeparator());
        move(n - 1, 6 - x - y, y);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        writer.write(String.valueOf(new Main().solve(n)));

        reader.close();
        writer.close();
    }
}
