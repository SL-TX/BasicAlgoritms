package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class IntegerListImplTest {

    IntegerList integerList1 = new IntegerListImpl(5);
    IntegerList integerList2 = new IntegerListImpl(0);

    @BeforeEach
    void init() {
        integerList1.add(12);
        integerList1.add(24);
        integerList1.add(36);
    }

    @Test
    void add() {
        Integer expected = integerList1.add(32);
        Integer actual = integerList1.get(3);
        assertEquals(expected, actual);
        assertThrows(IllegalArgumentException.class, () -> integerList1.add(null));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> integerList2.add(null));
    }

    @Test
    void testAdd() {
        Integer expected = integerList1.add(2, 32);
        Integer actual = integerList1.get(2);
        assertEquals(expected, actual);
        expected = 36;
        actual = integerList1.get(3);
        assertEquals(expected, actual);
        assertThrows(IllegalArgumentException.class, () -> integerList1.add(2, null));
        integerList1.add(34);
        assertThrows(IndexOutOfBoundsException.class, () -> integerList1.add(10, 8));
        assertThrows(IndexOutOfBoundsException.class, () -> integerList1.add(-1, 8));
        integerList1.add(1, 8);
        expected = 6;
        actual = integerList1.size();
        assertEquals(expected,actual);
    }

    @Test
    void set() {
        Integer expected = integerList1.set(2, 65);
        Integer actual = integerList1.get(2);
        assertEquals(expected, actual);
        assertThrows(IllegalArgumentException.class, () -> integerList1.add(2, null));
        assertThrows(IndexOutOfBoundsException.class, () -> integerList1.add(10, 8));
    }

    @Test
    void remove() {
        Integer expected = integerList1.remove((Integer) 36);
        Integer actual = 36;
        assertEquals(expected, actual);
        assertThrows(IllegalArgumentException.class, () -> integerList1.remove((Integer) 36));
    }

    @Test
    void testRemove() {
        Integer expected = integerList1.remove(2);
        Integer actual = 36;
        assertEquals(expected, actual);
        assertThrows(IllegalArgumentException.class, () -> integerList1.remove(2));
        assertThrows(IndexOutOfBoundsException.class, () -> integerList2.remove(0));
    }

    @Test
    void contains() {
        var expected = integerList1.contains(36);
        var actual = true;
        assertEquals(expected, actual);
        expected = integerList1.contains(88);
        actual = false;
        assertEquals(expected, actual);
        assertThrows(IllegalArgumentException.class, () -> integerList1.contains(null));
    }

    @Test
    void indexOf() {
        var expected = integerList1.indexOf(36);
        var actual = 2;
        assertEquals(expected, actual);
        expected = integerList1.indexOf(88);
        actual = -1;
        assertEquals(expected, actual);
        assertThrows(IllegalArgumentException.class, () -> integerList1.indexOf(null));
    }

    @Test
    void lastIndexOf() {
        var expected = integerList1.lastIndexOf(36);
        var actual = 2;
        assertEquals(expected, actual);
        expected = integerList1.lastIndexOf(88);
        actual = -1;
        assertEquals(expected, actual);
        assertThrows(IllegalArgumentException.class, () -> integerList1.lastIndexOf(null));
    }

    @Test
    void get() {
        var expected = integerList1.get(2);
        var actual = 36;
        assertEquals(expected, actual);
        assertThrows(IndexOutOfBoundsException.class, () -> integerList1.get(-1));
    }

    @Test
    void testEquals() {
        IntegerList IntegerList3 = new IntegerListImpl(5);
        IntegerList3.add(12);
        IntegerList3.add(24);
        IntegerList3.add(36);
        var expected = true;
        var actual = integerList1.equals(IntegerList3);
        assertEquals(expected, actual);
        expected = false;
        actual = integerList1.equals(integerList2);
        assertEquals(expected, actual);
    }

    @Test
    void size() {
        var expected = 3;
        var actual = integerList1.size();
        assertEquals(expected, actual);
        expected = 0;
        actual = integerList2.size();
        assertEquals(expected, actual);
    }

    @Test
    void isEmpty() {
        var expected = true;
        var actual = integerList2.isEmpty();
        assertEquals(expected, actual);
        expected = false;
        actual = integerList1.isEmpty();
        assertEquals(expected, actual);
        expected = true;
        IntegerList integerList3 = new IntegerListImpl(5);
        actual = integerList3.isEmpty();
        assertEquals(expected, actual);
    }

    @Test
    void clear() {
        integerList1.clear();
        var expected = true;
        var actual = integerList1.isEmpty();
        assertEquals(expected, actual);
        integerList2.clear();
        expected = true;
        actual = integerList2.isEmpty();
        assertEquals(expected, actual);
    }

    @Test
    void toArray() {
        Integer[] expected = {12, 24, 36};
        Integer[] actual = integerList1.toArray();
        assertIterableEquals(Arrays.asList(expected), Arrays.asList(actual));
    }

    @Test
    void sortInsertion() {
        IntegerList integerList3 = new IntegerListImpl(5);
        integerList3.add(36);
        integerList3.add(24);
        integerList3.add(12);
        integerList3.sort();
        Integer[] expected = {12, 24, 36};
        Integer[] actual = integerList3.toArray();
        assertIterableEquals(Arrays.asList(expected), Arrays.asList(actual));

    }
}