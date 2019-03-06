package HashMap;

public class MapNode {
    private int key;
    private String value;
    public MapNode next;
    
    MapNode() {
        this.key = 0;
        this.value = null;
        this.next = null;
    }
    
    MapNode(int key, String value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
    
    public int getKey() {
        return this.key;
    }
    
    public void setKey(int key) {
        this.key = key;
    }
    
    public void setValue(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return this.value;
    }
}

