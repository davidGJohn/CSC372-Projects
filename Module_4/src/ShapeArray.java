public class ShapeArray {
    public static void main(String[] args) {
        Shape[] shapeArray = {
            new Sphere(5),
            new Cylinder(3, 7),
            new Cone(4, 6)
        };
        System.out.print("\n");
        for (Shape shape : shapeArray) {
            System.out.println(shape);
        }
    }
}

