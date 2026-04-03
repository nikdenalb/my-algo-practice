package block3.contest8.task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

/**
 * OK<br>
 * 1st try<br>
 * 10 min
 */
public class Main {

    record Coord(long x, long y) {}

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = reader.readLine();
        Coord curr = new Coord(0, 0);
        Set<Coord> set = new HashSet<>();
        Set<Coord> setD = new HashSet<>();
        set.add(curr);


        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);

            curr = switch (c) {
                case 'U' -> new Coord(curr.x, curr.y + 1);
                case 'R' -> new Coord(curr.x + 1, curr.y);
                case 'D' -> new Coord(curr.x, curr.y - 1);
                case 'L' -> new Coord(curr.x - 1, curr.y);
                default -> throw new IllegalArgumentException();
            };

            if (!set.add(curr)) setD.add(curr);
        }

        writer.write(String.valueOf(setD.size()));

        reader.close();
        writer.close();
    }
}
