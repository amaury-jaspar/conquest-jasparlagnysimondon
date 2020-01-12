package fr.umontpellier.iut.conquest;

import fr.umontpellier.iut.conquest.strategies.Minmax;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MinMaxTest {

    private Board board;
    Game game;
    private Minmax minMax;
    private Player player1;
    private Player aiPlayer;

    @BeforeEach
    void setup() {
        game = new Game(board, null, null, minMax, null);
        player1 = game.getPlayers()[0];
        aiPlayer = game.getPlayers()[1];
    }

    @Test
    void move_should_be_valid_for_depth_1() {
        minMax = new Minmax(1);
        board = new Board(3);
        board.initField(player1, aiPlayer);
        Move move = minMax.getMove(board, aiPlayer);

        assertTrue(board.isValid(move, aiPlayer));
    }

    @Test
    void move_should_be_the_best_possible_for_depth_1() {
        minMax = new Minmax(1);
        board = new Board(3);
        board.initField(player1, aiPlayer);
        Move move = minMax.getMove(board, aiPlayer);
        board.movePawn(move);

        assertEquals(2, board.getField()[0][0].getPlayer().getColor());
        assertEquals(2, board.getField()[0][2].getPlayer().getColor());
        assertEquals(2, board.getField()[1][1].getPlayer().getColor());
        assertEquals(2, board.getField()[2][0].getPlayer().getColor());
        assertEquals(2, board.getField()[2][2].getPlayer().getColor());
    }
}