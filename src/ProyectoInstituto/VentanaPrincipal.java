package ProyectoInstituto;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static java.awt.SystemColor.menu;

public class VentanaPrincipal extends JFrame {

    Container panelContenedor;
    BorderLayout layout = new BorderLayout();
    FlowLayout fl = new FlowLayout(FlowLayout.LEFT, 10, 5);
    Font tipoFuente = new Font("Courier", Font.BOLD, 25);
    JButton getBtnCentro = new JButton("Botón centro");
    JTextArea getTextAreaCentro;

    JPanel pnEste = new JPanel();
    JPanel pnNorte = new JPanel();

    //PANEL DE PESTAÑAS DEL CENTRO
    JTabbedPane pnPestanias = new JTabbedPane();


    //sin el borderlayout la tabla no se adapta al total del ancho disponible
    JPanel panelAlumnos = new JPanel(new BorderLayout());


    //BARRA DE MENÚ
    JMenuBar barra = new JMenuBar();
    JMenu menuAlumnos = new JMenu("Alumnos");
    JMenu menuAsignatura = new JMenu("Asiganturas");
    JMenu menuMatriculas = new JMenu("Matriculas");
    //este en su actionperformer lleva un formulario para que habra la pantalla de agregar alumno
    JMenuItem menuAgregarAlumno = new JMenuItem("Agregar alumno");


    JSplitPane splitCentral = new JSplitPane(0);
    JButton btnCentro = new JButton("Boton centro");
    JTextArea textAreaCentro;
    JButton btnAccion1 = new JButton("Opción 1");
    JButton btnAccion2 = new JButton("Opción 2");
    JButton btnAccion3 = new JButton("Opción 3");


    private AgregarAlumnoVentana agregarAlumnoVentana = new AgregarAlumnoVentana();

    public VentanaPrincipal() {
        initGUI();

    }

    private void initGUI() {
        this.panelContenedor = this.getContentPane();
        this.panelContenedor.setLayout(this.layout);
        this.textAreaCentro = new JTextArea(10, 50);
        // this.textAreaCentro.setFont(this.fuente);
        this.textAreaCentro.setText("AREA DE TEXTO CENTRO ABAJO");

        /*this.splitCentral.add(this.btnCentro);
        this.btnCentro.setVerticalAlignment(1);
        //propiedades del panel divisor
        this.splitCentral.add(this.textAreaCentro);
        this.splitCentral.setDividerLocation(400);
        this.splitCentral.setOneTouchExpandable(true);*/

        //agrego componenetes al panel contenedor del JFrame
        //en las posiciones del border layout

        this.panelContenedor.add(pnPestanias, "Center");

        this.btnAccion1.setToolTipText("Botón 1");
        this.btnAccion2.setToolTipText("Botón 2");
        this.btnAccion3.setToolTipText("Botón 3");
        initMenu();

        inicarTablaAlumnos();

        establecerPestanias();
    }

    //PANEL DE PESTAÑAS
    private void establecerPestanias() {
        //primero hacemos una consultar a la base de datos
        ;
        inicarTablaAlumnos();
        //panelAlumnos.add(new JLabel("Aquí irá la tabla de alumnos"));
        pnPestanias.addTab("Alumnos", panelAlumnos);
        //    pnPestanias.addTab("Alumnos", new ImageIcon(()), panelAlumnos);
        //le puedo poner una imagen como arriab
        //añadir alog para las otras 2 pestañas
        JPanel panelAsiganturas = new JPanel();
        panelAsiganturas.add(new JLabel("Aquí irá la table de asignaturas"));
        pnPestanias.addTab("Asignaturas ", panelAsiganturas);
        JPanel panelMatricula = new JPanel();
        panelMatricula.add(new Label("Aquí ira la tabla matrícula. "));
        pnPestanias.addTab("Matrículas", new ImageIcon(), panelMatricula);


    }

    //Menú
    private void initMenu() {
        this.setJMenuBar(barra);
        barra.add(menuAlumnos);
        barra.add(menuAsignatura);
        barra.add(menuMatriculas);
        menuAlumnos.add(menuAgregarAlumno);
        menuAgregarAlumno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirVentanaAgregarAlumno();
            }
            //incluimos el abrirVentanaAgregarAlumno
        });
    }

    private void abrirVentanaAgregarAlumno() {
        agregarAlumnoVentana.setTitle("Agregar alumnno");
        agregarAlumnoVentana.setSize(400, 300);
        agregarAlumnoVentana.setVisible(true);
    }


    private void inicarTablaAlumnos() {
        //creamos la tabla a partir del modelo definido TablaAlumnosModel
        JTable tablaAlumnos = new JTable(new TablaAlumnosModel());
        panelAlumnos.add(new JScrollPane(tablaAlumnos), BorderLayout.CENTER);
        //le añadimso un modo de redimensionamiento de columnas especial a la tabla
        tablaAlumnos.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        panelAlumnos.setBorder(new EmptyBorder(10, 10, 10, 10));
    }


    public static void main(String[] args) {

        VentanaPrincipal ventana = new VentanaPrincipal();
        ventana.setTitle("Ejercicio con border layout");
        ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}




