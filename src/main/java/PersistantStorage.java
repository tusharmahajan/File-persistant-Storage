import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class PersistantStorage {

    private Map<String, String> data;
    private String path;

    public PersistantStorage(String path) {
        this.data = new HashMap<>();
        this.path = path;
        populateMap();
    }

    private synchronized void populateMap() {
        try(FileInputStream fileInputStream = new FileInputStream(this.path)) {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object obj = objectInputStream.readObject();
            if(obj instanceof Map){
                this.data = (Map<String, String>) obj;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public synchronized void put(String key, String value){
        this.data.put(key, value);
        try(FileOutputStream fileOutputStream = new FileOutputStream(this.path)){
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized String get(String key){
        return this.data.get(key);
    }

    public synchronized void remove(String key){
       this.data.remove(key);
    }
}
