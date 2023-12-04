public class MyRunnable implements Runnable{

    private final PersistantStorage persistantStorage;
    private final String name;
    private final String id;

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
