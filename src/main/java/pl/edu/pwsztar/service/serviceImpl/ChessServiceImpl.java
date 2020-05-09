package pl.edu.pwsztar.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.edu.pwsztar.domain.chess.RulesOfGame;
import pl.edu.pwsztar.domain.dto.FigureMoveDto;
import pl.edu.pwsztar.domain.enums.FigureType;
import pl.edu.pwsztar.service.ChessService;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

@Service
public class ChessServiceImpl implements ChessService {

    private RulesOfGame bishop;
    private RulesOfGame knight;
    private RulesOfGame pawn;
    private RulesOfGame queen;
    private RulesOfGame king;
    private RulesOfGame rock;

    @Autowired
    public ChessServiceImpl(@Qualifier("Bishop") RulesOfGame bishop,
                            @Qualifier("Knight") RulesOfGame knight,
                            @Qualifier("Pawn") RulesOfGame pawn,
                            @Qualifier("Queen") RulesOfGame queen,
                            @Qualifier("King") RulesOfGame king,
                            @Qualifier("Rock") RulesOfGame rock) {
        this.bishop = bishop;
        this.knight = knight;
        this.pawn = pawn;
        this.queen = queen;
        this.king = king;
        this.rock = rock;
    }

    @Override
    public boolean isCorrectMove(FigureMoveDto figureMoveDto) {
        FigureType type = figureMoveDto.getType();

        String[] startPosition = figureMoveDto.getStart().split("_");
        String[] destinationPosition = figureMoveDto.getDestination().split("_");
        List<String> positions = new ArrayList<>(Arrays.asList("a","b","c","d","e","f","g","h"));

        int currentColumn = positions.indexOf(startPosition[0]);
        int currentRow = Integer.parseInt(startPosition[1]);
        int destinationColumn = positions.indexOf(destinationPosition[0]);
        int destinationRow = Integer.parseInt(destinationPosition[1]);

        switch (type){
            case BISHOP:
                return this.bishop.isCorrectMove(currentColumn, currentRow, destinationColumn, destinationRow);
            case KNIGHT:
                return this.knight.isCorrectMove(currentColumn, currentRow, destinationColumn, destinationRow);
            case PAWN:
                return this.pawn.isCorrectMove(currentColumn, currentRow, destinationColumn, destinationRow);
            case QUEEN:
                return this.queen.isCorrectMove(currentColumn, currentRow, destinationColumn, destinationRow);
            case ROCK:
                return this.rock.isCorrectMove(currentColumn, currentRow, destinationColumn, destinationRow);
            case KING:
                return this.king.isCorrectMove(currentColumn, currentRow, destinationColumn, destinationRow);
        }
        return false;
    }
}
