package fr.umontpellier.iut.conquest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest2 {
    private Board b;
    private Player player1 = new Player(null, null, null, 1);
    private Player player2 = new Player(null, null, null, 2);

    @BeforeEach
    void disableConsole() {
        System.setOut(new PrintStream(new OutputStream() {
            @Override
            public void write(int arg0) {

            }
        }));

    }

    @BeforeEach
    void create_board() {
        b = new Board(5);
        b.initField(player1, player2);
    }

    @Test
    void from_starting_position_on_a_board_of_size_3_player1_should_be_able_to_move_top_left_pawn_and_bottom_right_to_every_free_cell() {
        Board board = new Board(3);
        board.initField(player1, player2);
        List<Move> validMoves = board.getValidMoves(player1);
        System.out.println(validMoves.size());

        assertFalse(validMoves.contains(new Move(0, 0, 0, 2)));
        assertFalse(validMoves.contains(new Move(0, 0, 2, 0)));
        assertFalse(validMoves.contains(new Move(0, 0, -1, -1)));
        assertFalse(validMoves.contains(new Move(0, 0, -1, 0)));
        assertFalse(validMoves.contains(new Move(0, 0, 0, -1)));
        assertFalse(validMoves.contains(new Move(0, 0, 2, 2)));

    }

}