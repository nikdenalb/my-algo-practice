package block3.contest8.task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/89540/problems?id=30404%2F2026_03_01%2FZSSos64DZz">
 * Cell painting (Yandex Contest)
 * </a>
 * <br><br>
 * Constraints (from statement):<br>
 * - program is a string of letters U, R, D, L only, length at most 1000<br>
 * - U moves one cell up, R right, D down, L left on an infinite grid<br>
 * - the starting cell is painted; every visited cell is painted<br>
 * - time limit 1 s, memory 256 MB<br>
 * <br>
 * Solution idea:<br>
 * - simulate the walk from the origin, keeping a set of cells already visited at least once.<br>
 * - when a move lands on a cell that is already in that set, put the cell in a second set of cells painted more than once (duplicates merge in a set, so each such cell is counted once).<br>
 * - answer is the size of the second set.<br>
 */
public class MainRefined {

    record Coord(int x, int y) {}

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Coord coord = new Coord(0, 0);
        Set<Coord> set = new HashSet<>();
        Set<Coord> setD = new HashSet<>();
        set.add(coord);

        String s = reader.readLine();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            coord = switch (c) {
                case 'U' -> new Coord(coord.x, coord.y + 1);
                case 'R' -> new Coord(coord.x + 1, coord.y);
                case 'D' -> new Coord(coord.x, coord.y - 1);
                case 'L' -> new Coord(coord.x - 1, coord.y);
                default -> throw new IllegalArgumentException();
            };

            if (!set.add(coord)) setD.add(coord);
        }

        writer.write(String.valueOf(setD.size()));

        reader.close();
        writer.close();
    }
}
