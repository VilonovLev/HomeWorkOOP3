package controller;

import data.StreamGroups;
import data.StudyGroup;
import service.StreamGroupService;
import service.StudentServiceImpl;
import service.StudyGroupServiceImpl;
import service.TeacherServiceImpl;

import java.util.ArrayList;

public class ControllerImpl implements Conroller {
    private TeacherServiceImpl teacherService = new TeacherServiceImpl();
    private StudentServiceImpl studentService = new StudentServiceImpl();
    private StudyGroupServiceImpl studyGroupService = new StudyGroupServiceImpl();

    @Override
    public void createTeacher(String name, String birthday, String info) {
        teacherService.create(name, birthday, info);
    }

    @Override
    public void createStudent(String name, String birthday, String info) {
        studentService.create(name, birthday, info);
    }

    @Override
    public void createStudyGroup() {
        studyGroupService.create();
    }

    @Override
    public void createStreamGroups(String nameStream) {
        StreamGroupService.create(nameStream);
    }

    @Override
    public StudyGroup getStudyGroup() {
        return studyGroupService.getNext();
    }

    @Override
    public void addStudyGroup(StudyGroup studyGroup) {
        studyGroupService.putStudyGroup(studyGroup);
    }

    @Override
    public void addGroupToStream(int indexStreamGroup) {
        StreamGroupService.addGroupToStream(indexStreamGroup);
    }

    @Override
    public void sortStudentById(StudyGroup studyGroup) {
        studyGroup.sortStudentsById();
        studyGroupService.putStudyGroup(studyGroup);
    }

    @Override
    public void sortStreamGroup() {
        StreamGroupService.sortStreamGroup();
    }

    public ArrayList<StreamGroups> getStreamGroups() {
        return StreamGroupService.getStreamGroupsArrayList();
    }


}
