package com.abn.dsalgos.ds.queue;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;

public class PriorityQLinkListTest {

    private PriorityQLinkList<Employee> employeeLinkList;

    @BeforeMethod
    public void setup() throws Exception {
        employeeLinkList = new PriorityQLinkList<>();
    }

    @Test
    public void priorityQSizeTest() {
        employeeLinkList.insert(new Employee(10,"A"));
        employeeLinkList.insert(new Employee(5,"B"));
        employeeLinkList.insert(new Employee(15,"C"));
        employeeLinkList.insert(new Employee(12,"D"));
        Assert.assertEquals(4,employeeLinkList.size());
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void priorityQEmptyTest() {
        employeeLinkList.peek();
    }

    @Test
    public void priorityQDeleteTest() {
        employeeLinkList.insert(new Employee(10,"A"));
        employeeLinkList.insert(new Employee(1,"B"));
        employeeLinkList.insert(new Employee(5,"C"));
        Assert.assertEquals(1,employeeLinkList.delete().getId());
    }

    @Test
    public void priorityQpeekTest() {
        employeeLinkList.insert(new Employee(10,"A"));
        employeeLinkList.insert(new Employee(1,"B"));
        employeeLinkList.insert(new Employee(5,"C"));
        Assert.assertEquals(1,employeeLinkList.peek().getId());
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void priorityQEmptyDeleteTest() {
        employeeLinkList.delete();
    }
}

class Employee implements Comparable<Employee>{

    int id;
    String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(Employee o) {
        return o.getId()-this.getId();
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.valueOf(this.id);
    }
}





