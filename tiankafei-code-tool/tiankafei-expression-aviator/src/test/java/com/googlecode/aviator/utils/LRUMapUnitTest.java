package com.googlecode.aviator.utils;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;


public class LRUMapUnitTest {

    private LruMap<Integer, Integer> map;


    @Before
    public void setUp() {
        this.map = new LruMap<Integer, Integer>(10);
    }


    @Test
    public void testPutGet() {
        assertTrue(map.isEmpty());
        assertEquals(0, map.size());
        for (int i = 0; i < 5; i++) {
            assertNull(this.map.get(i));
            this.map.put(i, i);
//            assertEquals(i, this.map.get(i));
        }
        assertEquals(5, map.size());
    }


    @Test
    public void testLRU() {
        for (int i = 0; i < 20; i++) {
            assertNull(this.map.get(i));
            this.map.put(i, i);
//            assertEquals(i, this.map.get(i));
        }
        assertEquals(10, map.size());
        for (int i = 0; i < 10; i++)
            assertNull(this.map.get(0));
        for (int i = 10; i < 11; i++)
//            assertEquals(i, this.map.get(i));
            assertEquals(10, map.size());

    }

}
