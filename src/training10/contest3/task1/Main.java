package training10.contest3.task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nm = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        char[][] field = new char[nm[0]][nm[1]];
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < nm[0]; i++) {
            field[i] = reader.readLine().toCharArray();
            boolean flag = false;
            int cnt = 0;
            List<Integer> list = new ArrayList<>();
            int cntG = 0;
            for (int j = 0; j < field[i].length; j++) {
                if (!flag && field[i][j] == '#') {
                    cnt = 1;
                    cntG++;
                    flag = true;
                } else if (flag && field[i][j] == '.') {
                    flag = false;
                    list.add(cnt);
                    cnt = 0;
                } else if (flag && field[i][j] == '#') {
                    cnt++;
                }
            }
            if (cnt > 0) list.add(cnt);
            out.append(cntG).append(" ");
            list.forEach(x -> out.append(x.toString()).append(" "));
            out.append(System.lineSeparator());
        }

        out.append(System.lineSeparator());

        for (int i = 0; i < nm[1]; i++) {
            boolean flag = false;
            int cnt = 0;
            List<Integer> list = new ArrayList<>();
            int cntG = 0;
            for (int j = 0; j < field.length; j++) {
                if (!flag && field[j][i] == '#') {
                    cnt = 1;
                    cntG++;
                    flag = true;
                } else if (flag && field[j][i] == '.') {
                    flag = false;
                    list.add(cnt);
                    cnt = 0;
                } else if (flag && field[j][i] == '#') {
                    cnt++;
                }
            }
            if (cnt > 0) list.add(cnt);
            out.append(cntG).append(" ");
            list.forEach(x -> out.append(x.toString()).append(" "));
            out.append(System.lineSeparator());

        }


        writer.write(out.toString());

        reader.close();
        writer.close();
    }
}
