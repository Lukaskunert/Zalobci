public class Plaintiff {

     int year;
     String name;
     double amount;

    public Plaintiff(int year, String name, double cost) {
        this.year = year;
        this.name = name;
        this.amount = cost; }
    public double getAmount() {
        return amount;
    }
    public String getName() {
        return name;
    }
}
