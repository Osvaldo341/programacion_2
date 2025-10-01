package allgo;
import java.util.Random;
public class Main2 {

	public static void main(String[] args) {
		Figura [] fi= new Figura[5]  ;
		Random random = new Random();
		for(int i=0;i<5;i++) {
			 int aleatorio = random.nextInt(2) + 1;
			if(aleatorio==1) {
			    int numa =random.nextInt(100)+1;
			    fi[i]= new Cuadrado("Rojo",numa);
			}
			else if(aleatorio==2) {
				int numa =random.nextInt(100)+1;
				fi[i]= new Circulo("Verde",numa);	
			}
		}
		for(int h=0;h<5;h++) {
			System.out.println(fi[h]);
			System.out.println("Area : "+fi[h].area());
			System.out.println("Perimero : "+fi[h].Perimetro());
			System.out.println(fi[h].comoColorear());
		}
		
		

	}

}

