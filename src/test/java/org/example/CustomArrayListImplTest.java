package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

// названия методов не соответствуют конвенциям и неинформативны
// старайся придерживаться given when then
public class CustomArrayListImplTest {

    CustomArrayList<String> myArrayList;

    @Before
    public void init() {

        myArrayList = new CustomArrayListImpl<>();
        for (int i = 1; i < 12; i++) {
            myArrayList.add(String.valueOf(i));
        }
    }

    @Test
    public void size() {

        assertEquals(11, myArrayList.size());
    }

    @Test
    public void add() {

        int prevSize = myArrayList.size();
        myArrayList.add("100");
        assertEquals("100", myArrayList.get(11));
        assertEquals(++prevSize, myArrayList.size());
    }

    @Test
    public void addByIndex() {

        int prevSize = myArrayList.size();
        myArrayList.add(0, "100");
        assertEquals("100", myArrayList.get(0));
        assertEquals("1", myArrayList.get(1));
        assertEquals(++prevSize, myArrayList.size());
    }

    @Test
    public void set() {

        myArrayList.set(10, "100");
        assertEquals("100", myArrayList.get(10));
    }

    @Test
    public void get() {

        assertEquals("10", myArrayList.get(9));
    }

    @Test
    public void removeElement() {

        int prevSize = myArrayList.size();
        myArrayList.remove("10");
        assertEquals(-1, myArrayList.indexOf("10"));
        assertEquals(--prevSize, myArrayList.size());
    }

    @Test
    public void testRemoveByIndex() {

        int prevSize = myArrayList.size();
        myArrayList.remove(0);
        assertEquals("2", myArrayList.get(0));
        assertEquals(--prevSize, myArrayList.size());
    }

    @Test
    public void indexOfElementExist() {

        assertEquals(9, myArrayList.indexOf("10"));
    }

    @Test
    public void indexOfElemenNottExist() {

        assertEquals(-1, myArrayList.indexOf("100"));
    }

    @Test
    public void clear() {

        myArrayList.clear();
        assertEquals(0, myArrayList.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void OutOfBoundExceptionTooLargeIndex() {
        myArrayList.set(100, "100");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void OutOfBoundExceptionNegativeIndex() {
        myArrayList.set(-1, "100");
    }
}
