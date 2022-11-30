package util;

import data.StreamGroups;

import java.util.Comparator;

public class StreamGroupComparator implements Comparator<StreamGroups> {

    @Override
    public int compare(StreamGroups o1, StreamGroups o2) {
        if (o1.getSizeStreamGroup() > o2.getSizeStreamGroup()) {
            return 1;
        } else if (o1.getSizeStreamGroup() < o2.getSizeStreamGroup()) {
            return -1;
        } else {
            return 0;
        }
    }
}
