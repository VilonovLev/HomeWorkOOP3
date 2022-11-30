package data;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.Consumer;

public class Student extends User implements Iterator<String>, Comparable<Student> {
    private String studentId;

    public Student(String name, String birthday, String studentId) {
        super.setName(name);
        super.setBirthday(birthday);
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "\n" + "Student{" +
                "Name=" + super.getName() + " " +
                "Birthday=" + super.getBirthday() + " " +
                "studentId='" + studentId + '\'' +
                '}';
    }

    int indexIterator;

    @Override
    public boolean hasNext() {
        return indexIterator++ < 3;
    }

    @Override
    public String next() {
        switch (indexIterator) {
            case 1:
                return super.getName();
            case 2:
                return super.getBirthday();
            case 3:
                return this.getStudentId();
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(super.getBirthday(), ((Student) o).getBirthday()) &&
                Objects.equals(super.getName(), ((Student) o).getName()) &&
                Objects.equals(studentId, student.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, indexIterator);
    }


    @Override
    public int compareTo(Student o) {
        int first = Integer.parseInt(this.studentId);
        int second = Integer.parseInt(o.studentId);
        return Objects.compare(first, second, ((o1, o2) -> o1 - o2));
    }
}
