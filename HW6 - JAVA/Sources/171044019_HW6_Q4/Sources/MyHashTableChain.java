
/**
 * HashTable implementation using chaining with binary search tree.
 * @author Emirhan Uzun / 171044019
 * @since 05/24/2020
 *
 * @param <K> Keys
 * @param <V> Values
 */
public class MyHashTableChain<K extends Comparable<K>,V extends Comparable <V>> implements KWHashMap<K,V> {
	private BinarySearchTree<Entry <K,V>>[] table;
	private int numKeys;
	private static final int CAPACITY = 101;
	private static final double LOAD_THRESHOLD = 3.0;

	private static class Entry<K extends Comparable <K>, V extends Comparable<V>> implements Comparable<Entry <K,V>> {
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
		
		public String toString() {
			return getKey() + "\t" + getValue();
		}

		@Override
		public int compareTo(Entry<K, V> o) {
			return (this.getKey().compareTo(o.getKey()));
			
		}
	}

	public MyHashTableChain() {
		table = new BinarySearchTree[CAPACITY];
	}

	@Override
	public V get(Object key) {
		int index = key.hashCode() % table.length;
		if(index < 0) index += table.length;
		if(table[index] == null) return null;

		V value = null;
		Entry temp = table[index].find(new Entry<K,V>((K) key, value));
		//return table[index].find(target)
		value = (V) temp.getValue();
		return value;
	}

	@Override
	public boolean isEmpty() {
		if(numKeys > 0 ) return false;
		return true;
	}

	@Override
	public V put(K key, V value) {
		int index = key.hashCode() % table.length;
		if(index < 0) index += table.length;
		if(table[index] == null) {
			table[index] = new BinarySearchTree<Entry <K,V>>();
		}
		
		Entry<K,V> temp = table[index].find(new Entry<K,V>(key,value));
		if(temp != null) {
			V oldVal = temp.getValue();
			table[index].remove(temp);
			temp.setValue(value);
			table[index].add(temp);
			return oldVal;
		}
		

		table[index].add(new Entry<K,V>(key,value));
		numKeys++;
		if(numKeys > ( LOAD_THRESHOLD * table.length)) rehash();
		return null;
	}
	
	private void rehash() {
		BinarySearchTree<Entry <K,V>>[] oldTable = table;

		table = new BinarySearchTree[2 * oldTable.length + 1];

		numKeys = 0;
		for(int i =0 ;i< oldTable.length;i++) {
			if((oldTable[i] != null) ) {
				table[i] = oldTable[i];
			}
		}
	}

	@Override
	public V remove(Object key) {
		Entry<K,V> temp ;
		V val = null ;
		for(int i =0;i<table.length;++i) {
			if(table[i] != null) {
				temp = table[i].find(new Entry<K,V>((K) key,val));
				if(temp != null) {
					V value = temp.getValue();
					table[i].remove(temp);
					//System.out.println("The key '" + key + "' was removed !  ");
					numKeys--;
					return value;
				}
			}
		}

		//System.out.println("The key " + key + " was not found ! ");
		return null;
	}

	@Override
	public int size() {
		return numKeys;
	}
	
	public String toString() {
		String sb = "";
		System.out.println("\nHash Table");
		System.out.println("Key\tValue\n");
		for (int i = 0; i < CAPACITY; i++) {
			if (table[i] != null)
				sb +=  table[i].toString() ;
		}
		return sb;
	}
}

