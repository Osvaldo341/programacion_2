package practica__2;

public class AlgebraVectorial{
    private double x;
    private double y;
    private double z;
    
    public AlgebraVectorial() {
        this(0, 0, 0);
    }
      public AlgebraVectorial(double x, double y) {
        this(x, y, 0);
    }
    public AlgebraVectorial(double x, double y, double z) {
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
    
    public double magnitud() {
        return Math.sqrt(x*x + y*y + z*z);
    }
    
    public double productoPunto(AlgebraVectorial otro) {
        return this.x * otro.x + this.y * otro.y + this.z * otro.z;
    }
    
    public AlgebraVectorial productoCruz(AlgebraVectorial otro) {
        double nuevoX = this.y * otro.z - this.z * otro.y;
        double nuevoY = this.z * otro.x - this.x * otro.z;
        double nuevoZ = this.x * otro.y - this.y * otro.x;
        return new AlgebraVectorial(nuevoX, nuevoY, nuevoZ);
    }
    public boolean esPerpendicular(AlgebraVectorial b) {
        return productoPunto(b) == 0;
    }
    public boolean esPerpendicular(AlgebraVectorial b, int metodo) {
        switch (metodo) {
            case 1: // |a + b| = |a - b|
                AlgebraVectorial suma1 = new AlgebraVectorial(this.x + b.x, this.y + b.y, this.z + b.z);
                AlgebraVectorial resta1 = new AlgebraVectorial(this.x - b.x, this.y - b.y, this.z - b.z);
                return Math.abs(suma1.magnitud() - resta1.magnitud()) < 1e-10;
                
            case 2: // |a - b| = |b - a|
                AlgebraVectorial resta2a = new AlgebraVectorial(this.x - b.x, this.y - b.y, this.z - b.z);
                AlgebraVectorial resta2b = new AlgebraVectorial(b.x - this.x, b.y - this.y, b.z - this.z);
                return Math.abs(resta2a.magnitud() - resta2b.magnitud()) < 1e-10;
                
            case 3: // a · b = 0
                return productoPunto(b) == 0;
                
            case 4: // |a + b|² = |a|² + |b|²
                AlgebraVectorial suma4 = new AlgebraVectorial(this.x + b.x, this.y + b.y, this.z + b.z);
                double ladoIzq = Math.pow(suma4.magnitud(), 2);
                double ladoDer = Math.pow(this.magnitud(), 2) + Math.pow(b.magnitud(), 2);
                return Math.abs(ladoIzq - ladoDer) < 1e-10;
                
            default:
                return productoPunto(b) == 0;
        }
    }
    
    public boolean esParalelo(AlgebraVectorial b) {
        AlgebraVectorial cruz = productoCruz(b);
        return cruz.magnitud() == 0;
    }
    
    public boolean esParalelo(AlgebraVectorial b, int metodo) {
        switch (metodo) {
            case 1: // a = r*b (existe escalar r)
                if (b.magnitud() == 0) return this.magnitud() == 0;
                
                double r = 0;
                if (b.x != 0) r = this.x / b.x;
                else if (b.y != 0) r = this.y / b.y;
                else if (b.z != 0) r = this.z / b.z;
                else return this.magnitud() == 0;
                

                boolean propX = Math.abs(this.x - r * b.x) < 1e-10;
                boolean propY = Math.abs(this.y - r * b.y) < 1e-10;
                boolean propZ = Math.abs(this.z - r * b.z) < 1e-10;
                
                return propX && propY && propZ;
                
            case 2: // a × b = 0
                AlgebraVectorial cruz = productoCruz(b);
                return cruz.magnitud() < 1e-10;
                
            default:
                return esParalelo(b);
        }
    }
    
    public AlgebraVectorial proyeccion(AlgebraVectorial b) {
        double productoPunto = productoPunto(b);
        double magnitudBCuadrada = Math.pow(b.magnitud(), 2);
        
        if (magnitudBCuadrada == 0) {
            return new AlgebraVectorial(0, 0, 0);
        }
        
        double factor = productoPunto / magnitudBCuadrada;
        return new AlgebraVectorial(
            factor * b.x,
            factor * b.y,
            factor * b.z
        );
    }
    
    public double componente(AlgebraVectorial b) {
        double productoPunto = productoPunto(b);
        double magnitudB = b.magnitud();
        
        if (magnitudB == 0) {
            return 0;
        }
        
        return productoPunto / magnitudB;
    }
    
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
    public static void main(String[] args) {
        AlgebraVectorial a = new AlgebraVectorial(1, 0, 0);
        AlgebraVectorial b = new AlgebraVectorial(0, 1, 0);
        
        System.out.println("Vector a: " + a);
        System.out.println("Vector b: " + b);
        
        System.out.println("\n¿Son perpendiculares?");
        System.out.println("Método 1: " + a.esPerpendicular(b, 1));
        System.out.println("Método 2: " + a.esPerpendicular(b, 2));
        System.out.println("Método 3: " + a.esPerpendicular(b, 3));
        System.out.println("Método 4: " + a.esPerpendicular(b, 4));
        
        AlgebraVectorial c = new AlgebraVectorial(2, 0, 0);
        System.out.println("\nVector c: " + c);
        System.out.println("¿Son paralelos a y c?");
        System.out.println("Método 1: " + a.esParalelo(c, 1));
        System.out.println("Método 2: " + a.esParalelo(c, 2));
        
        AlgebraVectorial d = new AlgebraVectorial(3, 4, 0);
        AlgebraVectorial e = new AlgebraVectorial(1, 0, 0);
        
        System.out.println("\nProyección de d sobre e: " + d.proyeccion(e));
        System.out.println("Componente de d en e: " + d.componente(e));
    }
}
