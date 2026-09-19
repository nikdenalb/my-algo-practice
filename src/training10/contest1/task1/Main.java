package training10.contest1.task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/97742/problems?id=30404%2F2026_08_02%2FIjpUFvQlN0">
 * Смена стиля
 * </a>
 * <br><br>
 * Solve time 00:10. No submit errors.<br>
 */
public class Main {

    String solve(String s) {
        StringBuilder out = new StringBuilder();
        out.append(Character.toLowerCase(s.charAt(0)));
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isUpperCase(c)) {
                out.append('_').append(Character.toLowerCase(c));
            } else {
                out.append(c);
            }
        }
        return out.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n - 1; i++) {
            writer.write(new Main().solve(reader.readLine()));
            writer.newLine();
        }
        writer.write(new Main().solve(reader.readLine()));

        reader.close();
        writer.close();
    }
}
