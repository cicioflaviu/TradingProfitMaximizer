import java.util.List;
import java.util.stream.Collectors;

public class MaximumProfit {

    private final int maxProfit;
    private final List<Integer> amounts;

    public MaximumProfit(final int maxProfit, final List<Integer> amounts) {
        this.maxProfit = maxProfit;
        this.amounts = amounts;
    }

    public int getMaxProfit() {
        return maxProfit;
    }

    public List<String> getAmountsToPrint() {
        return amounts.stream().sorted().limit(10).map(Object::toString).collect(Collectors.toList());
    }
}
