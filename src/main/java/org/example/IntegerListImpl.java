package org.example;

import java.util.Arrays;

public class IntegerListImpl implements IntegerList {

    private Integer[] array;
    private final int size;

    public IntegerListImpl(int size) {
        this.size = size;
        this.array = new Integer[size];
    }

    @Override
    public Integer add(Integer item) {
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
    public Integer add(int index, Integer item) {
        if (array[size - 1] != null){
            grow();
        }
        if (index >= size - 1 || index < 0) {
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
    public Integer set(int index, Integer item) {
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
    public Integer remove(Integer item) {
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
    public Integer remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Integer ret = array[index];
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
    public boolean contains(Integer item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        sort();
        return containsBinary(item);
    }

    @Override
    public int indexOf(Integer item) {
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
    public int lastIndexOf(Integer item) {
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
    public Integer get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
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
        int i = array.length - 1;
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
    public Integer[] toArray() {
        Integer[] newArr = new Integer[size()];
        for (int i = 0; i <= size() - 1; i++) {
            newArr[i] = array[i];
        }
        return newArr;
    }

    public void sort() {
        quickSort(array,0,size()-1);
    }

    private void quickSort(Integer[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private int partition(Integer[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                swapElements(arr, i, j);
            }
        }

        swapElements(arr, i + 1, end);
        return i + 1;
    }

    private void swapElements(Integer[] arr, int i, int minElementIndex) {
        Integer buf = arr[i];
        arr[i] = arr[minElementIndex];
        arr[minElementIndex] = buf;
    }

    private boolean containsBinary(int element) {
        int min = 0;
        int max = size() - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (element == array[mid]) {
                return true;
            }

            if (element < array[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }
    private void grow(){
        Integer[] newArray = new Integer[array.length + array.length/2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

}
