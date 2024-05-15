package org.example;

import org.example.utils.classes.MyBST;
import org.example.utils.classes.Student;
import org.example.utils.classes.Utilities;
import org.example.utils.classes.MyTestingClass;

public class Main {
    public static void main(String[] args) {
        MyBST<Integer, Student> bst = new MyBST<>();

        Utilities.readNames();

        for (int i = 1; i <= 10; i++) {
            Student student = Utilities.studentGenerator(i);
            bst.put(student.getId(), student);
        }

        System.out.println("In-order traversal:");
        bst.inOrder();

        System.out.println("Size of BST: " + bst.getSize());

        System.out.println("Deleting student with ID 5");
        bst.delete(5);

        System.out.println("In-order traversal after deletion:");
        bst.inOrder();

        System.out.println("Size of BST after deletion: " + bst.getSize());

        System.out.println("Printing all students:");
        for (var key : bst) {
            Student student = bst.get(key);
            System.out.println("Student ID: " + student.getId() +
                    ", Name: " + student.getName() +
                    ", GPA: " + student.getGpa() +
                    ", Gender: " + student.getGender());
        }

        MyTestingClass testingClass = Utilities.testingClassGenerator(1);
        System.out.println("Testing Class Key: " + testingClass.getKey());
    }
}
