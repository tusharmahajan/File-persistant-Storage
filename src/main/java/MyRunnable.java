public class MyRunnable implements Runnable{

    private PersistantStorage persistantStorage;
    private String name;
    private String id;

    public MyRunnable(PersistantStorage persistantStorage, String name, String id) {
        this.persistantStorage = persistantStorage;
        this.name = name;
        this.id = id;
    }

    @Override
    public void run() {
        this.persistantStorage.put(this.name, this.id);
    }
}
