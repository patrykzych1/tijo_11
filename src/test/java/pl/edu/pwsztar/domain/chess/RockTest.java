package pl.edu.pwsztar.domain.chess;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RockTest {
    private RulesOfGame rock = new RulesOfGame.Rock();

    @Tag("Rock")
    @ParameterizedTest
    @CsvSource({
            " 0,  10,  0,  62",
            "5,   7,  25, 7",
            "-14, 30, -15,  30",
            " 0,  1,  0,  101 ",
    })
    void checkCorrectMoveForRock(int xStart, int yStart, int xStop, int yStop) {
        assertTrue(rock.isCorrectMove(xStart, yStart, xStop, yStop));
    }

    @ParameterizedTest
    @CsvSource({
            "0,  1,  1,  6",
            "10, 10, 11,  15"
    })
    void checkIncorrectMoveForRock(int xStart, int yStart, int xStop, int yStop) {
        assertFalse(rock.isCorrectMove(xStart, yStart, xStop, yStop));
    }
}
