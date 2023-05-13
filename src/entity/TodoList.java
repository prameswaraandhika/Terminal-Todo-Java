package entity;

/**
 *
 * @author Andhika Prameswara <prameswaara@gmail.com>
 */
public class TodoList {

    private String todo;

    public TodoList(String todo) {
        this.todo = todo;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

}
