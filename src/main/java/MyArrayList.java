import java.util.Arrays;

public class MyArrayList<E> implements MyCollectible, MyRemovable {
    private static final int DEFAULT_LENGTH = 4;
    private final int startLength;
    private Object[] items;
    private int size = 0;

    //============================================================
    public MyArrayList() {
        this(MyArrayList.DEFAULT_LENGTH);
    }

    public MyArrayList(int startLength) {
        this.items = new Object[startLength];
        this.startLength = startLength;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(items, size));
    }

    //============================================================
    private void changeSpace(int endIndex) {
        int newLength = items.length;

        if (endIndex == items.length) {
            newLength = Math.round(items.length * 1.5f);
        } else if (endIndex < items.length / 2 && endIndex > startLength) {
            newLength = Math.round(items.length / 1.5f);
        }

        if (items.length != newLength) {
            items = Arrays.copyOf(items, newLength);
        }
    }

    public boolean indexValid(int index) {
        if (index < 0 || index >= size) {
            return false;
        }
        return true;
    }

    public int getLength(){
        return items.length;
    }

    //============================================================
    @Override
    public void clear() {
        size = 0;
        items = new Object[startLength];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean remove(int index) {

        if (!indexValid(index)){
            return false;
        }

        System.arraycopy(items, index+1, items, index, size-index-1);

        size--;
        changeSpace(size);

        return true;
    }

    public void add(E value) {
        changeSpace(size);
        items[size] = value;
        size++;
    }

    public E get(int index) {
        return (E) items[index];
    }

}
