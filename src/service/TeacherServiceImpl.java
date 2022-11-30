package service;

import data.Student;
import data.Teacher;
import util.ReaderFromTxt;
import util.WriterToTxt;

import java.util.ArrayList;
import java.util.Stack;

public class TeacherServiceImpl implements UserService<Teacher> {
    private static Stack<Teacher> teacherStack;
    private ArrayList<String> tempList;

    static {
        teacherStack = new Stack<>();
    }

    @Override
    public void write(Teacher teacher, String fileName) {
        tempList = new ArrayList<>();
        tempList.add(teacher.getClass().getSimpleName());
        tempList.add(teacher.getName());
        tempList.add(teacher.getBirthday());
        tempList.add(teacher.getDisciplesTaught());
        WriterToTxt.write(tempList, fileName);
    }

    @Override
    public void create(String name, String birthday, String info) {
        Teacher currentTeacher = new Teacher(name, birthday, info);
        teacherStack.push(currentTeacher);
    }

    @Override
    public Teacher read(String fileName) {
        tempList = ReaderFromTxt.read(fileName);
        if (tempList == null) {
            System.out.println("Ощибка чтения!");
        } else {
            for (int i = 0; i < tempList.size(); i++) {
                if (tempList.get(i).equals(Teacher.class.getSimpleName())) {
                    return new Teacher(tempList.get(++i), tempList.get(++i), tempList.get(++i));
                }
            }
        }

        return null;
    }

    @Override
    public void addAll(ArrayList<Teacher> teachers) {
        teacherStack.addAll(teachers);
    }

    @Override
    public Teacher getNext() {
        if (!teacherStack.isEmpty()) {
            return teacherStack.pop();
        }
        return null;
    }

    @Override
    public ArrayList<Teacher> getAll() {
        return new ArrayList<>(teacherStack);
    }

    @Override
    public void sort() {
        teacherStack.sort((o1, o2) -> o1.compareTo(o2));
    }
}
