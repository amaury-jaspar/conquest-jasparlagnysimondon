package fr.umontpellier.iut.conquest.history;

import fr.umontpellier.iut.conquest.Pawn;

public class BoardHistory {

    /**
     * tableau de pion
     */
    private Pawn[][] field;

    /**
     * Constructeur.
     *
     * @param field : un tableau de pion
     */
    public BoardHistory(Pawn[][] field) {
        this.field = field;
    }

    /**
     * Retourne l'attribut this.field
     */
    public Pawn[][] getState() {
        return this.field;
    }
}
