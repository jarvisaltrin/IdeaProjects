/*
Write a program which tests if two rectangles have a nonempty intersection. If the intersection is nonempty,
return the rectangle formed by their intersection.

How can you check if two rectangles, not necessarily aligned with the X and Y axes, intersect?

Time Complexity - O(1), since the number of operations is constant.
 */

public class Rectangle {

    int x,y,width,height;

    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", height=" + height +
                '}';
    }

    public static Rectangle intersectRectangle(Rectangle R1, Rectangle R2){
        if(isIntersect(R1, R2)){
            return new Rectangle(0,0,-1,-1);
        }
        return new Rectangle(
                Math.max(R1.x, R2.x), Math.max(R1.y, R2.y),
                Math.min(R1.x + R1.width, R2.x + R2.width) - Math.max(R1.x, R2.x),
                Math.min(R1.y + R1.height, R2.y + R2.height) - Math.max(R1.y, R2.y)
        );
    }

    public static boolean isIntersect(Rectangle R1, Rectangle R2){
        return R1.x <= R2.x + R2.width && R1.x + R1.width >= R2.x
                && R1.y <= R2.y + R2.height && R1.y + R1.height >= R2.y;
    }

    public static void main(String[] args){
        Rectangle R1 = new Rectangle(1,2,3,4);
        Rectangle R2 = new Rectangle(5,3,2,4);

        System.out.println(intersectRectangle(R1, R2).toString());
    }
}
