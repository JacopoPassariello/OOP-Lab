import java.awt.Rectangle;

public class Main {
    public static void main(String[] args) {
        int x = 0;
        int y = 0;
        int width = 10;
        int height = 20;

        int newX = 5;
        int newY = 5;

        double area;
        double perimeter;

        Rectangle box;
        box = new Rectangle(x,y,width,height);
        System.out.println(box);
        box.setLocation(newX,newY);

        Rectangle box1, box2, box3;

        box1 = new Rectangle(newX+box.width,newY,width,height);
        box.add(box1);
        box2 = new Rectangle(box.x+box.width,newY,width,height);
        box.add(box2);
        box3 = new Rectangle(box.x+box.width,newY,width,height);
        box.add(box3);

        double larghezza = box.getWidth();
        double lunghezza = box.getHeight();

        area= larghezza * lunghezza;
        perimeter= (larghezza + lunghezza) * 2;



        System.out.println(box);
        System.out.println (area);
        System.out.println (perimeter);

    }
}