package com.ed2.lab7;

import java.io.BufferedReader;

public class Game {
    private Labirinto labirinto;
      
    // Cria um labirinto aleatorio
    private void createRandom(int size){
        this.labirinto = new Labirinto(size, true);
    }
    
    private void createByFile(In filename){
        this.labirinto = new Labirinto(filename);
    }
       
    // Define a posição do player
    private void setPlayerNode(int index){
        this.labirinto.inserePessoa(index);
    }
    
    // Define a posição do item
    private void setItemNode(int index){
        this.labirinto.insereObjeto(index);
    }
    
    // Retorna o caminho do player até o item
    private String getPathToItem(){
        return this.labirinto.showPathToItem();
    }
    
 
    
    public static void main(String[] args) {
        
        // Exemplo de teste com arquivo.
        Game g = new Game();
        g.createByFile(new In("teste.txt"));
        System.out.println(g.labirinto.toString());
        
        g.setPlayerNode(0);
        g.setItemNode(3);
        
        System.out.println(g.getPathToItem());
        
        // TODO: adicionar a interação com o usuário
        // com ele selecionando as opções, etc, etc.
    }
}