package repository;

import entity.TodoList;

/**
 *
 * @author Andhika Prameswara <prameswaara@gmail.com>
 */
public class TodoListRepositoryImpl implements TodoListRepository {

    public TodoList[] data = new TodoList[10];

    private boolean isFull() {
        boolean isFull = true;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) {
                isFull = false;
                break;
            }
        }
        return isFull;
    }

    public void resizeIfFull() {
        if (isFull()) {
            TodoList[] tempModels = data;
            data = new TodoList[data.length * 2];
            System.arraycopy(tempModels, 0, data, 0, tempModels.length);
        }
    }

    @Override
    public TodoList[] getAll() {
        return data;
    }

    @Override
    public void add(TodoList todolist) {
        resizeIfFull();
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) {
                data[i] = todolist;
                break;
            }
        }
    }

    @Override
    public boolean remove(Integer num) {
        if ((num - 1) >= data.length) {
            return false;
        } else if (data[num - 1] == null) {
            return false;
        } else {
            for (int i = (num - 1); i < data.length; i++) {
                if (i == (data.length - 1)) {
                    data[i] = null;
                } else {
                    data[i] = data[i + 1];
                }
            }
            return true;
        }
    }

}
