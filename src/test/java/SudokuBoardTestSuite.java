import com.kodilla.sudokukodilla.SudokuBoard;
import com.kodilla.sudokukodilla.SudokuData;
import com.kodilla.sudokukodilla.SudokuGame;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SudokuBoardTestSuite {

    @Test
    void testBoardPrint() {
        //Given
        SudokuBoard board = new SudokuBoard();

        //When & Then
        System.out.println(board);
    }
    @Test
    void cloneBoardTest() {
        //Given
        SudokuGame game = new SudokuGame();
        List<SudokuData> data = new ArrayList<>();
        data.add(new SudokuData(1, 3, 4));
        data.add(new SudokuData(5, 3, 7));
        data.add(new SudokuData(1, 2, 5));
        game.setTheBoard(data);
        //When
        SudokuBoard clonedBoard= game.getBoard().deepCopy();;
        //Then
        System.out.println(game.getBoard());
        System.out.println();
        System.out.println(clonedBoard);
    }
}
