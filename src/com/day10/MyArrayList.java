package com.day10;

public class MyArrayList<U> {
    private Object[] list;
    private int currentIndex = 0;

    public MyArrayList(int size) {
        list = new Object[size];
    }

    public MyArrayList() {
        this(10);
    }

    public void add(U volume) {
        list[currentIndex] = volume;
        currentIndex++;
    }

    public void set(U volume, int index) {
        if (index < currentIndex) {
            this.list[index] = volume;
        }
    }

    public U getByIndex(int index) {
        if (index <= currentIndex) return (U) list[index];
        throw new RuntimeException("Out of ..");
    }

    public boolean contains(U toFind) {
        for (Object in : list) {
            if (in != null && in.equals(toFind)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(U toFind) {
        if (contains(toFind)) {
            for (int i = 0; i < currentIndex; i++) {
                if (list[i].equals(toFind)) return i;
            }
        }
        System.out.println("Not present");
        return -1;
    }

    public void removeByIndex(int index) {
        if (index < currentIndex) {
            for (int i = index; i < currentIndex; i++) {
                list[i] = list[i + 1];
            }
            list[currentIndex] = null;
            currentIndex--;
        }

    }

    public void removeByElement(U toRemove) {
        int i = indexOf(toRemove);
        removeByIndex(i);
    }

    public void clear() {
        currentIndex = 0;
    }

    public int size() {
        return currentIndex;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (int i = 0; i < currentIndex; i++) {
            sb.append(list[i]).append(" ");
        }
        sb.append("]");
        return sb.toString();
    }
}
