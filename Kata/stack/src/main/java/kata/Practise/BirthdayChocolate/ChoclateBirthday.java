package kata.Practise.BirthdayChocolate;

import java.util.List;

public class ChoclateBirthday {

    public static int birthday(List<Integer> chocolateBar, int day, int month) {
        int matchingElements = 0;

        for (int i = 0; i < chocolateBar.size(); i++) {
            if ((getSegmentSum(chocolateBar, month, i)).equals(day))
                matchingElements++;
        }
        return matchingElements;
    }

    private static Integer getSegmentSum(List<Integer> choclateBarArray, int month, int iterator) {
        Integer sum = 0;
        for (int i = 0; i < month; i++) {
            if (iterator + i < choclateBarArray.size())
                sum += choclateBarArray.get(iterator + i);
        }
        return sum;
    }
}
