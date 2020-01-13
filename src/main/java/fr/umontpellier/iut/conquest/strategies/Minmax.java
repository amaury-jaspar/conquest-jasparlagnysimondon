package fr.umontpellier.iut.conquest.strategies;

import fr.umontpellier.iut.conquest.Board;
import fr.umontpellier.iut.conquest.Move;
import fr.umontpellier.iut.conquest.Player;

import java.util.List;

public class Minmax implements Strategy {

    private final int level;

    /**
     * Constructeur
     * @param level le niveau de difficulté de l'IA
     */
    public Minmax(int level) {
        this.level = level;
    }

    /**
     * Retourne le meilleur coup possible en fonction de la difficulté choisie
     * @param board le plateau de jeu dans l'état donné
     * @param player le joueur dont on détermine les coups (IA)
     * @return un Move
     */
    @Override
    public Move getMove(Board board, Player player) {
        double maxPoints = Double.NEGATIVE_INFINITY;
        Move bestMove = null;
        List<Move> movesList = board.getValidMoves(player);
        for(Move move : movesList) {
            Board currentBoard = board.getBoardCopy();
            currentBoard.movePawn(move);
            double points = minimax(currentBoard, player, level-1, false);
            if (points > maxPoints) {
                bestMove = move;
            }
            maxPoints = Math.max(maxPoints, points);
        }
        return bestMove;
    }

    /**
     * Retourne le score le plus élevé au prochain tour en fonctions des déplacements disponibles et du nombre de coups
     * calculés à l'avance
     * @param board le plateau de jeu en l'état actuel
     * @param player le joueur pour lequel on calcule les coups possibles
     * @param depth la profondeur de l'arbre = le nombre de coups prévus à l'avance
     * @param maximizingPlayer boolean déterminant si l'on cherche le score maximum
     *                         ou le score minimum
     * @return le meilleur score pour {@code player}
     */
    public double minimax(Board board, Player player, int depth, boolean maximizingPlayer) {
        List<Move> playerMovesList = board.getValidMoves(player);
        Player otherPlayer = player.getGame().getOtherPlayer(player);
        List<Move> otherPlayerMovesList = board.getValidMoves(otherPlayer);
        if(depth == 0 || playerMovesList.isEmpty()) {
            return board.getNbPawns(player) - board.getNbPawns(otherPlayer);
        }
        if (maximizingPlayer) {
            double maxEval = Double.NEGATIVE_INFINITY;
            for (Move move : playerMovesList) {
                Board currentBoard = board.getBoardCopy();
                currentBoard.movePawn(move);
                double eval = minimax(currentBoard, player, depth-1, false);
                maxEval = Math.max(maxEval, eval);
            }
            return maxEval;
        } else {
            double minEval = Double.POSITIVE_INFINITY;
            for (Move move : otherPlayerMovesList) {
                Board currentBoard = board.getBoardCopy();
                currentBoard.movePawn(move);
                double eval = minimax(currentBoard, player, depth-1, true);
                minEval = Math.min(minEval, eval);
            }
            return minEval;
        }
    }
}
