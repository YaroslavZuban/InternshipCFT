package Jaroslav.Zuban;

import com.beust.jcommander.Parameter;

import java.io.IOException;
import java.util.ArrayList;

public class ConsoleReading {
    @Parameter(required = true, variableArity = true)
    private ArrayList<String> file = new ArrayList<>();


    public void readingParameters() {
        FileHandling sortMerger;

        if (file.contains("-i") || file.contains("-s")) {

            if (file.contains("-i")) {
                sortMerger = new FileHandling();
                FileHandling.type = "-i";
                file.remove("-i");
            } else if (file.contains("-s")) {
                sortMerger = new FileHandling();
                FileHandling.type = "-s";
                file.remove("-s");
            } else {
                System.out.println("Не ввели тип значений в файле!");
                return;
            }

            if (file.contains("-d")) {
                FileHandling.kindSorting = "-d";
                file.remove("-d");
            } else {
                FileHandling.kindSorting = "-a";
                file.remove("-a");
            }

            try {
                if (file.size() <= 1) {
                    System.out.println("Ввели малое количество файлов!");
                } else {
                    sortMerger.nameFile(file);
                    sortMerger.playSort();
                }
            } catch (IOException e) {
                e.printStackTrace();

                System.out.println("Что-то пошло не так!");
            }

        } else {
            System.out.println("Вы не указали тип данных которые находятся в файле.");
        }
    }
}
