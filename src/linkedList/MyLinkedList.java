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
        if (first != null || last != null) return true;
        else return false;
    }

    @Override
    public boolean contains(E e) {
        if (!isEmpty()) {
            return false;
        }else {
            for (Node<E> i = first; i != null; i = i.next) {
                if (e.equals(i.el)) {
                    return true;
                }
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

 // public void setFirst(E element) {
 //     this.first = first;
 // }

    @Override
    public E getLast() {
        Node<E> l = first;
        if (l == null)
            throw new NoSuchElementException();
        return l.el;
    }

 // public void setLast(E element) {
 //     
 //     this.last = last;
 // }

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
    public E remove(int index) {
        Node<E> n = node(index);
        E element = n.el;
        Node<E> prev = n.prev;
        Node<E> next = n.next;
        if (prev == null) { // (prev == null   , first , next )
            first = next;   // (null , first , next) -> (null , next , next)
        } else {
            prev.next = next;//
            n.prev = null;
        }
        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            n.next = null;
        }
        n.el = null;
        curSize--;
        return element;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.el == null) {
                    remove(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.el)) {
                    remove(x);
                    return true;
                }
            }
        }
      return false;
    }

    @Override
    public E removeFirst() {
        Node<E> f = first;
        E element = f.el;
        Node<E> next = f.next;
        first = next;
        if (next == null)
            last = null;
        else
            next.prev = null;
        curSize--;

        return element;
    }

    @Override
    public E removeLast() {
        Node<E> l = last;
        E element = l.el;
        Node<E> prev = l.prev;
        last = prev;
        if (prev == null)
            first = null;
        else
            prev.next = null;
        curSize--;
        return element;
    }

    @Override
    public E set(int index, E element) {
        Node<E> setElement = node(index); //setElement = new Node<>(prev, setElement, next)
        E exElement = setElement.el;//exElement "value" -> setElement "null"
        setElement.el = element; // setElement"null" -> setElement "element"
        return exElement;
    }

    @Override
    public void clear() {
        for (Node<E> x = first; x != null;  ) {
            Node<E> next = x.next;
            x.el = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = last = null;
        curSize = 0;
    }

    public int getCurSize() {
        return curSize;
    }

    @Override
    public Object[] toArray() {
        Object[] res = new Object[curSize];
        int i = 0;
        Node<E> x = first;
        while (x != null) {
            res[i++] = x.el;
            x = x.next;
        }
        return res;
    }

    Node<E> node(int index) {
        Node<E> x = first;
        for (int i = 0; i < index; i++)
            x = x.next;
        return x;
    }

    static class Node<E> {
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

        public Node(int index) {

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
    public IteratorLinkedList<E> iteratorLinkedList(){
        return new IteratorLinkedList<E>();
    }
}
