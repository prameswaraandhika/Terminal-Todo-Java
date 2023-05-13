package service;

/**
 *
 * @author Andhika Prameswara <prameswaara@gmail.com>
 */
public interface TodoListService {

    void showTodoList();

    void addTodoList(String todo);

    void removeTodoList(Integer number);

}
