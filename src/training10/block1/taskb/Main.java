package training10.block1.taskb;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/97104/problems?id=30404%2F2024_11_02%2FmyVIGk5VNm">
 * Минимальная ПСП
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

    String solve(int n, String w, String s) {
        Deque<Character> st = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ')' || c == ']') st.pop();
            else st.push(c);

        }
        StringBuilder out = new StringBuilder(s);
        n -= s.length();
        for (; n > 0; n--) {
            for (char c : w.toCharArray()) {
                if (c == '(' || c == '[') {
                    if (n > st.size()) {
                        st.push(c);
                        out.append(c);
                        break;
                    }
                } else if (!st.isEmpty() && st.peek() == (c == ')' ? '(' : '[')) {
                    st.pop();
                    out.append(c);
                    break;
                }
            }
        }
        return out.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        String w = reader.readLine();
        String s = reader.readLine();
        writer.write(new Main().solve(n, w, s));

        reader.close();
        writer.close();
    }
}
