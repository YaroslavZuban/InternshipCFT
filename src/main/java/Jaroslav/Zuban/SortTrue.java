package Jaroslav.Zuban;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static Jaroslav.Zuban.FileHandling.reader;

public class SortTrue<T> {
    public static boolean checkingElementsSorting(int i, List t, List t1, List t2, Sort sort) throws IOException {
        Collections.reverse(t2);
        sort.setList(t);
        sort.sortPlay();

        if (!t1.equals(sort.getList()) && !t2.equals(sort.getList())) {
            System.out.println("Проверти пожалуйста, что файл " + FileHandling.nameFile.get(i) + " отсортировал правильно!");
            reader();
            return true;
        }

        return false;
    }
}
