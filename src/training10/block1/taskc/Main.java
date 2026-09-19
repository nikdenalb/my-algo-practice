package training10.block1.taskc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/97104/problems?id=30404%2F2021_10_27%2F4skidbF6ac">
 * Поврежденный XML
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

    String solve(String s) {
        char[] a = s.toCharArray();
        String w = "<>/abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < a.length; i++) {
            char t = a[i];
            for (char c : w.toCharArray()) {
                if (c == t) continue;
                a[i] = c;
                if (isCorrect(a)) return new String(a);
            }
            a[i] = t;
        }
        throw new RuntimeException();
    }

    boolean isCorrect(char[] a) {
        Deque<String> st = new ArrayDeque<>();
        int n = a.length;
        for (int i = 0; i < n; i++) {
            boolean isOpen = true;
            StringBuilder token = new StringBuilder();

            if (a[i++] != '<') return false;

            if (i < n && a[i] == '/') {
                isOpen = false;
                i++;
            }

            while (i < n && Character.isAlphabetic(a[i])) token.append(a[i++]);

            if (token.isEmpty() || i == n || a[i] != '>') return false;

            if (isOpen) st.push(token.toString());
            else if (st.isEmpty() || !st.pop().contentEquals(token)) return false;

        }
        return st.isEmpty();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        writer.write(new Main().solve(reader.readLine()));

        reader.close();
        writer.close();
    }
}
