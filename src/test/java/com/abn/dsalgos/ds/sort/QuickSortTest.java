package com.abn.dsalgos.ds.sort;

import com.abn.dsalgos.sortAlgos.QuickSort;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class QuickSortTest {

    private Integer[] x;
    private Person[] persons;

    @BeforeMethod
    public void setup() throws Exception {

        x = new Integer[]{20,10,5,19,27,30,45,17,6,3,0,35,55,8,55};

        persons = new Person[]{ new Person(10,"A"),
                           new Person(5,"B"),
                           new Person(6,"C"),
                           new Person(8,"D"),
                           new Person(4,"E"),
                           new Person(18,"F"),
                           new Person(1,"G")
        };
    }

    @Test
    public void integerSort() throws Exception {
        QuickSort<Integer> qs = new QuickSort<>();
        qs.sort(x);
        System.out.println("");
        for(Integer i: x) {
            System.out.print(i+ " ");
        }
    }

    @Test
    public void objectSort() {
        QuickSort<Person> quickSort = new QuickSort<>();
        quickSort.sort(persons);
        System.out.println("");
        for( Person person: persons) {
            System.out.print(person.getId()+":"+person.getName()+" ");
        }

    }
}


class Person implements Comparable<Person>{

    int id;
    String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(Person o) {
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

