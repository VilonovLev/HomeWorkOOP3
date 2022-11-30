package data;

import java.util.Iterator;
import java.util.Objects;

public class Teacher extends User implements Iterator<String>, Comparable<Teacher> {
    private String disciplesTaught;

    public Teacher(String name, String birthday, String disciplesTaught) {
        super.setName(name);
        super.setBirthday(birthday);
        this.disciplesTaught = disciplesTaught;
    }


    public String getDisciplesTaught() {
        return disciplesTaught;
    }

    public void setDisciplesTaught(String disciplesTaught) {
        this.disciplesTaught = disciplesTaught;
    }

    @Override
    public String toString() {
        return "\n" + "Teacher{" +
                "Name=" + super.getName() + " " +
                "Birthday=" + super.getBirthday() + " " +
                "disciplesTaught='" + disciplesTaught + '\'' +
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
                return this.getDisciplesTaught();
        }
        return null;
    }

    @Override
    public int compareTo(Teacher o) {
        int first = Integer.parseInt(this.disciplesTaught);
        int second = Integer.parseInt(o.disciplesTaught);
        return Objects.compare(first, second, ((o1, o2) -> o1 - o2));
    }
}
