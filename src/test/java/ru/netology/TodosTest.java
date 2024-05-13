package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
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

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void taskGet() {
        Task task = new Task(5);
        int expected = task.id;
        int actual = task.getId();
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void subtasksEpicGet() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        String[] expected = subtasks;
        String[] actual = epic.getSubtasks();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void simpleTaskGet() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        String expected = simpleTask.title;
        String actual = simpleTask.getTitle();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void MeetingTopicGet() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        String expected = meeting.topic;
        String actual = meeting.getTopic();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void MeetingProjectGet() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        String expected = meeting.project;
        String actual = meeting.getProject();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void MeetingStartGet() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        String expected = meeting.start;
        String actual = meeting.getStart();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesQueryEpicTrue() {
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
        todos.add(epic);

        Boolean expected = true;
        Boolean actual = epic.matches("Яйца");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesQueryEpicFalse() {
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
        todos.add(epic);

        Boolean expected = false;
        Boolean actual = epic.matches("Помидор");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesQuerySimpleTrue() {
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
        todos.add(simpleTask);

        Boolean expected = true;
        Boolean actual = simpleTask.matches("родителям");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesQuerySimpleFalse() {
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
        todos.add(simpleTask);

        Boolean expected = false;
        Boolean actual = simpleTask.matches("Написать");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesQueryMeetingTrueTopic() {
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
        todos.add(meeting);

        Boolean expected = true;
        Boolean actual = meeting.matches("Выкатка");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesQueryMeetingTrueProject() {
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
        todos.add(meeting);

        Boolean expected = true;
        Boolean actual = meeting.matches("Приложение");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesQueryMeetingTrueStart() {
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
        todos.add(meeting);

        Boolean expected = true;
        Boolean actual = meeting.matches("вторник");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesQueryMeetingFalse() {
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
        todos.add(meeting);

        Boolean expected = false;
        Boolean actual = meeting.matches("Понедельник");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void searchQueryEpic() {
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
        todos.add(epic);

        Task[] expected = {epic};
        Task[] actual = todos.search("Молоко");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchQuerySimple() {
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
        todos.add(simpleTask);

        Task[] expected = {simpleTask};
        Task[] actual = todos.search("Позвонить");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchQueryMeeting() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting1 = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        Meeting meeting2 = new Meeting(
                556,
                "Выкатка 4й версии приложения",
                "Приложение НетоБанка",
                "В среду после обеда"
        );
        Meeting meeting3 = new Meeting(
                557,
                "Выкатка 5й версии приложения",
                "Приложение Банка",
                "В четверг после обеда"
        );

        Todos todos = new Todos();
        todos.add(meeting1);
        todos.add(meeting2);
        todos.add(meeting3);

        Task[] expected = {meeting1};
        Task[] actual = todos.search("вторник");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchQueryMeetingNull() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting1 = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение Банка",
                "Во вторник после обеда"
        );
        Meeting meeting2 = new Meeting(
                556,
                "Выкатка 4й версии приложения",
                "Приложение НетоБанка",
                "В среду после обеда"
        );
        Meeting meeting3 = new Meeting(
                557,
                "Выкатка 5й версии приложения",
                "Приложение Банка",
                "В четверг после обеда"
        );

        Todos todos = new Todos();
        todos.add(meeting1);
        todos.add(meeting2);
        todos.add(meeting3);

        Task[] expected = {};
        Task[] actual = todos.search("пятница");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchQueryMeeting2() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting1 = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        Meeting meeting2 = new Meeting(
                556,
                "Выкатка 4й версии приложения",
                "Приложение НетоБанка",
                "В среду после обеда"
        );
        Meeting meeting3 = new Meeting(
                557,
                "Выкатка 5й версии приложения",
                "Приложение Банка",
                "В четверг после обеда"
        );

        Todos todos = new Todos();
        todos.add(meeting1);
        todos.add(meeting2);
        todos.add(meeting3);

        Task[] expected = {meeting1, meeting2};
        Task[] actual = todos.search("НетоБанка");
        Assertions.assertArrayEquals(expected, actual);
    }
}
