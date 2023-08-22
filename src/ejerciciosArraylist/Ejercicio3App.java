package ejerciciosArraylist;

import java.awt.*;
import java.awt.event.*;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.swing.*;
import javax.swing.border.*;

public class Ejercicio3App{
	
    Hashtable <String, Producto> producto = new Hashtable<String, Producto>();
    
	public  Ejercicio3App() {
		
		JFrame f = new JFrame("Stock de productos");
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2, 10, 10)); 

        JLabel labelArticulo = new JLabel("Artículo:");
        labelArticulo.setBorder(new EmptyBorder(0, 10, 0, 0));
        JTextField textField = new JTextField();
        textField.setBorder(new LineBorder(Color.BLACK, 1));

        JLabel labelPrecio = new JLabel("Precio:");
        labelPrecio.setBorder(new EmptyBorder(0, 10, 0, 0));
        JTextField textField1 = new JTextField();
        textField1.setBorder(new LineBorder(Color.BLACK, 1));
        
        JLabel labelCantidad = new JLabel("Cantidad:");
        labelCantidad.setBorder(new EmptyBorder(0, 10, 0, 0));
        JTextField textField2 = new JTextField();
        textField2.setBorder(new LineBorder(Color.BLACK, 1));
        

        JLabel labelEmpty = new JLabel();
        labelEmpty.setBorder(new EmptyBorder(0, 10, 0, 0));

        panel.add(labelArticulo);
        panel.add(textField);
        panel.add(labelPrecio);
        panel.add(textField1);
        panel.add(labelCantidad);
        panel.add(textField2);
        panel.add(labelEmpty);

        JButton buttonAnadir = new JButton("Añadir");
        JButton buttonMostrar = new JButton("Mostrar");

        JPanel buttonPanel = new JPanel(); 
        buttonPanel.add(buttonAnadir);
        buttonPanel.add(buttonMostrar);

        f.setLayout(new BorderLayout()); // Usamos BorderLayout para organizar los paneles
        f.add(panel, BorderLayout.CENTER); // Panel de datos en el centro
        f.add(buttonPanel, BorderLayout.SOUTH); // Panel de botón en la parte inferior

        f.setSize(550, 200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        

        producto.put("Arroz", new Producto("Arroz", 1.20, 3));
        producto.put("Cerveza",new Producto("Cerveza", 2.50, 3));
        producto.put("Pan",new Producto("Pan", 0.80, 3));
        producto.put("Papel higienico", new Producto("Papel higienico", 5.26, 3));
        producto.put("Cocacola",new Producto("Cocacola", 1.25, 3));
        producto.put("Nestea",new Producto("Nestea", 1.02, 3));
        producto.put("Balletas",new Producto("Balletas", 0.60, 3));
        producto.put("Chocolate", new Producto("Chocolate", 1.00, 3));
        producto.put("Tomiño", new Producto("Tomiño", 1.54, 3));
        producto.put("Queso", new Producto("Queso", 8.23, 3));
        
        buttonAnadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
            	 try {
                     String productoNombre = textField.getText();
                     double productoPrecio = Double.parseDouble(textField1.getText());
                     int productoCantidad = Integer.parseInt(textField2.getText());

                     labelEmpty.setText("Producto añadido: " + productoNombre + " | Precio: " + productoPrecio + " | Cantidad: " + productoCantidad);
               
                     producto.put(productoNombre, new Producto(productoNombre, productoPrecio, productoCantidad));
                     
                     textField.setText("");
                     textField1.setText("");
                     textField2.setText("");
                     
                 } catch (NumberFormatException e) {
                     System.out.println("Error: Precio o cantidad incorrectos");
                 }
            }
        });
        
        buttonMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
            	Enumeration<String> enumerationNombres = producto.keys();
                Enumeration<Producto> enumerationProductos = producto.elements();

                System.out.println("\n------------------------------\n");
                
                while (enumerationNombres.hasMoreElements()) {
                    String productName = enumerationNombres.nextElement();
                    Producto product = enumerationProductos.nextElement();
                    System.out.println((productName)+(": ")+(product.getPrecio())+(" (Cantidad: ")+(product.getCantidad())+(")\n"));
                    
                }
                
                System.out.println("\n------------------------------\n");
                
            }
        });
        
    }
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ejercicio3App();
	}

}
