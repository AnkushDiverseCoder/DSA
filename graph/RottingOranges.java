package graph;

import java.util.LinkedList;
import java.util.Queue;

class RottingOranges {

    class Pair{
        int i;
        int j;
        int tm;
        Pair(int i, int j,int tm) {
            this.i=i;
            this.j=j;
            this.tm=tm;
        }
    }

    int orangesRotting(int[][] grid) {
       // Code Here 
       int n = grid.length;
       int m = grid[0].length;
       // Queue
       Queue<Pair> q = new LinkedList<>();
        int cntFresh = 0;
       // n*m
       int[][] vis = new int[n][m];
       for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[0].length; j++) {
            if(grid[i][j]==2){
                q.add(new Pair(i, j, 0));
                vis[i][j]=2;
            }else{
                vis[i][j]=0;
            }
            if(grid[i][j] == 1) cntFresh++;
        }
       }

       int tm =0;
       int delRow[]={-1,0,1,0};
       int delCol[]={0,1,0,-1};
       while(q.isEmpty()){
        int r = q.peek().i;
        int c = q.peek().j;
        int t = q.peek().tm;
        q.remove();
        for (int i = 0; i < delCol.length; i++) {
         int nrow= r+ delRow[i];
         int ncol = c+ delCol[i];
         if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol] != 2 && ){

         }       
        }
       }

    }

    public void main(String[] args) {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(orangesRotting(grid));
    }
}
