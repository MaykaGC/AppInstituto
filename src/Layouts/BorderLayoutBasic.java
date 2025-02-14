package Layouts;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BorderLayoutBasic extends JFrame {

    BorderLayout layout = new BorderLayout();
    FlowLayout fl = new FlowLayout(FlowLayout.LEFT, 10, 5);


    Font fuente = new Font("Courier", Font.BOLD, 36);
    //podemos cargar un archivo de fuentes .tiff que se descarga fuentes y las pone


    //definimos etiquetas que van a ir con los paneles correspondientes
    // JLabel lblNorte = new JLabel("Etiqueta norte");
    JLabel lblOeste = new JLabel("Etiqueta oeste");
    JLabel lblEste = new JLabel("Etiqueta Este");
    JLabel lblSur = new JLabel("Etiqueta sur");

    //elementos del formulario     las cosas no se meten dentro del border sino dentro del contenedor
    Container panelContenedor;
    JPanel pnOeste = new JPanel();
    JPanel pnEste = new JPanel();
    JPanel pnSur = new JPanel();
    JPanel pnNorte = new JPanel();
    JSplitPane splitCentral = new JSplitPane(JSplitPane.VERTICAL_SPLIT);

    //ELEMENTOS VISUALES
    //en el centro , en el split centra, arriba va a ir un jbutto
    JButton btnCentro = new JButton("Boton centro");
    //y abajo un área de texto
    JTextArea textAreaCentro;


    //botones del flowlayout
    JButton btnAccion1 = new JButton("Opción 1");
    JButton btnAccion2 = new JButton("Opción 2");
    JButton btnAccion3 = new JButton("Opción 3");


    public BorderLayoutBasic() {
        initGUI();
        //en el constuctor se llama al initGUI aunaque se pueden hacer más cosas

    }

    private void initGUI() {
        //panel contenedor de la ventana
        panelContenedor = this.getContentPane();  //este mÉtodo me devuelve el panel contenor de este frame
        //le aplico el panel contenedor un border layout
        panelContenedor.setLayout(layout);


        //empiezo a definir los elementos
        textAreaCentro = new JTextArea(10, 50);
        textAreaCentro.setFont(fuente);
        textAreaCentro.setText("AREA DE TEXTO CENTRO ABAJO"); //le puedo poner borde, columnas, limitacion de lineas


        //a las etiquetas les asigno a todos la fuente creada anteriormente
        //no es necesario ni imprescindible, pero ayuda a mejorar la vista

        //  lblNorte.setFont(fuente);
        lblEste.setFont(fuente);
        lblOeste.setFont(fuente);
        lblSur.setFont(fuente);
        lblEste.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        //vamo a añadir a cada panel su etiqueta correspondiente
        // pnNorte.add(lblNorte);
        pnEste.add(lblEste);
        pnOeste.add(lblOeste);
        pnSur.add(lblSur);


        //panel del centro que está definido como un split pane vertical
        //Eso significa que añado 2 cosas, y una se pone encima de la otra
        //el boton,el primero, va arriba
        splitCentral.add(btnCentro);
        //con esto pongo el texto del boton arriba
        btnCentro.setVerticalAlignment(SwingConstants.TOP);

        //a continuación, debajo del botón, añado el área de texto
        splitCentral.add(textAreaCentro);
        splitCentral.setDividerLocation(400);
        splitCentral.setOneTouchExpandable(true);

        //añado los componentes al panel conteneder del JFrame
        // en las posiciones del borderlayout que yo quiera
        panelContenedor.add(pnNorte, BorderLayout.NORTH);
        panelContenedor.add(splitCentral, BorderLayout.CENTER);
        panelContenedor.add(pnOeste, BorderLayout.WEST);
        panelContenedor.add(pnEste, BorderLayout.EAST);
        panelContenedor.add(pnSur, BorderLayout.SOUTH);


        pnNorte.setLayout(fl);
        pnNorte.add(btnAccion1);
        btnAccion1.setToolTipText("Botón 1");
        //btnAccion1.setIcon(new ImageIcon("lib\\imagenes\\img.png"));
        //agrego una acción al botón 
        btnAccion1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //voy a abrir la ventana de agregar alumno, añado la acción que voy a realizar
               /* abrirVentanaAgregarAlumno();*/

            }
        });

        pnNorte.add(btnAccion2);
        btnAccion2.setToolTipText("Botón 2");
        pnNorte.add(btnAccion3);
        btnAccion3.setToolTipText("Botón 3");

    }


   /* private void abrirVentanaAgregarAlumno() {
        ProyectoInstituto.AgregarAlumnoVentana ventana = new ProyectoInstituto.AgregarAlumnoVentana();
        ventana.setTitle("Agregar alumno. ");
        ventana.setSize(400, 300);
        ventana.setVisible(true);


    }*/


    public static void main(String[] args) {
        BorderLayoutBasic ventana = new BorderLayoutBasic();
        ventana.setTitle("Ejercicio basicco border layout 2 dam");
        ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //ventana.


    }


}



