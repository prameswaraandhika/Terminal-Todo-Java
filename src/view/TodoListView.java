package view;

import service.TodoListService;
import util.InputUtil;

/**
 *
 * @author Andhika Prameswara <prameswaara@gmail.com>
 */
public class TodoListView {

    TodoListService todoListService;

    public TodoListView(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    public void showTodoList() {
        dance:
        while (true) {
            todoListService.showTodoList();
            System.out.println("ToDoApp");
            System.out.println("=======================================");
            System.out.println("PILIHAN: ");
            System.out.println("1. TAMBAH");
            System.out.println("2. HAPUS");
            System.out.println("3. KELUAR");
            System.out.print("Silahkan pilih: ");
            String result = InputUtil.input();
            switch (result) {
                case "1" ->
                    addTodoList();
                case "2" ->
                    removeTodoList();
                case "3" -> {
                    System.out.println("\nThanks for using this App :)");
                    break dance;
                }
                default -> {
                    System.err.println("Msg info: pilihan1 tidak diketahui");
                    todoListService.showTodoList();
                }
            }
        }
    }

    public void addTodoList() {

    }

    public void removeTodoList() {

    }
}
