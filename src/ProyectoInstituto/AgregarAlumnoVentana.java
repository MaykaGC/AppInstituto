package ProyectoInstituto;

import ProyectoInstituto.controlador.ControladorAlumno;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AgregarAlumnoVentana extends JFrame {

    Container panel;
    GridLayout gridLayout;
    JButton btnAceptar = new JButton("Aceptar");
    JButton btnCancelar = new JButton("Cancelar");

    JLabel lblNombre = new JLabel("Nombre");
    JLabel lblDireccion = new JLabel("Dirección: ");
    JLabel lblEstadoMatricula = new JLabel("Estado de matrícula: ");

    JTextField txtNombre = new JTextField(30);
    JTextField txtDireccion = new JTextField(30);
    JTextField txtMatricula = new JTextField(30);

    //Objeto controlador porque hay que llamar al metodo
    ControladorAlumno controlador = new ControladorAlumno();

    public AgregarAlumnoVentana() {

        initGUI();
    }

    //SetBounds para hacerla más bonita, con GridBagLayout
    //o diversos Flowlayout en el que se va añadiendo uno debajo del otro  con un boxlayout dentro
    //con paneles se pueden anida paneles
    //boxlayout va añadiendo cosas en vertical como los lineas layout. POdemos hacer que cada
    //linea sea un JPanel y este tener dentro un flowlayout.left con un - JLabel y un -JTextField
    //si queremos hacer un layout dentro de otro tiene que ser con un JPanel

    public void initGUI() {
        gridLayout = new GridLayout(3, 2);
        //Este es el panel contenedor de la ventana
        //al que le tngo que establecer el layout que yo quiera
        panel = this.getContentPane();
        //al panel contenedor le pongo un grid layout
        panel.setLayout(gridLayout);
        panel.add(lblNombre);
        panel.add(lblDireccion);
        panel.add(lblEstadoMatricula);
        panel.add(txtNombre);

        panel.add(btnAceptar);
        panel.add(btnCancelar);
    }
    /*public void iniciarEventos (){

        btnCancelar.addActionListener(ActionEvent e);
      }Ç*/


    private void agregarAlumno(){
        //va a tomar los textos de los campos de la ventana
        String nombre= txtNombre.getText();
        String direccion = txtDireccion.getText();
        String estadoMatricula= txtMatricula.getText();
        //recojo en una variable el resultado de insertar un alumno
        int resultado = controlador.insertarAlumno(nombre, direccion, estadoMatricula);
        //Si es mayor que 0 voy a mostrar un JDialog informando de que ha sido exitoso
        if (resultado > 0){
            JOptionPane.showMessageDialog(this, "Alumno insertado con éxito.");



        } else {
            JOptionPane.showMessageDialog(this, "Error al insertar alumno. ");
        }
        dispose();


    }


    public static void main(String[] args) {
        //creamos una instancia de ventana
        AgregarAlumnoVentana ventana = new AgregarAlumnoVentana();
        ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ventana.setTitle("Agragar alumno");
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
