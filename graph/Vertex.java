/** An Vertex represents vertices.
 *  @author Omer Kaan Uslu
*/
import java.util.*;
public class Vertex<E> {
    E value;
    int index;
    String label;
    double weight;
    Map<String,String> infoMap = new HashMap<>();
    /**Base constructor
     * */
    public Vertex(){}
     /**Constructor with properties.
      * @param label is label of vertex.
      * @param weight is weight of vertex.
     * */
    public Vertex(String label,double weight){
        this.label=label;
        this.weight=weight;
    }
    /**Constructor with properties.
      * @param index is index of vertex.
      * @param label is label of vertex.
      * @param weight is weight of vertex.
     * */
    public Vertex(int index,String label,double weight){
        this.index=index;
        this.label=label;
        this.weight=weight;
    }
    /**setValue function.
      * @param value is value.
     * */
    public void setValue(E value){this.value=value;}
        /**addInfo function.
      * @param key is key.
      * @param value is value.
     * */
    public void addInfo(String key,String value){
        infoMap.put(key,value);
    }
        /**addInfo function.
      * @param label is key.
      * @param filter is value.
     * */
    public void replace(String label,String filter){
        this.infoMap.replace(label,filter);
    }
    /**printInfoMap prints infoMap HashMap.
     * */
    public void printInfoMap(){
        for (String name: infoMap.keySet()) {
            String key = name.toString();
            String value = infoMap.get(name).toString();
            System.out.println(index+":   "+key + " = " + value);
        }
    }

}