package pl.edu.pwsztar.domain.chess;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class QueenTest {
    private RulesOfGame queen = new RulesOfGame.Queen();

    @Tag("Queen")
    @ParameterizedTest
    @CsvSource({
            " 0,  0,  7, 7",
            "-1, -1, -1,  0",
            "-1,  1, -1,  5",
            " 0,  1,  0,  11",
    })
    void checkCorrectMoveForQueen(int xStart, int yStart, int xStop, int yStop) {
        assertTrue(queen.isCorrectMove(xStart, yStart, xStop, yStop));
    }

    @ParameterizedTest
    @CsvSource({
            "1,  1,  1,  1",
            "1,  1,  2,  3"
    })
    void checkIncorrectMoveForQueen(int xStart, int yStart, int xStop, int yStop) {
        assertFalse(queen.isCorrectMove(xStart, yStart, xStop, yStop));
    }
}
