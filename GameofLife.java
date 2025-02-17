// Time Complexity : O(N*M)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode  : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

public class GameofLife {
    

    static int m,n;
    public void gameOfLife(int[][] board) {
        
        if(board==null || board[0].length==0)
        {
            return;
        }
        
         m = board.length;
         n = board[0].length;
        
        
        
        for(int i =0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                int countLiveCells = getCount(board,i,j);
                
                if(board[i][j]==1)
                {
                    if(countLiveCells<2 || countLiveCells>3)
                    {
                        board[i][j]=2;
                    }
                }
                else
                {
                    if(countLiveCells==3)
                    {
                        board[i][j]=3;
                    }
                }
            }
        }
        
        for(int i =0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]==2)
                {
                    board[i][j]=0;
                }
                else if(board[i][j]==3)
                {
                    board[i][j]=1;
                }
            }
        }
    }
    
    
    private static int getCount(int[][] board,int r,int c)
    {
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,-1},{-1,1},{1,-1}};
        
        int total = 0;
        
        for(int[] dir: dirs)
        {
            int nr = r + dir[0];
            int nc = c + dir[1];
            
            if(nr>=0 && nr<m && nc>=0 && nc<n && (board[nr][nc] == 1 || board[nr][nc]==2))
               {
                   total++;
               }
               
        
        }
        return total;
    }

}
