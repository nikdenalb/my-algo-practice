package block2.contest6.task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * OK<br>
 * 1st try<br>
 * 24 min<br><br>
 * ⚠ ALARM: Task conditions were changed.<br>
 * Re-run and update tests according to the new statement.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        int[] a = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < a.length; i++) {
            int k = i + 1 - a[i];
            if (k < 0) k += n;
            set.add(k);
        }
        String out = "";
        if (set.size() == n) {
            out = "-1";
        } else {
            for (int i = 0; i < n; i++) {
                if (!set.contains(i)) {
                    out = "" + i;
                    break;
                }
            }
        }

        writer.write(out);


        reader.close();
        writer.close();
    }
}

/*
1 2 3 4 5
1 4 2 3 5
4 2 3 5 1
2 3 5 1 4

 */
