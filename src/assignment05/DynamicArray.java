package assignment05;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Gianni Belizaire (A00487024)
 */
public class DynamicArray<T> implements DynamicCollection<T> {

    private static final int INITIAL_CAPACITY = 8;
    private T[] arrayData;
    private int size;

    public DynamicArray() {
        this.arrayData = (T[]) new Object[INITIAL_CAPACITY];
        this.size = 0;
    }

    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        }

        return false;
    }

    public int size() {
        return this.size;
    }

    public Object[] toJavaArray() {
        return Arrays.copyOf(this.arrayData, this.size);
    }

    public Object[] getUnderlyingArrayCopy() {
        return Arrays.copyOf(this.arrayData, this.arrayData.length);
    }

    @Override
    public String toString() {
        return Arrays.toString(this.toJavaArray());
    }

    public T get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Array index is out of bounds");
        }

        return this.arrayData[index];
    }

    public T getLast() {
        if (this.isEmpty()) {
            return null;
        }

        return this.arrayData[this.size - 1];
    }

    public T getRandom() {
        if (this.isEmpty()) {
            return null;
        }

        Random rand = new Random();
        int randIndex = rand.nextInt(this.size);

        return this.arrayData[randIndex];
    }

    public void set(int index, T value) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Array index is out of bounds");
        }

        this.arrayData[index] = value;
    }

    public void add(T data) {
        if (this.size == this.arrayData.length) {
            int newCapacity = this.arrayData.length * 2;
            this.arrayData = Arrays.copyOf(this.arrayData, newCapacity);
        }
        
        this.arrayData[this.size++] = data;
    }

    public T delete(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Array index is out of bounds");
        }

        T deletedElement = this.arrayData[index];

        for (int i = index; i < this.size - 1; i++) {
            this.arrayData[i] = this.arrayData[i + 1];
        }

        this.arrayData[--this.size] = null;

        return deletedElement;
    }
}
