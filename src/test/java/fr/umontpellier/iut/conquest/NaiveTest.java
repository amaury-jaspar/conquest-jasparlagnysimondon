package fr.umontpellier.iut.conquest;

import fr.umontpellier.iut.conquest.strategies.Naive;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NaiveTest {

    private Board b;
    private Player player1 = new Player(null, null, null, 1);
    private Naive naive = new Naive();
    private Player aiPlayer = new Player(naive, null, null, 2);

    @BeforeEach
    void create_board() {
        b = new Board(5);
        b.initField(player1, aiPlayer);
    }

    @Test
    void move_should_be_in_valid_moves_list() {
        Move move = naive.getMove(b, aiPlayer);
        assertTrue(b.getValidMoves(aiPlayer).contains(move));
    }

}
