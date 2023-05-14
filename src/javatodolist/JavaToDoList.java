package javatodolist;

import java.util.Scanner;

/**
 *
 * @author Andhika Prameswara <prameswaara@gmail.com>
 */
public class JavaToDoList {

    /**
     * @param args the command line arguments
     */
    static Scanner scan = new Scanner(System.in);
    static String[] models = new String[10];

    public static void main(String[] args) {
//        testShowToDoList();
//        testAddToDoList();
//        testRemoveToDoList();
//        testInput(); 
//        testViewShowToDoList();
//        testViewAddToDoList();
//        testViewRemoveToDoList();
        viewShowToDoList();

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
        for (int i = 0; i < 3; i++) {
            models[i] = "Test " + (i + 1);
        }
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
        for (String model : models) {
            if (model == null) {
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
        for (int i = 0; i < 3; i++) {
            addToDoList("Test " + (i + 1));
        }
        showToDoList();
    }

    /*
        Menghapus ToDoList
     */
    public static boolean removeToDoList(Integer num) {
        if ((num - 1) >= models.length) {
            return false;
        } else if (models[num - 1] == null) {
            return false;
        } else {
            System.out.println("Todo \"" + models[num - 1] + "\" has been deleted\n\n");
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
        for (int i = 0; i < 3; i++) {
            addToDoList("Test " + (i + 1));
        }
        boolean res = removeToDoList(2);
        showToDoList();
    }


    /*
        Menampilkan menu ToDoList
     */
    public static void viewShowToDoList() {

        dance:
        while (true) {
            showToDoList();
            System.out.println("ToDoApp");
            System.out.println("=======================================");
            System.out.println("PILIHAN: ");
            System.out.println("1. TAMBAH");
            System.out.println("2. HAPUS");
            System.out.println("3. KELUAR");
            System.out.print("Silahkan pilih: ");
            String result = input();
            switch (result) {
                case "1":
                    viewAddToDoList();
                    break;
                case "2":
                    viewRemoveToDoList();
                    break;
                case "3":
                    System.out.println("\nThanks for using this App :)");
                    break dance;
                default:
                    System.err.println("Msg info: pilihan1 tidak diketahui");
                    viewShowToDoList();
            }
        }
    }

    public static void testViewShowToDoList() {
        for (int i = 0; i < 3; i++) {
            addToDoList("Test " + (i + 1));
        }
        viewShowToDoList();
    }

    /*
        Menampilkan tampilan tambah ToDoList
     */
    public static void viewAddToDoList() {
        System.out.println("=======================================");
        System.out.println("=======================================");
        System.out.println("MENAMBAH TODOLIST (X Jika ingin batal)");
        System.out.println("Silahkan tulis todo");
        String todo = input();
        switch (todo) {
            case "X", "x" ->
                System.out.println("\n");
            default ->
                addToDoList(todo);
        }

    }

    public static void testViewAddToDoList() {
        for (int i = 0; i < 3; i++) {
            addToDoList("Test " + (i + 1));
        }
        viewAddToDoList();
        showToDoList();
    }


    /*
        Menampilkan view menghapus ToDoList
     */
    public static void viewRemoveToDoList() {
        System.out.println("=======================================");
        System.out.println("=======================================");
        System.out.println("MENGHAPUS TODOLIST (X Jika ingin batal)");
        System.out.print("Tulis nomer yang dihapus: ");
        String number = input();
        switch (number) {
            case "X":
            case "x":
                System.out.println("\n");
                break;
            default:
                boolean result = removeToDoList(Integer.valueOf(number));
                if (!result) {
                    System.out.println("Gagal menghapus todo: " + number);
                }
        }
    }

    public static void testViewRemoveToDoList() {
        for (int i = 0; i < 3; i++) {
            addToDoList("Test " + (i + 1));
        }
        showToDoList();
        viewRemoveToDoList();
        showToDoList();
    }

    /*
        Fungsi untuk input
     */
    public static String input() {
        String data = scan.nextLine();
        return data;
    }

}
