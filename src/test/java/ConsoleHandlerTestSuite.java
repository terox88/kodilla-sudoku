import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ConsoleHandlerTestSuite {

    @Test
    void testCreateSudokuData() {
        //Given
        ConsoleHandler handler = new ConsoleHandler();

        //When
        List<SudokuData> result = handler.createSudokuData("1, 3, 4, 5, 6,7, 1, 2,5");
        int val1X = result.get(0).getX();
        int val1Y = result.get(0).getY();
        int val1V = result.get(0).getValue();
        int val2X = result.get(1).getX();
        int val2Y = result.get(1).getY();
        int val2V = result.get(1).getValue();
        int val3X = result.get(2).getX();
        int val3Y = result.get(2).getY();
        int val3V = result.get(2).getValue();

        //Then
        Assertions.assertEquals(3, result.size());
        Assertions.assertEquals(1, val1X);
        Assertions.assertEquals(3, val1Y);
        Assertions.assertEquals(4, val1V);
        Assertions.assertEquals(5, val2X);
        Assertions.assertEquals(6, val2Y);
        Assertions.assertEquals(7, val2V);
        Assertions.assertEquals(1, val3X);
        Assertions.assertEquals(2, val3Y);
        Assertions.assertEquals(5, val3V);

    }
}
