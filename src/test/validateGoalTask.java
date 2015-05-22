import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by Julik on 20.05.2015.
 */
public class validateGoalTask {

    @Test
    public void validateNameMinValue_shouldPass() {
        assertTrue(GoalTask.validateNameLength("abcdef"), "It should be possible to create name with 6 symbols");
    }

    @Test
    public void validateNameMaxValue_shouldPass() {
        assertTrue(GoalTask.validateNameLength("abcdefabcdabcdefabcd"), "It should be possible to create name with 20 symbols");
    }

    @Test
    public void validateNameNumber_shouldPass() {
        assertTrue(GoalTask.validateNameSymbols("QWERTYUIOPASDFGHJKLZXCVBNM"), "It should be possible to create name with alphabetic symbols");
        assertTrue(GoalTask.validateNameSymbols("qwertyuiopasdfghjklzxcvbnm"), "It should be possible to create name with alphabetic symbols");
    }

    @Test(dataProvider = "numbers")
    public void validateNameNumber_shouldFail(String numbers) {
        assertFalse(GoalTask.validateNameSymbols("abcdef"+numbers), "It should be impossible to create name with digits");
    }

    @Test(dataProvider = "specSymbols")
    public void validateNameSpec_shouldFail(String specSymbol) {
        assertFalse(GoalTask.validateNameSymbols("abcdef"+specSymbol), "It should be impossible to create name with spec characters");
    }

    @DataProvider
    public Object[][] specSymbols() {
        return new String[][]{
                {"!"}, {"@"}, {"#"}, {"$"}, {"%"}, {"^"}, {"&"}, {"*"}, {"("}, {")"}, {"{"}, {"}"}, {"\""}, {"'"}, {"|"}, {"?"}, {"+"}, {";"},{":"},{">"},{"<"}
        };
    }

    @DataProvider
    public Object[][] numbers() {
        return new String[][]{
                {"0"}, {"1"}, {"2"}, {"3"}, {"4"}, {"5"}, {"6"}, {"7"}, {"8"}, {"9"}
        };
    }
}
