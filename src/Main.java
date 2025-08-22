public class Main {
    public static void main(String[] args) {
     
        Vector v2D = new Vector(new double[]{3, 4});
        Vector v3D = new Vector(new double[]{5, -2, 3});
        Vector vND = new Vector(new double[]{1, 2, 3, 4, 5});

        System.out.println("2D Vector: " + v2D);   // <3, 4>
        System.out.println("3D Vector: " + v3D);   // <5, -2, 3>
        System.out.println("nD Vector: " + vND);   // <1, 2, 3, 4, 5>

        System.out.println("Magnitude of v2D: " + v2D.magnitude()); // 5.0

        Vector sum = v2D.add(new Vector(new double[]{1, 2}));
        System.out.println("Sum of <3,4> and <1,2>: " + sum);       // <4, 6>

        Vector diff = v3D.subtract(new Vector(new double[]{2, 1, -1}));
        System.out.println("Difference: " + diff);                  // <3, -3, 4>

        double dot = v3D.dot(new Vector(new double[]{2, 0, -1}));
        System.out.println("Dot product of v3D with <2,0,-1>: " + dot); // 7
    }
}
