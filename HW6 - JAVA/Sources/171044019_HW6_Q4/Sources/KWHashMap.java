
/**
 * To show more than one way to implement a hash table, the interface helps me.
 * @author Emirhan Uzun / 171044019
 * @since 05/24/2020
 *
 * @param <K> Keys
 * @param <V> Values
 */
public interface KWHashMap <K,V>{
	/**
	 * Returns the value associated with the specified key. Returns null if the key is not present.
	 * @param key Specified Key
	 * @return tha value or null
	 */
	V get(Object key);
	/**
	 * Returns true if this table contains no key-value mappings.
	 * @return true if the table is empty
	 */
	boolean isEmpty();
	/**
	 * Associates the specified value with specified key.
	 * @param key Specified key
	 * @param value Specified value
	 * @return The previous value associated with the specified key,or null if there was no mapping for the key
	 * 
	 */
	V put(K key,V value);
	/**
	 * Removes the mapping for this key
	 * @param key Specified key
	 * @return the previous value associated with the specified key, or null if there was no mapping
	 */
	V remove(Object key);
	/**
	 * Size of the table
	 * @return the size of the table
	 */
	int size();
}
