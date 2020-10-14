package concreateаactory;

import badalgorithm.BadAlgorithmAbstractFactory;
import badalgorithm.FactoryBadAlgorithm;

/**
 * Created by akaporov on 13.10.2020.
 * Конкретная фабрика для Неизвестного Алгоритма Сортировки
 */
public class BadAlgorithmFactory implements SortAbstractFactory{
    @Override
    public void sort(int[] array) {
        // Создаем фабрику для Неизвестного Алгоритма Сортировки
        FactoryBadAlgorithm factoryBadAlgorithm = new FactoryBadAlgorithm();
        // Получаем продукт Неизвестный Алгоритм Сортировки
        BadAlgorithmAbstractFactory badAlgorithm = factoryBadAlgorithm.getBadAlgorithm();
        badAlgorithm.sort(array);
    }
}
