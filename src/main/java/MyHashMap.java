import java.util.Arrays;
import java.util.Objects;

public class MyHashMap<K, V> implements MyCollectible {
    private static final int FACTOR = 10;
    private Node<K, V>[] backets;
    private int size = 0;
    //=========================================================================


    public MyHashMap() {
        this(MyHashMap.FACTOR);
    }

    public MyHashMap(int factor) {
        backets = new Node [factor];
    }

    @Override
    public String toString() {
        String[] result = new String[size];
        int count = 0;
        Node <K,V> currentNode = null;

        for (int i = 0; i < backets.length; i++) {
            currentNode = backets[i];

            if (currentNode == null) {
                continue;
            }
            while (currentNode!=null){
                result[count] = "{"+currentNode.key.toString()+" = "+currentNode.value.toString()+"}";
                count++;
                currentNode = currentNode.next;
            }
        }
        return Arrays.toString(result);
    }

    //=========================================================================
    private int getIndexKey(K key) {
        return Math.abs(key.hashCode() % MyHashMap.FACTOR);
    }

    private Node<K, V>[] searchNode(Node<K, V> startNode, K key) {
/*        returns:
        [0] searched key Node, if not - null   sea - if the backet is empty
        [1] prev Node searched key Node. if not searched key Node - null :
        [2] last Node if not searched key Node.
 */
        Node<K, V>[] result = new Node[]{null, null, null};

        if (startNode == null) return result;

        Node<K, V> currentNode = startNode;
        Node<K, V> prevNode = null;

        do {
            if (currentNode.key.equals(key)) {
                result[0] = currentNode;
                result[1] = prevNode;
                return result;
            }

            prevNode = currentNode;
            currentNode = currentNode.next;
        } while (currentNode != null);

        result[2] = prevNode;
        result[1] = prevNode;
        return result;
    }

    //=========================================================================
    @Override
    public void clear() {
        backets = new Node[MyHashMap.FACTOR];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    public void put(K key, V value) {
        int index = getIndexKey(key);
        Node<K, V>[] searchNode = searchNode(backets[index], key);

        if (searchNode[0] != null) {
            //key found
            searchNode[0].value = value;
        } else {
            Node<K, V> newNode = new Node<K, V>(key, value, searchNode[1]);

            if (searchNode[1] == null) {
                backets[index] = newNode;
            } else {
                searchNode[1].next = newNode;
            }

            size++;
        }
    }

    public void remove(K key) {

        int index = getIndexKey(key);
        Node<K, V>[] searchNode = searchNode(backets[index], key);

        if (searchNode[0] == null) return;

        if (searchNode[1] == null) {
            backets[index] = searchNode[0].next;
        } else {
            searchNode[1].next = searchNode[0].next;
        }
        size--;

    }

    public V get(K key) {
        int index = getIndexKey(key);
        Node<K, V>[] searchNode = searchNode(backets[index], key);

        if (searchNode[0] == null) return null;

        return searchNode[0].value;
    }


    //=========================================================================

    private static class Node<K, V> {
        int hash;
        K key;
        V value;
        MyHashMap.Node<K, V> next;

        Node(K key, V value, MyHashMap.Node<K, V> parentNode) {
            this.key = key;
            this.value = value;
            if (parentNode != null) parentNode.next = this;
        }
    }
}
