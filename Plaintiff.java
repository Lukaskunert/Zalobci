public class Plaintiff {

    final int rok;
    final String name;
    final double amount;

    public Plaintiff(int year, String name, double cost) {
        this.rok = year;
        this.name = name;
        this.amount = cost; }
    public double getAmount() {
        return amount;
    }
    public String getName() {
        return name;
    }
}
