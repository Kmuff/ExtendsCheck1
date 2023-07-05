import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TodosTest {
    SimpleTask simpleTask1 = new SimpleTask(1, "Будильник");
    SimpleTask simpleTask2 = new SimpleTask(2, "Зарядка");
    String[] subtasks1 = {"Собрать рюкзак", "Купить проездной", "Посмотреть расписание"};
    Epic epic1 = new Epic(3, subtasks1);
    String[] subtasks2 = {"Заказать продукты", "Встретить курьера", "Выбросить мусор"};
    Epic epic2 = new Epic(4, subtasks2);
    Meeting meeting1 = new Meeting(45, "Поставить Будильник", "Важная встреча", "Сегодня");
    Meeting meeting2 = new Meeting(45, "Отдых", "Встреча с друзьями", "Вечер");

    @Test
    public void shouldFindSimpleTest() {
        Todos todos = new Todos();
        todos.add(simpleTask1);
        todos.add(simpleTask2);

        Task[] expected = {simpleTask1};
        Task[] actual = todos.search("Будильник");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindSimpleTest() {
        Todos todos = new Todos();
        todos.add(simpleTask1);
        todos.add(simpleTask2);

        Task[] expected = new Task[0];
        Task[] actual = todos.search("Часы");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindEpicTest() {
        Todos todos = new Todos();
        todos.add(epic1);
        todos.add(epic2);

        Task[] expected = {epic1};
        Task[] actual = todos.search("Купить проездной");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindEpicTest() {
        Todos todos = new Todos();
        todos.add(epic1);
        todos.add(epic2);

        Task[] expected = new Task[0];
        Task[] actual = todos.search("Отдых");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindMeetingTest() {
        Todos todos = new Todos();
        todos.add(meeting1);
        todos.add(meeting2);

        Task[] expected = {meeting1};
        Task[] actual = todos.search("Важная встреча");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindMeetingTest() {
        Todos todos = new Todos();
        todos.add(meeting1);
        todos.add(meeting2);

        Task[] expected = new Task[0];
        Task[] actual = todos.search("День");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindEverywhere() {
        Todos todos = new Todos();
        todos.add(simpleTask1);
        todos.add(simpleTask2);
        todos.add(epic1);
        todos.add(epic2);
        todos.add(meeting1);
        todos.add(meeting2);

        Task[] expected = {simpleTask1, meeting2};
        Task[] actual = todos.search("Будильник");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindEverywhere() {
        Todos todos = new Todos();
        todos.add(simpleTask1);
        todos.add(simpleTask2);
        todos.add(epic1);
        todos.add(epic2);
        todos.add(meeting1);
        todos.add(meeting2);

        Task[] expected = new Task[0];
        Task[] actual = todos.search("Кефир");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAll() {
        Todos todos = new Todos();
        todos.add(simpleTask1);
        todos.add(simpleTask2);
        todos.add(epic1);
        todos.add(epic2);
        todos.add(meeting1);
        todos.add(meeting2);

        Task[] expected = {simpleTask1, simpleTask2, epic1, epic2, meeting1, meeting2};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение Нетобанка",
                "во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }


}