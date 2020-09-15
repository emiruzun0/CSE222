import java.util.*;

/**
 * HashTable implementation using chaining.
 * @author Emirhan Uzun / 171044019
 * @since 05/24/2020
 *
 * @param <K> Keys
 * @param <V> Values
 */
public class HashTableChain<K,V> implements KWHashMap<K,V> {
	
    private LinkedList<Entry<K,V>> [] table;
    private int numKeys;
    private static final int CAPACITY = 101;
    private double LOAD_THRESHOLD = 0.75;
   
    
    @SuppressWarnings("unchecked")
	public HashTableChain(){
        table = new LinkedList[CAPACITY];
    }

    @Override
    public V get(Object key) {
        int index = key.hashCode() % table.length;
        if(index < 0) index += table.length;
        if(table[index] == null) return null;
        
        for(Entry<K,V> nextItem : table[index]) {
        	if(nextItem.getKey().equals(key)) return nextItem.value;
        }
        return null;
    }
    
    @Override
    public boolean isEmpty() {
        return numKeys == 0;
    }

    @Override
    public V put(K key, V value) {
        int index = key.hashCode() % table.length;
        if(index < 0) index += table.length;
        if(table[index] == null) table[index] = new LinkedList<Entry<K,V>>();
        
        for(Entry<K,V> nextItem : table[index]){
            if(nextItem.getKey().equals(key)){
                V oldVal = nextItem.value;
                nextItem.setValue(value);
                return oldVal;
            }
        }
        
        table[index].addFirst(new Entry<K,V>(key,value));
        numKeys++;
        if(numKeys > (LOAD_THRESHOLD * table.length)) rehash();
        return null;
    }
    
    @SuppressWarnings("unchecked")
	private void rehash() {
    	LinkedList<Entry<K, V>>[] oldTable = table;
    	table = new LinkedList[2 * oldTable.length + 1];
    	numKeys = 0;
    	
    	for (int i = 0; i < oldTable.length; i++) {
    		if (oldTable[i] != null) {
    			for(Entry<K,V> nextItem : oldTable[i]) {
    				put(nextItem.getKey(),nextItem.getValue());
    	    	}
    		}
    	}
    }
    
    @Override
    public V remove(Object key) {
    	int index = key.hashCode() % table.length;
    	if(index < 0) index += table.length;
    	if(table[index] == null) return null;
    	
    	V oldVal = null;
    	
    	for(Entry<K,V> nextItem : table[index]) {
    		if(nextItem.getKey().equals(key)) {
    			oldVal = nextItem.getValue();
    	    	int i = table[index].indexOf(nextItem);
    	    	table[index].remove(i);
    	    	numKeys--;
    	    	if(table[index].isEmpty()) table[index]  = null;
    		}
    	}
    	return oldVal;
    }

    @Override
    public int size() {
        return numKeys;
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


