package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class IntegerListImplTest {

    IntegerList IntegerList1 = new IntegerListImpl(5);
    IntegerList IntegerList2 = new IntegerListImpl(0);

    @BeforeEach
    void init() {
        IntegerList1.add(12);
        IntegerList1.add(24);
        IntegerList1.add(36);
    }

    @Test
    void add() {
        Integer expected = IntegerList1.add(32);
        Integer actual = IntegerList1.get(3);
        assertEquals(expected, actual);
        assertThrows(IllegalArgumentException.class, () -> IntegerList1.add(null));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> IntegerList2.add(null));
    }

    @Test
    void testAdd() {
        Integer expected = IntegerList1.add(2, 32);
        Integer actual = IntegerList1.get(2);
        assertEquals(expected, actual);
        expected = 36;
        actual = IntegerList1.get(3);
        assertEquals(expected, actual);
        assertThrows(IllegalArgumentException.class, () -> IntegerList1.add(2, null));
        IntegerList1.add(34);
        assertThrows(IndexOutOfBoundsException.class, () -> IntegerList1.add(10, 8));
        assertThrows(IndexOutOfBoundsException.class, () -> IntegerList1.add(-1, 8));
        assertThrows(IndexOutOfBoundsException.class, () -> IntegerList1.add(1, 8));
    }

    @Test
    void set() {
        Integer expected = IntegerList1.set(2, 65);
        Integer actual = IntegerList1.get(2);
        assertEquals(expected, actual);
        assertThrows(IllegalArgumentException.class, () -> IntegerList1.add(2, null));
        assertThrows(IndexOutOfBoundsException.class, () -> IntegerList1.add(10, 8));
    }

    @Test
    void remove() {
        Integer expected = IntegerList1.remove((Integer) 36);
        Integer actual = 36;
        assertEquals(expected, actual);
        assertThrows(IllegalArgumentException.class, () -> IntegerList1.remove((Integer) 36));
    }

    @Test
    void testRemove() {
        Integer expected = IntegerList1.remove(2);
        Integer actual = 36;
        assertEquals(expected, actual);
        assertThrows(IllegalArgumentException.class, () -> IntegerList1.remove(2));
        assertThrows(IndexOutOfBoundsException.class, () -> IntegerList2.remove(0));
    }

    @Test
    void contains() {
        var expected = IntegerList1.contains(36);
        var actual = true;
        assertEquals(expected, actual);
        expected = IntegerList1.contains(88);
        actual = false;
        assertEquals(expected, actual);
        assertThrows(IllegalArgumentException.class, () -> IntegerList1.contains(null));
    }

    @Test
    void indexOf() {
        var expected = IntegerList1.indexOf(36);
        var actual = 2;
        assertEquals(expected, actual);
        expected = IntegerList1.indexOf(88);
        actual = -1;
        assertEquals(expected, actual);
        assertThrows(IllegalArgumentException.class, () -> IntegerList1.indexOf(null));
    }

    @Test
    void lastIndexOf() {
        var expected = IntegerList1.lastIndexOf(36);
        var actual = 2;
        assertEquals(expected, actual);
        expected = IntegerList1.lastIndexOf(88);
        actual = -1;
        assertEquals(expected, actual);
        assertThrows(IllegalArgumentException.class, () -> IntegerList1.lastIndexOf(null));
    }

    @Test
    void get() {
        var expected = IntegerList1.get(2);
        var actual = 36;
        assertEquals(expected, actual);
        assertThrows(IndexOutOfBoundsException.class, () -> IntegerList1.get(-1));
    }

    @Test
    void testEquals() {
        IntegerList IntegerList3 = new IntegerListImpl(5);
        IntegerList3.add(12);
        IntegerList3.add(24);
        IntegerList3.add(36);
        var expected = true;
        var actual = IntegerList1.equals(IntegerList3);
        assertEquals(expected, actual);
        expected = false;
        actual = IntegerList1.equals(IntegerList2);
        assertEquals(expected, actual);
    }

    @Test
    void size() {
        var expected = 3;
        var actual = IntegerList1.size();
        assertEquals(expected, actual);
        expected = 0;
        actual = IntegerList2.size();
        assertEquals(expected, actual);
    }

    @Test
    void isEmpty() {
        var expected = true;
        var actual = IntegerList2.isEmpty();
        assertEquals(expected, actual);
        expected = false;
        actual = IntegerList1.isEmpty();
        assertEquals(expected, actual);
        expected = true;
        IntegerList IntegerList3 = new IntegerListImpl(5);
        actual = IntegerList3.isEmpty();
        assertEquals(expected, actual);
    }

    @Test
    void clear() {
        IntegerList1.clear();
        var expected = true;
        var actual = IntegerList1.isEmpty();
        assertEquals(expected, actual);
        IntegerList2.clear();
        expected = true;
        actual = IntegerList2.isEmpty();
        assertEquals(expected, actual);
    }

    @Test
    void toArray() {
        Integer[] expected = {12, 24, 36};
        Integer[] actual = IntegerList1.toArray();
        assertIterableEquals(Arrays.asList(expected), Arrays.asList(actual));
    }

    @Test
    void sortInsertion() {
        IntegerList IntegerList3 = new IntegerListImpl(5);
        IntegerList3.add(36);
        IntegerList3.add(24);
        IntegerList3.add(12);
        IntegerList3.sort();
        Integer[] expected = {12, 24, 36};
        Integer[] actual = IntegerList3.toArray();
        assertIterableEquals(Arrays.asList(expected), Arrays.asList(actual));

    }
}