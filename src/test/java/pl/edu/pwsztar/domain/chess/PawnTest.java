package pl.edu.pwsztar.domain.chess;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PawnTest {
    private RulesOfGame pawn = new RulesOfGame.Pawn();

    @Tag("Pawn")
    @ParameterizedTest
    @CsvSource({
            " 0,  3,  0,  4",
            "-1, -1, -1, 0",
            "-1,  4, -1,  5",
            " 0,  1,  0,  2",
    })
    void checkCorrectMoveForPawn(int xStart, int yStart, int xStop, int yStop) {
        assertTrue(pawn.isCorrectMove(xStart, yStart, xStop, yStop));
    }

    @ParameterizedTest
    @CsvSource({
            "0,  0,  -1,   0",
            "0,  0,   2,   0"
    })
    void checkIncorrectMoveForPawn(int xStart, int yStart, int xStop, int yStop) {
        assertFalse(pawn.isCorrectMove(xStart, yStart, xStop, yStop));
    }
}
