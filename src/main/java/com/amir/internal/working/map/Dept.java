package com.amir.internal.working.map;

import java.util.Objects;

public class Dept {
    private String name;

    public Dept(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Dept dept = (Dept) o;
        return Objects.equals(name, dept.name);
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
