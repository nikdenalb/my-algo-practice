package training10.block2.taska;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/97108/problems?id=175943%2F2016_11_22%2FcXYEjvzveD">
 * Очередь с защитой от ошибок
 * </a>
 * <br><br>
 * Блок 2. Очереди, деки, кучи.<br>
 * Lecture: <a href="https://youtu.be/-ZVZt3dp0nw">YouTube</a>,
 * <a href="https://vkvideo.ru/video-220652761_456240272">VK Video</a>.<br>
 * Editorial: <a href="https://vkvideo.ru/video-220652761_456240271">VK Video</a>.<br>
 * Practice: <a href="https://new.contest.yandex.ru/contests/97108">Тренировки 10.0 - 2.1. Очередь и способы её реализации</a>.
 */
public class Main {
    StringBuilder out = new StringBuilder();

    int[] arr = new int[1000];

    int curr = 0;
    int end = 0;

    void push(int val) {
        if (end == arr.length) expand();
        arr[end++] = val;
        out.append("ok").append(System.lineSeparator());
    }

    void pop() {
        if (curr == end) out.append("error").append(System.lineSeparator());
        else out.append(arr[curr++]).append(System.lineSeparator());
    }

    void front() {
        if (curr == end) out.append("error").append(System.lineSeparator());
        else out.append(arr[curr]).append(System.lineSeparator());
    }

    void size() {
        out.append(end - curr).append(System.lineSeparator());
    }

    void clear() {
        curr = 0;
        end = 0;
        out.append("ok").append(System.lineSeparator());
    }

    void expand() {
        System.arraycopy(arr, curr, arr, 0, end - curr);
        end = end - curr;
        curr = 0;
    }

    void execute(String input) {
        String[] cmd = input.split(" ");
        switch (cmd[0]) {
            case "push" -> push(Integer.parseInt(cmd[1]));
            case "pop" -> pop();
            case "front" -> front();
            case "size" -> size();
            case "clear" -> clear();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        var queue = new Main();

        for (String input; !(input = reader.readLine()).equals("exit"); ) queue.execute(input);
        queue.out.append("bye");

        writer.write(queue.out.toString());

        reader.close();
        writer.close();
    }
}
