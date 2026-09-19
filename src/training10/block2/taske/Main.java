package training10.block2.taske;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/97109/problems?id=30404%2F2023_01_27%2FCuRXCfvxXa">
 * Гоблины и шаманы
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

    static class DequeWithVIP {
        Deque<Integer> head = new ArrayDeque<>();
        Deque<Integer> tail = new ArrayDeque<>();

        void add(int g) {
            tail.addLast(g);
            if (tail.size() > head.size()) head.addLast(tail.pollFirst());
        }

        void addVIP(int g) {
            tail.addFirst(g);
            if (tail.size() > head.size()) head.addLast(tail.pollFirst());
        }

        int poll() {
            int out = head.pollFirst();
            if (tail.size() > head.size()) head.addLast(tail.pollFirst());
            return out;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        DequeWithVIP goblins = new DequeWithVIP();

        int N = Integer.parseInt(reader.readLine());
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String[] cmd = reader.readLine().split(" ");
            switch (cmd[0]) {
                case "+" -> goblins.add(Integer.parseInt(cmd[1]));
                case "*" -> goblins.addVIP(Integer.parseInt(cmd[1]));
                case "-" -> out.append(goblins.poll()).append(System.lineSeparator());
            }
        }
        writer.write(out.toString());

        reader.close();
        writer.close();
    }
}
