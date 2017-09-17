package com.api.geometry;
import java.util.Scanner;
public class CircleLatticePoints {

    public static final int maxRadius = 100;
    public int squares[];

    public CircleLatticePoints(){
        squares = new int[maxRadius+1];
        for(int i=0;i<=maxRadius;i++){
            squares[i] = i*i;
        }
    }
    public static void main(String args[]) throws Exception{

        Scanner scanner = new Scanner(System.in);
        CircleLatticePoints latticePoints = new CircleLatticePoints();
        int testcases = scanner.nextInt();
        int radii[] = new int[testcases];
        int latticeCount[] = new int[testcases];
        for(int i=0;i<testcases;i++){
            radii[i] = scanner.nextInt();
            latticeCount[i] = latticePoints.getCountOfLatticePoints(radii[i]);
        }
        for(int j=0;j<testcases;j++)
            System.out.println(latticeCount[j]);
    }

    public int getCountOfLatticePoints(int radius) throws Exception{
        if(radius<0 || radius>maxRadius) throw new Exception();
        int radiusSquare = radius * radius;
        int latticePointsCount = 4;
        if(radius==0) return 1;
        if(radius==1) return latticePointsCount;
        int tripletsCount = 0;
        int start = 1;
        int end = radius-1;
        int currentSum = 0;
        while(start<=end){
            currentSum = squares[start] + squares[end];
            if (currentSum==radiusSquare){
                tripletsCount++;
                start++;
                end--;
            } else if(currentSum<radiusSquare)
                start++;
            else end--;
        }
        latticePointsCount = latticePointsCount + (tripletsCount * 8);
        return latticePointsCount;
    }
}
