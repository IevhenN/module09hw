import java.util.Arrays;

public class MyLinkedList<E> extends BiDirectionalList<E> implements MyCollectible, MyRemovable {

    int size = 0;
    Node<E> first;
    Node<E> last;

    //============================================================
    public MyLinkedList() {

    }

    //============================================================
    private Node<E> getNode(int index) {
        Node<E> currentNode;

        if (index < size / 2) {
            currentNode = first;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
        } else {
            currentNode = last;
            for (int i = size - 1; i > index; i--) {
                currentNode = currentNode.prev;
            }
        }
        return currentNode;
    }

    public boolean indexValid(int index) {
        if (index < 0 || index >= size) {
            return false;
        }

        return true;
    }

    //============================================================
    public void add(E item) {
        Node<E> newNode = new Node<>(last, item, null);

        if (size != 0) {
            last.next = newNode;
        }

        last = newNode;

        if (size == 0) {
            first = newNode;
        }

        size++;
    }

    @Override
    public boolean remove(int index) {
        if (!indexValid(index)) return false;

        Node<E> currentNode = getNode(index);
        if (currentNode == null) return false;

        if (currentNode.prev == null) {
            first = currentNode.next;
        } else {
            currentNode.prev.next = currentNode.next;
        }


        if (currentNode.next != null) {
            currentNode.next.prev = currentNode.prev;
        } else {
            last = currentNode.prev;
        }

        size--;

        return true;
    }

    @Override
    public void clear() {
        size = 0;
        first = null;
        last = null;
    }

    @Override
    public int size() {
        return size;
    }

    public E get(int index) {
        if (!indexValid(index)) {
            return null;
        }

        if (first == null || last == null) return null;

        return getNode(index).item;
    }

    //============================================================
    @Override
    public String toString() {
        String[] result = new String[size];

        if (size != 0) {
            Node<E> currentNode = first;

            for (int i = 0; i < size; i++) {
                if (i != 0) {
                    currentNode = currentNode.next;
                }
                ;
                result[i] = currentNode.item.toString();
            }
        }

        return Arrays.toString(result);
    }
}
