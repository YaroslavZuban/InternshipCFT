package Jaroslav.Zuban;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SortString implements Sort {
    private SortSelection<String> sortSelection = new SortSelection<>();
    public List<String> array;

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
        List<String> t = new ArrayList<>();
        List<String> t1 = new ArrayList<>();
        List<String> t2 = new ArrayList<>();

        for (int j = 0; j < temp.size(); j++) {
            t.add((String) temp.get(j));
            t1.add((String) temp.get(j));
            t2.add((String) temp.get(j));
        }

        if (SortTrue.checkingElementsSorting(i, t, t1, t2, this)) return;
    }

    private void merge(List<String> arr, List<String> l, List<String> r) {
        int left = l.size();
        int right = r.size();

        int i = 0;
        int j = 0;
        int idx = 0;

        while (i < left && j < right) {
            if (sortSelection.sortType(r.get(j), l.get(i))) {
                arr.set(idx, l.get(i));
                i++;
            } else {
                arr.set(idx, r.get(j));
                j++;
            }

            idx++;
        }

        for (int il = i; il < left; il++) {
            arr.set(idx++, l.get(il));
        }

        for (int ir = j; ir < right; ir++) {
            arr.set(idx++, r.get(ir));
        }
    }

    private void sort(List<String> list) {
        int n = list.size();
        if (list.size() == 1) // выход из рекурсии - массив из 1 элемента отсортирован по определению
            return;

        int mid = list.size() / 2; //

        ArrayList<String> l = new ArrayList<>();

        for (int i = 0; i < mid; i++) {
            l.add(list.get(i));
        }

        ArrayList<String> r = new ArrayList<>();

        for (int i = mid; i < n; i++) {
            r.add(list.get(i));
        }

        sort(l);    // сортировка 1-й половины массива
        sort(r); // сортировка 2-й половины массива
        merge(list, l, r);
    }
}
