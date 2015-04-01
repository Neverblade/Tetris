/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 *
 * @author James
 */
public class J extends Tetrimino {
    
    public J(int x, int y, int dir, int[][] grid)
    {
        super(x, y, dir, grid);
        
        ArrayList<Integer> jlX = new ArrayList<Integer>();
        ArrayList<Integer> jlY = new ArrayList<Integer>();
        jlX.add(0);
        jlY.add(-1);
        jlX.add(0);
        jlY.add(0);
        jlX.add(-1);
        jlY.add(1);
        jlX.add(0);
        jlY.add(1);
        getXShape().add(jlX);
        getYShape().add(jlY);
        
        ArrayList<Integer> juX = new ArrayList<Integer>();
        ArrayList<Integer> juY = new ArrayList<Integer>();
        juX.add(-1);
        juY.add(-1);
        juX.add(-1);
        juY.add(0);
        juX.add(0);
        juY.add(0);
        juX.add(1);
        juY.add(0);
        getXShape().add(juX);
        getYShape().add(juY);
        
        ArrayList<Integer> jrX = new ArrayList<Integer>();
        ArrayList<Integer> jrY = new ArrayList<Integer>();
        jrX.add(0);
        jrY.add(-1);
        jrX.add(1);
        jrY.add(-1);
        jrX.add(0);
        jrY.add(0);
        jrX.add(0);
        jrY.add(1);
        getXShape().add(jrX);
        getYShape().add(jrY);
        
        ArrayList<Integer> jdX = new ArrayList<Integer>();
        ArrayList<Integer> jdY = new ArrayList<Integer>();
        jdX.add(-1);
        jdY.add(0);
        jdX.add(0);
        jdY.add(0);
        jdX.add(1);
        jdY.add(0);
        jdX.add(1);
        jdY.add(1);
        getXShape().add(jdX);
        getYShape().add(jdY);
        
        updatePos();
    }
    
    public int returnType()
    {
        return 2;
    }    
}