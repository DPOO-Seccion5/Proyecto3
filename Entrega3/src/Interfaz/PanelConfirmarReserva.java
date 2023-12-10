package Interfaz;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicComboBoxEditor;

import modelo.Cliente;

public class PanelConfirmarReserva extends JPanel {
    private JPanel cardPanel;
	private CardLayout cardLayout;
	private VentanaInicio ventanaInicio;

	public PanelConfirmarReserva(JPanel cardPanel, CardLayout cardLayout, double precio,String categoria, boolean appCliente,Cliente cliente) {
   	 
   	 	this.cardPanel = cardPanel;
        this.cardLayout = cardLayout;
        this.ventanaInicio = new VentanaInicio();
        if(appCliente == true) 
        {
        	Double descuento = precio*0.1;
        	precio=precio-descuento;
        }
        double precioFinal = precio;
        
        ventanaInicio.cargar_datos();
        
        String nombreCarro = ventanaInicio.nombreCarro(categoria);
        
        setLayout(new BorderLayout());

        // First Panel (North)
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel titleLabel = new JLabel("Confirmar Reserva");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titlePanel.add(titleLabel);
        add(titlePanel, BorderLayout.NORTH);

        // Second Panel (Center)
        JPanel infoPanel = new JPanel(new GridLayout(3, 1)); // Two rows and two columns

        // Labels and Text Fields
        JLabel label1 = new JLabel("                     Precio:");
        JTextField textField1 = new JTextField(20);
        textField1.setText(String.valueOf(precio));
        textField1.setEditable(false); // Make the text field uneditable
        textField1.setPreferredSize(new Dimension(200, 25)); // Set a fixed size for the text field

        // Customize the text field's appearance
        textField1.setBackground(Color.BLACK);
        textField1.setForeground(Color.WHITE);

        JLabel label2 = new JLabel("                     Vehiculo:");
        JTextField textField2 = new JTextField(20);
        textField2.setText(nombreCarro);
        textField2.setEditable(false); // Make the text field uneditable
        textField2.setPreferredSize(new Dimension(100, 25)); // Set a fixed size for the text field

        
        // Customize the text field's appearance
        textField2.setBackground(Color.BLACK);
        textField2.setForeground(Color.WHITE);


     // Payout method
        JLabel labelComponent = new JLabel("        Pasarela de pago:");
        JComboBox<String> comboBox1 = new JComboBox<>();
        comboBox1.setPreferredSize(new Dimension(20, 30));
        comboBox1.addItem("PayPal");
        comboBox1.addItem("PayU");
        comboBox1.addItem("Sire");
        
        
    
             
        infoPanel.add(label1);
        infoPanel.add(textField1);
        infoPanel.add(label2);
        infoPanel.add(textField2);
        infoPanel.add(labelComponent);
        infoPanel.add(comboBox1);

        add(infoPanel, BorderLayout.CENTER);

        // Third Panel (South)
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton confirmButton = new JButton("Confirmar pago");
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String pasarela = (String) comboBox1.getSelectedItem();
            	try {
					ventanaInicio.crearTransaccion(cliente, precioFinal, pasarela);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	JOptionPane.showMessageDialog(null, "Reserva creada exitosamente!");
            	ventanaInicio.cargar_datos();
            	cardLayout.show(cardPanel, "panelUsuario");
            }
        });
        
        JButton returnButton = new JButton("Devolverse");
        Dimension buttonSize2 = new Dimension(100, 25); // Adjust the button size
        returnButton.setPreferredSize(buttonSize2);
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                	cardLayout.show(cardPanel, "panelCrearReserva");
                
               
            }
        });

        buttonPanel.add(returnButton);
        buttonPanel.add(confirmButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
