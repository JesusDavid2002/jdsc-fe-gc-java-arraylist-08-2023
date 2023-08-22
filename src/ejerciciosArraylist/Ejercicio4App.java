package ejerciciosArraylist;

import java.awt.*;
import java.awt.event.*;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.swing.*;
import javax.swing.border.*;

public class Ejercicio4App {
	
	private Hashtable<String, Producto> producto = new Hashtable<String, Producto>();
  
    public Ejercicio4App() {
        
    	JFrame f = new JFrame("Gestión de Productos y Ventas");
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2, 10, 10)); 

        // Parte de control de stock
        JLabel labelArticulo = new JLabel("Artículo:");
        labelArticulo.setBorder(new EmptyBorder(0, 10, 0, 0));
        JTextField textField = new JTextField();
        textField.setBorder(new LineBorder(Color.BLACK, 1));

        JLabel labelPrecio = new JLabel("Precio:");
        labelPrecio.setBorder(new EmptyBorder(0, 10, 0, 0));
        JTextField textField1 = new JTextField();
        textField1.setBorder(new LineBorder(Color.BLACK, 1));

        JLabel labelCantidad = new JLabel("Cantidad en stock:");
        labelCantidad.setBorder(new EmptyBorder(0, 10, 0, 0));
        JTextField textField2 = new JTextField();
        textField2.setBorder(new LineBorder(Color.BLACK, 1));

        // Comentarios o mostrar resultados
        JLabel labelEmpty = new JLabel();
        labelEmpty.setBorder(new EmptyBorder(0, 10, 0, 0));
        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setPreferredSize(new Dimension(0, 2));
        JSeparator separator1 = new JSeparator(SwingConstants.HORIZONTAL);
        separator1.setPreferredSize(new Dimension(0, 2));
        
        // Parte de ventas
        JLabel labelArticuloCompra = new JLabel("Artículo a comprar:");
        labelArticuloCompra.setBorder(new EmptyBorder(0, 10, 0, 0));
        JTextField textFieldCompra = new JTextField();
        textFieldCompra.setBorder(new LineBorder(Color.BLACK, 1));
        
        JLabel labelCantidadCompra = new JLabel("Cantidad a comprar:");
        labelCantidadCompra.setBorder(new EmptyBorder(0, 10, 0, 0));
        JTextField textFieldCantidadCompra = new JTextField();
        textFieldCantidadCompra.setBorder(new LineBorder(Color.BLACK, 1));
        
        
        panel.add(labelArticulo);
        panel.add(textField);
        panel.add(labelPrecio);
        panel.add(textField1);
        panel.add(labelCantidad);
        panel.add(textField2);
        panel.add(separator1);
        panel.add(separator);
        panel.add(labelArticuloCompra);
        panel.add(textFieldCompra);
        panel.add(labelCantidadCompra);
        panel.add(textFieldCantidadCompra);
        panel.add(labelEmpty);

        JButton buttonAnadir = new JButton("Añadir");
        JButton buttonMostrar = new JButton("Mostrar");
        JButton buttonComprar = new JButton("Comprar");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(buttonAnadir);
        buttonPanel.add(buttonMostrar);
        buttonPanel.add(buttonComprar);

        f.setLayout(new BorderLayout());
        f.add(panel, BorderLayout.CENTER);
        f.add(buttonPanel, BorderLayout.SOUTH);

        f.setSize(600, 300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.setLocationRelativeTo(null);

        // 1 producto de la lista
        producto.put("Arroz", new Producto("Arroz", 1.20, 3));
        
        
        // ActionListener "Añadir" button
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
                    labelEmpty.setText("Error: Precio o cantidad incorrectos");
                }
            }
        });

        // ActionListener "Mostrar" button
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

        // ActionListener "Comprar" button
        buttonComprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
            	 String nombre = textFieldCompra.getText();
                 int cantidad = Integer.parseInt(textFieldCantidadCompra.getText());
   
                 if(producto.containsKey(nombre) && producto.get(nombre).getCantidad() > 0) {
                	 int cantidadStock = producto.get(nombre).getCantidad();
                	 
                	 if(cantidadStock >= cantidad) {
                		 producto.get(nombre).setCantidad(cantidadStock - cantidad);
                		 System.out.println("Venta realizada: " + nombre + ", cantidad: " + cantidad);
                		 
                	 } else {
                		 System.out.println("No hay suficiente cantidad en stock.");
                		 
                	 }
                	 
                 } else {
                	 System.out.println("El articulo no esta en stock. ");
                	 
                 }
                 
                 textFieldCompra.setText("");
                 textFieldCantidadCompra.setText("");

            }
        });
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ejercicio4App();
	}

}
