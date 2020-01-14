package fr.umontpellier.iut.conquest.history;

import java.util.ArrayDeque;
import java.util.Deque;

public class BoardCareTaker {

    /**
     * Une liste de memento, de type FILO (une pile)
     */
    final Deque<BoardHistory> mementos;

    /**
     * Constructeur.
     * Initialise la liste de mementos
     */
    public BoardCareTaker () {
        mementos = new ArrayDeque<>();
    }

    /**
     * récupère le dernier memento ajouté à la pile
     */
    public BoardHistory getMemento() {
        return mementos.pop();
    }

    /**
     * Ajoute un memento à la pile
     */
    public void addMemento (BoardHistory memento) {
        mementos.push(memento);
    }

    /**
     * Renvoie un booléen.
     *  True = la pile de mememto est vide
     *  False = la pile contient un ou des memento
     */
    public boolean isAtTheBeginning() {return mementos.isEmpty();}
}
