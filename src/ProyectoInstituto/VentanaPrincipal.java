package ProyectoInstituto;

import ProyectoInstituto.vistas.AgregarAsignatura;
import ProyectoInstituto.vistas.AgregarMatricula;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {

    Container panelContenedor;
    BorderLayout layout = new BorderLayout();
    FlowLayout fl = new FlowLayout(FlowLayout.LEFT, 10, 5);


    //PANEL DE PESTAÑAS DEL CENTRO
    JTabbedPane pnPestanias = new JTabbedPane();


    //sin el borderlayout la tabla no se adapta al total del ancho disponible
    //Pintar la tabla de alumnos
    JPanel panelAlumnos = new JPanel(new BorderLayout());

    //Pintar la tabla de asignatura
    JPanel panelAsignaturas = new JPanel(new BorderLayout());

    //Pintar la tabla de matrícula
    JPanel panelMatriculas = new JPanel(new BorderLayout());


    ImageIcon alumno = new ImageIcon("C:\\Users\\gonzalez.camar\\Desktop\\Multimedia 2ºT\\untitled\\src\\Imagenes\\img.png");


    //BARRA DE MENÚ
    JMenuBar barra = new JMenuBar();
    JMenu menuAlumnos = new JMenu("Alumnos");
    JMenu menuAsignatura = new JMenu("Asignaturas");
    JMenu menuMatriculas = new JMenu("Matriculas");
    //este en su actionperformer lleva un formulario para que habra la pantalla de agregar alumno
    JMenuItem menuAgregarAlumno = new JMenuItem("Agregar alumno");
    JMenuItem menuEliminarAlumno = new JMenuItem("Eliminar alumno");
    JMenuItem menuActualizarAlumno = new JMenuItem("Editar alumno");
    JMenuItem menuAgregarAsignatura = new JMenuItem("Agregar asignatura");
    JMenuItem menuAgregarMatricula = new JMenuItem("Agregar matrícula");


    JTextArea textAreaCentro;
    JButton btnAccion1 = new JButton("Opción 1");
    JButton btnAccion2 = new JButton("Opción 2");
    JButton btnAccion3 = new JButton("Opción 3");


    //Ventana emergente de alumno
    private AgregarAlumnoVentana agregarAlumnoVentana = new AgregarAlumnoVentana();

    //Ventana emergente de asignatura
    private AgregarAsignatura agregarAsignaturaVentana = new AgregarAsignatura();

    //Ventana emergente de matrícula
    private AgregarMatricula agregarMatriculaVentana = new AgregarMatricula();


    public VentanaPrincipal() {
        initGUI();

    }

    private void initGUI() {
        this.panelContenedor = this.getContentPane();
        this.panelContenedor.setLayout(this.layout);
        this.textAreaCentro = new JTextArea(10, 50);
        // this.textAreaCentro.setFont(this.fuente);
        this.textAreaCentro.setText("AREA DE TEXTO CENTRO ABAJO");


        //agrego componenetes al panel contenedor del JFrame
        //en las posiciones del border layout

        this.panelContenedor.add(pnPestanias, "Center");

        this.btnAccion1.setToolTipText("Botón 1");
        this.btnAccion2.setToolTipText("Botón 2");
        this.btnAccion3.setToolTipText("Botón 3");

        initMenu();

        inicarTablaAlumnos();

        iniciarTablaAsignaturas();

        establecerPestanias();
    }

    //PANEL DE PESTAÑAS
    private void establecerPestanias() {

        inicarTablaAlumnos();

        //Pestaña alumnos
        pnPestanias.addTab("Alumnos", panelAlumnos);

       //Pestaña asignaturas
        pnPestanias.addTab("Asignaturas", panelAsignaturas);

        //Pestaña matriculas
        pnPestanias.addTab("Matrículas", panelMatriculas);

    }

    //Menú
    private void initMenu() {
        this.setJMenuBar(barra);
        barra.add(menuAlumnos);
        barra.add(menuAsignatura);
        barra.add(menuMatriculas);
        menuAlumnos.add(menuAgregarAlumno);
        menuAlumnos.add(menuActualizarAlumno);
        menuAlumnos.add(menuEliminarAlumno);
        menuAgregarAlumno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirVentanaAgregarAlumno();
            }
            //incluimos el abrirVentanaAgregarAlumno
        });
        menuAsignatura.add(menuAgregarAsignatura);
        menuAgregarAsignatura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirVentanaAgregarAsignatura();
            }
        });

        menuMatriculas.add(menuAgregarMatricula);
        menuAgregarMatricula.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirVentanaAgregarMatricula();
            }
        });


    }

    private void abrirVentanaAgregarAlumno() {
        agregarAlumnoVentana.setTitle("Agregar alumnno");
        agregarAlumnoVentana.setSize(400, 300);
        agregarAlumnoVentana.setVisible(true);
    }

    private void abrirVentanaAgregarAsignatura() {
     agregarAsignaturaVentana.setTitle("Agregar asignatura");
     agregarAsignaturaVentana.setSize(400, 300);
     agregarAsignaturaVentana.setVisible(true);
    }

    private void abrirVentanaAgregarMatricula(){

        agregarMatriculaVentana.setTitle("Agregar matriculta");
        agregarMatriculaVentana.setSize(400, 300);
        agregarAsignaturaVentana.setVisible(true);
    }


    private void inicarTablaAlumnos() {
        //creamos la tabla a partir del modelo definido TablaAlumnosModel
        JTable tablaAlumnos = new JTable(new TablaAlumnosModel());
        panelAlumnos.add(new JScrollPane(tablaAlumnos), BorderLayout.CENTER);
        //le añadimso un modo de redimensionamiento de columnas especial a la tabla
        tablaAlumnos.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        panelAlumnos.setBorder(new EmptyBorder(10, 10, 10, 10));
    }


    private void iniciarTablaAsignaturas(){
        //Creamos la tabla a partir del modelo definido en TablaAsignaturaModel
        JTable tablaAsignatura = new JTable(new TablaAsignaturaModel());
        panelAsignaturas.add(new JScrollPane(tablaAsignatura), BorderLayout.CENTER);
        tablaAsignatura.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        panelAsignaturas.setBorder(new EmptyBorder(10,10,10,10));
    }

    private void iniciarTablaMatriculas(){
        //Creamos la tabla a partir del modelo definido en TablaMatriculaModel
        JTable tablaMatriculas = new JTable(new TablaAsignaturaModel());
        panelMatriculas.add(new JScrollPane(tablaMatriculas), BorderLayout.CENTER);
        tablaMatriculas.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        panelMatriculas.setBorder(new EmptyBorder(10,10,10,10));
    }



    public static void main(String[] args) {
        VentanaPrincipal ventana = new VentanaPrincipal();
        ventana.setTitle("Colegio Salesianos");
        ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}




