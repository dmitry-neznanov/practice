package Homework;

import java.util.Arrays;

public class DynamicArray<T> {
    private Object[] data;
    private int size = 0;

    public DynamicArray() {
        this.data= new Object[10];
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

//    public void print() {
//
//        StringBuilder print = new StringBuilder();
//        for (Object i : data) {
//            if (i == null) {
//                print.append("[");
//            }
//            if (i != null) {
//                System.out.printf("%s ", i);
//            }
//        }
//        System.out.println();
//    }

    public String toString() {
        return Arrays.toString(data);
    }

    public void print() {
        if (data == null) {
            System.out.println((String) null);
        } else {
            StringBuilder print = new StringBuilder();
            print.append("[ ");
            for (int i = 0; i < data.length; i++) {
                if (data[i] == null) {
                    print.append("");
                } else if (i == data.length - 1) {
                    print.append(data[i]).append(" ");
                } else if (data[i] != null && i != data.length - 1) {
                    print.append(data[i]).append(", ");
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

    public void addAt(T item, int position) {
        if (data.length <= size) {
            Object[] temp = data;
            data = new Object[size * 2];

            for (int i = 0; i < temp.length ; i++) {
                if (i >= position) {
                    data[i + 1] = temp[i];

                } else {
                    data[i] = temp[i];
                }
            }
            data[position] = item;
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


}


