package training10.block1.taske;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/97105/problems?id=30404%2F2023_01_18%2FHgDt2DvsLq">
 * Значение арифметического выражения
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

    String solve(String s) {
        List<Token> tokens = tokenize(s);

        if (tokens == null) return "WRONG";

        List<Token> polish = new ArrayList<>();
        Deque<Token> opSt = new ArrayDeque<>();

        for (Token token : tokens) {
            switch (token.type()) {
                case 'd' -> polish.add(token);
                case '(' -> opSt.push(token);
                case ')' -> {
                    while (!opSt.isEmpty() && opSt.peek().type() != '(') polish.add(opSt.pop());
                    if (opSt.isEmpty()) return "WRONG";
                    opSt.pop();
                }
                default -> {
                    while (!opSt.isEmpty() && opSt.peek().type() != '(') {
                        char peek = opSt.peek().type();
                        if (order(peek) >= order(token.type()))
                            polish.add(opSt.pop());
                        else break;
                    }
                    opSt.push(token);
                }
            }
        }
        while (!opSt.isEmpty()) {
            if (opSt.peek().type() == '(') return "WRONG";
            polish.add(opSt.pop());
        }

        int out = calcPost(polish);
        return out == Integer.MIN_VALUE ? "WRONG" : String.valueOf(out);
    }

    int order(char c) {
        return c == '*' ? 2 : 1;
    }

    int calcPost(List<Token> polish) {
        Deque<Integer> st = new ArrayDeque<>();
        for (Token token : polish) {
            if (token.type() == 'd') {
                st.push(token.val());
                continue;
            }
            if (st.size() < 2) return Integer.MIN_VALUE;
            switch (token.type()) {
                case '+' -> st.push(st.pop() + st.pop());
                case '-' -> st.push(-st.pop() + st.pop());
                case '*' -> st.push(st.pop() * st.pop());
            }
        }
        return st.size() == 1 ? st.pop() : Integer.MIN_VALUE;
    }

    List<Token> tokenize(String s) {
        List<Token> out = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case ' ' -> {}
                case '+', '*', '(', ')' -> out.add(new Token(c));
                case '-' -> {
                    if (out.isEmpty() || out.getLast().type() == '(') out.add(new Token('d', 0));
                    out.add(new Token(c));
                }
                default -> {
                    if (!Character.isDigit(c)) return null;
                    int start = i;
                    while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) i++;
                    out.add(new Token('d', Integer.parseInt(s.substring(start, i + 1))));
                }
            }
        }
        return out;
    }

    record Token(Character type, int val) {
        Token(char c) {
            this(c, 0);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        writer.write(new Main().solve(reader.readLine()));

        reader.close();
        writer.close();
    }
}
