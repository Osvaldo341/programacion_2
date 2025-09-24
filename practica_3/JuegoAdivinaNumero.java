package practica_3;
import java.util.Random;
import java.util.Scanner ; 
public class JuegoAdivinaNumero extends Juego {
	public int naa  ;/*Numero a adivinar*/
	private Random random;
	public JuegoAdivinaNumero(int ndv) {
		super(ndv);
		this.random=new Random();
		this.naa=random.nextInt(11);
	}
	/*nuevo metodo */
	public boolean validaNumero(int numero) {
		if(numero>=0 && numero<11 ) {
			return true;
		}
		else {return false;}
	}
	public void juega() {
		super.reiniciaPartida();
		int naa= random.nextInt(11);
		System.out.println("Adivine un numero entre el 0 y el 10");
		Scanner z = new Scanner(System.in);
			while(true) {
				int a=z.nextInt();
				if(validaNumero(a)) {
				if(a==naa) {
					System.out.println("Acertaste!!");
					super.actualizaRecord();
					break;
				}
				else {
					boolean veri=super.quitavida();
					if(veri) {
						if(a>naa) {
							System.out.println("El numero es menor  intentalo denuevo");
							System.out.println("Te quedan " + this.numeroDeVidas + " vidas");
						}
						else {
							System.out.println("El numero es mayor intentalo denuevo");
							System.out.println("Te quedan " + this.numeroDeVidas + " vidas");
						}
					}
					else {
						System.out.println("perdiste");
						break;
					}
					}
				}
				
			}
			
		}
		
	}	
	

