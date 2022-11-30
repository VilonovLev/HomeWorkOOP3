package controller;

import data.StudyGroup;
import data.User;

import java.util.ArrayList;

public interface Conroller {
    void createTeacher(String name, String birthday, String info);

    void createStudent(String name, String birthday, String info);

    void createStudyGroup();

    void createStreamGroups(String nameStream);

    StudyGroup getStudyGroup();

    void addStudyGroup(StudyGroup studyGroup);

    void addGroupToStream(int indexStreamGroup);

    void sortStudentById(StudyGroup studyGroup);

    void sortStreamGroup();
}
