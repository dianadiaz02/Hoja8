package com.hoja8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Es el main del programa. Genera la versi�n con VectorHeap y la que utiliza
 * priority queue
 */
public class Main {

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		
		
		Paciente paciente;
		PriorityQueue<Paciente> pacientequeue = new PriorityQueue<Paciente>();
		VectorHeap<Paciente> p = new VectorHeap<>();
		try {
			File f = new File("/Users/dianadiaz/Documents/GitHub/Hoja8/hoja8/src/main/java/com/hoja8/pacientes.txt");
			Scanner pr = new Scanner(f);
	
			
			while (pr.hasNextLine()) {
				String linea = pr.nextLine();
				String[] spliLinea = linea.split(",");
				String nombre = "";
				String enfermedad = "";
				String tipo = "";
				nombre = spliLinea[0];
				enfermedad = spliLinea[1];
				tipo = spliLinea[2];
				paciente = new Paciente(nombre, enfermedad, tipo);
				p.add(paciente);
				pacientequeue.offer(paciente);
			}
			pr.close();
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
