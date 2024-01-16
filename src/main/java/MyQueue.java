import java.util.Arrays;

public class MyQueue<E> extends BiDirectionalList<E> implements MyCollectible {

    int size = 0;
    Node<E> first;
    Node<E> last;

    //============================================================
    public MyQueue() {

    }

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

    //============================================================

    private void removeFirst() {
        if (first.next!=null) first.next.prev=null;
        first = first.next;

        size--;
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
    public void clear() {
        size = 0;
        first = null;
        last = null;
    }

    @Override
    public int size() {
        return size;
    }

    public E peek(){
        if (first==null) return null;

        return first.item;
    }

    public E poll(){
        if (first==null) return null;

        E result = first.item;

        removeFirst();

        return result;
    }

}
