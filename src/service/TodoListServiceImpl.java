package service;

import entity.TodoList;
import repository.TodoListRepository;

/**
 *
 * @author Andhika Prameswara <prameswaara@gmail.com>
 */
public class TodoListServiceImpl implements TodoListService {

    private TodoListRepository todoListRepository;

    public TodoListServiceImpl(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Override
    public void showTodoList() {
        System.out.println("TodoList");
        TodoList[] models = todoListRepository.getAll();
        for (int i = 0; i < models.length; i++) {
            TodoList toDoModels = models[i];
            int num = i + 1;
            if (toDoModels != null) {
                System.out.println(num + ". " + toDoModels.getTodo());
            }
        }
    }

    @Override
    public void addTodoList(String todo) {
        TodoList todoList = new TodoList(todo);
        todoListRepository.add(todoList);
        System.out.println("DATA TODO " + todo + " BERHASIL DITAMBAHKAN");
    }

    @Override
    public void removeTodoList(Integer number) {
        boolean isSucces = todoListRepository.remove(number);
        if (isSucces) {
            System.out.println("DATA TODO BERHASIL DIHAPUS, NOMER" + number);
        } else {
            System.out.println("DATA TODO GAGAL DIHAPUS, NOMER" + number);
        }
    }

}
