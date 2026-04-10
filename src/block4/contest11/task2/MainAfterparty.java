package block4.contest11.task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainAfterparty {

    static boolean solve(String ans, String a, String b) {
        int aG = 0;
        int aW = 0;
        int bG = 0;
        int bW = 0;
        int GG = 0;
        int BB = 0;

        for (int i = 0; i < ans.length(); i++) {
            if (ans.charAt(i) == a.charAt(i)) {
                aG++;
                if (a.charAt(i) == b.charAt(i)) {
                    bG++;
                    GG++;
                } else {
                    bW++;
                }
            } else {
                aW++;
                if (a.charAt(i) == b.charAt(i)) {
                    BB++;
                    bW++;
                } else if (b.charAt(i) == ans.charAt(i)) {
                    bG++;
                } else {
                    bW++;
                }
            }
        }

        return (2 * GG > aG)
                && 2 * BB > aW
                && 2 * GG > bG
                && 2 * BB > bW;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(reader.readLine());

        String ans = reader.readLine();

        int m = Integer.parseInt(reader.readLine());

        String[] works = new String[m];

        for (int i = 0; i < m; i++) works[i] = reader.readLine();

        StringBuilder out = new StringBuilder();

        int cnt = 0;
        for (int i = 0; i < works.length; i++) {
            for (int j = i + 1; j < works.length; j++) {
                if (solve(ans, works[i], works[j])) {
                    out.append(i + 1).append(" ").append(j + 1).append("\n");
                    cnt++;
                }
            }
        }

        if (cnt == 0) {
            writer.write("0");
            reader.close();
            writer.close();
            return;
        }


        out.insert(0, cnt + "\n");
        out.setLength(out.length() - 1);

        writer.write(out.toString());


        reader.close();
        writer.close();
    }
}
