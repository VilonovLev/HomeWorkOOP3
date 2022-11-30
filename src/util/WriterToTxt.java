package util;

import java.io.FileWriter;
import java.util.ArrayList;

public class WriterToTxt {
    public static void write(ArrayList<String> list, String fileName) {
        try (FileWriter fileWriter = new FileWriter(fileName, true)) {
            for (int i = 0; i < list.size(); i++) {
                fileWriter.write(list.get(i) + "\n");
            }
        } catch (Exception e) {
            System.out.println("Файл не найден!");
        }
    }
}
