package com.hoja8;
/**
 * Universidad del Valle de Guatemala
 * Algoritmos y estructuras de datos
 * @author Diana Díaz 21066
 * @author Mario Puente 21290
 * @version 1.0
 * Fecha 7/04/2022
 */

 //imports
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Es el main del programa. Genera la version con VectorHeap y la que utiliza
 * priority queue
 */
public class Main {

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		
		/*instancias */
		Paciente paciente;
		PriorityQueue<Paciente> pacientequeue = new PriorityQueue<Paciente>();
		VectorHeap<Paciente> p = new VectorHeap<>();
		try {
			//path 
			File f = new File("/Users/dianadiaz/Documents/GitHub/Hoja8/hoja8/src/main/java/com/hoja8/pacientes.txt");
			//instancia de un scanner para leer archivo
			Scanner pr = new Scanner(f);
	
			//mientras sea true que exista una siguiente linea
			while (pr.hasNextLine()) {
				String linea = pr.nextLine(); //guardad linea
				String[] spliLinea = linea.split(","); //hacer split por cada coma y guardar en array
				String nombre = ""; //string de nombre
				String enfermedad = ""; //string enfermedad
				String tipo = ""; //string tipo
				nombre = spliLinea[0]; //guardar en nombre la posición 0 del array
				enfermedad = spliLinea[1]; //guardar en enfermedad la posición 1 del array
				tipo = spliLinea[2]; //guardar en enfermedad la posición 2 del array
				paciente = new Paciente(nombre, enfermedad, tipo); 
				p.add(paciente);
				pacientequeue.offer(paciente);
			}
			pr.close();
			//manejo de excepciones
		} catch (FileNotFoundException e) {
			//System.err.println("Se produjo un error");
			e.printStackTrace();
		}
		System.out.println("===Registro de pacientes con VectorHeap===");
		/**
		 * while(!p.isEmpty()){ /// System.out.println(p.remove().toString()); }
		 */
		System.out.println(p.print());
		System.out.println("===Registro de pacientes con Priority Queue===");
		// System.out.println(pacientequeue.peek());
		Iterator<Paciente> pacienteIterator = pacientequeue.iterator();
		while (pacienteIterator.hasNext()) {
			Paciente temp = pacienteIterator.next();
			System.out.println("Nombre del paciente: " + temp.getNombre() + ", Descripcion del sintoma: "
					+ temp.getEnfermedad() + ", Tipo: " + temp.getTipo());
		}

	}

}
