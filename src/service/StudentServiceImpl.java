package service;

import data.Student;
import util.*;

import java.util.ArrayList;
import java.util.Stack;


public class StudentServiceImpl implements UserService<Student> {
    private static Stack<Student> studentStack;
    private ArrayList<String> tempList;

    static {
        studentStack = new Stack<>();
    }

    @Override
    public void create(String name, String birthday, String info) {
        Student currentStudent = new Student(name, birthday, info);
        studentStack.add(currentStudent);
    }

    @Override
    public Student read(String fileName) {
        tempList = ReaderFromTxt.read(fileName);
        if (tempList == null) {
            System.out.println("Ощибка чтения!");
        } else {
            for (int i = 0; i < tempList.size(); i++) {
                if (tempList.get(i).equals(Student.class.getSimpleName())) {
                    return new Student(tempList.get(++i), tempList.get(++i), tempList.get(++i));
                }
            }
        }

        return null;
    }

    @Override
    public void addAll(ArrayList<Student> students) {
        studentStack.addAll(students);
    }

    @Override
    public void write(Student student, String fileName) {
        tempList = new ArrayList<>();
        tempList.add(student.getClass().getSimpleName());
        tempList.add(student.getName());
        tempList.add(student.getBirthday());
        tempList.add(student.getStudentId());
        WriterToTxt.write(tempList, fileName);
    }

    @Override
    public Student getNext() {
        if (!studentStack.isEmpty()) {
            return studentStack.pop();
        }
        return null;
    }

    @Override
    public ArrayList<Student> getAll() {
        var result = new ArrayList<>(studentStack);
        studentStack.clear();
        return result;
    }

    @Override
    public void sort() {
        studentStack.sort((o1, o2) -> o1.compareTo(o2));
    }
}
