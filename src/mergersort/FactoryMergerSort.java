package mergersort;

/**
 * Created by akaporov on 13.10.2020.
 * Конкретная фабрика по созданию продукта Сортировка Слиянием
 */
public class FactoryMergerSort {
    public MergerSortAbstractFactory getMergerSort(){
        return new MergerSortAbstractFactoryImpl();
    }
}
