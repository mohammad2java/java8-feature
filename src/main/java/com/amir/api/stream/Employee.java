package com.amir.api.stream;

public class Employee {
    private int id;
    private int sal;
    private String dept;
    private String city;

    public Employee(int id, int sal, String dept, String city) {
        this.id = id;
        this.sal = sal;
        this.dept = dept;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", sal=" + sal +
                ", dept='" + dept + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
