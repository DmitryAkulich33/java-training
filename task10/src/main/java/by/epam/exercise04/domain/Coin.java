package by.epam.exercise04.domain;

public class Coin extends Treasure {
    private int coinYear;

    public Coin() {
    }

    public Coin(String name, int cost, String materialType, int coinYear) {
        super(name, cost, materialType);
        this.coinYear = coinYear;
    }

    public int getCoinYear() {
        return coinYear;
    }

    public void setCoinYear(int coinYear) {
        this.coinYear = coinYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Coin coin = (Coin) o;

        return coinYear == coin.coinYear;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + coinYear;
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + "  coin year: " + coinYear;
    }
}
