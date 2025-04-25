package HashTable;

public class HashTable2 {

    private int size = 0;
    private String[] fr;
    private String[] eng;

    public HashTable2(int capacity) {
        fr = new String[capacity];
        eng = new String[capacity];
    }

    public void put(String key, String value) {
        // is hashtable full?
        if (size == fr.length) {
            System.out.println("Hash table is full");
        }
        // use hash function to convert key to hash index
        int index = hashFunction(key);
        // add new value to the array at the computed position
        int i = index;
        // if there is a vaule in the computed index, do linear probling
        if (fr[index] != null) {

            System.out.println("Putting " + value + " has collision");

            // plus the index until finding the null space
            while (fr[i] != null && i < fr.length - 1) {
                i++;
            }
            // if last index is full, print failed
            if (fr[i] != null) {
                System.out.println("Putting " + value + " is failed.");

            } else {
                fr[i] = key;
                eng[i] = value;
                size++;
                System.out.println("Putting " + value + " is successful.");
            }
        } else {
            fr[index] = key;
            eng[index] = value;
            size++;
            System.out.println("Putting " + key + " is successful.");

        }
    }

    public String get(String key) {
        for (int i = 0; i < fr.length; i++) {
            if (fr[i] == key) {
                return eng[i];
            }
        }
        return "N/A";
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
