package view;

import static javatodolist.JavaToDoList.input;
import static javatodolist.JavaToDoList.removeToDoList;
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
            System.out.println("=======================================");
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
        System.out.println("=======================================");
        System.out.println("=======================================");
        System.out.println("MENAMBAH TODOLIST (X Jika ingin batal)");
        System.out.println("Silahkan tulis todo");
        String todo = InputUtil.input();
        switch (todo) {
            case "X":
            case "x":
                System.out.println("\n");
                break;
            default:
                todoListService.addTodoList(todo);
        }
    }

    public void removeTodoList() {
        System.out.println("=======================================");
        System.out.println("=======================================");
        System.out.println("MENGHAPUS TODOLIST (X Jika ingin batal)");
        System.out.print("Tulis nomer yang dihapus: ");
        String number = InputUtil.input();
        switch (number) {
            case "X", "x" ->
                System.out.println("\n");
            default -> {
                todoListService.removeTodoList(Integer.valueOf(number));
            }
        }
    }

}
