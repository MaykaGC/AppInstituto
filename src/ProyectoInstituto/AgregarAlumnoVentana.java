package ProyectoInstituto;

import ProyectoInstituto.controlador.ControladorAlumno;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgregarAlumnoVentana extends JFrame {

    private JTextField txtNombre = new JTextField(20);
    private JTextField txtDireccion = new JTextField(20);
    private JTextField txtMatricula = new JTextField(20);
    private JButton btnAceptar = new JButton("Aceptar");
    private JButton btnCancelar = new JButton("Cancelar");

    private ControladorAlumno controlador = new ControladorAlumno();

    public AgregarAlumnoVentana() {
        setTitle("Agregar Alumno");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelFormulario = new JPanel();
        panelFormulario.setLayout(new GridBagLayout());
        panelFormulario.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        agregarComponente(panelFormulario, new JLabel("Nombre:"), 0, 0, gbc);
        agregarComponente(panelFormulario, txtNombre, 1, 0, gbc);
        agregarComponente(panelFormulario, new JLabel("Dirección:"), 0, 1, gbc);
        agregarComponente(panelFormulario, txtDireccion, 1, 1, gbc);
        agregarComponente(panelFormulario, new JLabel("Estado de matrícula:"), 0, 2, gbc);
        agregarComponente(panelFormulario, txtMatricula, 1, 2, gbc);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelBotones.add(btnAceptar);
        panelBotones.add(btnCancelar);

        add(panelFormulario, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarAlumno();
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void agregarComponente(JPanel panel, Component componente, int x, int y, GridBagConstraints gbc) {
        gbc.gridx = x;
        gbc.gridy = y;
        panel.add(componente, gbc);
    }

    private void agregarAlumno() {
        String nombre = txtNombre.getText();
        String direccion = txtDireccion.getText();
        String estadoMatricula = txtMatricula.getText();

        int resultado = controlador.insertarAlumno(nombre, direccion, estadoMatricula);

        if (resultado > 0) {
            JOptionPane.showMessageDialog(this, "Alumno insertado con éxito.");
        } else {
            JOptionPane.showMessageDialog(this, "Error al insertar alumno.");
        }
        dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AgregarAlumnoVentana().setVisible(true);
        });
    }
}
