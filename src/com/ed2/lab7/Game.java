package com.ed2.lab7;

import java.io.BufferedReader;
import java.util.InputMismatchException;

public class Game {
    private Labirinto labirinto;
          
    public void createRandom(int size){
        this.labirinto = new Labirinto(size, true);
    }
    
    public void createByFile(In filename){
        this.labirinto = new Labirinto(filename);
    }
       
    // Define a posição do player
    public void setPlayerNode(int index){
        this.labirinto.inserePessoa(index);
    }
    
    // Define a posição do item
    public void setItemNode(int index){
        this.labirinto.insereObjeto(index);
    }
    
    public boolean hasItemNodeSet(){
        return this.labirinto.getNodoItem() != null;
    }
    
    public boolean hasPlayerNodeSet(){
        return this.labirinto.getNodoPlayer() != null;
    }
    
    public int getMazeSize(){
        return this.labirinto.V();
    }
    
    
    // Retorna o caminho do player até o item
    public String getPathToItem(){
        return this.labirinto.showPathToItem();
    }
    
    public String getMaze(){
        return this.labirinto.toString();
    }
    
    /*
    public String showMenu(){
        System.out.println("1 - Criar labirinto a partir de arquivo");
        System.out.println("2 - Criar labirinto aleatório");
        System.out.println("3 - Inserir jogador no labirinto");
        System.out.println("4 - Inserir item no labirinto");
        System.out.println("5 - Exibir caminho até o item");
        System.out.println("6 - Sair");
        System.out.println("----------------------------------------");
        System.out.print("Digite uma opção: ");

        return StdIn.readString();
   }
    
    public void menuCore(String option){
        String option = this.showMenu();
        
        switch (option){
            case "1":
                System.out.println("Opção não implementada.");
                break;
            case "2":
                this.createRandom();
                break;
            case "3":
                System.out.println("Opção não implementada.");
                break;
            case "4":
                System.out.println("Opção não implementada.");
                break;
            case "5":
                System.out.println("Opção não implementada.");
                break;
            case "6":
                System.out.println("Opção não implementada.");
                break;
            default:
                System.out.println("Opção inválida.");
                this.showMenu();
                break;
        }
    }*/
    
 
    
    public static void main(String[] args) {        
        // Exemplo de teste com arquivo.
        Game g = new Game();
        
        /*g.createByFile(new In("teste.txt"));
        System.out.println(g.labirinto.toString());
        
        g.setPlayerNode(0);
        g.setItemNode(3);
        
        System.out.println(g.getPathToItem());*/
        //String option = g.showMenu();
        
        
        
        
        // TODO: adicionar a interação com o usuário
        // com ele selecionando as opções, etc, etc.
    }
}