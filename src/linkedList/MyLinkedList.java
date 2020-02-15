package linkedList;

import java.util.NoSuchElementException;

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
        if (first!= null&&last!=null){
            return true;
        }else {
            return false;
        }
    }

     @Override
     public boolean contains(E e) {
         if(isEmpty()) for (int i = 0; i < curSize; i++) {
             if (get(i).equals(e)) return true;
         }
         return false;
     }


    @Override
    public void addFirst(E e) {
        Node<E> f = first;
        Node<E> newNode = new Node<>(null, e, f);
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.prev = newNode;
        curSize++;
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

    @Override
    public E getLast() {
        Node<E> l = first;
        if (l == null)
            throw new NoSuchElementException();
        return l.el;
    }

    @Override
    public boolean offerFirst(E e) {
        Node<E> f = first;
        Node<E> newNode = new Node<>(null, e, f);
        if (f == null) {
            first = newNode;
            if (f == null) {
                last = newNode;
            } else {
                f.prev = newNode;
                curSize++;
            }
        }
        return true;
    }

    @Override
    public boolean offerLast(E e) {
        Node<E> l = last;
        Node<E> newNode = new Node<>(l, e, null);
        if (l == null) {
            last = newNode;
            if (l == null) {
                first = newNode;
            } else {
                l.next = newNode;
                curSize++;
            }
        }
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
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public void toArray() {

    }

    private static class Node<E> {
        E el;
        MyLinkedList.Node<E> next;
        MyLinkedList.Node<E> prev;

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
