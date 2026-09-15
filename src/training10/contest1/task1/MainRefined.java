package training10.contest1.task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/97742/problems?id=30404%2F2026_08_02%2FIjpUFvQlN0">
 * Смена стиля (Yandex Contest)
 * </a>
 */
public class MainRefined {

    StringBuilder solve(String s) {
        StringBuilder out = new StringBuilder();
        out.append(Character.toLowerCase(s.charAt(0)));
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            out.append(Character.isUpperCase(c) ? "_" + Character.toLowerCase(c) : c);
        }
        return out;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        StringBuilder out = new StringBuilder();
        for (int i = 0; i < n - 1; i++) {
            out.append(new MainRefined().solve(reader.readLine())).append(System.lineSeparator());
        }
        out.append(new MainRefined().solve(reader.readLine()));

        writer.write(out.toString());

        reader.close();
        writer.close();
    }
}
