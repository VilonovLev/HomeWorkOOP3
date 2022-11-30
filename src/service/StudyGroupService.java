package service;

import data.StudyGroup;

public interface StudyGroupService<T> {
    void create();

    void write(T object, String fileName);

    T read(String fileName);

    void sortStudentsById(StudyGroup studyGroup);

    T getNext();

    void putStudyGroup(StudyGroup studyGroup);
}
