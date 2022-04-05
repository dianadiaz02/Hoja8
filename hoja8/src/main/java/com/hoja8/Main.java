package com.hoja8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Iterator;
import java.util.PriorityQueue;

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
		
		File f;
		FileReader fr;
		BufferedReader br;
		Paciente paciente;
		PriorityQueue<Paciente> pacientequeue = new PriorityQueue<Paciente>();
		VectorHeap<Paciente> p = new VectorHeap<>();
		try {
			f = new File("/pacientes.txt");
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			String linea;
			while ((linea = br.readLine()) != null) {
				String nombre = "";
				String enfermedad = "";
				String tipo = "";
				String temporal = "";
				int pos = linea.indexOf(",");
				nombre = linea.substring(0, pos);
				temporal = linea.substring(pos + 1, linea.length());
				pos = temporal.indexOf(",");
				enfermedad = temporal.substring(0, pos);
				tipo = temporal.substring(pos + 1, temporal.length());
				paciente = new Paciente(nombre, enfermedad, tipo);
				p.add(paciente);
				pacientequeue.offer(paciente);
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			System.err.println("Se produjo un error");
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
