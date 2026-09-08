package block3.contest9.task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * WA<br>
 * 1st try<br>
 * 28 min
 */
public class Main {

    long solve(int N, int[] a, int K) {

        long[] pref = new long[N + 1];
        pref[0] = a[0];
        for (int i = 0; i < N; i++) {
            pref[i + 1] = a[i] + pref[i];
        }

        //pref1
        //pref2



//        long max = 0;
//        long cur = 0;
//        for (int v : a) {
//            cur = Math.max(0, cur + v);
//            max = Math.max(max, cur);
//        }
//        if (max % K > 0) return max;


        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] NK = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] a = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        writer.write(String.valueOf(new Main().solve(NK[0], a, NK[1])));


        reader.close();
        writer.close();
    }
}
