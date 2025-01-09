class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
       int Xn =Math.max(x1 , Math.min(xCenter , x2));
       int Yn = Math.max(y1 , Math.min(yCenter , y2)); 

       int X = (xCenter - Xn) * (xCenter - Xn);
       int Y = (yCenter - Yn) * (yCenter - Yn);
       int Distance = X + Y;
       if(Distance <= radius*radius){
        return true;
       }else{
        return false;
       }   
    }
}