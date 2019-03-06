package HashMap;

/**
 *
 * @author Tempest
 */
public class HashMap {

    MapNode[] arr;
    int size;

    HashMap(int size) {
        arr = new MapNode[size];
        this.size = size;
    }

    public void put(int key, String value) {
        int hash = key % this.size;

        if (arr[hash] == null) {
            arr[hash] = new MapNode(key, value);
        } else {
            MapNode current = arr[hash];
            if (current.getKey() == key) {
                current.setValue(value);
                return;
            }
            while (current.next != null) {
                current = current.next;
                if (current.getKey() == key) {
                    current.setValue(value);
                    return;
                }
            }
            current.next = new MapNode(key, value);
        }
    }

    public String get(int key) {
        int hash = key % this.size;

        if (arr[hash] == null) {
            return null;
        } else {
            MapNode current = arr[hash];
            if (current.getKey() == key) {
                return current.getValue();
            }
            while (current.next != null) {
                current = current.next;
                if (current.getKey() == key) {
                    return current.getValue();
                }
            }
            return null;
        }
    }

    public boolean containsKey(int key) {
        int hash = key % this.size;

        if (arr[hash] == null) {
            return false;
        } else {
            MapNode current = arr[hash];
            if (current.getKey() == key) {
                return true;
            }
            while (current.next != null) {
                current = current.next;
                if (current.getKey() == key) {
                    return true;
                }
            }
            return false;
        }
    }

}
