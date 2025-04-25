package HashTable;

public class HashTable {
    private int size = 0;
    private String[] fr;
    private String[] eng;

    public HashTable(int capacity) {
        this.fr = new String[capacity];
        this.eng = new String[capacity];
    }

    public void put(String key, String value) {
        // is hashtable full?
        if (size == fr.length) {
            System.out.println("Hash table is full");
        }

        // use hash function to convert key to hash index
        int hashIndex = hashFunction(key);
        // add new value to the array at the computed position
        fr[hashIndex] = key;
        eng[hashIndex] = value;
        size++;
        System.out.println("Hash table is full");

    }

    public int getSize() {
        return size;
    }

    public int hashFunction(String key) {
        int hash = (key.hashCode() & 0x7FFFFFFF) % eng.length;
        return hash;
    }

    public void printHashTable() {
        System.out.println("---Hash Table---");
        for (int i = 0; i < fr.length; i++) {
            System.out.println(i + " " + fr[i] + " " + eng[i]);

        }
    }
    
}
