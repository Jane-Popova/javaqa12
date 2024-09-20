package ru.netology.todos;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


public class TodosTest {
    SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

    String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
    Epic epic = new Epic(55, subtasks);

    Meeting meeting = new Meeting(
            555,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанка",
            "Во вторник после обеда"
    );

    Todos todos = new Todos();



    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testTodosSimpleTaskSearch() {
        todos.add(simpleTask);

        Task[] expected = {simpleTask};
        Task[] actual = todos.search("Позвонить родителям");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindByQueryOfAllTasks2() {

        todos.add(epic);

        Task[] expected = {epic};
        Task[] actual = todos.search("Молоко");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindByQueryOfAllTasks3() {
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("Приложение НетоБанка");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test public void shouldNotFindTasksByQuery() {


        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("Выбрать");

        Assertions.assertArrayEquals(expected, actual);
    }


}