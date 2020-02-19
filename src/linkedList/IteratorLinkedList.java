package linkedList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class IteratorLinkedList<E> implements Iterator {
    private MyLinkedList.Node<E> lastReturned;
    private MyLinkedList.Node<E> next;
    private int nextIndex;
    MyLinkedList<E> myLinkedList = new MyLinkedList<>();

    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */
    @Override
    public boolean hasNext() {
        return nextIndex < myLinkedList.getCurSize();
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        lastReturned = next;
        next = next.next;
        nextIndex++;
        return lastReturned.el;
    }
}