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
public class S extends Tetrimino {
    
    public S(int x, int y, int dir, int[][] grid)
    {
        super(x, y, dir, grid);
        
        ArrayList<Integer> shX = new ArrayList<Integer>();
        ArrayList<Integer> shY = new ArrayList<Integer>();
        shX.add(0);
        shY.add(0);
        shX.add(1);
        shY.add(0);
        shX.add(-1);
        shY.add(1);
        shX.add(0);
        shY.add(1);
        getXShape().add(shX);
        getYShape().add(shY);
        
        ArrayList<Integer> svX = new ArrayList<Integer>();
        ArrayList<Integer> svY = new ArrayList<Integer>();
        svX.add(0);
        svY.add(-1);
        svX.add(0);
        svY.add(0);
        svX.add(1);
        svY.add(0);
        svX.add(1);
        svY.add(1);
        getXShape().add(svX);
        getYShape().add(svY);
        
        updatePos();
    }
    
    public int returnType()
    {
        return 5;
    } 
}