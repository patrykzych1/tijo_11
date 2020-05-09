package pl.edu.pwsztar.domain.chess;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class KnightTest {
    private RulesOfGame knight = new RulesOfGame.Knight();

    @Tag("Knight")
    @ParameterizedTest
    @CsvSource({
            " 0,  0,  1, 2",
            " 3,  5,  2, 3",
            "-1,  4,  0, 2",
            " 0,  1,  1, 3",
    })
    void checkCorrectMoveForKnight(int xStart, int yStart, int xStop, int yStop) {
        assertTrue(knight.isCorrectMove(xStart, yStart, xStop, yStop));
    }

    @ParameterizedTest
    @CsvSource({
            "0,  1,  1,  1",
            "10, 11, 12, 13"
    })
    void checkIncorrectMoveForKnight(int xStart, int yStart, int xStop, int yStop) {
        assertFalse(knight.isCorrectMove(xStart, yStart, xStop, yStop));
    }
}
