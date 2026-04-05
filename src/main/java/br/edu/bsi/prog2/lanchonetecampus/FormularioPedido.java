package br.edu.bsi.prog2.lanchonetecampus;

import java.awt.Color;
import javax.swing.JOptionPane;

public class FormularioPedido extends javax.swing.JFrame {

    public FormularioPedido() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        configurarTela();
    }

    // Configura cores e logo da tela
    private void configurarTela() {
        Color verdePastel = new Color(198, 239, 206);
        getContentPane().setBackground(verdePastel);
        jPanel1.setBackground(verdePastel);

        btnConfirmar.setBackground(new Color(34, 139, 34));
        btnConfirmar.setForeground(Color.WHITE);
        btnLimpar.setBackground(new Color(255, 200, 0));
        btnSair.setBackground(new Color(200, 30, 30));
        btnSair.setForeground(Color.WHITE);
        btnConfirmar.setEnabled(false);

        try {
            java.net.URL imgURL = getClass().getResource("/logo.jpeg");
            if (imgURL != null) {
                javax.swing.ImageIcon logo = new javax.swing.ImageIcon(imgURL);
                java.awt.Image img = logo.getImage().getScaledInstance(120, 60, java.awt.Image.SCALE_SMOOTH);
                lblTitulo.setIcon(new javax.swing.ImageIcon(img));
                lblTitulo.setText(" Lanchonete Campus");
            }
        } catch (Exception e) {
            System.out.println("Logo não encontrada: " + e.getMessage());
        }
    }

    // Atualiza o total conforme lanche, bebida e quantidade
    private void atualizarTotal() {
        double precoLanche = 0;
        double precoBebida = 0;

        switch (cbLanche.getSelectedIndex()) {
            case 1: precoLanche = 15.00; break;
            case 2: precoLanche = 18.00; break;
            case 3: precoLanche = 20.00; break;
            case 4: precoLanche = 25.00; break;
        }

        switch (cbBebida.getSelectedIndex()) {
            case 1: precoBebida = 5.00; break;
            case 2: precoBebida = 7.00; break;
            case 3: precoBebida = 3.00; break;
            case 4: precoBebida = 5.00; break;
        }

        int qtd = (Integer) spnQtd.getValue();
        double total = (precoLanche * qtd) + precoBebida;
        lblTotal.setText(String.format("Total: R$ %.2f", total));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        grupEntrega = new javax.swing.ButtonGroup();
        jCheckBox2 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblLanche = new javax.swing.JLabel();
        cbLanche = new javax.swing.JComboBox<>();
        lblBebida = new javax.swing.JLabel();
        cbBebida = new javax.swing.JComboBox<>();
        lblEntrega = new javax.swing.JLabel();
        rbLocal = new javax.swing.JRadioButton();
        rbViagem = new javax.swing.JRadioButton();
        rbDelivery = new javax.swing.JRadioButton();
        lblOpcionais = new javax.swing.JLabel();
        chkSemCebola = new javax.swing.JCheckBox();
        chkSemAlface = new javax.swing.JCheckBox();
        chkPontoExtra = new javax.swing.JCheckBox();
        lblQtd = new javax.swing.JLabel();
        spnQtd = new javax.swing.JSpinner();
        lblObs = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taObservacao = new javax.swing.JTextArea();
        lblTotal = new javax.swing.JLabel();
        btnConfirmar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        lblStatus = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jTextField1.setText("jTextField1");
        jCheckBox2.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lanchonete Campus — Faça seu Pedido");

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Lanchonete Campus");

        lblNome.setText("Nome do Cliente:");

        // Evento 1 - KeyListener: atualiza status ao digitar
        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lblStatus.setText("Digitando nome: " + txtNome.getText());
                btnConfirmar.setEnabled(!txtNome.getText().isEmpty());
            }
        });

        // Evento 2 - FocusListener: valida campo ao perder foco
        txtNome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (txtNome.getText().trim().isEmpty()) {
                    lblStatus.setText("⚠️ Nome obrigatório!");
                    lblStatus.setForeground(Color.RED);
                    txtNome.setBorder(new javax.swing.border.LineBorder(Color.RED, 2));
                } else {
                    lblStatus.setText("✅ Nome preenchido!");
                    lblStatus.setForeground(new Color(0, 128, 0));
                    txtNome.setBorder(new javax.swing.border.LineBorder(Color.GRAY, 1));
                }
            }
        });

        lblLanche.setText("Lanche: ");

        cbLanche.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Selecione...", "X-Burguer - R$15,00", "X-Salada - R$18,00", "X-Bacon - R$20,00", "X-Tudo - R$25,00"}));

        // Evento 3 - ItemListener: atualiza total ao trocar lanche
        cbLanche.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                if (cbLanche.getSelectedIndex() > 0) {
                    lblStatus.setText("Lanche: " + cbLanche.getSelectedItem());
                    lblStatus.setForeground(Color.BLUE);
                    atualizarTotal();
                }
            }
        });

        lblBebida.setText("Bebida: ");

        cbBebida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Selecione...", "Coca-Cola - R$5,00", "Suco - R$7,00", "Água - R$3,00", "Guaraná - R$5,00"}));

        // Evento 4 - ItemListener: atualiza total ao trocar bebida
        cbBebida.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                if (cbBebida.getSelectedIndex() > 0) {
                    lblStatus.setText("Bebida: " + cbBebida.getSelectedItem());
                    lblStatus.setForeground(Color.BLUE);
                    atualizarTotal();
                }
            }
        });

        lblEntrega.setText("Tipo de Entrega");

        grupEntrega.add(rbLocal);
        rbLocal.setText("Comer aqui");

        // Evento 5 - ActionListener: RadioButton tipo de entrega
        rbLocal.addActionListener(e -> { lblStatus.setText("Entrega: Comer aqui"); lblStatus.setForeground(Color.BLUE); });

        grupEntrega.add(rbViagem);
        rbViagem.setText("Para viagem");
        rbViagem.addActionListener(e -> { lblStatus.setText("Entrega: Para viagem"); lblStatus.setForeground(Color.BLUE); });

        grupEntrega.add(rbDelivery);
        rbDelivery.setText("Delivery");
        rbDelivery.addActionListener(e -> { lblStatus.setText("Entrega: Delivery"); lblStatus.setForeground(Color.BLUE); });

        lblOpcionais.setText("Opcionais");

        chkSemCebola.setText("Sem Cebola");

        // Evento 6 - ActionListener: CheckBox opcionais
        chkSemCebola.addActionListener(e -> {
            lblStatus.setText(chkSemCebola.isSelected() ? "Adicionado: Sem Cebola" : "Removido: Sem Cebola");
            lblStatus.setForeground(Color.BLUE);
        });

        chkSemAlface.setText("Sem Alface");
        chkSemAlface.addActionListener(e -> {
            lblStatus.setText(chkSemAlface.isSelected() ? "Adicionado: Sem Alface" : "Removido: Sem Alface");
            lblStatus.setForeground(Color.BLUE);
        });

        chkPontoExtra.setText("Ponto Extra");
        chkPontoExtra.addActionListener(e -> {
            lblStatus.setText(chkPontoExtra.isSelected() ? "Adicionado: Ponto Extra" : "Removido: Ponto Extra");
            lblStatus.setForeground(Color.BLUE);
        });

        lblQtd.setText("Quantidade: ");

        spnQtd.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10, 1));

        // Evento 7 - ChangeListener:Spinner de quantidade
        spnQtd.addChangeListener(e -> {
            lblStatus.setText("Quantidade: " + spnQtd.getValue());
            lblStatus.setForeground(Color.BLUE);
            atualizarTotal();
        });

        lblObs.setText("Observações: ");

        taObservacao.setColumns(20);
        taObservacao.setRows(3);
        jScrollPane1.setViewportView(taObservacao);

        lblTotal.setFont(new java.awt.Font("Segoe UI", 1, 16));
        lblTotal.setText("Total: R$ 0,00");

        btnConfirmar.setText("Confirmar Pedido");

        // Evento 8 - ActionListener: botão Confirmar com validação
        btnConfirmar.addActionListener(e -> {
            if (cbLanche.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(this, "Escolha um lanche!", "Atenção", JOptionPane.WARNING_MESSAGE);
                return;
            }
            String msg = "✅ Pedido confirmado!\n\n"
                    + "Cliente: " + txtNome.getText() + "\n"
                    + "Lanche: " + cbLanche.getSelectedItem() + "\n"
                    + "Bebida: " + cbBebida.getSelectedItem() + "\n"
                    + "Quantidade: " + spnQtd.getValue() + "\n"
                    + lblTotal.getText();
            JOptionPane.showMessageDialog(this, msg, "Pedido Enviado", JOptionPane.INFORMATION_MESSAGE);
            lblStatus.setText("Pedido confirmado para: " + txtNome.getText());
            lblStatus.setForeground(new Color(0, 128, 0));
        });

        btnLimpar.setText("Limpar");

        // Evento 9 - ActionListener: botão Limpar com confirmação
        btnLimpar.addActionListener(e -> {
            int r = JOptionPane.showConfirmDialog(this, "Deseja limpar o formulário?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (r == JOptionPane.YES_OPTION) {
                txtNome.setText("");
                cbLanche.setSelectedIndex(0);
                cbBebida.setSelectedIndex(0);
                grupEntrega.clearSelection();
                chkSemCebola.setSelected(false);
                chkSemAlface.setSelected(false);
                chkPontoExtra.setSelected(false);
                spnQtd.setValue(1);
                taObservacao.setText("");
                lblTotal.setText("Total: R$ 0,00");
                lblStatus.setText("Formulário limpo!");
                lblStatus.setForeground(Color.GRAY);
                btnConfirmar.setEnabled(false);
            }
        });

        btnSair.setText("Sair");

        // Evento 10 - ActionListener: botão Sair com confirmação
        btnSair.addActionListener(e -> {
            int r = JOptionPane.showConfirmDialog(this, "Deseja realmente sair?", "Sair", JOptionPane.YES_NO_OPTION);
            if (r == JOptionPane.YES_OPTION) System.exit(0);
        });

        lblStatus.setText("Aguardando ação...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblBebida, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblLanche, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbLanche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbBebida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblEntrega)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbLocal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbViagem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbDelivery))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblOpcionais)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkSemCebola)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkSemAlface)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkPontoExtra))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblQtd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spnQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblObs)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTotal)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnConfirmar)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpar)
                        .addGap(18, 18, 18)
                        .addComponent(btnSair))
                    .addComponent(lblStatus))
                .addContainerGap(300, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLanche)
                    .addComponent(cbLanche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBebida)
                    .addComponent(cbBebida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEntrega)
                    .addComponent(rbLocal)
                    .addComponent(rbViagem)
                    .addComponent(rbDelivery))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblOpcionais)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(chkSemCebola)
                        .addComponent(chkSemAlface)
                        .addComponent(chkPontoExtra)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblQtd)
                    .addComponent(spnQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lblObs)))
                .addGap(24, 24, 24)
                .addComponent(lblTotal)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmar)
                    .addComponent(btnLimpar)
                    .addComponent(btnSair))
                .addGap(26, 26, 26)
                .addComponent(lblStatus)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(FormularioPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> new FormularioPedido().setVisible(true));
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSair;
    private javax.swing.JComboBox<String> cbBebida;
    private javax.swing.JComboBox<String> cbLanche;
    private javax.swing.JCheckBox chkPontoExtra;
    private javax.swing.JCheckBox chkSemAlface;
    private javax.swing.JCheckBox chkSemCebola;
    private javax.swing.ButtonGroup grupEntrega;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblBebida;
    private javax.swing.JLabel lblEntrega;
    private javax.swing.JLabel lblLanche;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblObs;
    private javax.swing.JLabel lblOpcionais;
    private javax.swing.JLabel lblQtd;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JRadioButton rbDelivery;
    private javax.swing.JRadioButton rbLocal;
    private javax.swing.JRadioButton rbViagem;
    private javax.swing.JSpinner spnQtd;
    private javax.swing.JTextArea taObservacao;
    private javax.swing.JTextField txtNome;
    // End of variables declaration
}