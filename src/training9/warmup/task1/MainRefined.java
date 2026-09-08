package warmup.task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/89606/problems?id=30404%2F2023_02_12%2FLiYbwI4iG4">
 * Decode the string (Yandex Contest)
 * </a>
 */
public class MainRefined {

    /**
     * Decodes a string where letters are encoded as numbers:<br>
     * 'a'–'i' -> "1"–"9"<br>
     * 'j'–'z' -> "10#"–"26#".<br>
     * <br>
     * Constraints: 1 ≤ |str| ≤ 100, the string consists only of digits and '#' and
     * is guaranteed to represent a valid encoding of a lowercase Latin string.<br>
     * <br>
     * Examples:<br>
     * "1212#" -> "abl"<br>
     * "8512#12#15#23#15#18#12#4" -> "helloworld"
     *
     * @param str encoded string consisting of digits and the '#' character
     * @return decoded string of lowercase Latin letters
     */
    String decode(String str) {
        StringBuilder out = new StringBuilder();

        for (int i = 0; i < str.length(); ) {
            if (i + 2 < str.length() && str.charAt(i + 2) == '#') {
                int d = Integer.parseInt(str.substring(i, i + 2));
                out.append((char) ('j' + d - 10));
                i += 3;
            } else {
                int d = Integer.parseInt(String.valueOf(str.charAt(i)));
                out.append((char) ('a' + d - 1));
                i++;
            }
        }

        return out.toString();
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        MainRefined sol = new MainRefined();

        String s = reader.readLine();

        writer.write(sol.decode(s));

        reader.close();
        writer.close();
    }
}
