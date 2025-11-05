package p5;

public class Pagina {
	private int nro_pagina;
	private String contenido_pagina;
	public Pagina(int nrop, String con) {
		this.contenido_pagina=con;
		this.nro_pagina=nrop;
	}
	public void mostrarContenido(){
		System.out.println(this.contenido_pagina);
		System.out.println("Pagina : " + this.nro_pagina);
	}
}
