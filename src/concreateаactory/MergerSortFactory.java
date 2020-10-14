package concreateаactory;

import mergersort.FactoryMergerSort;
import mergersort.MergerSortAbstractFactory;

/**
 * Created by akaporov on 13.10.2020.
 * Конкретная фабрика для Сортировки Слиянием
 */
public class MergerSortFactory implements SortAbstractFactory {
    @Override
    public void sort(int[] array) {
        // Создаем фабрику для сортировки Слиянием
        FactoryMergerSort factoryMergerSort = new FactoryMergerSort();
        // Получаем продукт Сортировка Слиянием
        MergerSortAbstractFactory mergerSort = factoryMergerSort.getMergerSort();
        mergerSort.sort(array);
    }
}
