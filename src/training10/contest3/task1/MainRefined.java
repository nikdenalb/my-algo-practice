package training10.contest3.task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/97118/problems?id=30404%2F2026_08_02%2Fx3I9JKzRfW">
 * Японский кроссворд (Yandex Contest)
 * </a>
 */
public class MainRefined {

    char[][] field;
    int n, m;

    MainRefined(char[][] field, int n, int m) {
        this.field = field;
        this.n = n;
        this.m = m;
    }

    String solve() {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < n; i++) out.append(line(i, true)).append(System.lineSeparator());
        out.append(System.lineSeparator());
        for (int i = 0; i < m; i++) out.append(line(i, false).append(System.lineSeparator()));
        return out.toString();
    }

    StringBuilder line(int x, boolean isRow) {
        StringBuilder out = new StringBuilder();
        List<Integer> list = new ArrayList<>();

        int cnt = 0;
        int len = isRow ? m : n;
        for (int i = 0; i < len; i++) {
            char c = isRow ? field[x][i] : field[i][x];

            if (c == '#') cnt++;
            else if (cnt > 0) {
                list.add(cnt);
                cnt = 0;
            }
        }
        if (cnt > 0) list.add(cnt);

        out.append(list.size()).append(' ');
        list.forEach(e -> out.append(e).append(' '));
        return out;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nm = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        char[][] field = new char[nm[0]][];
        for (int i = 0; i < nm[0]; i++) field[i] = reader.readLine().toCharArray();

        MainRefined solver = new MainRefined(field, nm[0], nm[1]);

        writer.write(solver.solve());

        reader.close();
        writer.close();
    }
}
