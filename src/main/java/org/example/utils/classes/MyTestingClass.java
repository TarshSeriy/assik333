package org.example.utils.classes;

import java.util.Objects;

public class MyTestingClass {
    private int id;
    private String key;

    public MyTestingClass(int id, String key) {
        this.id = id;
        this.key = key;
    }

    public int getId() {
        return id;
    }

    public String getKey() {
        return key;
    }

    @Override
    public int hashCode() {
        int hash = Objects.hash(id, key);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        MyTestingClass other = (MyTestingClass) obj;
        return id == other.id && key.equals(other.key);
    }

    @Override
    public String toString() {
        return "MyTestingClass{" +
                "id=" + id +
                ", key='" + key + '\'' +
                '}';
    }
}


