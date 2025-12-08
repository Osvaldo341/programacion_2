package hola;

public class main {

	public static void main(String[] args) {
			
		Consulta c1= new Consulta(1234567,"joel","Quipe",2314,12,"Marzo",2023);
		Consulta c2= new Consulta(1223427,"Jorge","Coronel",123,3,"Enero",2025);
		Consulta c3= new Consulta(1234567,"Andres","Mamani",1423,25,"Marzo",2024);
		Consulta c4= new Consulta(14705774,"Brandon","Alvarez",2431,5,"Diciembre",2025);
		Consulta c5= new Consulta(34534,"Ariel","Cruz",6384,30,"Enero",2025);
		Consulta c6= new Consulta(2,"Alexis","Choque",324568,8,"Febrero",2024);
		Consulta c7= new Consulta(354101,"Ninel","Quipe",124123,25,"Marzo",2023);
		Consulta c8= new Consulta(42,"Nestor","Coronel",67867,3,"Enero",2025);
		Consulta c9= new Consulta(278678,"Gabriela","Mamani",6786785,25,"Marzo",2024);
		Consulta [] algo = new  Consulta [9];
		algo[0]=c1;
		algo[1]=c2;
		algo[2]=c3;
		algo[3]=c4;
		algo[4]=c5;
		algo[5]=c6;
		algo[6]=c7;
		algo[7]=c8;
		algo[8]=c9;
		for(int i=0; i<9;i++) {
			if(algo[i].getDia()==25 && algo[i].getMes()=="Marzo"){
				System.out.println(algo[i].toString());
			}
		}
		
		c1.alta();
		c2.alta();
		c3.alta();
		c4.alta();
		c5.alta();
		c6.alta();
		c7.alta();
		c8.alta();
		c9.alta();
		Medico m1=new Medico(5432,5,"Cristian","Limachi");
		Medico m2=new Medico(3423,1,"John","Zarate");
		Medico m3=new Medico(5675,10,"Edson","Mamani");
		m1.alta();
		m2.alta();
		m3.alta();
			
	}

}