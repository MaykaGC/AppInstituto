import ProyectoInstituto.AgregarAlumnoVentana;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;


public class BorderLayoutBasic extends JFrame {
    BorderLayout layout = new BorderLayout();
    FlowLayout fl = new FlowLayout(0, 10, 5);
    Font fuente = new Font("Courier", 1, 36);

    JLabel lblOeste = new JLabel("Etiqueta oeste");
    JLabel lblEste = new JLabel("Etiqueta Este");
    JLabel lblSur = new JLabel("Etiqueta sur");

    Container panelContenedor;
    JPanel pnOeste = new JPanel();
    JPanel pnEste = new JPanel();
    JPanel pnSur = new JPanel();
    JPanel pnNorte = new JPanel();
    JSplitPane splitCentral = new JSplitPane(0);

    JButton btnCentro = new JButton("Boton centro");
    JTextArea textAreaCentro;
    JButton btnAccion1 = new JButton("Opción 1");
    JButton btnAccion2 = new JButton("Opción 2");
    JButton btnAccion3 = new JButton("Opción 3");

    private AgregarAlumnoVentana agregarAlumnoVentana = new AgregarAlumnoVentana();


    public BorderLayoutBasic() {

        this.initGUI();
    }

    private void initGUI() {
        this.panelContenedor = this.getContentPane();
        this.panelContenedor.setLayout(this.layout);
        this.textAreaCentro = new JTextArea(10, 50);
        this.textAreaCentro.setFont(this.fuente);
        this.textAreaCentro.setText("AREA DE TEXTO CENTRO ABAJO");


        this.lblEste.setFont(this.fuente);
        this.lblOeste.setFont(this.fuente);
        this.lblSur.setFont(this.fuente);
        this.lblEste.setBorder(BorderFactory.createBevelBorder(0));

        this.pnEste.add(this.lblEste);
        this.pnOeste.add(this.lblOeste);
        this.pnSur.add(this.lblSur);


        this.splitCentral.add(this.btnCentro);
        this.btnCentro.setVerticalAlignment(1);
        //propiedades del panel divisor
        this.splitCentral.add(this.textAreaCentro);
        this.splitCentral.setDividerLocation(400);
        this.splitCentral.setOneTouchExpandable(true);

        //agrego componenetes al panel contenedor del JFrame
        //en las posiciones del border layout
        this.panelContenedor.add(this.pnNorte, "North");
        this.panelContenedor.add(this.splitCentral, "Center");
        this.panelContenedor.add(this.pnOeste, "West");
        this.panelContenedor.add(this.pnEste, "East");
        this.panelContenedor.add(this.pnSur, "South");

        this.pnNorte.setLayout(this.fl);
        this.pnNorte.add(this.btnAccion1);
        this.btnAccion1.setToolTipText("Botón 1");
        this.pnNorte.add(this.btnAccion2);
        this.btnAccion2.setToolTipText("Botón 2");
        this.pnNorte.add(this.btnAccion3);
        this.btnAccion3.setToolTipText("Botón 3");

    }

    private void abrirVentanaAgregarAlumno(){
         agregarAlumnoVentana.setTitle("Agregar alumnno");
         agregarAlumnoVentana.setSize(400, 300);
         agregarAlumnoVentana.setVisible(true);
    }

    public static void main(String [] arg){

        AgregarAlumnoVentana ventana = new AgregarAlumnoVentana();
        ventana.setTitle("Ejercicio con border layout");
        ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

