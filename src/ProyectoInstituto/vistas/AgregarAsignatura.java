package ProyectoInstituto.vistas;
import ProyectoInstituto.controlador.ControladorAsignatura;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgregarAsignatura extends JFrame {

    private JTextField txtNombre = new JTextField(20);
    private JTextField txtCurso = new JTextField(20);
    private JButton btnAceptar = new JButton("Aceptar");
    private JButton btnCancelar = new JButton("Cancelar");

    private ControladorAsignatura controlador = new ControladorAsignatura();


    public AgregarAsignatura() {

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
        agregarComponente(panelFormularioAsignatura, txtNombre, 1, 0, gbc);
        agregarComponente(panelFormularioAsignatura, new JLabel("Curso:"), 0, 1, gbc);
        agregarComponente(panelFormularioAsignatura, txtCurso, 1, 1, gbc);



        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelBotones.add(btnAceptar);
        panelBotones.add(btnCancelar);

        add(panelFormularioAsignatura, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);


        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarAsignatura();
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


    private void agregarAsignatura() {
        String nombreAsignatura = txtNombre.getText();
        int curso = Integer.parseInt(txtCurso.getText());


        int resultado = controlador.insertarAsignatura(nombreAsignatura, String.valueOf(curso));

        if (resultado > 0) {
            JOptionPane.showMessageDialog(this, "Asignatura insertada con éxito.");
        } else {
            JOptionPane.showMessageDialog(this, "Error al insertar asignatura.");
        }
        dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AgregarAsignatura().setVisible(true);
        });
    }
}

