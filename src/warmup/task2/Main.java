package warmup.task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * OK<br>
 * 1st try<br>
 * 27 min
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(reader.readLine());
        long[] a = Arrays.stream(reader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        long[] sort = a.clone();
        Arrays.sort(sort);

        long needed = 0;
        long sum = 0;

        for (long curr : sort) {
            if (sum <= curr) {
                if (needed == curr) {
                    needed++;
                } else {
                    needed = curr;
                }
            }
            sum += curr;
        }

        for (int i = 0; i < a.length; i++) {
            if (needed <= a[i]) {
                a[i] = 1;
            } else a[i] = 0;
        }

        writer.write(Arrays.stream(a)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(System.lineSeparator())));

        reader.close();
        writer.close();
    }
}
