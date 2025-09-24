package practica_3;
import java.util.Random;
public class JuegoAdivinaPar extends JuegoAdivinaNumero {
	private Random random;

	public JuegoAdivinaPar(int ndv) {
		super(ndv);
		this.random = new Random();
        // nuevo numero para que sea par
        do {
            this.naa = random.nextInt(11);
        } while (this.naa % 2 != 0);
    }
	@Override
	public boolean validaNumero(int numero) {
		if(numero>-1 && numero<11) {
			if(numero%2==0) {
				return true;
			}
			else {
				System.out.println("Error, el numero no es par");
				return false;
			}
		}
		else {
			System.out.println("Error, el numero no esta entre 0 y 10");
			return false;
		}
		
	
		
	}
}
