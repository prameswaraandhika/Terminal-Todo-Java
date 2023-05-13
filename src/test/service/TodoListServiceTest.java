package test.service;

import entity.TodoList;
import repository.TodoListRepository;
import repository.TodoListRepositoryImpl;
import service.TodoListService;
import service.TodoListServiceImpl;

/**
 *
 * @author Andhika Prameswara <prameswaara@gmail.com>
 */
public class TodoListServiceTest {

    public static void main(String[] args) {
//        testShowTodoList();
//        testAddTodoList();
        testRemoveTodoList();

    }

    private static void testShowTodoList() {
        TodoListRepositoryImpl todoListRepository = new TodoListRepositoryImpl();
        todoListRepository.data[0] = new TodoList("Java Dasar");
        todoListRepository.data[1] = new TodoList("Java OOP");
        todoListRepository.data[2] = new TodoList("Java Spring");
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        todoListService.showTodoList();
    }

    private static void testAddTodoList() {
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        todoListService.addTodoList("Java Dasar");
        todoListService.addTodoList("Java OOP ");
        todoListService.addTodoList("Java Spring");
        todoListService.showTodoList();
    }

    private static void testRemoveTodoList() {
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        todoListService.addTodoList("Java Dasar");
        todoListService.addTodoList("Java OOP ");
        todoListService.addTodoList("Java Spring");
        todoListService.showTodoList();
        todoListService.removeTodoList(2);
        todoListService.showTodoList();
    }

}
