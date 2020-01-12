package fr.umontpellier.iut.conquest.strategies;

import fr.umontpellier.iut.conquest.Board;
import fr.umontpellier.iut.conquest.Move;
import fr.umontpellier.iut.conquest.Player;

import java.util.List;
import java.util.Random;

public class Naive implements Strategy {

    @Override
    public Move getMove(Board board, Player player) {
        Random rand = new Random();
        List<Move> validMoves = board.getValidMoves(player);
        if(! validMoves.isEmpty()) {
            return validMoves.get(rand.nextInt(validMoves.size()));
        } else return null;
    }
}
