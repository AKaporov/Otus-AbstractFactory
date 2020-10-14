package enums;

/**
 * Created by akaporov on 02.10.2020.
 */
public enum SortingType {
    ONE("Сортировка выбором"),
    TWO("Сортировка вставкой"),
    THREE("Сортировка слиянием"),
    OTHER("Неизвестный тип сортировки");

    private String title;

    SortingType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
