package ProyectoInstituto.vistas;

import ProyectoInstituto.controlador.ControladorMatricula;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgregarMatricula extends JFrame {

    private JTextField txtidAlumno = new JTextField(20);
    private JTextField txtid = new JTextField(20);
    private JTextField txtNota = new JTextField(20);
    private JButton btnAceptar = new JButton("Aceptar");
    private JButton btnCancelar = new JButton("Cancelar");

    private ControladorMatricula controlador = new ControladorMatricula();

    public AgregarMatricula() {
        setTitle("Agregar Asignatura");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelFormularioAsignatura = new JPanel();
        panelFormularioAsignatura.setLayout(new GridBagLayout());
        panelFormularioAsignatura.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        agregarComponente(panelFormularioAsignatura, new JLabel("Nombre:"), 0, 0, gbc);
        agregarComponente(panelFormularioAsignatura, txtidAlumno, 1, 0, gbc);
        agregarComponente(panelFormularioAsignatura, new JLabel("Id:"), 0, 1, gbc);
        agregarComponente(panelFormularioAsignatura, txtid, 1, 1, gbc);
        agregarComponente(panelFormularioAsignatura, new JLabel("Nota:"), 0, 2, gbc);
        agregarComponente(panelFormularioAsignatura, txtNota, 1, 2, gbc);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelBotones.add(btnAceptar);
        panelBotones.add(btnCancelar);

        add(panelFormularioAsignatura, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarMatricula();
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

    private void agregarMatricula() {

        String nombreAlumno = txtidAlumno.getText();
        int idAlumno = Integer.parseInt(txtid.getText());
        float nota = Float.parseFloat(txtNota.getText());

        int resultado = controlador.insertarMatricula(Integer.parseInt(nombreAlumno), idAlumno, nota);

        if (resultado > 0) {
            JOptionPane.showMessageDialog(this, "Matrícula agregada con éxito.");
        } else {
            JOptionPane.showMessageDialog(this, "Error al agregar matrícula.");
        }
        dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AgregarMatricula().setVisible(true);
        });
    }
}
