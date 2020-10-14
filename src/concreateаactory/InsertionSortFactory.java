package concreateаactory;

import insertionsort.FactoryInsertionSort;
import insertionsort.InsertionSortAbstractProduct;

/**
 * Created by akaporov on 13.10.2020.
 * Конкретная фабрика для Сортировки Вставкой
 */
public class InsertionSortFactory implements SortAbstractFactory {
    @Override
    public void sort(int[] array) {
        // Создаем фабрику для сортировки Вставкой
        FactoryInsertionSort factoryInsertionSort = new FactoryInsertionSort();
        // Получаем продукт Сортировка Вставкой
        InsertionSortAbstractProduct insertionSort = factoryInsertionSort.getInsertionSort();
        insertionSort.sort(array);
    }
}
