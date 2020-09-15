
/**
 * HashTable implementation using open addressing.
 * @author Emirhan Uzun / 171044019
 * @since 05/24/2020
 *
 * @param <K> Keys
 * @param <V> Values
 */
public class HashTableOpen<K,V> implements KWHashMap<K,V> {
   
	/**
	 * The Hash Table Array
	 */
	private Entry<K,V> [] table;
    /**
     * The initial capacity
     */
    private static final int START_CAPACITY = 101;
    private double LOAD_THRESHOLD = 0.75;
    private int numKeys;
    private int numDeletes;
    private final Entry<K,V> DELETED = new Entry<K,V>(null,null);
    
    /**
     * Constructor. Create a array to table
     */
    @SuppressWarnings("unchecked")
	public HashTableOpen(){
        table = new Entry[START_CAPACITY];
    }
    
    @Override
    public boolean isEmpty(){
        if( numKeys > 0 ) return false;
        return true;
    }
    
    @Override
    public int size() {
        return numKeys;
    }
    
    @Override
    public V get(Object key) {
        int index = find(key);
        if(table[index] != null) return table[index].getValue();
        else return null;
    }
    
    @Override
    public V put(K key, V value) {
        int index = find(key);
        if(table[index] == null){ 
        	table[index] = new Entry<>(key,value);
            numKeys++;
            double loadFactor = (double) (numKeys + numDeletes) / table.length;
            if(loadFactor > LOAD_THRESHOLD) rehash();
            return null;
        }
        
        V oldVal = table[index].getValue();
        table[index].setValue(value);
        return oldVal;
    }
    
    @Override
    public V remove(Object key) {
    	int index = find(key);
    	if(table[index] == null) return null;
    	V oldVal = table[index].getValue();
    	table[index] = null;
    	numKeys--;
        return oldVal;
    }

    @SuppressWarnings("unchecked")
    private void rehash() {
    	Entry<K, V>[] oldTable = table;
    	table = new Entry[2 * oldTable.length + 1];
    	numKeys = 0;
    	numDeletes = 0;
    	for (int i = 0; i < oldTable.length; i++) {
    		if ((oldTable[i] != null) && (oldTable[i] != DELETED)) {
    			put(oldTable[i].getKey(), oldTable[i].getValue());
    		}
    	}
    }
    
    private int find(Object key){
        int index = key.hashCode() % table.length;
        if(index < 0) index += table.length;
        while ((table[index] != null) && (!key.equals(table[index].key))){
            index++;
            if(index >= table.length) index = 0;
        }
        return index;
    }

    private static class Entry<K,V>{

    	private K key;
    	private V value;
   
        /**
         * Creates a new key-value pair.
         * @param key The key 
         * @param value The value
         */
        public Entry(K key, V value){
            this.key = key;
            this.value = value;
        }
      
        /**
         * Retrieves the key
         * @return The key 
         */
        public K getKey(){
            return key;
        }
        
        /**
         * Retrieves the value
         * @return the value
         */
        public V getValue() {
            return value;
        }
        
        /**
         * Sets the value
         * @param val The new value
         * @return old value
         */
        public V setValue(V val) {
            V oldVal = value;
            this.value = val;
            return oldVal;
        }
    }
}
