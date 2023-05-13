package repository;

import entity.TodoList;

/**
 *
 * @author Andhika Prameswara <prameswaara@gmail.com>
 */
public interface TodoListRepository {

    TodoList[] getAll();

    void add(TodoList todolist);

    boolean remove(Integer num);

}
