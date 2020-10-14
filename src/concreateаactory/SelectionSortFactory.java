package concreateаactory;

import selectionsort.FactorySelectionSort;
import selectionsort.SelectionSortAbstractFactory;
import selectionsort.SelectionSortAbstractFactoryImpl;

/**
 * Created by akaporov on 13.10.2020.
 * Конкретная фабрика для Сортировки Выборки
 */
public class SelectionSortFactory implements SortAbstractFactory{
    @Override
    public void sort(int[] array) {
        // Создаем фабрику для сортировки выбором
        FactorySelectionSort factorySelectionSort = new FactorySelectionSort();
        // Получаем продукт Сортировка Выбором
        SelectionSortAbstractFactory selectionSort = factorySelectionSort.getSelectionSort();
        selectionSort.sort(array);

    }
}
