import org.jetbrains.annotations.NotNull;

public class Money implements Comparable<Money> {

    private final long amount;

    public Money(long amount) {
        this.amount = amount;
    }

    public long getAmount() {
        return amount;
    }

    public Money plus(Money money) {
        return new Money(money.amount + this.amount);
    }

    @Override
    public int compareTo(@NotNull Money o) {
        return Long.compare(this.amount, o.amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Money money = (Money) o;

        return amount == money.amount;
    }

    @Override
    public int hashCode() {
        return (int) (amount ^ (amount >>> 32));
    }
}
