import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        File tabulkazalobcu = new File("C:\\Users\\Lukyn\\Desktop\\Zalobci-main\\tabulkazalobcu.csv");
        Scanner sc = new Scanner(tabulkazalobcu);
        ArrayList<Plaintiff> list = new ArrayList<>();
        Plaintiff plaintiff = null;
        String name;
        double price;
        double sum = 0;

        while (sc.hasNext()) {
            final String line = sc.nextLine();
            final String[] divided = line.split(",");
            if (divided.length == 3) {
                plaintiff = new Plaintiff(Integer.parseInt(divided[0]), divided[1], Double.parseDouble(divided[2])); }
            else {
                final String lenght = line.substring(line.indexOf("\""), line.lastIndexOf("\""));
                plaintiff = new Plaintiff(Integer.parseInt(divided[0]), lenght, Double.parseDouble(divided[3])); }
            list.add(plaintiff);
        }
        for (Plaintiff z : list) {
            sum += z.getAmount(); }
        double avg = sum / list.size();
        System.out.println("Prumer je = " + avg / 100);

        Map<String, Double> map = new HashMap<>();
        for (Plaintiff i : list) {
            name = i.getName();
            price = map.get(name) == null ? 0 : map.get(name);
            map.put(name, price + i.getAmount()); }
        price = Collections.max(map.values());
        name = Collections.max(map.keySet());

        System.out.println("Nejdrazsi zalobce je " + name + "a jeho castka je " + price);
    }
}
