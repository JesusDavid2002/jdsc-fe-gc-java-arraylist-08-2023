package ejerciciosArraylist;

import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Ejercicio2App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList <Double> listaCompra = new ArrayList<>();
		boolean estaComprando = true;
		double IVA = 0.21;
		double precioBruto = 0;
		double precioFinal = 0;
		
		while (estaComprando == true) {
			
			String precio = JOptionPane.showInputDialog("Introduce el precio del producto: ");
			double precioProducto = Double.parseDouble(precio);
			
			listaCompra.add(precioProducto);

			double continuar = JOptionPane.showConfirmDialog(null, "¿Quiere introducir más productos?", "", JOptionPane.YES_NO_OPTION );
			
			if(continuar == JOptionPane.NO_OPTION) {
				estaComprando = false;
			}
		}
		
		double[] datos = calcularPrecio(IVA, precioBruto, precioFinal, listaCompra);
		precioFinal = datos[2];
		precioBruto = datos[1];
		IVA = datos[0];
		
		comprar(precioFinal, precioBruto, IVA);
		
		
	}


	private static double[] calcularPrecio(double IVA, double precioBruto, double precioFinal, ArrayList<Double> listaCompra) {
		// TODO Auto-generated method stub
		double esIvaReducido = JOptionPane.showConfirmDialog(null, "¿Tiene IVA reducido (4%)?", "", JOptionPane.YES_NO_OPTION );
		
		if(esIvaReducido == JOptionPane.YES_OPTION) {
			IVA = 0.04;
		}
		
		for(double precio : listaCompra) {
			precioBruto += precio;
		}
		
		precioFinal = precioBruto + (precioBruto * IVA);
		
		double[] resultados = new double [3];
		resultados[0] = IVA;
		resultados[1] = precioBruto;
		resultados[2] = precioFinal;
		
		return resultados;
	}

	private static void comprar(double precioFinal, double precioBruto, double IVA) {	
		// TODO Auto-generated method stub	
		DecimalFormat df = new DecimalFormat ("#.00");
		String cantidadPagada = JOptionPane.showInputDialog("Introduzca la cantidad a pagar, el total es de " + df.format(precioFinal)+ " €:");
		double cantidadAPagar = Double.parseDouble(cantidadPagada);
		double cambio = 0;
		
		if(cantidadAPagar == precioFinal) {
			JOptionPane.showMessageDialog(null, "Gracias por su compra, que tenga un buen día.");
			String recibo = "Recibo de la compra\n" + "-------------------------\n" +
					"IVA aplicado: " + IVA + "\nPrecio Total Bruto: " + precioBruto + "\nPrecio Total + IVA: " + precioFinal +
					"\nCantidad que has pagado: " + cantidadAPagar + "\nCambio: " + cambio;
			System.out.println(recibo);
			
		} else if(cantidadAPagar > precioFinal) {
			cambio = cantidadAPagar - precioFinal;
			JOptionPane.showMessageDialog(null, "Aquí tiene su cambio, que son: " + df.format(cambio) + " €. Gracias por su compra, que tenga un buen día.");
			String recibo = "Recibo de la compra\n" + "-------------------------\n" +
					"IVA aplicado: " + IVA + "€\nPrecio Total Bruto: " + precioBruto + "€\nPrecio Total + IVA: " + precioFinal +
					"€\nCantidad que has pagado: " + cantidadAPagar + "€\nCambio: " + cambio + "€";
			System.out.println(recibo);
			
		} else {
			JOptionPane.showMessageDialog(null, "El dinero que me has dado no llega para hacer la compra");
			comprar(precioFinal, precioBruto, IVA);	
		}
		
	}

}
