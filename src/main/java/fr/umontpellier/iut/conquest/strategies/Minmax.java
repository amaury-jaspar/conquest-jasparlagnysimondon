package fr.umontpellier.iut.conquest.strategies;

import fr.umontpellier.iut.conquest.Board;
import fr.umontpellier.iut.conquest.Move;
import fr.umontpellier.iut.conquest.Player;

import java.util.List;

public class Minmax implements Strategy {

    private final int level;

    public Minmax(int level) {
        this.level = level;
    }

    @Override
    public Move getMove(Board board, Player player) {
        double maxPoints = Double.NEGATIVE_INFINITY;
        Move bestMove = null;
        for(Move move : board.getValidMoves(player)) {
            Board currentBoard = board.getBoardCopy();
            currentBoard.movePawn(move);
            double points = minmax(currentBoard, player, level-1, false);
            if (points > maxPoints) {
                bestMove = move;
            }
            maxPoints = Math.max(maxPoints, points);
        }
        return bestMove;
    }

    public double minmax(Board board, Player player, int depth, boolean maximizingPlayer) {
        List<Move> movesList = board.getValidMoves(player);
        if(depth == 0 || movesList.isEmpty()) {
            return board.getNbPawns(player) - board.getNbPawns(player.getGame().getOtherPlayer(player));
        }
        if (maximizingPlayer) {
            double maxEval = Double.NEGATIVE_INFINITY;
            for (Move move : movesList) {
                Board currentBoard = board.getBoardCopy();
                currentBoard.movePawn(move);
                double eval = minmax(currentBoard, player, depth-1, false);
                maxEval = Math.max(maxEval, eval);
            }
            return maxEval;
        } else {
            double minEval = Double.POSITIVE_INFINITY;
            for (Move move : movesList) {
                Board currentBoard = board.getBoardCopy();
                currentBoard.movePawn(move);
                double eval = minmax(currentBoard, player, depth-1, true);
                minEval = Math.max(minEval, eval);
            }
            return minEval;
        }
    }
}
