package training10.block1.taskf;

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
 * <a href="https://new.contest.yandex.ru/contests/97105/problems?id=30404%2F2023_01_18%2FV1acL50PPm">
 * Значение логического выражения
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

    int solve(String s) {
        List<Token> tokens = tokenize(s);

        List<Token> polish = new ArrayList<>();
        Deque<Token> opSt = new ArrayDeque<>();

        for (Token token : tokens) {
            switch (token.type()) {
                case 'd' -> polish.add(token);
                case '(', '!' -> opSt.push(token);
                case ')' -> {
                    while (opSt.peek().type() != '(') polish.add(opSt.pop());
                    opSt.pop();
                }
                default -> {
                    while (!opSt.isEmpty() && opSt.peek().type() != '(') {
                        char peek = opSt.peek().type();
                        if (order(peek) >= order(token.type())) polish.add(opSt.pop());
                        else break;
                    }
                    opSt.push(token);
                }
            }
        }

        while (!opSt.isEmpty()) polish.add(opSt.pop());

        return calcPost(polish);
    }

    int order(char c) {
        return switch (c) {
            case '!' -> 3;
            case '&' -> 2;
            default -> 1;
        };
    }

    int calcPost(List<Token> polish) {
        Deque<Integer> st = new ArrayDeque<>();
        for (Token token : polish) {
            switch (token.type()) {
                case 'd' -> st.push(token.val());
                case '!' -> st.push(1 - st.pop());
                case '&' -> st.push(st.pop() & st.pop());
                case '|' -> st.push(st.pop() | st.pop());
                case '^' -> st.push(st.pop() ^ st.pop());
            }
        }
        return st.pop();
    }

    List<Token> tokenize(String s) {
        List<Token> out = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '!', '&', '|', '^', '(', ')' -> out.add(new Token(c));
                default -> out.add(new Token('d', Integer.parseInt(c + "")));
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

        writer.write(String.valueOf(new Main().solve(reader.readLine())));

        reader.close();
        writer.close();
    }
}
