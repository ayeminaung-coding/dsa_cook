public class HashTable {
    private int size = 0;
    private String[] fr;
    private String[] eng;

    public HashTable(int capacity) {
        fr = new String[capacity];
        eng = new String[capacity];
    }

    public void put(String key, String value) {
        if (size == fr.length) {
            System.out.println("Hash Table is full");
        }

        int hashIndex = hashFuntion(key);
        fr[hashIndex] = key;
        eng[hashIndex] = value;
        size++;
        System.out.println("Putting: " + key + " is successful");
    }

    public int getSize() {
        return size;
    }

    public int hashFuntion(String key) {
        int hash = (key.hashCode() & 0x7FFFFFFF) % eng.length;
        return hash;
    }

    public void printHashTable() {
        System.out.println("---- Hash Table ----");
        for (int i = 0; i < fr.length; i++) {
            System.out.println(i + " " + fr[i] + " " + eng[i]);
        }
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable(5);
        String key1 = "pomme";
        String value1 = "apple";
        String key2 = "pain";
        String value2 = "bread";
        String key3 = "clavier";
        String value3 = "keyboard";
        // put keys and values to hashtable
        hashTable.put(key1, value1);
        hashTable.put(key2, value2);
        hashTable.put(key3, value3);
        System.out.println();
        // show data and size of the hashtable
        hashTable.printHashTable();
        System.out.println("Table size = " + hashTable.getSize());
        System.out.println();
    }
}
