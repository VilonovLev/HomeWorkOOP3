package com.company;

import controller.ControllerImpl;

public class Main {


    public static void main(String[] args) {
        ControllerImpl controller = new ControllerImpl();
        controller.createStreamGroups("Разработчик");
        controller.createStudent("Сергей", "20.06.1984","016");
        controller.createStudent("Сергей", "20.06.1984","017");
        controller.createStudent("Сергей", "20.06.1984","018");
        controller.createStudent("Сергей", "20.06.1984","019");
        controller.createStudent("Сергей", "20.06.1984","020");
        controller.createTeacher("Сергей", "20.06.1984","Физика");
        controller.addGroupToStream(0);
        controller.createStudent("Иван", "20.06.1984","013");
        controller.createStudent("Иван", "20.06.1984","015");
        controller.createStudent("Иван", "20.06.1984","012");
        controller.createStudent("Иван", "20.06.1984","014");
        controller.createTeacher("Иван", "20.06.1984","Математика");
        controller.addGroupToStream(0);
        controller.createStreamGroups("Geek");
        controller.createStudent("Сергей", "20.06.1984","11");
        controller.createStudent("Сергей", "20.06.1984","10");
        controller.createTeacher("Сергей", "20.06.1984","Физика");
        controller.addGroupToStream(1);
        controller.sortStreamGroup();
        System.out.println(controller.getStreamGroups());
    }
}
