package Jaroslav.Zuban;

import com.beust.jcommander.internal.Lists;

import java.io.*;
import java.util.*;


public class FileHandling {
    private Sort sort;

    public static String type;
    public static String kindSorting = "-a";

    private static List mass;
    public static ArrayList<String> nameFile = new ArrayList<>();
    private ArrayList<String> temp = new ArrayList<>();

    public void playSort() throws IOException {
        files();
    }

    public void nameFile(ArrayList<String> name) {
        this.nameFile = name;
    }

    private void files() throws IOException {

        if (typeDefinitions() == 0) {
            System.out.println("Не коректные данные!");
        } else {
            if (typeDefinitions() == 1) {
                sort = new SortInteger();
                mass = new ArrayList<Integer>();
            } else {
                sort = new SortString();
                mass = new ArrayList<String>();
            }

            for (int i = 1; i < nameFile.size(); i++) {

                try (Scanner scanner = new Scanner(new File("C:\\Users\\babka\\IdeaProjects" + "\\InternshipCFT\\src\\main\\java\\Jaroslav\\Zuban\\" + nameFile.get(i)))) {
                    while (scanner.hasNext()) {
                        temp.add(scanner.nextLine());

                        if ("".equals(temp.get(temp.size() - 1)) || temp.contains(" ") || temp.get(temp.size() - 1).contains(" ")) {
                            System.out.println("Есть пустное пространство в " + nameFile.get(i));
                            return;
                        }
                    }

                    sort.sortWatch(temp, i);

                    mass.addAll(temp);

                    sort.setList(mass);
                    sort.sortPlay();

                    reader();

                    temp.clear();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    private int typeDefinitions() {
        if ("-i".equals(type)) {
            return 1;
        } else if ("-s".equals(type)) {
            return 2;
        }

        return 0;
    }

    public static void reader() throws IOException {
        FileWriter nFile = new FileWriter("C:\\Users\\babka\\IdeaProjects" + "\\InternshipCFT\\src\\main\\java\\Jaroslav\\Zuban\\" + nameFile.get(0), false);

        for (int i = 0; i < mass.size(); i++) {
            nFile.write(mass.get(i) + "\n");
        }

        nFile.flush();
        nFile.close();
    }
}

