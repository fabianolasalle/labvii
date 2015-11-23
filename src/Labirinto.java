
import java.util.ArrayList;


public class Labirinto implements ADTLabirinto{
    private static final String NEWLINE = System.getProperty("line.separator");

    private final int V;
    private int E;
    private ArrayList<Integer>[] adj;
    private int nodoPlayer;
    private int nodoItem;
    private boolean visited[];
    private StringBuilder caminhoItemPlayer;
    
    /**
     * Initializes an empty graph with <tt>V</tt> vertices and 0 edges.
     * param V the number of vertices
     *
     * @param  V number of vertices
     * @throws IllegalArgumentException if <tt>V</tt> < 0
     */
    public Labirinto(int V) {
        if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
        this.V = V;
        this.E = 0;
        adj = (ArrayList<Integer>[]) new ArrayList[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new ArrayList<Integer>();
        }
    }

    /**  
     * Initializes a graph from an input stream.
     * The format is the number of vertices <em>V</em>,
     * followed by the number of edges <em>E</em>,
     * followed by <em>E</em> pairs of vertices, with each entry separated by whitespace.
     *
     * @param  in the input stream
     * @throws IndexOutOfBoundsException if the endpoints of any edge are not in prescribed range
     * @throws IllegalArgumentException if the number of vertices or edges is negative
     */
    public Labirinto(In in) {
        this(in.readInt());
        int E = in.readInt();
        if (E < 0) throw new IllegalArgumentException("Number of edges must be nonnegative");
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    @Override
    public void ADTLabirinto(int V) {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ADTLabirinto(In in) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Returns the number of vertices in this graph.
     *
     * @return the number of vertices in this graph
     */
    public int V() {
        return V;
    }

    /**
     * Returns the number of edges in this graph.
     *
     * @return the number of edges in this graph
     */
    public int E() {
        return E;
    }

    // throw an IndexOutOfBoundsException unless 0 <= v < V
    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and " + (V-1));
    }

    /**
     * Adds the undirected edge v-w to this graph.
     *
     * @param  v one vertex in the edge
     * @param  w the other vertex in the edge
     * @throws IndexOutOfBoundsException unless both 0 <= v < V and 0 <= w < V
     */
    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        E++;
        adj[v].add(w);
        adj[w].add(v);
    }
 
    /**
     * Returns the vertices adjacent to vertex <tt>v</tt>.
     *
     * @param  v the vertex
     * @return the vertices adjacent to vertex <tt>v</tt>, as an iterable
     * @throws IndexOutOfBoundsException unless 0 <= v < V
     */
    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    /**
     * Returns the degree of vertex <tt>v</tt>.
     *
     * @param  v the vertex
     * @return the degree of vertex <tt>v</tt>
     * @throws IndexOutOfBoundsException unless 0 <= v < V
     */
    public int degree(int v) {
        validateVertex(v);
        return adj[v].size();
    }

    /**
     * Returns a string representation of this graph.
     *
     * @return the number of vertices <em>V</em>, followed by the number of edges <em>E</em>,
     *         followed by the <em>V</em> adjacency lists
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
    
    public String toStringNode(int V){
        StringBuilder s = new StringBuilder();
        for (int w : adj[V]) {
            s.append(w + " ");
        }
        return s.toString();
    }


    @Override
    public void insereObjeto(int V) {
        this.nodoItem = V;
    }

    @Override
    public void inserePessoa(int V) {
        this.nodoPlayer = V;
    }

    public String buscaCaminhoDFS(int P) {
        visited[P] = true;
        System.out.println(this.toStringNode(P));
                
        for (int j = 0; j < adj[P].size(); j++){          
            if (adj[P].get(j) == this.nodoItem){
                this.caminhoItemPlayer.append(" -> " + P);
                return String.valueOf(adj[P].get(j));
            }
            
            if (visited[adj[P].get(j)] == false){
                String caminho = this.buscaCaminhoDFS(adj[P].get(j));
                if (caminho != null){
                    this.caminhoItemPlayer.append(" -> " + caminho);
                }
                
            }
        }
        
        return null;
    }
    
    /*
    
    */
    public int getNodoItem(){
        return this.nodoItem;
    }
    
    public int getNodoPlayer(){
        return this.nodoPlayer;
    }

    /**
     * Unit tests the <tt>Graph</tt> data type.
     */
    public static void main(String[] args) {
        Labirinto L = new Labirinto(15);
        L.visited = new boolean[15];
        
        for(boolean w : L.visited){
            w = false;
        }
        
        L.caminhoItemPlayer = new StringBuilder();
        
        //L.addEdge(0, 1);
        L.addEdge(0, 2);
        //L.addEdge(0, 3);
        //L.addEdge(3, 6);
              
        //L.addEdge(4, 3);
        
        L.addEdge(5, 2);

        //L.addEdge(7, 8);
        //L.addEdge(7, 9);
        L.addEdge(7, 5);
        //L.addEdge(9, 10);
        //L.addEdge(10, 12);
        
       
        L.insereObjeto(7);
        L.inserePessoa(0);
        
        System.out.println(L);
        
        // System.out.println("Item está na posição: " + L.getNodoItem());
        // System.out.println("Player está na posição: " + L.getNodoPlayer());
        
        L.caminhoItemPlayer.append(L.nodoPlayer);
        L.buscaCaminhoDFS(L.nodoPlayer);
        
        System.out.println(L.caminhoItemPlayer.toString());
        
        
    }

}