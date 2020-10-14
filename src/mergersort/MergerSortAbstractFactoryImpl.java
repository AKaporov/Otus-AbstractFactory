package mergersort;

import concreateаactory.SortAbstractFactory;

/**
 * Created by akaporov on 02.10.2020.
 *
 *
 * Сортировка слиянием
 *
 * Сортировка слиянием эффективнее, алгоритмов Выбором, Вставками, Пузырьком благодаря использованию рекурсии и
 * подходу «разделяй и властвуй».
 *
 * Массив делится на два подмассива, а затем происходит:
 * 1. Сортировка левой половины массива (рекурсивно);
 * 2. Сортировка правой половины массива (рекурсивно);
 * 3. Слияние.
 *
 *
 * Реализация:
 * В главную функцию (mergeSortAlgorithm) передаются left и right – индексы подмассивов для сортировки,
 * крайние слева и справа. Изначально они имеют значения 0 и array.length-1, в зависимости от реализации.
 * Основа нашей рекурсии гарантирует, что мы выйдем, когда закончим, или когда left и right встретятся друг с другом.
 * Мы находим среднюю точку mid и рекурсивно сортируем подмассивы слева и справа от середины, в итоге объединяя наши
 * решения.
 * Возможно, вы вспомните дерево и спросите: почему мы не передаем два меньших массива?
 * Ответ прост: это не нужно и вызовет огромное потребление памяти для очень длинных массивов.
 *
 * Достаточно следовать индексам не нарушая логики дерева рекурсии - Реализация метода mergeSortAlgorithm.
 * Для сортировки двух подмассивов в один нужно вычислить их длину и создать временные массивы, в которые будем
 * копировать. Так можно свободно изменять главный массив.
 * После копирования мы проходим по результирующему массиву и назначаем текущий минимум.
 * Помните, что наши подмассивы отсортированы?
 * Теперь нужно просто выбрать наименьший из двух элементов, которые еще не были выбраны, и двигать итератор для этого
 * массива вперед.
 *
 * Временная сложность:
 * Для вычисления временной сложности нам понадобится основная теорема о рекуррентных соотношениях.
 * https://ru.wikipedia.org/wiki/%D0%9E%D1%81%D0%BD%D0%BE%D0%B2%D0%BD%D0%B0%D1%8F_%D1%82%D0%B5%D0%BE%D1%80%D0%B5%D0%BC%D0%B0_%D0%BE_%D1%80%D0%B5%D0%BA%D1%83%D1%80%D1%80%D0%B5%D0%BD%D1%82%D0%BD%D1%8B%D1%85_%D1%81%D0%BE%D0%BE%D1%82%D0%BD%D0%BE%D1%88%D0%B5%D0%BD%D0%B8%D1%8F%D1%85
 * Сложность равна O(nlog n), и это лучшая временная сложность для алгоритма сортировки.
 * Доказано, что массив не может быть отсортирован быстрее, чем O(nlog n).
 */
public class MergerSortAbstractFactoryImpl implements MergerSortAbstractFactory {
    @Override
    public void sort(int[] array) {
        mergeSortAlgorithm(array, 0, array.length - 1);
    }

    private void mergeSortAlgorithm(int[] array, int left, int right) {
        if (right <= left) return;
        int mid = (left+right)/2;
        mergeSortAlgorithm(array, left, mid);
        mergeSortAlgorithm(array, mid+1, right);
        merge(array, left, mid, right);
    }

    private void merge(int[] array, int left, int mid, int right) {
        // вычисляем длину
        int lengthLeft = mid - left + 1;
        int lengthRight = right - mid;

        // создаем временные подмассивы
        int leftArray[] = new int [lengthLeft];
        int rightArray[] = new int [lengthRight];

        // копируем отсортированные массивы во временные
        for (int i = 0; i < lengthLeft; i++)
            leftArray[i] = array[left+i];
        for (int i = 0; i < lengthRight; i++)
            rightArray[i] = array[mid+i+1];

        // итераторы содержат текущий индекс временного подмассива
        int leftIndex = 0;
        int rightIndex = 0;

        // копируем из leftArray и rightArray обратно в массив
        for (int i = left; i < right + 1; i++) {
            // если остаются нескопированные элементы в R и L, копируем минимальный
            if (leftIndex < lengthLeft && rightIndex < lengthRight) {
                if (leftArray[leftIndex] < rightArray[rightIndex]) {
                    array[i] = leftArray[leftIndex];
                    leftIndex++;
                }
                else {
                    array[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            }
            // если все элементы были скопированы из rightArray, скопировать остальные из leftArray
            else if (leftIndex < lengthLeft) {
                array[i] = leftArray[leftIndex];
                leftIndex++;
            }
            // если все элементы были скопированы из leftArray, скопировать остальные из rightArray
            else if (rightIndex < lengthRight) {
                array[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }
    }
}
