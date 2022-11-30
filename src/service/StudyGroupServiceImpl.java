package service;

import data.Student;
import data.StudyGroup;
import data.Teacher;
import util.ReaderFromTxt;
import util.WriterToTxt;

import java.util.ArrayList;
import java.util.Stack;

public class StudyGroupServiceImpl implements StudyGroupService<StudyGroup> {
    private UserService<Student> studentService = new StudentServiceImpl();
    private UserService<Teacher> teacherService = new TeacherServiceImpl();
    private static Stack<StudyGroup> studyGroupsStack;
    private ArrayList<String> tempList;

    static {
        studyGroupsStack = new Stack<>();
    }

    @Override
    public void create() {
        StudyGroup currentStudyGroup = new StudyGroup();
        currentStudyGroup.changeTeacher(teacherService.getNext());
        for (var student : studentService.getAll()) {
            currentStudyGroup.addStudent(student);
        }
        studyGroupsStack.add(currentStudyGroup);
    }

    @Override
    public void write(StudyGroup studyGroup, String fileName) {
        tempList = new ArrayList<>();
        tempList.add(studyGroup.getClass().getSimpleName() + "{");
        WriterToTxt.write(tempList, fileName);
        teacherService.write(studyGroup.getGroupTeacher(), fileName);
        ArrayList<Student> listSt = new ArrayList<>(studyGroup.getStudentsList());
        for (int i = 0; i < studyGroup.getStudentsList().size(); i++) {
            studentService.write(listSt.get(i), fileName);
        }
        tempList = new ArrayList<>();
        tempList.add("}");
        WriterToTxt.write(tempList, fileName);
    }

    @Override
    public StudyGroup read(String fileName) {
        tempList = ReaderFromTxt.read(fileName);
        if (tempList == null) {
            System.out.println("Ощибка чтения!");
        } else {
            StudyGroup studyGroup = new StudyGroup();
            for (int i = 0; i < tempList.size(); i++) {
                if (tempList.get(i).equals(Teacher.class.getSimpleName())) {
                    Teacher teacher = new Teacher(tempList.get(++i), tempList.get(++i), tempList.get(++i));
                    studyGroup.changeTeacher(teacher);
                } else if (tempList.get(i).equals(Student.class.getSimpleName())) {
                    studyGroup.addStudent(new Student(tempList.get(++i), tempList.get(++i), tempList.get(++i)));
                }
            }
            return studyGroup;
        }
        return null;
    }

    @Override
    public void sortStudentsById(StudyGroup studyGroup) {
        studyGroup.sortStudentsById();
    }

    @Override
    public StudyGroup getNext() {
        if (studyGroupsStack.size() > 0) {
            return studyGroupsStack.pop();
        }
        return null;
    }

    @Override
    public void putStudyGroup(StudyGroup studyGroup) {
        studyGroupsStack.push(studyGroup);
    }


}
