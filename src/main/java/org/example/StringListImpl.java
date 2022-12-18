package org.example;

import java.util.Arrays;

public class StringListImpl implements StringList {

    private final String[] array;
    private final int size;

    public StringListImpl(int size) {
        this.size = size;
        this.array = new String[size];
    }

    @Override
    public String add(String item) {
        if (array[size - 1] != null) {
            throw new IndexOutOfBoundsException();
        }
        if (item == null) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < size; i++) {
            if (array[i] == null) {
                array[i] = item;
                return item;
            }
        }
        return null;
    }

    @Override
    public String add(int index, String item) {
        if (index >= size - 1 || index < 0 || array[size - 1] != null) {
            throw new IndexOutOfBoundsException();
        }
        if (item == null) {
            throw new IllegalArgumentException();
        }
        for (int i = size - 1; i >= index; i--) {
            if (array[i] != null) {
                array[i + 1] = array[i];
            }
        }
        array[index] = item;
        return item;
    }

    @Override
    public String set(int index, String item) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (item == null) {
            throw new IllegalArgumentException();
        }
        array[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i].equals(item)) {
                return remove(i);
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        String ret = array[index];
        if (ret == null) {
            throw new IllegalArgumentException();
        }
        for (int i = size - 1; i >= index; i--) {
            if (i == size - 1) {
                array[i] = null;
            } else {
                array[i] = array[i + 1];
            }
        }
        return ret;
    }

    @Override
    public boolean contains(String item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < size; i++) {
            if (array[i] != null && array[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < size; i++) {
            if (array[i] != null && array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        for (int i = size - 1; i >= 0; i--) {
            if (array[i] != null && array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            throw new IllegalArgumentException();
        }
        if (size() == otherList.size()) {
            for (int i = 0; i <= size() - 1; i++) {
                if (!array[i].equals(otherList.get(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        int i = size - 1;
        while (i >= 0) {
            if (array[i] != null) {
                return i + 1;
            }
            i--;
        }
        return 0;
    }

    @Override
    public boolean isEmpty() {
        int i = 0;
        while (i < size) {
            if (array[i] != null) {
                return false;
            }
            i++;
        }
        return true;
    }

    @Override
    public void clear() {
        Arrays.fill(array, null);
    }

    @Override
    public String[] toArray() {
        String[] newArr = new String[size()];
        for (int i = 0; i <= size() - 1; i++) {
            newArr[i] = array[i];
        }
        return newArr;
    }
}
