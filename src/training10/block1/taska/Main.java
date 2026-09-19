package training10.block1.taska;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/97104/problems?id=175943%2F2016_11_22%2FeSUHFTjBwZ">
 * Правильная скобочная последовательность
 * </a>
 * <br><br>
 * Блок 1. Стеки.<br>
 * Lecture: <a href="https://youtu.be/-K0LaQsQius">YouTube</a>,
 * <a href="https://vkvideo.ru/video-220652761_456240257">VK Video</a>.<br>
 * Editorial: <a href="https://youtu.be/QNMGYTQ5EQw">YouTube</a>,
 * <a href="https://vkvideo.ru/video-220652761_456240258">VK Video</a>.<br>
 * Practice: <a href="https://new.contest.yandex.ru/contests/97104">Тренировки 10.0 - 1.1. Стек. Правильная скобочная последовательность</a>.
 */
public class Main {

    boolean solve(String s) {
        Deque<Character> st = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(', '[', '{' -> st.push(c);
                case ')' -> {if (st.isEmpty() || st.pop() != '(') return false;}
                case ']' -> {if (st.isEmpty() || st.pop() != '[') return false;}
                case '}' -> {if (st.isEmpty() || st.pop() != '{') return false;}
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        writer.write(new Main().solve(reader.readLine()) ? "yes" : "no");

        reader.close();
        writer.close();
    }
}
