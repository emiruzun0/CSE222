
/**
 * Search tree interface specifically for multidimensional trees
 * @author Emir
 */
public interface SearchTree<E> {
    boolean add(E item);
    boolean contains(E target);
    E find(E target);
    E delete(E target);
    boolean remove(E target);
}