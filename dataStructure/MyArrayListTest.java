package dataStructure;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MyArrayListTest {

    protected List<Integer> mylist;
    protected List<Integer> list;

    @Before
    public void setup() throws Exception {
        list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        mylist = new MyArrayList<Integer>();
        mylist.addAll(list);
    }

    @Test
    public void testMList() {
        Assert.assertEquals(mylist.size(), 3);
    }

    @Test
    public void testAddT() {
        for (int i = 4; i < 20; i++) {
            mylist.add(i);
        }

        Assert.assertEquals(mylist.get(18), Integer.valueOf(19));
    }

    @Test
    public void testSet() {
        Integer val = mylist.set(1, 5);
        Assert.assertEquals(val, Integer.valueOf(2));

        //val = mylist.set(0 , 6)
    }
}
