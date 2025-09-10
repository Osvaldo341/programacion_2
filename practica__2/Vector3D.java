package practica__2;
public class Vector3D {
    private double x;
    private double y;
    private double z;
    public Vector3D() {
        this(0, 0, 0);
    }
    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public double getX() { return x; }
    public double getY() { return y; }
    public double getZ() { return z; }
    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }
    public void setZ(double z) { this.z = z; }
    
    public Vector3D suma(Vector3D otro) {
        return new Vector3D(this.x + otro.x, this.y + otro.y, this.z + otro.z);
    }
    
    public Vector3D multiplicarEscalar(double escalar) {
        return new Vector3D(escalar * this.x, escalar * this.y, escalar * this.z);
    }
    
    public double magnitud() {
        return Math.sqrt(x*x + y*y + z*z);
    }
    
    public Vector3D normalizar() {
        double mag = magnitud();
        if (mag == 0) {
            return new Vector3D(0, 0, 0);
        }
        return new Vector3D(x/mag, y/mag, z/mag);
    }
    public double productoPunto(Vector3D otro) {
        return this.x * otro.x + this.y * otro.y + this.z * otro.z;
    }
    public Vector3D productoCruz(Vector3D otro) {
        double nuevoX = this.y * otro.z - this.z * otro.y;
        double nuevoY = this.z * otro.x - this.x * otro.z;
        double nuevoZ = this.x * otro.y - this.y * otro.x;
        return new Vector3D(nuevoX, nuevoY, nuevoZ);
    }
    
    public boolean esPerpendicular(Vector3D otro) {
        return Math.abs(productoPunto(otro)) < 1e-10;
    }
    
    public boolean esParalelo(Vector3D otro) {
        Vector3D cruz = productoCruz(otro);
        return cruz.magnitud() < 1e-10;
    }
    public Vector3D proyeccion(Vector3D otro) {
        double productoPunto = productoPunto(otro);
        double magnitudCuadrada = otro.magnitud() * otro.magnitud();
        
        if (magnitudCuadrada == 0) {
            return new Vector3D(0, 0, 0);
        }
        
        double factor = productoPunto / magnitudCuadrada;
        return otro.multiplicarEscalar(factor);
    }
    public double componente(Vector3D otro) {
        double productoPunto = productoPunto(otro);
        double magnitud = otro.magnitud();
        
        if (magnitud == 0) {
            return 0;
        }
        
        return productoPunto / magnitud;
    }
    public Vector3D add(Vector3D otro) {
        return this.suma(otro);
    }
    public Vector3D subtract(Vector3D otro) {
        return new Vector3D(this.x - otro.x, this.y - otro.y, this.z - otro.z);
    }
    
    public Vector3D multiply(double escalar) {
        return this.multiplicarEscalar(escalar);
    }
    public double multiply(Vector3D otro) {
        return this.productoPunto(otro);
    }
    
    public boolean equals(Vector3D otro) {
        if (this == otro) return true;
        if (otro == null) return false;
        
        return Math.abs(this.x - otro.x) < 1e-10 &&
               Math.abs(this.y - otro.y) < 1e-10 &&
               Math.abs(this.z - otro.z) < 1e-10;
    }
    
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vector3D vector3D = (Vector3D) obj;
        return equals(vector3D);
    }
    public String toString() {
        return String.format("(%.2f, %.2f, %.2f)", x, y, z);
    }
    
    public static void main(String[] args) {
        Vector3D a = new Vector3D(1, 2, 3);
        Vector3D b = new Vector3D(4, 5, 6);
        Vector3D c = new Vector3D(0, 1, 0);
        Vector3D d = new Vector3D(1, 0, 0);
        
        System.out.println("Vector a: " + a);
        System.out.println("Vector b: " + b);
        System.out.println("Vector c: " + c);
        System.out.println("Vector d: " + d);
        
        System.out.println("\n=== OPERACIONES BÁSICAS ===");
        System.out.println("a + b = " + a.add(b));
        System.out.println("a - b = " + a.subtract(b));
        System.out.println("2 * a = " + a.multiply(2));
        System.out.println("a · b = " + a.multiply(b));
        System.out.println("a × b = " + a.productoCruz(b));
        
        System.out.println("\n=== PROPIEDADES VECTORIALES ===");
        System.out.println("|a| = " + a.magnitud());
        System.out.println("Normal de a: " + a.normalizar());
        
        System.out.println("\n=== RELACIONES GEOMÉTRICAS ===");
        System.out.println("¿a es perpendicular a b? " + a.esPerpendicular(b));
        System.out.println("¿c es perpendicular a d? " + c.esPerpendicular(d));
        System.out.println("¿a es paralelo a b? " + a.esParalelo(b));
        
        Vector3D e = new Vector3D(3, 4, 0);
        Vector3D f = new Vector3D(1, 0, 0);
        
        System.out.println("\n=== PROYECCIÓN Y COMPONENTE ===");
        System.out.println("Proyección de e sobre f: " + e.proyeccion(f));
        System.out.println("Componente de e en f: " + e.componente(f));
        
        Vector3D paralelo1 = new Vector3D(2, 4, 6);
        Vector3D paralelo2 = new Vector3D(1, 2, 3);
        Vector3D perpendicular1 = new Vector3D(1, 0, 0);
        Vector3D perpendicular2 = new Vector3D(0, 1, 0);
        
        System.out.println("\n=== VECTORES DE PRUEBA ===");
        System.out.println("¿paralelo1 es paralelo a paralelo2? " + paralelo1.esParalelo(paralelo2));
        System.out.println("¿perpendicular1 es perpendicular a perpendicular2? " + 
                          perpendicular1.esPerpendicular(perpendicular2));
    }
}

