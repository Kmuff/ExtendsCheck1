import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {

    SimpleTask simpleTask1 = new SimpleTask(1, "Будильник");
    SimpleTask simpleTask2 = new SimpleTask(2, "Зарядка");
    String[] subtasks1 = {"Собрать рюкзак", "Купить проездной", "Посмотреть расписание"};
    Epic epic1 = new Epic(3, subtasks1);
    String[] subtasks2 = {"Заказать продукты", "Встретить курьера", "Выбросить мусор"};
    Epic epic2 = new Epic(4, subtasks2);
    Meeting meeting1 = new Meeting(45, "Совещание", "Важная встреча", "Сегодня");
    Meeting meeting2 = new Meeting(45, "Отдых", "Встреча с друзьями", "Вечер");


    @Test
    public void SimpleTaskTestTrue() {
        boolean expected = true;
        boolean actual = simpleTask1.matches("Будильник");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void SimpleTaskTestFalse() {
        boolean expected = false;
        boolean actual = simpleTask2.matches("Уборка");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void EpicTestTrue() {
        boolean expected = true;
        boolean actual = epic1.matches("Посмотреть расписание");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void EpicTestFalse() {
        boolean expected = false;
        boolean actual = epic2.matches("Посмотреть расписание");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void MeetingTestTrue() {
        boolean expected = true;
        boolean actual = meeting1.matches("встреча");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void MeetingTestFalse() {
        boolean expected = false;
        boolean actual = meeting2.matches("Утро");
        Assertions.assertEquals(expected, actual);
    }


}