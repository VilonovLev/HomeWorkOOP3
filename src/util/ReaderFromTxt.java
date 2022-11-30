package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ReaderFromTxt {
    public static ArrayList<String> read(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder sb = new StringBuilder();
            ArrayList<String> arrayList = new ArrayList<>();
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                if (!line.equals(" ")) {
                    arrayList.add(line);
                }
            }
            return arrayList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
