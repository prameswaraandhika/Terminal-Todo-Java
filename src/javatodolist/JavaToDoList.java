package javatodolist;

/**
 *
 * @author Andhika Prameswara <prameswaara@gmail.com>
 */
public class JavaToDoList {

    /**
     * @param args the command line arguments
     */
    static String[] models = new String[10];

    public static void main(String[] args) {
        System.out.println("ToDoApp");
//        testAddToDoList();
        testRemoveToDoList();
    }

    /*
        Menampilkan ToDoList    
     */
    public static void showToDoList() {
        for (int i = 0; i < models.length; i++) {
            String toDoModels = models[i];
            int num = i + 1;
            if (toDoModels != null) {
                System.out.println(num + ". " + toDoModels);
            }
        }
    }

    public static void testShowToDoList() {
        models[0] = "Java Core";
        models[1] = "Java OOP";
        models[2] = "Java JDBC";
        showToDoList();
    }

    /*
        Menambahkan ToDoList
     */
    public static void addToDoList(String task) {

        /*
        Set boolean isFull sebagai true
        Jika isfull tetap true 
            Tanda nya setiap index di array sudah terisi 
            Karena saat dilakukakn checking datanya tidak ada yang null. Oleh karena itu isFull tetap true
            Karena jikalau ketika dilakukan checking data saat ini null. Maka is full akan di set menjadi false
            Jika isFull tetap true kita akan menambahkan 2* lipat space baru pada arraynya
            
        Jika isFull false  
            Tandanya index saat ini masih ada data yang null
            Sehingga kita tidak perlu menambahkan space baru pada array nya
         */
        boolean isFull = true;
        for (int i = 0; i < models.length; i++) {
            if (models[i] == null) {
                isFull = false;
                break;
            }
        }

        if (isFull) {
            String[] tempModels = models;
            models = new String[models.length * 2];
            for (int i = 0; i < tempModels.length; i++) {
                models[i] = tempModels[i];
            }
        }

        for (int i = 0; i < models.length; i++) {
            if (models[i] == null) {
                models[i] = task;
                break;
            }
        }
    }

    public static void testAddToDoList() {
        for (int i = 0; i < 10; i++) {
            addToDoList("Contoh ke-" + (i + 1));
        }
        showToDoList();
    }

    /*
        Menghapus ToDoList
     */
    public static boolean removeToDoList(Integer num) {
        /*
            Lets say ada 3 todo
            todo1
            todo2
            todo3
            todo 2 delete
            
         */
        if ((num - 1) >= models.length) {
            return false;
        } else if (models[num - 1] == null) {
            return false;
        } else {
            System.out.println("Todo \"" + models[num - 1] + "\" has been deleted");
            for (int i = (num - 1); i < models.length; i++) {
                if (i == (models.length - 1)) {
                    models[i] = null;
                } else {
                    models[i] = models[i + 1];
                }
            }
            return true;
        }
    }

    /*
        Tes Fitur Hapus
     */
    public static void testRemoveToDoList() {
        addToDoList("Test Satu");
        addToDoList("Test Dua");
        addToDoList("Test Tiga");
        boolean res = removeToDoList(2);
        showToDoList();
    }


    /*
        Menampilkan menu ToDoList
     */
    public static void viewShowToDoList() {

    }

    /*
        Menampilkan tampilan tambah ToDoList
     */
    public static void viewAddToDoList() {

    }

    /*
        Menampilkan view menghapus ToDoList
     */
    public static void viewRemoveToDoList() {

    }

}
