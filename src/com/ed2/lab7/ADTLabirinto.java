package com.ed2.lab7;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 201560015
 */
public interface ADTLabirinto {
    public void ADTLabirinto(int V);
    
    public void ADTLabirinto(In in);
    
    public void addEdge(int v, int w);
    
    public Iterable<Integer> adj(int v);
    
    public String toString();
    
    public int E();
    
    public int V();
    
    public void insereObjeto(int V);
    
    public void inserePessoa(int V);
    
    public int buscaCaminhoDFS(int P);
    
}
