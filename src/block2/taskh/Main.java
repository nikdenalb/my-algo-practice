package block2.taskh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Task:
 * <a href="https://new.contest.yandex.ru/contests/89520/problems?id=175943%2F2016_10_09%2FFhWFF22cXL">
 * Bank accounts (Yandex Contest)
 * </a>
 * <br><br>
 * Input:<br>
 * - a sequence of operations: DEPOSIT, WITHDRAW, BALANCE, TRANSFER, INCOME.<br>
 * <br>
 * Output:<br>
 * - for each BALANCE operation print account value, or ERROR if account does not exist.<br>
 * <br>
 * Solution idea:<br>
 * - store balances in a map `name -> amount`.<br>
 * - DEPOSIT/WITHDRAW/TRANSFER update balances directly (creating missing accounts with zero).<br>
 * - INCOME applies integer percentage only to positive balances.<br>
 */
public class Main {

    Map<String, Long> map = new HashMap<>();

    void deposit(String name, Long amount) {
        map.put(name, map.getOrDefault(name, 0L) + amount);
    }

    void withdraw(String name, Long amount) {
        map.put(name, map.getOrDefault(name, 0L) - amount);
    }

    String balance(String name) {
        Long v = map.get(name);
        return v == null ? "ERROR" : String.valueOf(v);
    }

    void transfer(String name1, String name2, Long amount) {
        map.put(name1, map.getOrDefault(name1, 0L) - amount);
        map.put(name2, map.getOrDefault(name2, 0L) + amount);
    }

    void income(Long p) {
        map.keySet().forEach(name -> map.put(name, map.get(name) + Math.max(map.get(name) * p / 100, 0)));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Main main = new Main();
        StringBuilder out = new StringBuilder();

        for (String s = reader.readLine(); s != null && !s.isEmpty(); s = reader.readLine()) {
            String[] cmd = s.split(" ");
            switch (cmd[0]) {
                case "DEPOSIT" -> main.deposit(cmd[1], Long.parseLong(cmd[2]));
                case "WITHDRAW" -> main.withdraw(cmd[1], Long.parseLong(cmd[2]));
                case "BALANCE" -> out.append(main.balance(cmd[1])).append("\n");
                case "TRANSFER" -> main.transfer(cmd[1], cmd[2], Long.parseLong(cmd[3]));
                case "INCOME" -> main.income(Long.parseLong(cmd[1]));
            }
        }
        if (!out.isEmpty()) out.setLength(out.length() - 1);

        writer.write(out.toString());

        reader.close();
        writer.close();
    }
}
