package com.amir.api.stream;


import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamApiGroupBy {

    private String name;

    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();

        for (int s = 1; s < 10; s++) {
            int id = 10 + s;
            int sal = 1000+10000*s;
            String dept = "dept";
            String city = "city";
            if (s%2==0) {
                 dept = dept+s;
            }
            else  {
                city = city+s;
            }
            Employee employee = new Employee(id, sal, dept, city);
            employees.add(employee);

        }

        Map<String, Map<String, Integer>> group = employees.stream().
                collect(Collectors.groupingBy(Employee::getDept, Collectors.groupingBy(Employee::getCity, Collectors.summingInt(Employee::getSal))));

        System.out.println(group);

        //System.out.println(employees);

    }
}
