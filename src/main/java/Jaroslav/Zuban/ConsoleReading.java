package Jaroslav.Zuban;

import com.beust.jcommander.Parameter;

import java.io.IOException;
import java.util.ArrayList;

public class ConsoleReading {
    private FileHandling sortMerger;
    private int count = 0;

    @Parameter(required = true, variableArity = true)
    private ArrayList<String> file = new ArrayList<>();


    public void readingParameters() {

        if (file.contains("-i") || file.contains("-s")) {

            if (file.contains("-i")) {
                sortMerger = new FileHandling();
                FileHandling.type="-i";
                file.remove("-i");
            } else if (file.contains("-s")) {
                sortMerger = new FileHandling();
                FileHandling.type="-s";
                file.remove("-s");
            }

            if (file.contains("-d")) {
                FileHandling.kindSorting = "-d";
                file.remove("-d");
            } else {
                FileHandling.kindSorting = "-a";
                file.remove("-a");
            }

            if (sortMerger != null) {
                try {
                    sortMerger.nameFile(file);
                    sortMerger.playSort();
                } catch (IOException e) {
                    e.printStackTrace();

                    System.out.println("Что-то пошло не так!");
                }
            }
        }else {
            System.out.println("Вы не указали тип данных которые находятся в файле.");
        }
    }
}
