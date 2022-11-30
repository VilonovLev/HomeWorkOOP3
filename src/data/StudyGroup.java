package data;

import java.util.ArrayList;
import java.util.Iterator;

public class StudyGroup implements Iterator<User>, Iterable<User> {
    private Teacher groupTeacher;
    private ArrayList<Student> studentsList;

    public StudyGroup(Teacher groupTeacher, ArrayList<Student> studentsList) {
        this.groupTeacher = groupTeacher;
        this.studentsList = studentsList;
    }

    public StudyGroup(Teacher groupTeacher) {
        this(groupTeacher, new ArrayList<>());
    }

    public StudyGroup() {
        this(new Teacher("", "", ""));
    }


    public void changeTeacher(Teacher teacher) {
        this.groupTeacher = teacher;
    }

    public void addStudent(Student student) {
        if (!studentsList.contains(student)) {
            studentsList.add(student);
        }
    }

    public void removeStudent(Student student) {
        if (studentsList.contains(student)) {
            studentsList.remove(student);
        }
    }

    public Teacher getGroupTeacher() {
        return groupTeacher;
    }

    public ArrayList<Student> getStudentsList() {
        return studentsList;
    }

    public void sortStudentsById() {
        studentsList.sort((o1, o2) -> o1.compareTo(o2));
    }

    @Override
    public String toString() {
        return "\nStudyGroup" + "{" + groupTeacher +
                ", \nStudents=" + studentsList +
                '}';
    }

    int indexIterator = 0;

    @Override
    public boolean hasNext() {
        return indexIterator < 1 + studentsList.size();
    }

    @Override
    public User next() {
        if (indexIterator < 1 + studentsList.size()) {
            if (indexIterator == 0)
                return this.getGroupTeacher();
            else
                return this.studentsList.get(indexIterator - 2);

        }
        return null;
    }

    @Override
    public Iterator<User> iterator() {
        ArrayList<User> userArrayList = new ArrayList<>();
        userArrayList.add(this.groupTeacher);
        userArrayList.addAll(studentsList);
        return userArrayList.iterator();
    }


}
