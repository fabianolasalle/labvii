/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ed2.lab7.tests;

import org.junit.Test;

import com.ed2.lab7.Labirinto;

import static org.junit.Assert.*;

/**
 *
 * @author Fabiano
 */
public class LabirintoTest {
    Labirinto l = new Labirinto(15, true);

    @Test
    public void testSize() {
        assertEquals(l.V(), 15);
    }
    
    
    
}
