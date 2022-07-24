/** Represents an KWHashMap interface.
 * @author Koffman
 * @version 1.0
 * @since 1.0
*/
interface KWHashMap<K extends Comparable<K>,V extends Comparable<V>> {
  /** Get Function.
  * @param key is key of corresponding value.
  * @return value of parameter key.
  */
  V get (K key);
  /** isEmpty Function.
  * @return true or false in cases map is empty or not.
  */
  boolean isEmpty();   
  /** put Function.
  * @param key is key to be added.
  * @param value is value of key.
  * @return oldValue if exists. otherwise null.
  */
  V put( K key, V value);
/** remove Function.
  * @param key is key of value to be remove.
  * @return value of parameter key.
  */
  V remove(K key);
  /** size Function.
  * @return size of hashmap.
  */
  int size();

}