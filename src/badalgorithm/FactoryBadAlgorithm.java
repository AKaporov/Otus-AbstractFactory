package badalgorithm;

/**
 * Created by akaporov on 13.10.2020.
 * Конкретная фабрика по созданию продукта Неизвестный Алгоритм Сортировки
 */
public class FactoryBadAlgorithm {
    public BadAlgorithmAbstractFactory getBadAlgorithm(){
        return new BadAlgorithmAbstractFactoryImpl();
    }
}
