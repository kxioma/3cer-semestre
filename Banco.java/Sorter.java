//sorter.java
//clase utiliaria que contiene los  algoritmos de ordenamiento solicitados
// marge sort -> ordenamiento por balance
//quick sort -> ordenamiento por nombre

import java.util.*;

public class Sorter {

    public static List<Account> mergeSortByBalance(List<Account> list) {
        if (list.size() <= 1)
            return new ArrayList<>(list);

        int mid = list.size() / 2;

        // Dividir lista en dos mitades

        List<Account> left = mergeSortByBalance(list.subList(0, mid));
        List<Account> rigth = mergeSortByBalance(list.subList(mid, list.size()));

        // Combinar listas ordenadas
        return merge(left, rigth);

    }

    // mezcla ordenada de dos listas
    private static List<Account> merge(List<Account> a, List<Account> b) {
        List<Account> result = new ArrayList<>();
        int i = 0, j = 0;

        // Comparar y agregar en orden descendente por balance

        while (i < a.size() && j < b.size()) {
            if (a.get(i).getBalance() >= b.get(j).getBalance()) {
                result.add(a.get(i++));
            } else {
                result.add(b.get(j++));
            }
        }

        // Agregar restantes
        while (i < a.size())
            result.add(a.get(i++));
        while (j < b.size())
            result.add(b.get(j++));

        return result;

    }

    // QUICK SORT POR NOMBRE (orden ascendente A → Z)
    // ==========================================================

    public static List<Account> quickSortByName(List<Account> list) {

        List<Account> copy = new ArrayList<>(list);
        quickSort(copy, 0, copy.size() - 1);
        return copy;

    }

    private static void quickSort(List<Account> arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(List<Account> arr, int low, int high) {
        String pivot = arr.get(high).getHolderName().toLowerCase();
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr.get(j).getHolderName().toLowerCase().compareTo(pivot) <= 0) {
                i++;
                Collections.swap(arr, i, j);
            }
        }

        Collections.swap(arr, i + 1, high);
        return i + i;
    }

}
