import concreateаactory.*;
import enums.SortingType;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Created by akaporov on 09.10.2020.
 *
 * !!!!!!!!!!!! АБСТРАКТНАЯ ФАБРИКА !!!!!!!!!!!!
 *
 * Абстрактная фабрика позволяет создавать СЕМЕЙСТВА СВЯЗАННЫХ объетов, не привязываясь к конкректным классам создаваемых объектов.
 * СЕМЕЙСТВА - означает, что создаваемые объекты долджны использоваться вместе.
 *
 * <p>
 * Реализация выбора подходящего метода сортировки (выбором, вставки, слиянием) набора данных с использованием абстрактной фабрики и описание применения шаблона в проекте
 * Цель: Получите навык работы с абстрактной фабрикой.
 * Данные задаются в файле. Результат также помещается в файл.
 * 1. Выбрать массив размером 50 элементов.
 * 2. Создать программу, которая в качестве входного параметра получает вариант сортировки (1 - выбором, 2 - вставки, 3 - слиянием), имя файла со входным набором данных и имя файла с выходными данными.
 * 3. Реализовать в программе абстрактную фабрику и конкретные фабрики, отвечающие за каждый вариант сортировки как продукты.
 * 4. Программа записывает результаты в выходной файл данных. В содержании в пишется тип сортировки и результаты.
 * 5. Если потребуется использовать абстрактную фабрику или фабричный метод в проектной работе, предоставить описание в текстовом файле в GitHub репозитории где конкретно и в какой роли используется этот шаблон.
 * 6. нарисовать диаграмму классов.
 * Срок 2 недели от занятия
 * ДЗ сдается в виде ссылки на GitHub репозиторий с проектом.
 * По вопросам обращаться в Slack к студентам, преподавателям и наставникам в канал группы
 * Критерии оценки: Критерии оценки:
 * 1. Прислано решение: 1 балл
 * 2. Описаны все объекты , программа работает - 1 балл.
 * 3. Разработан тест - 1 балл
 * <p>
 * Минимальный балл для принятия - 2
 * Рекомендуем сдать до: 08.09.2020
 * <p>
 * <p>
 * Реализация алгоритмов на java:
 * https://proglib.io/p/java-sorting-algorithms
 */

public class AbstractFactoryApplication {
    private static int[] array = new int[50];
    private static String outputFile = "";
    private static String inputFile = "";
    private static int numberAlgorithm = 0;

    public static void main(String[] args) {
        numberAlgorithm = Integer.parseInt(args[0]);
        inputFile = args[1].trim();
        outputFile = args[2].trim();

        readArrayFromInputFile();
        createFactoryAndSortArray();
        saveSortingArrayInOutputFile();
    }

    private static void createFactoryAndSortArray() {
        //Тип продукта - для каждого понадобиться КОНКРЕТНАЯ ФАБРИКА
          // Сортировка матрицы

        //Конкректный продукт - онни описываются методами АБСТРАКТНОЙ ФАБРИКИ. И реализуются через соответствующие АБСТРАКТНЫЕ ПРОДУКТЫ А, Б и С.
          // Метод сортировки Выбором
          // Метод сортировки Вставки
          // Метод сортировки Слиянием

        // А:
          // Сортировка матриы методм Выбора
        // Б:
          // Сорировка матрицы методом Вставки
        // С:
          // Сортировка матрицы методом Слияния

        SortAbstractFactory sortAbstractFactory = createTypeProduct();
        sortAbstractFactory.sort(array);
    }

    private static SortAbstractFactory createTypeProduct() {
        SortAbstractFactory result = null;

        if (numberAlgorithm == 1){
            result = new SelectionSortFactory();
        } else if (numberAlgorithm == 2) {
            result = new InsertionSortFactory();
        } else if (numberAlgorithm == 3) {
            result = new MergerSortFactory();
        } else {
            return new BadAlgorithmFactory();
        }

        return result;
    }

    private static void saveSortingArrayInOutputFile() {
        try {
            OutputStream out = new FileOutputStream(outputFile);
            PrintWriter printWriter = new PrintWriter(out, true);

            printWriter.println(getCaptionByNumberAlgorithm() + ":");
            printWriter.println(Arrays.toString(array));

            out.flush();
            printWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    private static void readArrayFromInputFile() {
        array = new ReadArrayFromFileImpl().getIntArrayFromFile(inputFile);
    }

    public static String getCaptionByNumberAlgorithm() {
        if (numberAlgorithm == 1) {
            return SortingType.valueOf(SortingType.ONE.toString()).getTitle();
        } else if (numberAlgorithm == 2) {
            return SortingType.valueOf(SortingType.TWO.toString()).getTitle();
        } else if (numberAlgorithm == 3) {
            return SortingType.valueOf(SortingType.THREE.toString()).getTitle();
        } else {
            return SortingType.valueOf(SortingType.OTHER.toString()).getTitle();
        }
    }

}
