import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {

    private static final String INPUT_FILE_NAME = "input.txt";
    private static final Integer SELL_PRICE = 10;

    public static void main(String[] args) {
        final var testCases = TestCaseUtil.readFromFile(INPUT_FILE_NAME);
        executeTestCases(testCases);
    }

    private static void executeTestCases(Map<Integer, List<List<Integer>>> testCases) {
        testCases.forEach((testCaseId, testCase) -> {

            var profitMapPiles = extractProfitMapPiles(testCase);
            var maxProfit = extractMaximumProfit(combineProfitMaps(profitMapPiles));

            System.out.println("schuurs " + testCaseId);
            System.out.printf("Maximum profit is %s.%n", maxProfit.getMaxProfit());
            System.out.printf("Number of fluts to buy: %s%n%n", String.join(" ", maxProfit.getAmountsToPrint()));
        });
    }

    private static List<Map<Integer, Integer>> extractProfitMapPiles(final List<List<Integer>> testCase) {
        List<Map<Integer, Integer>> result = new ArrayList<>();

        for (var pile : testCase) {
            Map<Integer, Integer> pileProfitMap = new HashMap<>();
            var currentPrice = 0;
            for (var i = 0; i < pile.size(); i++) {
                currentPrice += pile.get(i);

                var currentProfit = SELL_PRICE * (i + 1) - currentPrice;
                if (currentProfit > 0) {
                    pileProfitMap.put(i + 1, currentProfit);
                }
            }
            result.add(pileProfitMap);
        }

        return result;
    }

    private static MaximumProfit extractMaximumProfit(final Map<Integer, Integer> combinedProfitMap) {
        int maxProfit = Collections.max(combinedProfitMap.values());
        List<Integer> amounts = new ArrayList<>();

        combinedProfitMap.forEach((amount, profit) -> {
            if (profit == maxProfit) {
                amounts.add(amount);
            }
        });

        return new MaximumProfit(maxProfit, amounts);
    }

    private static Map<Integer, Integer> combineProfitMaps(List<Map<Integer, Integer>> profitMapList) {
        Map<Integer, Integer> profitMap1 = profitMapList.get(0);
        Map<Integer, Integer> profitMap2 = profitMapList.size() > 1 ? profitMapList.get(1) : Collections.emptyMap();

        if (profitMap1.isEmpty()) {
            return profitMap2;
        }
        if (profitMap2.isEmpty()) {
            return profitMap1;
        }

        Map<Integer, Integer> combinedProfitMap = new HashMap<>();

        profitMap1.forEach((key1, value1) -> {
            profitMap2.forEach((key2, value2) -> {
                updateProfitMap(combinedProfitMap, key1 + key2, value1 + value2);
            });
        });

        combineProfitMaps(profitMapList.subList(1, profitMapList.size())).forEach((key, value) -> {
            updateProfitMap(combinedProfitMap, key, value);
        });

        return combinedProfitMap;
    }

    private static void updateProfitMap(Map<Integer, Integer> profitMap, int amount, int profit) {
        final var latestProfit = profitMap.computeIfPresent(amount, (oldAmount, oldProfit) -> {
            if (oldProfit > profit) {
                return oldProfit;
            } else {
                return profit;
            }
        });

        if (latestProfit == null) {
            profitMap.put(amount, profit);
        }
    }
}
