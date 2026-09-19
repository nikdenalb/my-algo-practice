package training10.block1.taskd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/97105/problems?id=30404%2F2023_01_18%2FqS3OsBniXH">
 * Постфиксная запись
 * </a>
 * <br><br>
 * Блок 1. Стеки.<br>
 * Lecture: <a href="https://youtu.be/kCSEoDyVHUo">YouTube</a>,
 * <a href="https://vkvideo.ru/video-220652761_456240259">VK Video</a>.<br>
 * Editorial: <a href="https://youtu.be/PwTcYRRnf18">YouTube</a>,
 * <a href="https://vkvideo.ru/video-220652761_456240260">VK Video</a>.<br>
 * Practice: <a href="https://new.contest.yandex.ru/contests/97105">Тренировки 10.0 - 1.2. Инфиксная и постфиксная запись</a>.
 */
public class Main {

    int solve(char[] a) {
        Deque<Integer> st = new ArrayDeque<>();
        for (char c : a) {
            switch (c) {
                case '+' -> st.push(st.pop() + st.pop());
                case '-' -> st.push(-st.pop() + st.pop());
                case '*' -> st.push(st.pop() * st.pop());
                default -> st.push(Integer.valueOf(c + ""));
            }
        }
        return st.pop();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        writer.write(String.valueOf(new Main().solve(reader.readLine().replace(" ", "").toCharArray())));

        reader.close();
        writer.close();
    }
}
