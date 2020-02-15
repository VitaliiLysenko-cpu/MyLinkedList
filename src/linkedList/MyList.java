package linkedList;

import org.w3c.dom.Node;

public interface MyList<E>  {
    int size();

    boolean isEmpty();

    boolean contains(E e);

    void  addFirst(E e);

    void addLast(E e);

    E get(int index);

    E getFirst();

    E getLast();

    boolean offerFirst(E e);

    boolean offerLast(E e);

    E remove();

    E remove(int index);

    boolean remove(Object o);

    E removeFirst();

    E removeLast();

    E set(int index, E element);

    void clear();

    void toArray();
}