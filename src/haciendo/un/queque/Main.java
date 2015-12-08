package haciendo.un.queque;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Main {
	
	static ArrayList<float[]> PoblacionInicial = new ArrayList<float[]>();
	static ArrayList<float[]> PoblacionGeneraciones= new ArrayList<float[]>();
	
	static ArrayList<float[]> PoblacionGeneracionesConSeleccion= new ArrayList<float[]>();
	
	static float[] vHijo1;
	static float[] vHijo2;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.poblacion inicial

		float x1,x3,x10=(float) 0.0;
		int x2,x4,x5,x6,x7,x8,x9=0;
		
		
		
		for(int i=0;i<1000;i++){
			Random  rnd = new Random();
			
			//exp cocinero
			x1=(float) (rnd.nextFloat() *0.8 + 0.2);
			//tamaño queque
			x2=(int) (rnd.nextFloat() * 350 + 350);
			//proporcion Ingredientes
			x3=(float) (rnd.nextFloat() *0.9 + 0.1);
			//Tiempo Mezcla
			x4=(int) (rnd.nextFloat() * 14 + 1);
			//tiempo Batido
			x5=(int) (rnd.nextFloat() * 14 + 1);
			//Temp Horno
			x6=(int) (rnd.nextFloat() * 55 + 140);
			//Tiempo Precalentado del horno
			x7=(int) (rnd.nextFloat() * 18 + 21);		
			//Tiempo de coccion
			x8=(int) (rnd.nextFloat() * 12 + 14);
			//tiempo enfriamiento
			x9=(int) (rnd.nextFloat() * 13 + 21);
			System.out.println("Padre x"+(i+1)+": "+x1+" ,x2:"+x2+" ,x3:"+x3+" ,x4:"+x4+" ,x5:"+x5
					  +  " ,x6:"+x6+" ,x7:"+x7+" ,x8:"+x8+" ,x9:"+x9);
		
			float vPadre[]={x1,x2,x3,x4,x5,x6,x7,x8,x9};
			PoblacionInicial.add(vPadre);
		}
		
		//cruzamiento de los padres... resultado padres e hijos
		for(int m=0;m<PoblacionInicial.size();m++){
			for(int l=0;l<PoblacionInicial.size();l++){
				//cruzamos solo los padres q son diferentes
				if(m<=l && m!=l){
					PoblacionGeneraciones.add(PoblacionInicial.get(m));
					PoblacionGeneraciones.add(PoblacionInicial.get(l));
				
					PoblacionGeneraciones.addAll(cruzamiento(PoblacionInicial.get(m), PoblacionInicial.get(l)));
				}
			}	
		}
		
		System.out.println("Tamaño Poblacion Generaciones: "+PoblacionGeneraciones.size());
		
		//seleccion natural
		
		Iterator<float[]> nombreIterator = PoblacionGeneraciones.iterator();
		int nIterator=0;
		double fitnessAceptableAbajo=12012*0.70;
		double fitnessAceptableArriba=12012*1.30;
		Random  rnd = new Random();
		
		while(nombreIterator.hasNext()){
			float[] elemento = nombreIterator.next();
			
			double fitness = fitness(elemento);
			if(fitness>fitnessAceptableAbajo && fitness<fitnessAceptableArriba){
				
				boolean dadoBinario=rnd.nextBoolean();
				if(dadoBinario){
					PoblacionGeneracionesConSeleccion.add(elemento);
				}
			}
			nIterator++;
		}
		
		System.out.println("Tamaño Poblacion Generaciones con Seleccion: "+PoblacionGeneracionesConSeleccion.size());
		
		//Mutando aleatoriamente
		//Iterator<float[]> pobGenConSeleccionMutacion = PoblacionGeneracionesConSeleccion.iterator();
		//while(pobGenConSeleccionMutacion.hasNext()){
		int cont=0;
		while(cont<1000){
			Random  rndx = new Random();
				if(rndx.nextBoolean()){
					int index= (int) (rndx.nextFloat() *PoblacionGeneracionesConSeleccion.size() + 0);
					float [] mutar = PoblacionGeneracionesConSeleccion.get(index);
					PoblacionGeneracionesConSeleccion.remove(index);
					PoblacionGeneracionesConSeleccion.add(mutando(mutar));
				}
			cont++;
		}
		
		//Buscando el optimo
				Iterator<float[]> pobGenConSeleccion = PoblacionGeneracionesConSeleccion.iterator();
				int nn=1;
				while(pobGenConSeleccion.hasNext()){
					float[] e = pobGenConSeleccion.next();
					double fitness = fitness(e);
					if(fitness>=12012*0.999 && fitness<=12012*1.001){
						//if(fitness)
						System.out.println("queque "+nn+" ["+e[0]+"-"+e[1]+"-"+e[2]+"-"+e[3]+"-"+e[4]+"-"+e[5]
								      +"-"+e[6]+"-"+e[7]+"-"+e[8]+"]"+" fitneess: "+fitness);
						
						nn++;
						//break;
					}
					
				}
		
		
	}

	static float[] mutando(float[] vHijo) {
		float[] mutado=null;
		
		Random  rnd = new Random();
		int gen =(int) (rnd.nextFloat() * 8 + 0);
		//System.out.println(gen);
		
		int mutacion =rnd.nextInt(111);
		vHijo[gen]=mutacion;
		
		mutado=vHijo;
		
		return mutado;
	}

	static ArrayList<float[]> cruzamiento(float[] vPadre, float[] vMadre) {
		
		ArrayList<float[]> cruza = new ArrayList<float[]>();
		
		int largoPadre=vPadre.length;
		int largoMadre=vMadre.length;
		
		vHijo1= new float[largoPadre];
		vHijo2= new float[largoMadre];
				
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
		
		
		cruza.add(vHijo1);
		cruza.add(vHijo2);
		
		
		return cruza;
		
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
