package service;

import data.Student;
import data.User;

import java.util.ArrayList;

public interface UserService<T extends User> {
    void create(String name, String birthday, String info);

    void write(T user, String fileName);

    T read(String fileName);

    void addAll(ArrayList<T> arrayList);

    T getNext();

    ArrayList<T> getAll();

    void sort();
}
