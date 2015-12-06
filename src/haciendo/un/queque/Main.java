package haciendo.un.queque;

import java.util.Random;

public class Main {

	/*
	1.	Comenzar con una población inicial, la cual puede ser generada de manera aleatoria.
	2.	Calcular el fitness (aptitud) de cada individuo.
	3.	Aplicar el operador de selección con base en el fitness de la población.
	4.	Aplicar los operadores genéticos de reproducción, cruce y mutación a la población actual para generar a la población de la siguiente generación.
	5.	Ir al paso 2 hasta que la condición de parada se satisfaga.
	6.	Cuando se cumple la condición de parada, se devuelve al mejor individuo encontrado (bien el mejor de todas las generaciones, bien el mejor de la última generación).
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.poblacion inicial

		//(int) (rnd.nextDouble() * cantidad_números_rango + término_inicial_rango)
		
		float x1,x3,x10=(float) 0.0;
		int x2,x4,x5,x6,x7,x8,x9=0;
		Random  rnd = new Random();
		
		//exp cocinero
		x1=(float) (rnd.nextDouble() *1 + 0.2);
		//tamaño queque
		x2=(int) (rnd.nextDouble() * 350 + 350);
		//proporcion Ingredientes
		x3=(float) (rnd.nextDouble() *1 + 0.1);
		//Tiempo Mezcla
		x4=(int) (rnd.nextDouble() * 14 + 1);
		//tiempo Batido
		x5=(int) (rnd.nextDouble() * 14 + 1);
		//Temp Horno
		x6=(int) (rnd.nextDouble() * 55 + 140);
		//Tiempo Precalentado del horno
		x7=(int) (rnd.nextDouble() * 18 + 21);		
		//Tiempo de coccion
		x8=(int) (rnd.nextDouble() * 12 + 14);
		//tiempo enfriamiento
		x9=(int) (rnd.nextDouble() * 13 + 21);
		
		System.out.println("Padre x1: "+x1+" ,x2:"+x2+" ,x3:"+x3+" ,x4:"+x4+" ,x5:"+x5
					  +  " ,x6:"+x6+" ,x7:"+x7+" ,x8:"+x8+" ,x9:"+x9);
		
		float vPadre[]={x1,x2,x3,x4,x5,x6,x7,x8,x9};
		
		//exp cocinero
		x1=(float) (rnd.nextDouble() *1 + 0.2);
		//tamaño queque
		x2=(int) (rnd.nextDouble() * 350 + 350);
		//proporcion Ingredientes
		x3=(float) (rnd.nextDouble() *1 + 0.1);
		//Tiempo Mezcla
		x4=(int) (rnd.nextDouble() * 14 + 1);
		//tiempo Batido
		x5=(int) (rnd.nextDouble() * 14 + 1);
		//Temp Horno
		x6=(int) (rnd.nextDouble() * 55 + 140);
		//Tiempo Precalentado del horno
		x7=(int) (rnd.nextDouble() * 18 + 21);		
		//Tiempo de coccion
		x8=(int) (rnd.nextDouble() * 12 + 14);
		//tiempo enfriamiento
		x9=(int) (rnd.nextDouble() * 13 + 21);
		
		float vMadre[]={x1,x2,x3,x4,x5,x6,x7,x8,x9};
		
		System.out.println("Madre x1: "+x1+" ,x2:"+x2+" ,x3:"+x3+" ,x4:"+x4+" ,x5:"+x5
				  +  " ,x6:"+x6+" ,x7:"+x7+" ,x8:"+x8+" ,x9:"+x9);
		
		//2. fitness con el modelo matematico
		System.out.println("fitness padre " +fitness(vPadre));
		System.out.println("fitness madre " +fitness(vMadre));
		
		//3. cruzamiento
		
		cruzamiento(vPadre,vMadre);
		
		
	
	}

	private static void cruzamiento(float[] vPadre, float[] vMadre) {
		int largoPadre=vPadre.length;
		int largoMadre=vMadre.length;
		
		float[] vHijo1= new float[largoPadre];
		float[] vHijo2= new float[largoMadre];
				
		int mitadPadre=largoPadre/2;
		int mitadMadre=largoMadre/2;
		
		for(int i=0;i<mitadPadre;i++){
			vHijo1[i]=vPadre[i];
		}
		for(int i=mitadPadre;i<largoPadre;i++){
			vHijo2[i]=vPadre[i];
		}
		
		for(int i=0;i<mitadMadre;i++){
			vHijo2[i]=vMadre[i];
		}
		for(int i=mitadMadre;i<largoMadre;i++){
			vHijo1[i]=vMadre[i];
		}
		
		System.out.print("hijo 1: ");
		for(int i=0;i<vHijo1.length;i++){
			System.out.print(""+vHijo1[i]+", ");
		}
		System.out.println("");
		
		System.out.print("hijo 2: ");
		for(int i=0;i<vHijo2.length;i++){
			System.out.print(""+vHijo2[i]+", ");
		}
		System.out.println("");
		
		
		
	}

	private static double fitness(float[] v) {
		// TODO Auto-generated method stub
		double total=0.0;
			try{
				float x1= v[0];
				float x2= v[1];
				float x3= v[2];
				float x4= v[3];
				float x5= v[4];
				float x6= v[5];
				float x7= v[6];
				float x8= v[7];
				float x9= v[8];
				
				
				total=((x9*x6*x7)/(x2*x8*x1))+(x2*(x3*(x4+x5)));
			}catch(Exception x){
				System.out.println("error: "+x.getMessage());
			}
		return total;
	}
	
	


}
