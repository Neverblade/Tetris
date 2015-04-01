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
public class T extends Tetrimino {
    
    public T(int x, int y, int dir, int[][] grid)
    {
        super(x, y, dir, grid);
        
        //add Iv
        ArrayList<Integer> tuX = new ArrayList<Integer>();
        ArrayList<Integer> tuY = new ArrayList<Integer>();
        tuX.add(0);
        tuY.add(-1);
        tuX.add(-1);
        tuY.add(0);
        tuX.add(0);
        tuY.add(0);
        tuX.add(1);
        tuY.add(0);
        getXShape().add(tuX);
        getYShape().add(tuY);

        //add Ih
        ArrayList<Integer> trX = new ArrayList<Integer>();
        ArrayList<Integer> trY = new ArrayList<Integer>();
        trX.add(0);
        trY.add(-1);
        trX.add(0);
        trY.add(0);
        trX.add(1);
        trY.add(0);
        trX.add(0);
        trY.add(1);
        getXShape().add(trX);
        getYShape().add(trY);
        
        ArrayList<Integer> tdX = new ArrayList<Integer>();
        ArrayList<Integer> tdY = new ArrayList<Integer>();
        tdX.add(-1);
        tdY.add(0);
        tdX.add(0);
        tdY.add(0);
        tdX.add(1);
        tdY.add(0);
        tdX.add(0);
        tdY.add(1);
        getXShape().add(tdX);
        getYShape().add(tdY);
        
        ArrayList<Integer> tlX = new ArrayList<Integer>();
        ArrayList<Integer> tlY = new ArrayList<Integer>();
        tlX.add(0);
        tlY.add(-1);
        tlX.add(-1);
        tlY.add(0);
        tlX.add(0);
        tlY.add(0);
        tlX.add(0);
        tlY.add(1);
        getXShape().add(tlX);
        getYShape().add(tlY);
        
        updatePos();
    }
    
    public int returnType()
    {
        return 1;
    } 
}