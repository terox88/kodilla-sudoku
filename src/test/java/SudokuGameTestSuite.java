import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SudokuGameTestSuite {

    @Test
    void settingBoardWithDataTest() {
        //Given
        SudokuGame game = new SudokuGame();
        List<SudokuData> data =new ArrayList<>();
        data.add(new SudokuData(1,3,4));
        data.add(new SudokuData(5,6,7));
        data.add(new SudokuData(1, 2, 5));
        //When
       boolean result = game.setTheBoard(data);
       //Then
        assertTrue(result);
        System.out.println(game.getBoard());
    }
    @Test
    void settingBoardWithoutDataTest() {
        //Given
        SudokuGame game = new SudokuGame();
        List<SudokuData> data = new ArrayList<>();
        //When
        boolean result = game.setTheBoard(data);
        //Then
        assertFalse(result);
        System.out.println(game.getBoard());
    }

    @Test
    void checkRowsTest() throws CanotResolveSudokuException{
        SudokuGame game = new SudokuGame();
        List<SudokuData> data =new ArrayList<>();
        data.add(new SudokuData(1,3,4));
        data.add(new SudokuData(5,3,7));
        data.add(new SudokuData(1, 2, 5));
        game.setTheBoard(data);
        //When
        boolean result = game.checkRows();
        int secondRow = game.getBoard().getBoard().get(1).getSudokuRow().get(2).getPossibleNumbers().size();
        int thirdRow = game.getBoard().getBoard().get(2).getSudokuRow().get(7).getPossibleNumbers().size();
        //Then
        assertTrue(result);
        assertEquals(8, secondRow);
        assertEquals(7, thirdRow);
        System.out.println(game.getBoard());
    }

    @Test
    void checkColumnsTest() throws CanotResolveSudokuException {
        SudokuGame game = new SudokuGame();
        List<SudokuData> data = new ArrayList<>();
        data.add(new SudokuData(1, 3, 4));
        data.add(new SudokuData(5, 3, 7));
        data.add(new SudokuData(1, 2, 5));
        game.setTheBoard(data);
        //When
        boolean result = game.checkColumns();
        int firstColumn = game.getBoard().getBoard().get(7).getSudokuRow().get(0).getPossibleNumbers().size();
        int fifthColumn = game.getBoard().getBoard().get(7).getSudokuRow().get(4).getPossibleNumbers().size();
        //Then
        assertTrue(result);
        assertEquals(7, firstColumn);
        assertEquals(8, fifthColumn);
        System.out.println(game.getBoard());
    }

    @Test
    void fieldCheckTest() throws CanotResolveSudokuException{
        SudokuGame game = new SudokuGame();
        List<SudokuData> data = new ArrayList<>();
        data.add(new SudokuData(1, 3, 4));
        data.add(new SudokuData(5, 3, 7));
        data.add(new SudokuData(1, 2, 5));
        game.setTheBoard(data);
        //When
        boolean result = game.fieldCheck(0, 0);
        int firstField = game.getBoard().getBoard().get(0).getSudokuRow().get(0).getPossibleNumbers().size();
        //Then
        assertTrue(result);
        assertEquals(7, firstField);
        System.out.println(game.getBoard());
    }
    @Test
    void checkRowsWithWrongEnteredDataTest() throws CanotResolveSudokuException {
        //Given
        SudokuGame game = new SudokuGame();
        List<SudokuData> data = new ArrayList<>();
        data.add(new SudokuData(1, 3, 4));
        data.add(new SudokuData(5, 3, 7));
        data.add(new SudokuData(1, 2, 5));
        data.add(new SudokuData(3, 3, 7));
        game.setTheBoard(data);
        //When & Then
        Assertions.assertThrows(CanotResolveSudokuException.class, () -> game.checkRows());

    }
    @Test
    void checkRowsWithWrongGuestedDataTest() throws CanotResolveSudokuException {
        //Given
        SudokuGame game = new SudokuGame();
        List<SudokuData> data = new ArrayList<>();
        data.add(new SudokuData(1, 3, 4));
        data.add(new SudokuData(5, 3, 7));
        data.add(new SudokuData(1, 2, 5));
        game.setTheBoard(data);
        game.getBoard().getBoard().get(2).getSudokuRow().get(2).getPossibleNumbers().remove(Integer.valueOf(1));
        game.getBoard().getBoard().get(2).getSudokuRow().get(2).getPossibleNumbers().remove(Integer.valueOf(2));
        game.getBoard().getBoard().get(2).getSudokuRow().get(2).getPossibleNumbers().remove(Integer.valueOf(3));
        game.getBoard().getBoard().get(2).getSudokuRow().get(2).getPossibleNumbers().remove(Integer.valueOf(4));
        game.getBoard().getBoard().get(2).getSudokuRow().get(2).getPossibleNumbers().remove(Integer.valueOf(5));
        game.getBoard().getBoard().get(2).getSudokuRow().get(2).getPossibleNumbers().remove(Integer.valueOf(6));
        game.getBoard().getBoard().get(2).getSudokuRow().get(2).getPossibleNumbers().remove(Integer.valueOf(8));
        game.getBoard().getBoard().get(2).getSudokuRow().get(2).getPossibleNumbers().remove(Integer.valueOf(9));
        //When & Then
        Assertions.assertThrows(CanotResolveSudokuException.class, () -> game.checkRows());

    }
    @Test
    void checkColumnsWithWrongGuessedDataTest() throws CanotResolveSudokuException {
        //Given
        SudokuGame game = new SudokuGame();
        List<SudokuData> data = new ArrayList<>();
        data.add(new SudokuData(1, 3, 4));
        data.add(new SudokuData(5, 3, 7));
        data.add(new SudokuData(1, 2, 5));

        game.setTheBoard(data);

        game.getBoard().getBoard().get(5).getSudokuRow().get(4).getPossibleNumbers().remove(Integer.valueOf(1));
        game.getBoard().getBoard().get(5).getSudokuRow().get(4).getPossibleNumbers().remove(Integer.valueOf(2));
        game.getBoard().getBoard().get(5).getSudokuRow().get(4).getPossibleNumbers().remove(Integer.valueOf(3));
        game.getBoard().getBoard().get(5).getSudokuRow().get(4).getPossibleNumbers().remove(Integer.valueOf(4));
        game.getBoard().getBoard().get(5).getSudokuRow().get(4).getPossibleNumbers().remove(Integer.valueOf(5));
        game.getBoard().getBoard().get(5).getSudokuRow().get(4).getPossibleNumbers().remove(Integer.valueOf(6));
        game.getBoard().getBoard().get(5).getSudokuRow().get(4).getPossibleNumbers().remove(Integer.valueOf(8));
        game.getBoard().getBoard().get(5).getSudokuRow().get(4).getPossibleNumbers().remove(Integer.valueOf(9));


        //When & Then

        Assertions.assertThrows(CanotResolveSudokuException.class, ()-> game.checkColumns());

    }
    @Test
    void checkColumnsWithWrongEnteredDataTest() throws CanotResolveSudokuException {
        //Given
        SudokuGame game = new SudokuGame();
        List<SudokuData> data = new ArrayList<>();
        data.add(new SudokuData(1, 3, 4));
        data.add(new SudokuData(3, 3, 7));
        data.add(new SudokuData(1, 2, 5));
        data.add(new SudokuData(3, 5, 7));
        game.setTheBoard(data);
        //When & Then
        Assertions.assertThrows(CanotResolveSudokuException.class, () -> game.checkColumns());

    }
    @Test
    void fieldCheckWithWrongEnteredDataTest() {
        //Given
        SudokuGame game = new SudokuGame();
        List<SudokuData> data = new ArrayList<>();
        data.add(new SudokuData(1, 3, 4));
        data.add(new SudokuData(3, 3, 7));
        data.add(new SudokuData(1, 2, 5));
        data.add(new SudokuData(3, 2, 7));
        game.setTheBoard(data);
        //When & Then
        Assertions.assertThrows(CanotResolveSudokuException.class,()-> game.fieldCheck(0,0));
    }
    @Test
    void checkFieldWithWrongGuessedDataTest() throws CanotResolveSudokuException {
        //Given
        SudokuGame game = new SudokuGame();
        List<SudokuData> data = new ArrayList<>();
        data.add(new SudokuData(1, 3, 4));
        data.add(new SudokuData(2, 3, 7));
        data.add(new SudokuData(1, 2, 5));

        game.setTheBoard(data);

        game.getBoard().getBoard().get(0).getSudokuRow().get(2).getPossibleNumbers().remove(Integer.valueOf(1));
        game.getBoard().getBoard().get(0).getSudokuRow().get(2).getPossibleNumbers().remove(Integer.valueOf(2));
        game.getBoard().getBoard().get(0).getSudokuRow().get(2).getPossibleNumbers().remove(Integer.valueOf(3));
        game.getBoard().getBoard().get(0).getSudokuRow().get(2).getPossibleNumbers().remove(Integer.valueOf(4));
        game.getBoard().getBoard().get(0).getSudokuRow().get(2).getPossibleNumbers().remove(Integer.valueOf(5));
        game.getBoard().getBoard().get(0).getSudokuRow().get(2).getPossibleNumbers().remove(Integer.valueOf(6));
        game.getBoard().getBoard().get(0).getSudokuRow().get(2).getPossibleNumbers().remove(Integer.valueOf(8));
        game.getBoard().getBoard().get(0).getSudokuRow().get(2).getPossibleNumbers().remove(Integer.valueOf(9));


        //When & Then

        Assertions.assertThrows(CanotResolveSudokuException.class, ()-> game.fieldCheck(0,0));

    }

}
