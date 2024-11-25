package Homework;

import java.util.Arrays;
import java.util.Objects;

public class DynamicArray<T> {
    private Object[] data;
    private int size = 0;

    public DynamicArray() {
        this.data = new Object[10];
    }

    public DynamicArray(int size) {
        this.size = size;
        this.data = new Object[size];
    }

    @SafeVarargs
    public DynamicArray(T... var) {
        this.data = var;
        this.size = var.length;
    }

    public String toString() {
        return Arrays.toString(data);
    }

    public void print() {
        if (data == null) {
            System.out.println((String) null);
        } else {
            StringBuilder print = new StringBuilder();
            print.append("[");
            print.append(data[0]);
            for (int i = 1; i < data.length; i++) {
                if (data[i] != null) {
                    print.append(", ");
                    print.append(data[i]);
                }
            }
            print.append("]");
            System.out.println(print);
        }
    }

    public void add(T item) {
        if (data.length <= size) {
            Object[] temp = data;
            data = new Object[size * 2];
            for (int i = 0; i < temp.length; i++) {
                data[i] = temp[i];
            }
        }
        data[size] = item;
        size++;
    }

    public void add(T item, int index) {
        if (data.length <= size) {
            Object[] temp = data;
            data = new Object[size * 2];

            for (int i = 0; i < temp.length; i++) {
                if (i >= index) {
                    data[i + 1] = temp[i];

                } else {
                    data[i] = temp[i];
                }
            }
            data[index] = item;
            size++;
        }
    }

    public T get(int index) {
        return (T) data[index];
    }

    public void set(T element, int index) {
        this.data[index] = element;
    }

    public int size() {
        return size;
    }

    public boolean contains(T val) {

        boolean result = false;

        for (Object xxx : data) {
            if (xxx == val) {
                result = true;
                break;
            }
        }
        return result;
    }

    public void remove(int index) {
        Object[] temp = data;
        data = new Object[data.length];

        for (int i = 0; i < data.length - 1; i++) {
            if (i >= index) {
                data[i] = temp[i + 1];
            } else {
                data[i] = temp[i];
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DynamicArray<?> array = (DynamicArray<?>) o;
        return Objects.deepEquals(data, array.data);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(data);
    }
}