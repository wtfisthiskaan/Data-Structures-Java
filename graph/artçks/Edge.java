/** An Edge represents a relationship between two
 *  vertices.
 *  @author Koffman and Wolfgang
*/

public class Edge {
  /**** BEGIN EXERCISE ****/
  // Data Fields
  /** The source vertix */
  private int source;

  /** The destination vertix */
  private int dest;

  /** The weight */
  private double weight;

  /** The time */
  private int time;

  /** The quality */
  private float quality;

  public int edgetype;

  // Constructor
  /** Construct an Edge with a source of from
      and a destination of to. Set the weight
      to 1.0.
      @param source - The source vertix
      @param dest - The destination vertix
   */
  public Edge(int source, int dest) {
    this.source = source;
    this.dest = dest;
    weight = 1.0;
    time = 1;
    quality = 1.0f;
  }

  /** Construct a weighted edge with a source
      of from and a destination of to. Set the
      weight to w.
      @param source - The source vertix
      @param dest - The destination vertix
      @param w - The weight
   */
  public Edge(int source, int dest, double w) {
    this.source = source;
    this.dest = dest;
    weight = w;
    time = 1;
    quality = 1.0f;
    edgetype = 0;
  }

  /** Construct a timed edge with a source
      of from and a destination of to. Set the
      time to t.
      @param source - The source vertix
      @param dest - The destination vertix
      @param t - The time
   */
  public Edge(int source, int dest, int t) {
    this.source = source;
    this.dest = dest;
    weight = 1.0;
    time = t;
    quality = 1.0f;
    edgetype = 1;

  }

    /** Construct a qualitied edge with a source
      of from and a destination of to. Set the
      quality to q.
      @param source - The source vertix
      @param dest - The destination vertix
      @param q - The quality
   */
  public Edge(int source, int dest, float q) {
    this.source = source;
    this.dest = dest;
    this.weight = 1.0;
    this.time = 1;
    this.quality = q;
    this.edgetype = 2;

  }

  // Methods
  /** Get the source
      @return The value of source
   */
  public int getSource() {
    return source;
  }

  /** Get the destination
      @return The value of dest
   */
  public int getDest() {
    return dest;
  }

  /** Get the weight
      @return the value of weight
   */
  public double getWeight() {
    return weight;
  }

  /** Get the time
    @return the value of weight
   */
  public int getTime() {
    return time;
  }

   /** Get the quality
    @return the value of weight
   */
  public float getQuality() {
    return quality;
  }

  /** Return a String representation of the edge
      @return A String representation of the edge
   */
  public String toString() {
    StringBuffer sb = new StringBuffer("[(");
    sb.append(Integer.toString(source));
    sb.append(", ");
    sb.append(Integer.toString(dest));
    sb.append("): ");
    sb.append(Double.toString(weight));
    sb.append(", ");
    sb.append(Integer.toString(time));
    sb.append(", ");
    sb.append(Float.toString(quality));
    sb.append("]");
    return sb.toString();
  }

  /** Return true if two edges are equal. Edges
      are equal if the source and destination
      are equal. Weight is not conidered.
      @param obj The object to compare to
      @return true if the edges have the same source
      and destination
   */
  public boolean equals(Object obj) {
    if (obj instanceof Edge) {
      Edge edge = (Edge) obj;
      return (source == edge.source
              && dest == edge.dest);
    }
    else {
      return false;
    }
  }

  /** Return a hash code for an edge.  The hash
      code is the source shifted left 16 bits
      exclusive or with the dest
      @return a hash code for an edge
   */
  public int hashCode() {
    return (source << 16) ^ dest;
  }

  /**** END EXERCISE ****/
}
