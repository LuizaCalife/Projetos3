package br.edu.cesarschool.projetos.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

import br.edu.cesarschool.projetos.caminhao.Caminhao;
import br.edu.cesarschool.projetos.caminhao.CaminhaoMediator;
import br.edu.cesarschool.projetos.caminhao.Empresa;
import br.edu.cesarschool.projetos.caminhao.Rota;
import br.edu.cesarschool.projetos.caminhao.EmpresaMediator;
import br.edu.cesarschool.projetos.caminhao.RotaMediator;

public class TelaGuiCaminhao extends JFrame {
    private CaminhaoMediator caminhaoMediator = CaminhaoMediator.obterInstancia();
    private EmpresaMediator empresaMediator = EmpresaMediator.obterInstancia();
    private RotaMediator rotaMediator = RotaMediator.obterInstancia();

    private JTextField placaField, telefoneField;
    private JComboBox<Empresa> empresaComboBox;
    private JComboBox<Rota> rotaComboBox;
    private JButton salvarButton, buscarButton, limparButton;

    public TelaGuiCaminhao() {
        setTitle("Cadastro de Caminhões");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initGUI();
    }

    private void initGUI() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().setBackground(new Color(245, 245, 245)); // Fundo principal
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        addLabel("Placa:", gbc);
        placaField = new JTextField(20);
        styleTextField(placaField);
        add(placaField, gbc);

        addLabel("Telefone:", gbc);
        telefoneField = new JTextField(20);
        styleTextField(telefoneField);
        add(telefoneField, gbc);

        addLabel("Empresa:", gbc);
        empresaComboBox = new JComboBox<>();
        fillEmpresaComboBox();
        styleComboBox(empresaComboBox);
        add(empresaComboBox, gbc);

        addLabel("Rota:", gbc);
        rotaComboBox = new JComboBox<>();
        styleComboBox(rotaComboBox);
        fillRotaComboBox();
        add(rotaComboBox, gbc);

        salvarButton = new JButton("Salvar");
        styleButton(salvarButton);
        salvarButton.addActionListener(this::salvarCaminhao);
        add(salvarButton, gbc);

        buscarButton = new JButton("Buscar");
        styleButton(buscarButton);
        buscarButton.addActionListener(this::buscarCaminhao);
        add(buscarButton, gbc);

        limparButton = new JButton("Limpar");
        styleButton(limparButton);
        limparButton.addActionListener(e -> resetForm());
        add(limparButton, gbc);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addLabel(String text, GridBagConstraints gbc) {
        JLabel label = new JLabel(text);
        label.setForeground(new Color(25, 25, 112));
        add(label, gbc);
    }

    private void styleTextField(JTextField field) {
        field.setBackground(Color.WHITE);
        field.setBorder(BorderFactory.createLineBorder(new Color(192, 192, 192), 1));
    }

    private void styleComboBox(JComboBox<?> comboBox) {
        comboBox.setBackground(Color.WHITE);
        comboBox.setForeground(Color.DARK_GRAY);

        comboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Empresa) {
                    Empresa empresa = (Empresa) value;
                    setText(empresa.getNome());
                } else if (value instanceof Rota) {
                    Rota rota = (Rota) value;
                    setText(rota.getEndereco());
                }
                setBackground(isSelected ? Color.LIGHT_GRAY : Color.WHITE);
                setForeground(isSelected ? Color.BLUE : Color.BLACK); 
                return this;
            }
        });
    }


    private void styleButton(JButton button) {
        button.setBackground(new Color(100, 149, 237));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 12));
    }

    private void fillEmpresaComboBox() {
        List<Empresa> empresas = empresaMediator.buscarTodas();
        for (Empresa empresa : empresas) {
            empresaComboBox.addItem(empresa);
        }
    }

    private void fillRotaComboBox() {
        List<Rota> rotas = rotaMediator.buscarTodas();
        for (Rota rota : rotas) {
            rotaComboBox.addItem(rota);
        }
    }

    private void salvarCaminhao(ActionEvent e) {
        String placa = placaField.getText();
        String telefone = telefoneField.getText();
        Empresa empresa = (Empresa) empresaComboBox.getSelectedItem();
        Rota rota = (Rota) rotaComboBox.getSelectedItem();

        Caminhao caminhao = new Caminhao(placa, telefone, empresa, rota);
        String resultado = caminhaoMediator.incluir(caminhao);
        JOptionPane.showMessageDialog(this, resultado == null ? "Caminhão salvo com sucesso." : resultado, "Resultado", JOptionPane.INFORMATION_MESSAGE);
    }

    private void buscarCaminhao(ActionEvent e) {
        String placa = placaField.getText();
        Caminhao caminhao = caminhaoMediator.buscar(placa);
        if (caminhao != null) {
            telefoneField.setText(caminhao.getTelefone());
            empresaComboBox.setSelectedItem(caminhao.getEmpresa());
            rotaComboBox.setSelectedItem(caminhao.getRota());
        } else {
            JOptionPane.showMessageDialog(this, "Caminhão não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void resetForm() {
        placaField.setText("");
        telefoneField.setText("");
        empresaComboBox.setSelectedIndex(0);
        rotaComboBox.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        new TelaGuiCaminhao();
    }
    
}
