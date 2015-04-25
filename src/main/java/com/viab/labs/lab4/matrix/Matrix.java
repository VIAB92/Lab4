package com.viab.labs.lab4.matrix;

import com.viab.labs.lab4.exception.UnsupportedMatrixException;

import java.util.*;

/**
 * Created by Viktor on 25.04.2015.
 */
public class Matrix {
    //comment for fictive commit
    private int[][] matrix;

    public Matrix(int[][] matrix) throws UnsupportedMatrixException {
        boolean isMatrixSuitable = checkMatrix(matrix);
        if (!isMatrixSuitable){
            throw new UnsupportedMatrixException();
        }
        this.matrix = matrix;
    }

    private boolean checkMatrix(int[][] matrix) {
        int n = matrix.length;
        for (int i=0; i<n; i++){
            if (matrix[i].length!=n){
                return false;
            }
        }
        return true;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    private int getMaxElement(){
        int max = 1;
        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[i].length; j++)   {
                if (matrix[i][j]>max){
                    max=matrix[i][j];
                }
            }
        }
        return max;
    }

    private List<Integer> getColumnsWithMaxElement(int maxElement){
        Set<Integer> values = new HashSet<Integer>();
        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[i].length; j++){
                if (matrix[i][j]==maxElement){
                    values.add(j);
                }
            }
        }
        List<Integer> result = new ArrayList<Integer>();
        result.addAll(values);
        return result;
    }

    private int getMinElementAtMainAndAccidentalDiagonal(){
        int min = 1;
        for (int i =0; i<matrix.length; i++){
            if (matrix[i][i]<min ){
                min=matrix[i][i];
            }
            if (matrix[i][matrix.length+1-i]<min){
                min= matrix[i][matrix.length+1-i];
            }
        }
        return min;
    }

    private void changeElementsAtColumnsOnMinimum(List<Integer> columns, int minimum){
        for(Integer column:columns){
            for(int i=0; i<matrix.length; i++){
                matrix[i][column]=minimum;
            }
        }
    }

    public void processMatrix(){
        changeElementsAtColumnsOnMinimum(getColumnsWithMaxElement(getMaxElement()),getMinElementAtMainAndAccidentalDiagonal());
    }

    public void printArray(){
        System.out.println(Arrays.deepToString(matrix));
    }
}
