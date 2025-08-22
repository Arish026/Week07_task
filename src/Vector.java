import java.util.Arrays;

public class Vector {

    private double[] components;
 public Vector(double[] components) {
        // Defensive copy to avoid aliasing
        this.components = Arrays.copyOf(components, components.length);
    }

 
    public int getDimension() {
        return components.length;   // n
    }

    public double getComponent(int i) {
        if (i < 0 || i >= components.length) {
            throw new IndexOutOfBoundsException("Invalid index for vector component.");
        }
        return components[i];
    }


    public double magnitude() {
        double sum = 0;
        for (double c : components) {
            sum += c * c;
        }
        return Math.sqrt(sum);
    }

    public Vector add(Vector v) {
        checkDimension(v);
        double[] result = new double[getDimension()];
        for (int i = 0; i < getDimension(); i++) {
            result[i] = this.components[i] + v.components[i];
        }
        return new Vector(result);
    }

    public Vector subtract(Vector v) {
        checkDimension(v);
        double[] result = new double[getDimension()];
        for (int i = 0; i < getDimension(); i++) {
            result[i] = this.components[i] - v.components[i];
        }
        return new Vector(result);
    }

    public double dot(Vector v) {
        checkDimension(v);
        double result = 0;
        for (int i = 0; i < getDimension(); i++) {
            result += this.components[i] * v.components[i];
        }
        return result;
    }

 
    private void checkDimension(Vector v) {
        if (this.getDimension() != v.getDimension()) {
            throw new IllegalArgumentException("Vectors must have same dimension.");
        }
    }

    @Override
    public String toString() {
        return "<" + Arrays.toString(components)
                .replace("[", "")
                .replace("]", "") + ">";
    }

  
    public static void main(String[] args) {
        Vector v2D = new Vector(new double[]{3, 4});
        Vector v3D = new Vector(new double[]{5, -2, 3});
        Vector v5D = new Vector(new double[]{1, 2, 3, 4, 5});

        System.out.println("v2D: " + v2D);                 // <3, 4>
        System.out.println("v2D magnitude: " + v2D.magnitude()); // 5.0
        System.out.println("v3D: " + v3D);                 // <5, -2, 3>
        System.out.println("v5D: " + v5D);                 // <1, 2, 3, 4, 5>

        Vector sum = v2D.add(new Vector(new double[]{1, 2}));
        System.out.println("Sum: " + sum);                 // <4, 6>

        double dotProduct = v3D.dot(new Vector(new double[]{2, 0, -1}));
        System.out.println("Dot product: " + dotProduct);  // 7
    }
}
