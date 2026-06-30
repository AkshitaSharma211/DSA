import java.util.*;
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    List<List<Integer>> q = new ArrayList<>();
    int old_color= image[sr][sc];

    if(old_color == color) return image;
    
    q.add(Arrays.asList(sr, sc));
    image[sr][sc] = color;




    while(!q.isEmpty()){

List<Integer> curr = q.remove(0);
int row=curr.get(0);
int col= curr.get(1);


int[] dr={-1,1,0,0};
int[] dc={0,0,-1,1};

for(int d=0;d<4 ; d++){

int nr= dr[d]+row;
int nc= dc[d]+col;
if(nc>=0 && nc< image[0].length && nr>=0 && nr< image.length && image[nr][nc]== old_color){


    image[nr][nc] = color;
q.add(Arrays.asList(nr, nc));
}
    }
    }
        return image;

}
public static void main(String[] args){
    Solution s = new Solution();
    int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
    int[][] result = s.floodFill(image, 1, 1, 2);
    for(int[] row : result){
        System.out.println(Arrays.toString(row));
    }
}
}