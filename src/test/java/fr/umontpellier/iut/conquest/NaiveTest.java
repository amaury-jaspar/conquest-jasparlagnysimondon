package fr.umontpellier.iut.conquest;

import fr.umontpellier.iut.conquest.strategies.Naive;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NaiveTest {

    private Board board;
    private Player player1 = new Player(null, null, null, 1);
    private Naive naive = new Naive();
    private Player aiPlayer = new Player(naive, null, null, 2);

    @BeforeEach
    void create_board() {
        board = new Board(5);
        board.initField(player1, aiPlayer);
    }

    @Test
    void move_should_be_valid() {
        Move move = naive.getMove(board, aiPlayer);
        assertTrue(board.isValid(move, aiPlayer));
    }
}
