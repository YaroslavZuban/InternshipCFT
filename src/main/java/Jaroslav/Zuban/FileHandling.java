package Jaroslav.Zuban;

import com.beust.jcommander.internal.Lists;

import java.io.*;
import java.util.*;


public class FileHandling {
    private Sort sort;

    public static String type;
    public static String kindSorting = "-a";

    private List mass;
    private ArrayList<String> nameFile = new ArrayList<>();
    private ArrayList<String> temp = new ArrayList<>();

    public void playSort() throws IOException {
        files();
    }

    public void nameFile(ArrayList<String> name) {
        this.nameFile = name;
    }

    private void files() throws IOException {

        if (typeDefinitions() == 1 || typeDefinitions() == 2) {

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

                        if ("".equals(temp.get(temp.size() - 1)) || temp.contains(" ")||temp.get(temp.size() - 1).contains(" ")) {
                            System.out.println("Есть пустное пространство в " + nameFile.get(i));
                            return;
                        }
                    }


                    if (typeDefinitions() == 1) {
                        List<Integer> t = new ArrayList<>();
                        List<Integer> t1 = new ArrayList<>();
                        List<Integer> t2 = new ArrayList<>();

                        for (int j = 0; j < temp.size(); j++) {
                            try {
                                t.add(Integer.parseInt(String.valueOf(temp.get(j))));
                                t1.add(Integer.parseInt(String.valueOf(temp.get(j))));
                                t2.add(Integer.parseInt(String.valueOf(temp.get(j))));
                            } catch (Exception e) {
                                System.out.println("Проверте " + nameFile.get(i) + " данный файл на корректность!");
                                return;
                            }

                        }

                        Collections.reverse(t2);
                        sort.setList(t);
                        sort.sortPlay();

                        if (!t1.equals(sort.getList()) && !t2.equals(sort.getList())) {
                            System.out.println("Проверти пожалуйста, что файл " + nameFile.get(i) + " отсортировал правильно!");
                            reader();
                            return;
                        }

                        mass.addAll(temp);
                        sort.setList(mass);
                    } else {
                        List<String> t = new ArrayList<>();
                        List<String> t1 = new ArrayList<>();
                        List<String> t2 = new ArrayList<>();

                        for (int j = 0; j < temp.size(); j++) {
                            t.add(temp.get(j));
                            t1.add(temp.get(j));
                            t2.add(temp.get(j));
                        }

                        Collections.reverse(t2);
                        sort.setList(t);
                        sort.sortPlay();

                        if (!t1.equals(sort.getList()) && !t2.equals(sort.getList())) {
                            System.out.println("Проверти пожалуйста, что файл " + nameFile.get(i) + " отсортировал правильно!");
                            reader();
                            return;
                        }

                        mass.addAll(temp);
                        sort.setList(mass);
                    }

                    sort.sortPlay();
                    reader();

                    temp.clear();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Не коректные данные!");
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

    private void reader() throws IOException {
        FileWriter nFile = new FileWriter("C:\\Users\\babka\\IdeaProjects" + "\\InternshipCFT\\src\\main\\java\\Jaroslav\\Zuban\\" + nameFile.get(0), false);

        for (int i = 0; i < mass.size(); i++) {
            nFile.write(mass.get(i) + "\n");
        }

        nFile.flush();
        nFile.close();
    }


}

