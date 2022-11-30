package service;

import data.StreamGroups;
import util.StreamGroupComparator;

import java.util.ArrayList;
import java.util.Comparator;

public class StreamGroupService {
    private static ArrayList<StreamGroups> streamGroupsArrayList;

    static {
        streamGroupsArrayList = new ArrayList<>();
    }

    public static void create(String nameStream) {
        StreamGroups streamGroups = new StreamGroups(nameStream);
        streamGroupsArrayList.add(streamGroups);
    }

    public static ArrayList<StreamGroups> getStreamGroupsArrayList() {
        return streamGroupsArrayList;
    }

    public static void setStreamGroupsArrayList(ArrayList<StreamGroups> streamGroupsArrayList) {
        StreamGroupService.streamGroupsArrayList = streamGroupsArrayList;
    }

    public static void addGroupToStream(int indexStreamGroup) {
        StudyGroupServiceImpl studyGroupService = new StudyGroupServiceImpl();
        studyGroupService.create();
        StreamGroups streamGroups = streamGroupsArrayList.remove(indexStreamGroup);
        streamGroups.addStudyGroup(studyGroupService.getNext());
        streamGroupsArrayList.add(indexStreamGroup, streamGroups);
    }

    public static void sortStreamGroup() {
        streamGroupsArrayList.sort(((o1, o2) -> (new StreamGroupComparator()).compare(o1,o2)));
    }
}
