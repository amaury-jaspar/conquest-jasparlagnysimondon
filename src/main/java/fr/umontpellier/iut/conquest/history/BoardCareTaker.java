package fr.umontpellier.iut.conquest.history;

import java.util.ArrayDeque;
import java.util.Deque;

public class BoardCareTaker {

    final Deque<BoardHistory> mementos = new ArrayDeque<>();

    public BoardHistory getMemento() {
        BoardHistory boardmemento = mementos.pop();
        return boardmemento;
    }

    public void addMemento (BoardHistory memento) {
        mementos.push(memento);
    }

    public boolean isAtTheBeginning() {return mementos.size() == 0;}

    public int size() {return mementos.size();}
}
