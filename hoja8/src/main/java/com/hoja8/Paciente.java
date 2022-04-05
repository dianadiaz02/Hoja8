package com.hoja8;

public class Paciente implements Comparable<Paciente> {

	private String nombre;
	private String enfermedad;
	private String tipo;

	/**
	 * @param nombre
	 * @param enfermedad
	 * @param tipo
	 */
	public Paciente(String nombre, String enfermedad, String tipo) {
		this.nombre = nombre;
		this.enfermedad = enfermedad;
		this.tipo = tipo;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return the enfermedad
	 */
	public String getEnfermedad() {
		return enfermedad;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @param enfermedad
	 *            the enfermedad to set
	 */
	public void setEnfermedad(String enfermedad) {
		this.enfermedad = enfermedad;
	}

	/**
	 * @param tipo
	 *            the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * M�todo compareTo para comparar dos elementos de la misma clase
	 * 
	 * @param p
	 * @return entero que indica, si es mayor, menor o igual
	 */
	public int compareTo(Paciente p) {
		if (this.tipo.compareTo(p.tipo) < 0) {
			return -1;
		} else if (this.tipo.compareTo(p.tipo) > 0) {
			return 1;
		} else {
			return 0;
		}
	}

	/**
	 * M�todo toString
	 * 
	 * @return texto
	 */
	public String toString() {
		return "Nombre del paciente: " + nombre + ", descripci�n del s�ntoma: " + enfermedad + ", Tipo: " + tipo;
	}

}
