package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class StringListImplTest {

    StringList stringList1 = new StringListImpl(5);
    StringList stringList2 = new StringListImpl(0);

    @BeforeEach
    void init() {
        stringList1.add("text1");
        stringList1.add("text2");
        stringList1.add("text3");
    }

    @Test
    void add() {
        String expected = stringList1.add("asd");
        String actual = stringList1.get(3);
        assertEquals(expected, actual);
        assertThrows(IllegalArgumentException.class, () -> stringList1.add(null));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> stringList2.add(null));
    }

    @Test
    void testAdd() {
        String expected = stringList1.add(2, "asd2");
        String actual = stringList1.get(2);
        assertEquals(expected, actual);
        expected = "text3";
        actual = stringList1.get(3);
        assertEquals(expected, actual);
        assertThrows(IllegalArgumentException.class, () -> stringList1.add(2, null));
        stringList1.add("asd");
        assertThrows(IndexOutOfBoundsException.class, () -> stringList1.add(10, "asd"));
        assertThrows(IndexOutOfBoundsException.class, () -> stringList1.add(-1, "asd"));
        assertThrows(IndexOutOfBoundsException.class, () -> stringList1.add(1, "asd"));
    }

    @Test
    void set() {
        String expected = stringList1.set(2, "asd2");
        String actual = stringList1.get(2);
        assertEquals(expected, actual);
        assertThrows(IllegalArgumentException.class, () -> stringList1.add(2, null));
        assertThrows(IndexOutOfBoundsException.class, () -> stringList1.add(10, "asd"));
    }

    @Test
    void remove() {
        String expected = stringList1.remove("text3");
        String actual = "text3";
        assertEquals(expected, actual);
        assertThrows(IllegalArgumentException.class, () -> stringList1.remove("text3"));
    }

    @Test
    void testRemove() {
        String expected = stringList1.remove(2);
        String actual = "text3";
        assertEquals(expected, actual);
        assertThrows(IllegalArgumentException.class, () -> stringList1.remove(2));
        assertThrows(IndexOutOfBoundsException.class, () -> stringList2.remove(0));
    }

    @Test
    void contains() {
        var expected = stringList1.contains("text3");
        var actual = true;
        assertEquals(expected, actual);
        expected = stringList1.contains("asdf");
        actual = false;
        assertEquals(expected, actual);
        assertThrows(IllegalArgumentException.class, () -> stringList1.contains(null));
    }

    @Test
    void indexOf() {
        var expected = stringList1.indexOf("text3");
        var actual = 2;
        assertEquals(expected, actual);
        expected = stringList1.indexOf("asdf");
        actual = -1;
        assertEquals(expected, actual);
        assertThrows(IllegalArgumentException.class, () -> stringList1.indexOf(null));
    }

    @Test
    void lastIndexOf() {
        var expected = stringList1.lastIndexOf("text3");
        var actual = 2;
        assertEquals(expected, actual);
        expected = stringList1.lastIndexOf("asdf");
        actual = -1;
        assertEquals(expected, actual);
        assertThrows(IllegalArgumentException.class, () -> stringList1.lastIndexOf(null));
    }

    @Test
    void get() {
        var expected = stringList1.get(2);
        var actual = "text3";
        assertEquals(expected, actual);
        assertThrows(IndexOutOfBoundsException.class, () -> stringList1.get(-1));
    }

    @Test
    void testEquals() {
        StringList stringList3 = new StringListImpl(5);
        stringList3.add("text1");
        stringList3.add("text2");
        stringList3.add("text3");
        var expected = true;
        var actual = stringList1.equals(stringList3);
        assertEquals(expected, actual);
        expected = false;
        actual = stringList1.equals(stringList2);
        assertEquals(expected, actual);
    }

    @Test
    void size() {
        var expected = 3;
        var actual = stringList1.size();
        assertEquals(expected, actual);
        expected = 0;
        actual = stringList2.size();
        assertEquals(expected, actual);
    }

    @Test
    void isEmpty() {
        var expected = true;
        var actual = stringList2.isEmpty();
        assertEquals(expected, actual);
        expected = false;
        actual = stringList1.isEmpty();
        assertEquals(expected, actual);
        expected = true;
        StringList stringList3 = new StringListImpl(5);
        actual = stringList3.isEmpty();
        assertEquals(expected, actual);
    }

    @Test
    void clear() {
        stringList1.clear();
        var expected = true;
        var actual = stringList1.isEmpty();
        assertEquals(expected, actual);
        stringList2.clear();
        expected = true;
        actual = stringList2.isEmpty();
        assertEquals(expected, actual);
    }

    @Test
    void toArray() {
        String[] expected = {"text1", "text2", "text3", null, null};
        String[] actual = stringList1.toArray();
        assertIterableEquals(Arrays.asList(expected), Arrays.asList(actual));
    }
}