package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class CarNames {
    public List<String> inputCarNames() {
        String rawCarNames = Console.readLine();
        return splitCarNames(rawCarNames);
    }

    private List<String> splitCarNames(String rawCarNames) {
        List<String> splitCarNames = new ArrayList<>();
        String nowCarNames = rawCarNames;

        if (rawCarNames.contains(",")) {


            while (nowCarNames.contains(",")) {
                int index = nowCarNames.indexOf(",");
                String tempCarNames = nowCarNames.substring(0, index);
                checkAndthenAdd(tempCarNames, splitCarNames);
                nowCarNames = nowCarNames.substring(index + 1);
            }
        }
        if(!nowCarNames.isEmpty()) {
            checkAndthenAdd(nowCarNames, splitCarNames);

        }
        if(nowCarNames.isEmpty()) {
            checkAndthenAdd(rawCarNames, splitCarNames);
        }
        return splitCarNames;
    }

    private void checkCarNameSize(String carName) {
        if (carName.length() > 5 || (carName.length() == 0)) {
            throw new IllegalArgumentException();
        }
    }

    private void checkSameCarName(List<String> splitCarName, String compareCarName) {
        if (splitCarName.contains(compareCarName)) {
            throw new IllegalArgumentException();
        }
    }

    private void checkAndthenAdd(String carName, List<String> splitCarNames) {
        checkCarNameSize(carName);
        checkSameCarName(splitCarNames, carName);
        splitCarNames.add(carName);
    }
}
