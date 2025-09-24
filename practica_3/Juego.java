package practica_3;
public class Juego {
	public int numeroDeVidas;
	private int record;
	public Juego(int ndv) {
		super();
		this.numeroDeVidas=ndv;
		this.record=0;
	}
	public void reiniciaPartida(){
	}
	public void actualizaRecord() {
		this.record=this.record+1;
	}
	public boolean quitavida() {
		if(this.numeroDeVidas>1) {
			this.numeroDeVidas-=1;
			return true;
			
		}
		else {
			return false;
		}
		
		
	}
}

