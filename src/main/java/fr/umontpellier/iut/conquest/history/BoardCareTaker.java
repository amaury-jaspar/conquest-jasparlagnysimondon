package fr.umontpellier.iut.conquest.history;

import java.util.ArrayDeque;
import java.util.Deque;

public class BoardCareTaker {

    final Deque<BoardHistory> mementos = new ArrayDeque<>();

    public BoardHistory getMemento() {
        return mementos.pop();
    }

    public void addMemento (BoardHistory memento) {
        mementos.push(memento);
    }

    public boolean isAtTheBeginning() {return mementos.isEmpty();}
}
