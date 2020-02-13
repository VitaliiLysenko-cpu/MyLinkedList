package linkedList;

public class MyLinkedList<E> implements MyList<E> {

    private int curSize = 0;
    private Node<E> first;
    private Node<E> last;

    public MyLinkedList() {
        first = new Node<E>(null, null, last);
        last = new Node<E>(first, null, null);
    }

    @Override
    public int size() {
        return curSize ;
    }

    @Override
    public boolean isEmpty() {
        return curSize == 0;
    }

    @Override
    public boolean contains(E e) {
        return false;
    }

    @Override
    public void addFirst(E e) {
        Node<E> next = first;
        next.setElement(e);
        first = new Node<E>(null, null, next);
        curSize++;
    }

    @Override
    public void addLast(E e) {
        Node<E> prev = last;
        prev.setElement(e);
        last = new Node<>(prev, null, null);
        curSize++;
    }

    @Override
    public E get(int index) {
        return null ;
    }

    @Override
    public E getFirst() {
        return null ;
    }

    @Override
    public E getLast() {
        return null;
    }

    @Override
    public boolean offerFirst(E e) {
        return false;
    }

    @Override
    public boolean offerLast(E e) {
        return false;
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
        E element;
        MyLinkedList.Node<E> next;
        MyLinkedList.Node<E> prev;

        Node(MyLinkedList.Node<E> prev, E element, MyLinkedList.Node<E> next) {
            this.element = element;
            this.next = next;
            this.prev = prev;

        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
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
