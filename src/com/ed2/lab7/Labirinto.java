package com.ed2.lab7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

import unused.In;


public class Labirinto implements ADTLabirinto{
    private static final String NEWLINE = System.getProperty("line.separator");

    private final int V;
    private int E;
    private ArrayList<Integer>[] adj;
    private int nodoPlayer;
    private int nodoItem;
    private boolean visited[];
    private LinkedList<Integer> path;
    
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
        
        this.visited = new boolean[V];
        for(boolean w : this.visited){
            w = false;
        }
        this.path = new LinkedList<Integer>();
    }
    
    public Labirinto(int V, boolean random){
        this(V);
        int randomVertices = ThreadLocalRandom.current().nextInt(0, 2 + 1);
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

    /**
     * Busca recursivamente com Depth-first search pelo nodo do item, 
     * a partir do parametro pontoPartidaBusca.
     * 
     * Como recursiva, considerar que a nomenclatura da variável
     * é dada para indicar que a partir daquele nodo, haverá uma
     * navegação aos vértices filho que não foram navegados ainda.
     */
    public int buscaCaminhoDFS(int pontoPartidaBusca) {
    	/**
    	 * Um array auxiliar é utilizado para marcar quais
    	 * nodos foram visitados. Ao início
    	 */
        visited[pontoPartidaBusca] = true;
                
        /**
         * Loop para navegar entre os vertices do nodo indicado
         * por pontoPartidaBusca.
         */
        for (int j = 0; j < adj[pontoPartidaBusca].size(); j++){   
        	
        	// Se o filho do nodo pontoPartidaBusca é o mesmo 
        	// nodo em que se encontra o nodoItem, então retornamos
        	// pois achamos um caminho até nodoItem
            if (adj[pontoPartidaBusca].get(j) == this.nodoItem){
            	return pontoPartidaBusca;
            }
            
            // Se o nodo filho ainda não foi visitado, recursivamente,
            // vamos visitar o filho, como dita o DFS.
            if (visited[adj[pontoPartidaBusca].get(j)] == false){
            	// Como retorno, espero o ponto que enviei por parâmetro
            	// para manter registro de onde eu passei com sucesso
            	// para buscar o item.
                int caminho = this.buscaCaminhoDFS(adj[pontoPartidaBusca].get(j));
                
                // Se o retorno foi um indice válido, então
                // alimento o LinkedList com o caminho.
                // e retorno o próprio pontoPartida para que a chamada anterior
                // possa ter registro de onde passou.
                if (caminho != -1){
                	this.path.add(caminho);
                	return pontoPartidaBusca;
                }                
            }
        }
        
        // Se eu não achei depois de iterar por todos os vértices filho do meu nodo
        // então retorno -1 para indicar que ali não é caminho. (╯°□°)╯︵ ┻�?┻
        return -1;
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
        L.path = new LinkedList<Integer>();

        for(boolean w : L.visited){
            w = false;
        }
        
        // Cria o grafo.
        L.addEdge(0, 2);
        L.addEdge(4, 3);
        L.addEdge(5, 2);
        L.addEdge(7, 4);
        L.addEdge(7, 5);
        L.addEdge(9, 7);
        L.addEdge(10, 9);
        
        // Insere o objeto e a pessoa.
        L.insereObjeto(7);
        L.inserePessoa(0);
        
        // Debug
        System.out.println(L);
        System.out.println("Item está na posição: " + L.getNodoItem());
        System.out.println("Player está na posição: " + L.getNodoPlayer());
        
        // Como é uma lista e a minha busca vai retornando do
        // caminho mais profundo até o mais próximo do player,
        // adiciono primeiro o nodo final.
        L.path.add(L.nodoItem);
        
        // Inicia a busca! ◉‿◉
        L.buscaCaminhoDFS(L.nodoPlayer);
        
        // Agora que percorremos de trás para frente
        // basta adicionar o nodo do player, que é o nodo
        // inicial.
        L.path.add(L.nodoPlayer);
        
        // Vamos percorrer invertidamente para ter o caminho
        // do inicio ao fim!
        StringBuilder finalpath = new StringBuilder();
        for(int i = (L.path.size() - 1); i >= 0; i--){
        	finalpath.append(L.path.get(i));
        	if (i > 0){
        		finalpath.append(" -> ");
        	}
        }
        
        System.out.println(finalpath.toString());
        
    }

}