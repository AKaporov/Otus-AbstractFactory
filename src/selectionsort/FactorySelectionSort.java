package selectionsort;

/**
 * Created by akaporov on 13.10.2020.
 * Конкретная фабрика по созданию продукта Сортировка Слиянием
 */
public class FactorySelectionSort {
    public SelectionSortAbstractFactory getSelectionSort(){
        return new SelectionSortAbstractFactoryImpl();
    }
}
