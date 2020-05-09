package pl.edu.pwsztar.domain.chess;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class KingTest {

    private RulesOfGame king = new RulesOfGame.King();

    @Tag("King")
    @ParameterizedTest
    @CsvSource({
            " 0,  0,  1,  1",
            "-1, -1, -2, -2",
            "-1,  4, -1, 5 ",
            " 0,  1,  0,  2 ",
    })
    void checkCorrectMoveForKing(int xStart, int yStart, int xStop, int yStop) {
        assertTrue(king.isCorrectMove(xStart, yStart, xStop, yStop));
    }

    @ParameterizedTest
    @CsvSource({
            "0,  1,  1,  6",
            "10, 10, 10,  15"
    })
    void checkIncorrectMoveForKing(int xStart, int yStart, int xStop, int yStop) {
        assertFalse(king.isCorrectMove(xStart, yStart, xStop, yStop));
    }
}
