package ejerciciosArraylist;

import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JOptionPane;

public class Ejercicio1App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Pedimos la cantidad tanto de alumnos como de asignaturas
		String numAlumnos = JOptionPane.showInputDialog("Cuantos alumnos hay en el curso: ");
		String numAsignaturas = JOptionPane.showInputDialog("Cuantas asignaturas hay en el curso: ");
		int alumnos = Integer.parseInt(numAlumnos);
		int asignaturas = Integer.parseInt(numAsignaturas);
		
		// Creamos un hashtable para crear la estrucutra y creamos un metodo para los procesos
		Hashtable<String, Double> datosAlumno = generarDatosAlumnos(alumnos, asignaturas);
		
		// Utilizando enumeration recorremos el hashtable 
		Enumeration <String> enumerationNombres = datosAlumno.keys();
		Enumeration<Double> enumerationNotas = datosAlumno.elements();
		
		// Mostramos los resultados por consola
		System.out.println("Las notas medias de los alumnos son: ");
		while(enumerationNombres.hasMoreElements()) {
			System.out.println("" + enumerationNombres.nextElement() + ": "+ enumerationNotas.nextElement());
		}
	}

	private static Hashtable<String, Double> generarDatosAlumnos(int alumnos, int asignaturas) {
		// TODO Auto-generated method stub	
		Hashtable<String, Double> datosAlumno = new Hashtable <String, Double>();
		
		for(int i = 0; i < alumnos; i++) {
			// Recogemos el nombre del alumno
			String nombre = JOptionPane.showInputDialog("Cual es el nombre del alumno " + (i + 1));
			double[] notas = new double [asignaturas];
			
			for (int j = 0; j < asignaturas; j++) {
				// Recogemos las notas del alumno
				String nota = JOptionPane.showInputDialog("Introduce la nota de la " + (j + 1) + " asignatura: ");
				double notaConvert = Double.parseDouble(nota);
				
				notas[j] = notaConvert;
			}
			
			double mediaNota = generarMedia(notas);
			
			// Almacena el nombre y la media de las notas;
			datosAlumno.put(nombre, mediaNota);
		}
		
		return datosAlumno;
	}

// Calculamos la media de las asignaturas
	private static Double generarMedia(double[] notas) {
		// TODO Auto-generated method stub	
		int sumaNotas = 0;
		
		for(int i = 0; i < notas.length; i++) {
			sumaNotas += notas[i];
		}
		
		double mediaNotas = (double) sumaNotas / notas.length;
		
		return mediaNotas;
	}

}
