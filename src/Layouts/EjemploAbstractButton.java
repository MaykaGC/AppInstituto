package Layouts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class EjemploAbstractButton extends JFrame {


    //declaramos los componentes que vamos a tener
    protected JButton boton = new JButton("Botón");
    protected JCheckBox casilla = new JCheckBox("Marcada");
    protected JRadioButton radio1 = new JRadioButton("Radio 1");
    protected JRadioButton radio2 = new JRadioButton("Radios 2");
    protected JToggleButton botoToggle = new JToggleButton("Botón no apretado");
    protected JComboBox combo = new JComboBox();
    protected Container panelContenedor;
    protected JList lista = new JList(); //es una especie de lista con todos los items puestos y hacer selecciones multiples


    //metodo contructor
    public EjemploAbstractButton(){
        //se añaden los elementos visuales, es deicr, establecer todos los componentes graficos
        initGuit();
        initEventos(); //no establecerlo aquí si hay muchos eventos, es más optimo ponerlo a parte en ese caso

    }

    private void initEventos() {

        //Eventos

        radiosListener(radio1, "Radio 1");
        radiosListener(radio2, "Radio 2");
        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                //mensajes de dialogo
                JOptionPane.showMessageDialog(panelContenedor,
                        "Has pulsado el botón. ");
            }});


        casilla.addItemListener(new ItemListener() {

            //ejemplo aplicable a los terminos y condiciones
            public void itemStateChanged(ItemEvent e) {

               int estado = e.getStateChange();
               SwingUtilities.invokeLater(() -> {
               if (estado == ItemEvent.SELECTED){
                   System.out.println("La casilla ha sido marcada.");
               }else if (estado == ItemEvent.DESELECTED){
                   System.out.println("La casilla ha sido desmarcada. ");
               }
        });
    }
});


        botoToggle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              if (botoToggle.isSelected()) {
                    //hacemos una acción asociada a apretar el botón
                    botoToggle.setText("Botón apretado. ");
                } else {
                    botoToggle.setText("Botón no apretado. ");
                }
            }
        });

        combo.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
               //hallo el origen del evento para saber que item esta seleccionado
               JComboBox cb = (JComboBox) e.getSource();
               String itemSeleccionado = cb.getSelectedItem().toString();
               JOptionPane.showMessageDialog(panelContenedor, "El item seleccionado es"
               + itemSeleccionado);
            }
        });
    }
    protected  void radiosListener (JRadioButton radio, final String nombre){
        radio.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    JOptionPane.showMessageDialog(panelContenedor,
                            "El " + nombre + " ha sido seleccionado");
                }
            }
        });
    }

    private void initGuit() {
        //averiguamos el panel contenedor de la ventana
        // siempre hay que añadirle un layout
        panelContenedor = getContentPane();
        panelContenedor.setLayout(new FlowLayout());

        //formo grupo de radios
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(radio1);
        grupo.add(radio2);

        //inicializo comobo
        /*for (int i = 0; i < 3; i++) {
            combo.addItem("Item " + (i + 1));
        }*/

        //inicalizo combo
        combo.addItem("Item 1");
        combo.addItem("Item 2");
        combo.addItem("Item 3");

        //agrego los componentes al panel contenedor
        //normalmente los combos se alimentan de arrays o lista de una base de datos
        panelContenedor.add(boton);
        panelContenedor.add(casilla);
        panelContenedor.add(botoToggle);
        panelContenedor.add(combo);
        panelContenedor.add(radio1);
        panelContenedor.add(radio2);
    }


    public static void main(String [] args){

        EjemploAbstractButton marco = new EjemploAbstractButton();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setSize(400, 300);
        marco.setVisible(true);
    }
}
