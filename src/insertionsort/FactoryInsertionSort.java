package insertionsort;

/**
 * Created by akaporov on 13.10.2020.
 * Конкретная фабрика по созданию продукта Сортировка Вставкой
 */
public class FactoryInsertionSort {
    public InsertionSortAbstractProduct getInsertionSort(){
        return new InsertionSortAbstractProductImpl();
    }
}
