import java.util.LinkedList;

public abstract class BiDirectionalList <E> {

    int size = 0;

    Node<E> first;

    Node<E> last;

    public BiDirectionalList () {

    }

    protected static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
