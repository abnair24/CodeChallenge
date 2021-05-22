package com.abn.dsalgos.ds.sort;

import com.abn.dsalgos.sortAlgos.MergeSort;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MergeSortTest {

    private Integer[] x;
    private Emp[] emp;

    @BeforeMethod
    public void setup() throws Exception {
        x = new Integer[]{20,10,5,19,27};

        emp = new Emp[]{ new Emp(10,"A"),
                new Emp(5,"B"),
                new Emp(6,"C"),
                new Emp(8,"D"),
                new Emp(4,"E"),
                new Emp(18,"F"),
                new Emp(1,"G")
        };
    }

    @Test
    public void integerSort() {
        MergeSort<Integer> ms = new MergeSort<>();
        ms.sort(Integer.class,x);
        for(Integer i: x) {
            System.out.print(i+ " ");
        }
    }

    @Test
    public void objectSort() {
        MergeSort<Emp> mergeSort = new MergeSort<>();
        mergeSort.sort(Emp.class,emp);
        for( Emp e: emp) {
            System.out.print(e.getId()+":"+e.getName()+" ");
        }

    }
}


class Emp implements Comparable<Emp>{

    int id;
    String name;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(Emp o) {
        return this.getId()-o.getId();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.valueOf(this.id);
    }

}
