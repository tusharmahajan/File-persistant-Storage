public class PersistanceTester {

    public static void main(String[] args) {
        PersistantStorage persistantStorage = new PersistantStorage("/Users/tusharmahajan/Desktop/IdeaProjects/test.txt");

        Thread thread1 = new Thread(new MyRunnable(persistantStorage, "ramesh", "35"));
        Thread thread2 = new Thread(new MyRunnable(persistantStorage, "ankit", "89"));
        Thread thread3 = new Thread(new MyRunnable(persistantStorage, "ramesh", "99"));
        thread1.start();
        thread2.start();
        thread3.start();
        System.out.println(persistantStorage.get("ramesh"));

    }
}
