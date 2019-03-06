package HashMap;

public class HashMapMain {
    public static void main(String[] args) {
        HashMap map = new HashMap(3);
        
        map.put(1, "aa");
        map.put(2, "bb");
        map.put(4, "cc");
        map.put(5, "dd");
        map.put(1, "ee");
        map.put(6, "f");
        map.put(9, "g");
        map.put(3, "h");
        
        System.out.println(map.get(1));
        System.out.println(map.get(2));
        System.out.println(map.get(4));
        System.out.println(map.get(5));
        System.out.println(map.get(7));
        System.out.println(map.get(6));
        System.out.println(map.get(9));
        System.out.println(map.get(3));
        
        System.out.println(map.containsKey(12)); 
    }   
}
