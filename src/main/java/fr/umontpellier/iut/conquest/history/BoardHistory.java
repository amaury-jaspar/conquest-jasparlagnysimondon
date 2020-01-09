package fr.umontpellier.iut.conquest.history;

import fr.umontpellier.iut.conquest.Pawn;

public class BoardHistory {

    private Pawn[][] field;

    public BoardHistory(Pawn[][] field) {
        this.field = field;
    }

    public Pawn[][] getState() {
        return this.field;
    }
}
