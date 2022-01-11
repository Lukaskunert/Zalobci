import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        File tabulka = new File("C:\\Škola\\Ukol7\\src\\naklady_zastoupeni.csv");
        Scanner sc = new Scanner(tabulka);
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
                final String delsi = line.substring(line.indexOf("\""), line.lastIndexOf("\""));
                plaintiff = new Plaintiff(Integer.parseInt(divided[0]), delsi, Double.parseDouble(divided[3])); }
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

        Map<String, Double> nej = new HashMap<>();
        Set set = map.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()) {
            Map.Entry me = (Map.Entry)i.next();
            nej.put((String) me.getKey(), (Double) me.getValue()); }
        price = Collections.max(nej.values());
        name = Collections.max(nej.keySet());
        System.out.println("Nejdrazsi zalobce je " + name + "a jeho castka je " + price);
    }
}
