package ru.netology.todos;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TaskTest {

    @Test
    public void testSimpleTaskSearchFalse() {
        SimpleTask search = new SimpleTask(5, "Позвонить родителям");

        boolean expected = false;
        boolean actual = search.matches("слово");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSimpleTaskSearchTrue() {
        SimpleTask search = new SimpleTask(5, "Позвонить родителям");

        boolean expected = true;
        boolean actual = search.matches("родител");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMeetingSearchFalse() {
        Meeting search = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = false;
        boolean actual = search.matches("вторник");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMeetingSearchTrue() {
        Meeting search = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = true;
        boolean actual = search.matches("НетоБанк");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testEpicSearchFalse() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic search = new Epic(55, subtasks);

        boolean expected = false;
        boolean actual = search.matches("Вода");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testEpicSearchTrue() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic search = new Epic(55, subtasks);

        boolean expected = true;
        boolean actual = search.matches("Хлеб");

        Assertions.assertEquals(expected, actual);
    }

}