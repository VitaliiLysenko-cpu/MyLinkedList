package linkedList;

import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;

public class MyLinkedList<E> implements MyList<E> {

    private int curSize = 0;
    private Node<E> first;
    private Node<E> last;

    public MyLinkedList() {

    }

    @Override
    public int size() {
        return curSize;
    }

    @Override
    public boolean isEmpty() {
        if (first != null && last != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean contains(E e) {
        if (isEmpty()) for (int i = 0; i < curSize; i++) {
            if (get(i).equals(e)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(int index, E e) {
        if (index <= 0 && index >= curSize) {
            throw new IndexOutOfBoundsException();
        }
        if (index == curSize) {
            addLast(e);
        } else {
            Node<E> desiredCell = node(index);
            Node<E> previousСell = desiredCell.prev;
            Node<E> newNode = new Node<>(previousСell, e, desiredCell);
            desiredCell.prev = newNode;
            if (previousСell == null)
                first = newNode;
            else
                previousСell.next = newNode;
            curSize++;
        }
    }


    @Override
    public void addFirst(E e) {
        //створюю змінну  присвоюю їй значення першої Node.
        Node<E> f = first;
        // створюю нову newNode із значенням "е" яка має посиляння на попередній елемент
        // зі значенням null і на наступний, зі значенням поередньо створеної змінної.
        Node<E> newNode = new Node<>(null, e, f);
        //записуємо в першу Node значення новоствореної newNode.
        first = newNode;
        //якщо значення f = null (елемент зі значенням != null додається вперше  ) ,
        // в кінцеву Node (last) записуемо значення новоствореної newNode. Ця перевірка не дозволяє
        // збільшувати розмір масиву при додованні першого елементу)
        if (f == null) {
            last = newNode;
        } else {
            f.prev = newNode;
            curSize++;
        }
    }

    @Override
    public void addLast(E e) {
        Node<E> l = last;
        Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        curSize++;
    }

    @Override
    public E get(int index) {
        Node<E> x;
        x = first;
        for (int i = 0; i < index; i++)
            x = x.next;
        return x.getElement();
    }

    @Override
    public E getFirst() {
        Node<E> f = first;
        if (f == null)
            throw new NoSuchElementException();
        return f.el;
    }

    public void setFirst(Node<E> first) {
        this.first = first;
    }

    @Override
    public E getLast() {
        Node<E> l = first;
        if (l == null)
            throw new NoSuchElementException();
        return l.el;
    }

    public void setLast(Node<E> last) {
        this.last = last;
    }

    @Override
    public boolean offerFirst(E e) {
        addFirst(e);
        return true;
    }

    @Override
    public boolean offerLast(E e) {
        addLast(e);
        return true;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public E removeFirst() {
        return null;
    }

    @Override
    public E removeLast() {
        return null;
    }

    @Override
    public E  set(int index, E element) {
        Node<E> setElement = node(index);
        E exElement = setElement.el;
        setElement.el = element;
        return exElement;

    }

    @Override
    public void clear() {

    }

    @Override
    public void toArray() {
    }

    Node<E> node(int index) {
        Node<E> x = first;
        for (int i = 0; i < index; i++)
            x = x.next;
        return x;
    }

    private static class Node<E> {
        E el;
        MyLinkedList.Node<E> next;
        MyLinkedList.Node<E> prev;

        public Node() {
        }

        Node(MyLinkedList.Node<E> prev, E element, MyLinkedList.Node<E> next) {
            this.el = element;
            this.next = next;
            this.prev = prev;

        }

        public E getElement() {
            return el;
        }

        public void setElement(E element) {
            this.el = element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }
    }
}
