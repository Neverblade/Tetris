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
public class Z extends Tetrimino {
    
    public Z(int x, int y, int dir, int[][] grid)
    {
        super(x, y, dir, grid);
        
        ArrayList<Integer> zhX = new ArrayList<Integer>();
        ArrayList<Integer> zhY = new ArrayList<Integer>();
        zhX.add(-1);
        zhY.add(0);
        zhX.add(0);
        zhY.add(0);
        zhX.add(0);
        zhY.add(1);
        zhX.add(1);
        zhY.add(1);
        getXShape().add(zhX);
        getYShape().add(zhY);
        
        ArrayList<Integer> zvX = new ArrayList<Integer>();
        ArrayList<Integer> zvY = new ArrayList<Integer>();
        zvX.add(1);
        zvY.add(-1);
        zvX.add(0);
        zvY.add(0);
        zvX.add(1);
        zvY.add(0);
        zvX.add(0);
        zvY.add(1);
        getXShape().add(zvX);
        getYShape().add(zvY);
        
        updatePos();
    }
    
    public int returnType()
    {
        return 3;
    } 
}