package by.shchemelev.duallab.utils;

import by.shchemelev.duallab.exceptions.NoSuchFileException;

import java.io.File;

public class Utils {
    public static void requireExistingFile(File file) {
        if (!file.exists()){
            try {
                throw new NoSuchFileException("File " + file.getName() + " doesn`t exists");
            } catch (NoSuchFileException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
    }

    public static int getHours(String time){
        return Integer.parseInt(time.split(":")[0]);
    }

    public static int getMinutes(String time){
        return Integer.parseInt(time.split(":")[1]);
    }

}
