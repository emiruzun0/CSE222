
/**
 * HashTable implementation using open addressing with double hashing.
 * @author Emirhan Uzun / 171044019
 * @since 05/24/2020
 *
 * @param <K> Keys
 * @param <V> Values
 */
public class MyHashTableOpen<K,V> implements KWHashMap<K,V> {
	private Entry <K,V>[] table;
	private int numKeys;
	private int numDeletes;
	private static final int START_CAPACITY = 101;
	private static final double LOAD_THRESHOLD = 0.75;
	private final Entry<K,V> DELETED = new Entry<K,V>(null,null);

	private static class Entry<K, V> {
		private K key;
		private V value;

		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public K getKey() {
			return key;
		}

		public V getValue() {
			return value;
		}

		public V setValue(V val) {
			V oldVal = value;
			value = val;
			return oldVal;
		}
	}

	public MyHashTableOpen() {
		table = new Entry[START_CAPACITY];
	}

	@Override
	public V get(Object key) {
		int index = find(key);

		if(table[index] != null) return table[index].value;
		else return null;
	}

	@Override
	public boolean isEmpty() {
		if(table.length > 0) return false;
		return true;
	}

	@Override
	public V put(K key, V value) {
		int index = find(key);

		if(table[index] == null) {
			table[index] = new Entry<K,V>(key,value);
			numKeys++;

			double loadFactor = (double) (numKeys + numDeletes) / table.length;
			if(loadFactor > LOAD_THRESHOLD ) {
				rehash();
			}
			return null;
		}
		V oldVal = table[index].value;
		table[index].setValue(value);
		return oldVal;
	}

	private void rehash() {
		Entry<K,V>[] oldTable = table;
		table = new Entry[2 * oldTable.length + 1];

		numKeys = 0;
		numDeletes = 0;
		for(int i =0 ;i< oldTable.length;i++) {
			if((oldTable[i] != null)  && (oldTable[i] != DELETED)) {
				put(oldTable[i].key,oldTable[i].value);
			}
		}
	}

	@Override
	public V remove(Object key) {
		int index = find(key);

		if(table[index] == null) return null;
		else {
		//	Entry<K,V> DELETED = new Entry(table[index].getKey(),table[index].getValue());
			V value = table[index].value;
			numDeletes++;
			numKeys--;
			table[index] = null;
			//System.out.println("The key '" + key + "' was removed !  ");
			return value;
		}

	}

	@Override
	public int size() {
		return table.length;
	}

	private int find(Object key) {
		int index = key.hashCode() % table.length;
		if(index < 0 ) {
			index += table.length ;
		}

		int index2 = key.hashCode() % table.length;
        if (index2 < 0)
        	index2 += table.length;
        index2 =  3 - (index2 % 3);

		while((table[index] != null) && (!key.equals(table[index].key))){
			index = (index + index2) % table.length;

			if(index >= table.length) index= 0;
		}
		return index;
	}

	@Override
	public String toString() {
		String sb = "";
		System.out.println("\nHash Table");
		System.out.println("Key\tValue\n");
		for (int i = 0; i < START_CAPACITY; i++) {
			if (table[i] != null)
				sb +=  "-" + table[i].getKey() +"\t"+ table[i].getValue() + "\n";
		}
		return sb;
	}


}
