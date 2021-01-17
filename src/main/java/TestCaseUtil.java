import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestCaseUtil {

    private TestCaseUtil() {
    }

    public static Map<Integer, List<List<Integer>>> readFromFile(String fileName) {
        Map<Integer, List<List<Integer>>> testCases = new HashMap<>();

        try {
            var myObj = new File(fileName);
            var myReader = new Scanner(myObj);
            var testCaseId = 1;
            while (myReader.hasNextLine()) {
                var line = myReader.nextLine();
                var amountOfSchuurs = Integer.parseInt((line.trim()));

                if(amountOfSchuurs == 0) {
                    break;
                }

                List<List<Integer>> piles = new ArrayList<>();
                for (var i = 0; i < amountOfSchuurs; i++) {
                    line = myReader.nextLine();
                    var pileDetails = Arrays.stream(line.split(" ")).map(Integer::parseInt)
                            .collect(Collectors.toList());

                    var amountOfBoxes = pileDetails.get(0);

                    var pile = IntStream.range(1, amountOfBoxes + 1).mapToObj(pileDetails::get)
                            .collect(Collectors.toCollection(ArrayList::new));
                    piles.add(pile);
                }

                testCases.put(testCaseId, piles);
                testCaseId++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return testCases;
    }
}
