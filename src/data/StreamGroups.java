package data;

import java.util.ArrayList;
import java.util.Iterator;

public class StreamGroups implements Iterable<StudyGroup> {
    private String nameStream;
    private ArrayList<StudyGroup> studyGroups = new ArrayList<>();


    public StreamGroups(String nameStream) {
        this.nameStream = nameStream;
    }

    public ArrayList<StudyGroup> getAllStudyGroups() {
        return studyGroups;
    }

    public void setStudyGroups(ArrayList<StudyGroup> studyGroups) {
        this.studyGroups = studyGroups;
    }

    public void addStudyGroup(StudyGroup studyGroup) {
        studyGroups.add(studyGroup);
    }

    public int getSizeStreamGroup() {
        return studyGroups.size();
    }

    @Override
    public Iterator<StudyGroup> iterator() {
        return studyGroups.iterator();
    }

    @Override
    public String toString() {
        return "\n" + "StreamGroups{" +
                "nameStream='" + nameStream + '\'' +
                ", studyGroups=" + studyGroups +
                '}';
    }
}
