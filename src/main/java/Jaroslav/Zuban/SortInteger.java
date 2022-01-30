package Jaroslav.Zuban;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SortInteger implements Sort {
    public List<Integer> array;

    @Override
    public List getList() {
        return array;
    }

    @Override
    public void setList(List list) {
        array = list;
    }

    @Override
    public void sortPlay() {
        sort(array);
    }

    public void sortWatch(List temp, int i) throws IOException {
        List<Integer> t = new ArrayList<>();
        List<Integer> t1 = new ArrayList<>();
        List<Integer> t2 = new ArrayList<>();

        for (int j = 0; j < temp.size(); j++) {
            try {
                t.add(Integer.parseInt(String.valueOf(temp.get(j))));
                t1.add(Integer.parseInt(String.valueOf(temp.get(j))));
                t2.add(Integer.parseInt(String.valueOf(temp.get(j))));
            } catch (Exception e) {
                System.out.println("Проверте " + FileHandling.nameFile.get(i) + " данный файл на корректность!");
                return;
            }

        }

        if (SortTrue.checkingElementsSorting(i, t, t1, t2, this)) return;
    }

    private boolean sortType(Integer number1, Integer number2) {
        int i = number1.compareTo(number2);

        if (FileHandling.kindSorting.equals("-a") && i > 0) {
            return true;
        } else if (FileHandling.kindSorting.equals("-d") && i < 0) {
            return true;
        }

        return false;
    }


    private void merge(List<Integer> arr, List<Integer> l, List<Integer> r) {
        int i = 0;
        int j = 0;
        int idx = 0;

        while (i < l.size() && j < r.size()) {
            if (sortType(r.get(j), l.get(i))) {
                arr.set(idx, l.get(i));
                i++;
            } else {
                arr.set(idx, r.get(j));
                j++;
            }

            idx++;
        }

        for (int il = i; il < l.size(); il++) {
            arr.set(idx++, l.get(il));
        }

        for (int ir = j; ir < r.size(); ir++) {
            arr.set(idx++, r.get(ir));
        }
    }

    private void sort(List<Integer> list) {
        int n = list.size();
        if (list.size() == 1) // выход из рекурсии - массив из 1 элемента отсортирован по определению
            return;

        int mid = list.size() / 2; //

        ArrayList<Integer> l = new ArrayList<>();

        for (int i = 0; i < mid; i++) {
            l.add(Integer.parseInt(String.valueOf(list.get(i))));
        }

        ArrayList<Integer> r = new ArrayList<>();

        for (int i = mid; i < n; i++) {
            r.add(Integer.parseInt(String.valueOf(list.get(i))));
        }

        sort(l);    // сортировка 1-й половины массива
        sort(r); // сортировка 2-й половины массива
        merge(list, l, r);
    }
}
