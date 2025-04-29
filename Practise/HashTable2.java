public class HashTable2 {
    private int size;
    private String[] fr;
    private String[] eng;

    public HashTable2(int capacity) {
        fr = new String[capacity];
        eng = new String[capacity];
    }

    public void put(String key, String value) {
        if (size == fr.length) {
            System.out.println("Hash table is full");
        }
        int index = hashFunction(key);
        int i = index;
        if (fr[index] != null) {
            System.out.println("Putting " + value + " has collision");
            while (fr[i] != null && i < fr.length - 1) {
                i++;
            }
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
        System.out.println("---- Hash Table ----");
        for (int i = 0; i < fr.length; i++) {
            System.out.println(i + " " + fr[i] + " " + eng[i]);
        }
    }

    public static void main(String[] args) {
        HashTable2 hashTable = new HashTable2(5);
        String key1 = "pomme";
        String value1 = "apple";
        String key2 = "pain";
        String value2 = "bread";
        String key3 = "clavier";
        String value3 = "keyboard";
        String key4 = "ordinateur";
        String value4 = "computer";
        String key5 = "lait";
        String value5 = "milk";
        hashTable.put(key1, value1);
        hashTable.put(key2, value2);
        hashTable.put(key3, value3);
        hashTable.put(key4, value4);
        hashTable.put(key5, value5);
        System.out.println();
        hashTable.printHashTable();
        System.out.println("Table size = " + hashTable.getSize());
        System.out.println();
        System.out.println("--- Searching ---");
        System.out.println(key1 + "=" + hashTable.get(key1));
        System.out.println(key2 + "=" + hashTable.get(key2));
        System.out.println(key3 + "=" + hashTable.get(key3));
        System.out.println(key4 + "=" + hashTable.get(key4));
        System.out.println(key5 + "=" + hashTable.get(key5));

    }
}
