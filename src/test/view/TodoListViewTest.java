package test.view;

import repository.TodoListRepository;
import repository.TodoListRepositoryImpl;
import service.TodoListService;
import service.TodoListServiceImpl;
import view.TodoListView;

/**
 *
 * @author Andhika Prameswara <prameswaara@gmail.com>
 */
public class TodoListViewTest {

    public static void main(String[] args) {
        testShowTodoList();
    }

    private static void testShowTodoList() {
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        TodoListView todoListView = new TodoListView(todoListService);
        todoListService.addTodoList("TODO 1");
        todoListService.addTodoList("TODO 2");
        todoListService.addTodoList("TODO 3");
        todoListView.showTodoList();
    }

}
