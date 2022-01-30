package Jaroslav.Zuban;

public class SortSelection<T> {
    public boolean sortType(T number1, T number2) {
        int i = number1.toString().compareTo(number2.toString());

        if (FileHandling.kindSorting.equals("-a") && i > 0) {
            return true;
        } else if (FileHandling.kindSorting.equals("-d") && i < 0) {
            return true;
        }

        return false;
    }
}
