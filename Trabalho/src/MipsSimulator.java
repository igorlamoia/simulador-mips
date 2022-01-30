/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import helpers.Convercao;
/**
 *
 * @author Igor Lamoia Queiroz
 */
public class MipsSimulator extends javax.swing.JFrame {

    /**
     * Creates new form MipsSimulator
     */
    final String VALOR_PADRAO = "0x00000000";
    public String console = "";
    public List<String> codigoCompilado = new ArrayList<>();
    public Integer PC = 0;
    public String $zero = this.VALOR_PADRAO;
    public String $s0 = this.VALOR_PADRAO;
    public String $s1 = this.VALOR_PADRAO;
    public String $s2 = this.VALOR_PADRAO;
    public String $s3 = this.VALOR_PADRAO;
    public String $s4 = this.VALOR_PADRAO;
    public String $s5 = this.VALOR_PADRAO;
    public String $s6 = this.VALOR_PADRAO;
    public String $s7 = this.VALOR_PADRAO;
    public String $t0 = this.VALOR_PADRAO;
    public String $t1 = this.VALOR_PADRAO;
    public String $t2 = this.VALOR_PADRAO;
    public String $t3 = this.VALOR_PADRAO;
    public String $t4 = this.VALOR_PADRAO;
    public String $t5 = this.VALOR_PADRAO;
    public String $t6 = this.VALOR_PADRAO;
    public String $t7 = this.VALOR_PADRAO;
    public String $t8 = this.VALOR_PADRAO;
    public String $t9 = this.VALOR_PADRAO;
    public String valor = ""; 
    Converter converter;
    Controle controle;
    ALU alu;
    MemoriaInstrucao memoriaInstrucao;
    public String regDST;
    public String jump;
    public String branch;
    public String memRead;
    public String memToReg;
    public String aluOp;
    public String memWrite;
    public String aluSRC;
    public String regWrite;
    public String entradaDeControleALU = ""; // 4 bits 


    public String enderecoDeLeitura = "";
    public String controleValor = "";
    public String controleDescricao = "";
    
    public String dadosParaEscrita = "";
    
    public MipsSimulator() {
        this.converter = new Converter(this); // this -> Classe Mips inteira sendo passada como parâmetro
        this.controle = new Controle(this); // this -> Classe Mips inteira sendo passada como parâmetro
        this.alu = new ALU(this); // this -> Classe Mips inteira sendo passada como parâmetro
        this.memoriaInstrucao = new MemoriaInstrucao(this); // this -> Classe Mips inteira sendo passada como parâmetro
        initComponents();
        this.jTextLinhaLida.setEnabled(false); // Nunca deixar linha habilitada, somente leitura
        this.sumirComLabels(); // Sumindo com as labels
        this.jTextAreaConsole.setText(new String (
            "or $s2, $s1, $s0 # comentário inútil\n"
            +"and $s3, $s0, $s2\n"
            + "# comentário inútil\n"
            + "# comentário inútil\n"
            + " \n"
            +"sub $s4, $s2, $s3\n"
            +"label_jump:\n"
            +"add $s5, $s5, $s0\n"
            +"slt $t0, $s1, $s5\n"
            +"beq $t1, $zero, label_beq\n"
            +"j label_jump\n"
            +"label_beq:\n"
            +"sw $s5, 0($zero)\n"
            +"lw $t1, 0($zero)\n"
        )
        );
        // this.jTextLinhaOp.setVisible(false);
    }
    
    public void setAddress (String campo, String valor) {
        switch (campo) {
            case "address1":
                this.jTextAdressValue1.setText(Convercao.binToHex0x(valor));
                this.jTextAdressValue1.setBackground(Color.cyan);
                break;
            case "address2":
                this.jTextAdressValue2.setText(Convercao.binToHex0x(valor));
                this.jTextAdressValue2.setBackground(Color.cyan);
                break;
            case "address3":
                this.jTextAdressValue3.setText(Convercao.binToHex0x(valor));
                this.jTextAdressValue3.setBackground(Color.cyan);
                break;
            case "address4":
                this.jTextAdressValue4.setText(Convercao.binToHex0x(valor));
                this.jTextAdressValue4.setBackground(Color.cyan);
                break;
            case "address5":
                this.jTextAdressValue5.setText(Convercao.binToHex0x(valor));
                this.jTextAdressValue5.setBackground(Color.cyan);
                break;
            case "address6":
                this.jTextAdressValue6.setText(Convercao.binToHex0x(valor));
                this.jTextAdressValue6.setBackground(Color.cyan);
                break;
            case "address7":
                this.jTextAdressValue7.setText(Convercao.binToHex0x(valor));
                this.jTextAdressValue7.setBackground(Color.cyan);
                break;
            case "address8":
                this.jTextAdressValue8.setText(Convercao.binToHex0x(valor));
                this.jTextAdressValue8.setBackground(Color.cyan);
                break;
            default:
                break;
        }
    }

    // Pega o valor em cada endereço
    public String getAddress (String campo) {
        switch (campo) {
            case "address1":
                this.jTextAdress1.setBackground(Color.cyan);
                return Convercao.hex0xToBin(this.jTextAdressValue1.getText());
            case "address2":
                this.jTextAdress2.setBackground(Color.cyan);
                return Convercao.hex0xToBin(this.jTextAdressValue2.getText());
            case "address3":
                this.jTextAdress3.setBackground(Color.cyan);
                return Convercao.hex0xToBin(this.jTextAdressValue3.getText());
            case "address4":
                this.jTextAdress4.setBackground(Color.cyan);
                return Convercao.hex0xToBin(this.jTextAdressValue4.getText());
            case "address5":
                this.jTextAdress5.setBackground(Color.cyan);
                return Convercao.hex0xToBin(this.jTextAdressValue5.getText());
            case "address6":
                this.jTextAdress6.setBackground(Color.cyan);
                return Convercao.hex0xToBin(this.jTextAdressValue6.getText());
            case "address7":
                this.jTextAdress7.setBackground(Color.cyan);
                return Convercao.hex0xToBin(this.jTextAdressValue7.getText());
            case "address8":
                this.jTextAdress8.setBackground(Color.cyan);
                return Convercao.hex0xToBin(this.jTextAdressValue8.getText());
            default:
                System.out.println("Não existe essa posição");
                return VALOR_PADRAO;
        }
    }

    public void setInterface(String campo, String valor) {
        switch (campo) {
            case "escritaMemoriaDados":
                this.jTextDadosEscrita_MemoriaDeDados.setVisible(true);
                this.jTextDadosEscrita_MemoriaDeDados.setText(Convercao.binToHex0x(valor));
                this.jTextDadosEscrita_MemoriaDeDados.setBackground(Color.cyan);
                break;
                case "ALUZero":
                this.jTextALUZero.setVisible(true);
                this.jTextALUZero.setText(valor); // 0 ou 1
                this.jTextALUZero.setBackground(Color.cyan);
            break;
            case "saidaALU":
                this.jTextSaidaALU.setVisible(true);
                this.jTextSaidaALU.setText(Convercao.binToHex0x(valor));
                this.jTextSaidaALU.setBackground(Color.cyan);
            break;
            case "dadosEscrita":
                this.jTextDadosParaEscrita.setVisible(true);
                this.jTextDadosParaEscrita.setText(Convercao.binToHex0x(valor));
                this.jTextDadosParaEscrita.setBackground(Color.cyan);
            break;
            case "enderecoDeLeitura":
                this.jTextEnderecoDeLeitura.setText(valor);
                this.enderecoDeLeitura = valor;
                this.jTextEnderecoDeLeitura.setBackground(Color.cyan);
            break;
            case "controleValor": // OP
                this.jTextLinhaOp.setText(valor);
                this.jTextControleValor.setText(valor);
                this.enderecoDeLeitura = valor;
                this.jTextControleValor.setBackground(Color.cyan);
                break;
            case "controleDescricao":
                this.jTextControleDescricao.setText(valor);
                this.enderecoDeLeitura = valor;
                break;
            case "pcHexa":
                this.jTextPC.setText(valor);
                break;
            case "rs":
                this.jTextLinhaRs.setVisible(true);
                this.jLabelLinhaRs.setVisible(true);
                this.jTextLinhaRs.setText(valor);
                break;
            case "rsValue":
                this.jTextRs.setText(Convercao.binToHex0x(valor));
                this.jTextRs.setBackground(Color.cyan);
                break;
            case "rt":
                this.jTextLinhaRt.setVisible(true);
                this.jLabelLinhaRt.setVisible(true);
                this.jTextLinhaRt.setText(valor);
                break;
            case "rtValue":
                this.jTextRt.setText(Convercao.binToHex0x(valor));
                this.jTextRt.setBackground(Color.cyan);
                break;
            case "rd":
                this.jTextLinhaRd.setVisible(true);
                this.jLabelLinhaRd.setVisible(true);
                this.jTextLinhaRd.setText(valor);
                break;
            case "rdValue":
                this.jTextRd.setText(Convercao.binToHex0x(valor));
                this.jTextRd.setBackground(Color.cyan);
                break;
            case "fn":
                this.jTextFn.setText(Convercao.binToHex0x(valor));
                this.jTextFn.setBackground(Color.cyan);
                this.jTextLinhaFn.setVisible(true);
                this.jLabelLinhaFn.setVisible(true);
                this.jTextLinhaFn.setText(valor);
                break;
            case "ime":
                this.jTextIme.setText(Convercao.binToHex0x(valor));
                this.jTextIme.setBackground(Color.cyan);
                break;
            case "dadosLeitura1":
                this.jTextALUDadosLeitura1.setVisible(true);
                this.jTextALUDadosLeitura1.setText(Convercao.binToHex0x(valor));    
                this.jTextALUDadosLeitura1.setBackground(Color.cyan);
                break;
            case "dadosLeitura2":
                this.jTextALUDadosLeitura2.setVisible(true);
                this.jTextALUDadosLeitura2.setText(Convercao.binToHex0x(valor));    
                this.jTextALUDadosLeitura2.setBackground(Color.cyan);
                break;
        }
    }

    public void setTipoLinha(String campo, String valor) {
        switch (campo) {
            case "op":
                this.jLabelLinhaOp.setVisible(true);
                this.enderecoDeLeitura = valor;
            break;
            case "rd":
                this.jTextLinhaRd.setVisible(true);
                this.jLabelLinhaRd.setVisible(true);
                this.jTextLinhaRd.setText(valor);
            break;
            case "rt":
                this.jTextLinhaRt.setVisible(true);
                this.jLabelLinhaRt.setVisible(true);
                this.jTextLinhaRt.setText(valor);
            break;
            case "rs":
                this.jTextLinhaRs.setVisible(true);
                this.jLabelLinhaRs.setVisible(true);
                this.jTextLinhaRs.setText(valor);
            break;
            case "sh":
                this.jTextLinhaSh.setVisible(true);
                this.jLabelLinhaSh.setVisible(true);
                this.jTextLinhaSh.setText(valor);
            break;
            case "fn":
                this.jTextLinhaFn.setVisible(true);
                this.jLabelLinhaFn.setVisible(true);
                this.jTextLinhaFn.setText(valor);
            break;
            case "ime":
                this.jTextLinhaIme.setVisible(true);
                this.jLabelLinhaIme.setVisible(true);
                this.jTextLinhaIme.setText(valor);
            break;
            case "address":
                this.jTextLinhaAddress.setVisible(true);
                this.jLabelLinhaAddress.setVisible(true);
                this.jTextLinhaAddress.setText(valor);
            break;
        }
    }

    public void setRegistrador(String nomeReg, String valor) {
        switch (nomeReg) {
            case "$zero":
                this.jTextZero.setText(Convercao.binToHex0x(valor));
                this.$s0 = valor;
                this.jTextZero.setBackground(Color.cyan);
                break;
            case "$s0":
                this.jTextS0.setText(Convercao.binToHex0x(valor));
                this.$s0 = valor;
                this.jTextS0.setBackground(Color.cyan);
                break;
            case "$s1":
                this.jTextS1.setText(Convercao.binToHex0x(valor));
                this.$s1 = valor;
                this.jTextS1.setBackground(Color.cyan);
                break;
            case "$s2":
                this.jTextS2.setText(Convercao.binToHex0x(valor));
                this.$s2 = valor;
                this.jTextS2.setBackground(Color.cyan);
                break;
            case "$s3":
                this.jTextS3.setText(Convercao.binToHex0x(valor));
                this.$s3 = valor;
                this.jTextS3.setBackground(Color.cyan);
                break;
            case "$s4":
                this.jTextS4.setText(Convercao.binToHex0x(valor));
                this.$s4 = valor;
                this.jTextS4.setBackground(Color.cyan);
                break;
            case "$s5":
                this.jTextS5.setText(Convercao.binToHex0x(valor));
                this.$s5 = valor;
                this.jTextS5.setBackground(Color.cyan);
                break;
            case "$s6":
                this.jTextS6.setText(Convercao.binToHex0x(valor));
                this.$s6 = valor;
                this.jTextS6.setBackground(Color.cyan);
                break;
            case "$s7":
                this.jTextS7.setText(Convercao.binToHex0x(valor));
                this.$s7 = valor;
                this.jTextS7.setBackground(Color.cyan);
                break;
            case "$t0":
                this.jTextT0.setText(Convercao.binToHex0x(valor));
                this.$t0 = valor;
                this.jTextT0.setBackground(Color.cyan);
                break;
            case "$t1":
                this.jTextT1.setText(Convercao.binToHex0x(valor));
                this.$t1 = valor;
                this.jTextT1.setBackground(Color.cyan);
                break;
            case "$t2":
                this.jTextT2.setText(Convercao.binToHex0x(valor));
                this.$t2 = valor;
                this.jTextT2.setBackground(Color.cyan);
                break;
            case "$t3":
                this.jTextT3.setText(Convercao.binToHex0x(valor));
                this.$t3 = valor;
                this.jTextT3.setBackground(Color.cyan);
                break;
            case "$t4":
                this.jTextT4.setText(Convercao.binToHex0x(valor));
                this.$t4 = valor;
                this.jTextT4.setBackground(Color.cyan);
                break;
            case "$t5":
                this.jTextT5.setText(Convercao.binToHex0x(valor));
                this.$t5 = valor;
                this.jTextT5.setBackground(Color.cyan);
                break;
            case "$t6":
                this.jTextT6.setText(Convercao.binToHex0x(valor));
                this.$t6 = valor;
                this.jTextT6.setBackground(Color.cyan);
                break;
            case "$t7":
                this.jTextT7.setText(Convercao.binToHex0x(valor));
                this.$t7 = valor;
                this.jTextT7.setBackground(Color.cyan);
                break;
            case "$t8":
                this.jTextT8.setText(Convercao.binToHex0x(valor));
                this.$t8 = valor;
                this.jTextT8.setBackground(Color.cyan);
                break;
            case "$t9":
                this.jTextT9.setText(Convercao.binToHex0x(valor));
                this.$t9 = valor;
                this.jTextT9.setBackground(Color.cyan);
                break;
            default:
                break;
        }
    } 
    
    public String getRegistrador(String nomeReg) {
        switch (nomeReg) {
            case "$zero":
                return this.$zero;
            case "$s0":
                return this.$s0;
            case "$s1":
                return this.$s1;
            case "$s2":
                return this.$s2;
            case "$s3":
                return this.$s3;
            case "$s4":
                return this.$s4;
            case "$s5":
                return this.$s5;
            case "$s6":
                return this.$s6;
            case "$s7":
                return this.$s7;
            case "$t0":
                return this.$t0;
            case "$t1":
                return this.$t1;
            case "$t2":
                return this.$t2;
            case "$t3":
                return this.$t3;
            case "$t4":
                return this.$t4;
            case "$t5":
                return this.$t5;
            case "$t6":
                return this.$t6;
            case "$t7":
                return this.$t7;
            case "$t8":
                return this.$t8;
            case "$t9":
                return this.$t9;
            default:
                return "";
        }
    } 


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabelPC = new javax.swing.JLabel();
        jTextPC = new javax.swing.JTextField();
        jTextEnderecoDeLeitura = new javax.swing.JTextField();
        jTextRs = new javax.swing.JTextField();
        jTextRt = new javax.swing.JTextField();
        jTextRd = new javax.swing.JTextField();
        jTextDadosParaEscrita = new javax.swing.JTextField();
        jTextFn = new javax.swing.JTextField();
        jTextIme = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextControleValor = new javax.swing.JTextField();
        jTextControleDescricao = new javax.swing.JTextField();
        jTextALUDadosLeitura1 = new javax.swing.JTextField();
        jTextALUDadosLeitura2 = new javax.swing.JTextField();
        jTextALUZero = new javax.swing.JTextField();
        jTextSaidaALU = new javax.swing.JTextField();
        jTextDadosEscrita_MemoriaDeDados = new javax.swing.JTextField();
        jPanelCodigoLinha = new javax.swing.JPanel();
        jTextLinhaOp = new javax.swing.JTextField();
        jLabelLinhaOp = new javax.swing.JLabel();
        jTextLinhaRs = new javax.swing.JTextField();
        jLabelLinhaRs = new javax.swing.JLabel();
        jTextLinhaRt = new javax.swing.JTextField();
        jLabelLinhaRt = new javax.swing.JLabel();
        jTextLinhaRd = new javax.swing.JTextField();
        jLabelLinhaRd = new javax.swing.JLabel();
        jTextLinhaFn = new javax.swing.JTextField();
        jLabelLinhaSh = new javax.swing.JLabel();
        jLabelLinhaFn = new javax.swing.JLabel();
        jTextLinhaSh = new javax.swing.JTextField();
        jTextLinhaIme = new javax.swing.JTextField();
        jLabelLinhaIme = new javax.swing.JLabel();
        jTextLinhaAddress = new javax.swing.JTextField();
        jLabelLinhaAddress = new javax.swing.JLabel();
        jLabelImagem = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaConsole = new javax.swing.JTextArea();
        jTextLinhaLida = new javax.swing.JTextField();
        jButton_clock_up = new javax.swing.JButton();
        jButton_clock_down = new javax.swing.JButton();
        jButton_run = new javax.swing.JButton();
        jButton_reset = new javax.swing.JButton();
        jPanelEnderecos = new javax.swing.JPanel();
        jLabelAdress = new javax.swing.JLabel();
        jTextAdress1 = new javax.swing.JTextField();
        jTextAdress2 = new javax.swing.JTextField();
        jTextAdress3 = new javax.swing.JTextField();
        jTextAdress4 = new javax.swing.JTextField();
        jTextAdress5 = new javax.swing.JTextField();
        jTextAdress6 = new javax.swing.JTextField();
        jTextAdress7 = new javax.swing.JTextField();
        jTextAdress8 = new javax.swing.JTextField();
        jLabelAdressValue = new javax.swing.JLabel();
        jTextAdressValue1 = new javax.swing.JTextField();
        jTextAdressValue2 = new javax.swing.JTextField();
        jTextAdressValue3 = new javax.swing.JTextField();
        jTextAdressValue4 = new javax.swing.JTextField();
        jTextAdressValue5 = new javax.swing.JTextField();
        jTextAdressValue6 = new javax.swing.JTextField();
        jTextAdressValue7 = new javax.swing.JTextField();
        jTextAdressValue8 = new javax.swing.JTextField();
        jPanelRegistradores = new javax.swing.JPanel();
        jTextS1 = new javax.swing.JTextField();
        jTextS2 = new javax.swing.JTextField();
        jTextS3 = new javax.swing.JTextField();
        jTextS4 = new javax.swing.JTextField();
        jTextS5 = new javax.swing.JTextField();
        jTextS6 = new javax.swing.JTextField();
        jTextS7 = new javax.swing.JTextField();
        jTextS0 = new javax.swing.JTextField();
        jTextValueS0 = new javax.swing.JTextField();
        jTextValueS1 = new javax.swing.JTextField();
        jTextValueS2 = new javax.swing.JTextField();
        jTextValueS3 = new javax.swing.JTextField();
        jTextValueS4 = new javax.swing.JTextField();
        jTextValueS5 = new javax.swing.JTextField();
        jTextValueS7 = new javax.swing.JTextField();
        jTextValueS6 = new javax.swing.JTextField();
        jTextValueT8 = new javax.swing.JTextField();
        jTextValueT9 = new javax.swing.JTextField();
        jTextT8 = new javax.swing.JTextField();
        jTextT9 = new javax.swing.JTextField();
        jLabelNomeRegistrador = new javax.swing.JLabel();
        jLabelValorRegistrador = new javax.swing.JLabel();
        jTextNomeS0 = new javax.swing.JTextField();
        jTextNomeS1 = new javax.swing.JTextField();
        jTextNomeS2 = new javax.swing.JTextField();
        jTextNomeS3 = new javax.swing.JTextField();
        jTextNomeS4 = new javax.swing.JTextField();
        jTextNomeS5 = new javax.swing.JTextField();
        jTextNomeS6 = new javax.swing.JTextField();
        jTextNomeS7 = new javax.swing.JTextField();
        jTextNomeT8 = new javax.swing.JTextField();
        jTextNomeT9 = new javax.swing.JTextField();
        jTextNomeT0 = new javax.swing.JTextField();
        jTextValueT0 = new javax.swing.JTextField();
        jTextT0 = new javax.swing.JTextField();
        jTextT1 = new javax.swing.JTextField();
        jTextValueT1 = new javax.swing.JTextField();
        jTextNomeT1 = new javax.swing.JTextField();
        jTextNomeT2 = new javax.swing.JTextField();
        jTextT2 = new javax.swing.JTextField();
        jTextValueT2 = new javax.swing.JTextField();
        jTextNomeT3 = new javax.swing.JTextField();
        jTextT3 = new javax.swing.JTextField();
        jTextValueT3 = new javax.swing.JTextField();
        jTextT4 = new javax.swing.JTextField();
        jTextValueT4 = new javax.swing.JTextField();
        jTextNomeT4 = new javax.swing.JTextField();
        jTextNomeT5 = new javax.swing.JTextField();
        jTextValueT5 = new javax.swing.JTextField();
        jTextT5 = new javax.swing.JTextField();
        jTextValueT6 = new javax.swing.JTextField();
        jTextNomeT6 = new javax.swing.JTextField();
        jTextT6 = new javax.swing.JTextField();
        jTextNomeT7 = new javax.swing.JTextField();
        jTextValueT7 = new javax.swing.JTextField();
        jTextT7 = new javax.swing.JTextField();
        jLabelNumeroRegistrador = new javax.swing.JLabel();
        jTextNomeZero = new javax.swing.JTextField();
        jTextValueZero = new javax.swing.JTextField();
        jTextZero = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setAutoscrolls(true);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelPC.setBackground(new java.awt.Color(51, 255, 204));
        jLabelPC.setFont(new java.awt.Font("Dank Mono", 1, 24)); // NOI18N
        jLabelPC.setForeground(new java.awt.Color(51, 51, 51));
        jLabelPC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPC.setText("0");
        jLabelPC.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel2.add(jLabelPC, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 380, 40, 40));

        jTextPC.setBackground(new java.awt.Color(255, 255, 255));
        jTextPC.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTextPC.setForeground(new java.awt.Color(204, 204, 204));
        jTextPC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextPC.setText("0x00000000");
        jTextPC.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 204, 255)));
        jTextPC.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextPC.setEnabled(false);
        jPanel2.add(jTextPC, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 540, 100, 30));

        jTextEnderecoDeLeitura.setBackground(new java.awt.Color(255, 255, 255));
        jTextEnderecoDeLeitura.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTextEnderecoDeLeitura.setForeground(new java.awt.Color(204, 204, 204));
        jTextEnderecoDeLeitura.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextEnderecoDeLeitura.setText("0x00000000");
        jTextEnderecoDeLeitura.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 204, 255)));
        jTextEnderecoDeLeitura.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextEnderecoDeLeitura.setEnabled(false);
        jPanel2.add(jTextEnderecoDeLeitura, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 460, 100, 40));

        jTextRs.setBackground(new java.awt.Color(255, 255, 255));
        jTextRs.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTextRs.setForeground(new java.awt.Color(204, 204, 204));
        jTextRs.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextRs.setText("0x00000000");
        jTextRs.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 204, 255)));
        jTextRs.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextRs.setEnabled(false);
        jPanel2.add(jTextRs, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 450, 90, 40));

        jTextRt.setBackground(new java.awt.Color(255, 255, 255));
        jTextRt.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTextRt.setForeground(new java.awt.Color(204, 204, 204));
        jTextRt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextRt.setText("0x00000000");
        jTextRt.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 204, 255)));
        jTextRt.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextRt.setEnabled(false);
        jPanel2.add(jTextRt, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 500, 90, 40));

        jTextRd.setBackground(new java.awt.Color(255, 255, 255));
        jTextRd.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTextRd.setForeground(new java.awt.Color(204, 204, 204));
        jTextRd.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextRd.setText("0x00000000");
        jTextRd.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 204, 255)));
        jTextRd.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextRd.setEnabled(false);
        jPanel2.add(jTextRd, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 560, 90, 40));

        jTextDadosParaEscrita.setBackground(new java.awt.Color(255, 255, 255));
        jTextDadosParaEscrita.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTextDadosParaEscrita.setForeground(new java.awt.Color(204, 204, 204));
        jTextDadosParaEscrita.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextDadosParaEscrita.setText("0x00000000");
        jTextDadosParaEscrita.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 204, 255)));
        jTextDadosParaEscrita.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextDadosParaEscrita.setEnabled(false);
        jPanel2.add(jTextDadosParaEscrita, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 610, -1, 40));

        jTextFn.setBackground(new java.awt.Color(255, 255, 255));
        jTextFn.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTextFn.setForeground(new java.awt.Color(204, 204, 204));
        jTextFn.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFn.setText("0x00000000");
        jTextFn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 204, 255)));
        jTextFn.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextFn.setEnabled(false);
        jPanel2.add(jTextFn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 830, -1, 30));

        jTextIme.setBackground(new java.awt.Color(255, 255, 255));
        jTextIme.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTextIme.setForeground(new java.awt.Color(204, 204, 204));
        jTextIme.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextIme.setText("0x00000000");
        jTextIme.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 204, 255)));
        jTextIme.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextIme.setEnabled(false);
        jPanel2.add(jTextIme, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 760, -1, 30));

        jLabel1.setFont(new java.awt.Font("DaddyTimeMono NF", 3, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Simulador Mips");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-930, 0, 2310, 46));
        jLabel1.getAccessibleContext().setAccessibleName("jlabel_titulo");
        jLabel1.getAccessibleContext().setAccessibleDescription("Título do Simulador");

        jTextControleValor.setBackground(new java.awt.Color(255, 255, 255));
        jTextControleValor.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTextControleValor.setForeground(new java.awt.Color(204, 204, 204));
        jTextControleValor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextControleValor.setText("0x0");
        jTextControleValor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 204, 255)));
        jTextControleValor.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextControleValor.setEnabled(false);
        jPanel2.add(jTextControleValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(877, 240, 70, 20));

        jTextControleDescricao.setBackground(new java.awt.Color(255, 255, 255));
        jTextControleDescricao.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTextControleDescricao.setForeground(new java.awt.Color(204, 204, 204));
        jTextControleDescricao.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextControleDescricao.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 204, 255)));
        jTextControleDescricao.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextControleDescricao.setEnabled(false);
        jPanel2.add(jTextControleDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(867, 270, 90, 20));

        jTextALUDadosLeitura1.setBackground(new java.awt.Color(255, 255, 255));
        jTextALUDadosLeitura1.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTextALUDadosLeitura1.setForeground(new java.awt.Color(204, 204, 204));
        jTextALUDadosLeitura1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextALUDadosLeitura1.setText("0x00000000");
        jTextALUDadosLeitura1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 204, 255)));
        jTextALUDadosLeitura1.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextALUDadosLeitura1.setEnabled(false);
        jPanel2.add(jTextALUDadosLeitura1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 440, 90, 30));

        jTextALUDadosLeitura2.setBackground(new java.awt.Color(255, 255, 255));
        jTextALUDadosLeitura2.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTextALUDadosLeitura2.setForeground(new java.awt.Color(204, 204, 204));
        jTextALUDadosLeitura2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextALUDadosLeitura2.setText("0x00000000");
        jTextALUDadosLeitura2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 204, 255)));
        jTextALUDadosLeitura2.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextALUDadosLeitura2.setEnabled(false);
        jPanel2.add(jTextALUDadosLeitura2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 630, 90, 30));

        jTextALUZero.setBackground(new java.awt.Color(255, 255, 255));
        jTextALUZero.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTextALUZero.setForeground(new java.awt.Color(204, 204, 204));
        jTextALUZero.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextALUZero.setText("0");
        jTextALUZero.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 204, 255)));
        jTextALUZero.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextALUZero.setEnabled(false);
        jPanel2.add(jTextALUZero, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 400, 30, 30));

        jTextSaidaALU.setBackground(new java.awt.Color(255, 255, 255));
        jTextSaidaALU.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTextSaidaALU.setForeground(new java.awt.Color(204, 204, 204));
        jTextSaidaALU.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextSaidaALU.setText("0x00000000");
        jTextSaidaALU.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 204, 255)));
        jTextSaidaALU.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextSaidaALU.setEnabled(false);
        jPanel2.add(jTextSaidaALU, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 540, 100, 40));

        jTextDadosEscrita_MemoriaDeDados.setBackground(new java.awt.Color(255, 255, 255));
        jTextDadosEscrita_MemoriaDeDados.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTextDadosEscrita_MemoriaDeDados.setForeground(new java.awt.Color(204, 204, 204));
        jTextDadosEscrita_MemoriaDeDados.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextDadosEscrita_MemoriaDeDados.setText("0x00000000");
        jTextDadosEscrita_MemoriaDeDados.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 204, 255)));
        jTextDadosEscrita_MemoriaDeDados.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextDadosEscrita_MemoriaDeDados.setEnabled(false);
        jPanel2.add(jTextDadosEscrita_MemoriaDeDados, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 650, 100, 40));

        jPanelCodigoLinha.setBackground(new java.awt.Color(255, 255, 255));
        jPanelCodigoLinha.setForeground(new java.awt.Color(255, 255, 255));
        jPanelCodigoLinha.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextLinhaOp.setEditable(false);
        jTextLinhaOp.setColumns(5);
        jTextLinhaOp.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextLinhaOp.setText("000000");
        jTextLinhaOp.setFocusable(false);
        jPanelCodigoLinha.add(jTextLinhaOp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabelLinhaOp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLinhaOp.setText("Op (6)");
        jPanelCodigoLinha.add(jLabelLinhaOp, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 60, 20));

        jTextLinhaRs.setEditable(false);
        jTextLinhaRs.setColumns(5);
        jTextLinhaRs.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextLinhaRs.setText("00000");
        jTextLinhaRs.setFocusable(false);
        jPanelCodigoLinha.add(jTextLinhaRs, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        jLabelLinhaRs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLinhaRs.setText("RS (5)");
        jLabelLinhaRs.setToolTipText("");
        jPanelCodigoLinha.add(jLabelLinhaRs, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 60, 20));

        jTextLinhaRt.setEditable(false);
        jTextLinhaRt.setColumns(5);
        jTextLinhaRt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextLinhaRt.setText("00000");
        jTextLinhaRt.setFocusable(false);
        jPanelCodigoLinha.add(jTextLinhaRt, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, -1));

        jLabelLinhaRt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLinhaRt.setText("RT (5)");
        jPanelCodigoLinha.add(jLabelLinhaRt, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 60, 20));

        jTextLinhaRd.setEditable(false);
        jTextLinhaRd.setColumns(5);
        jTextLinhaRd.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextLinhaRd.setText("00000");
        jTextLinhaRd.setFocusable(false);
        jPanelCodigoLinha.add(jTextLinhaRd, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, -1, -1));

        jLabelLinhaRd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLinhaRd.setText("RD (5)");
        jLabelLinhaRd.setToolTipText("");
        jPanelCodigoLinha.add(jLabelLinhaRd, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 60, 20));

        jTextLinhaFn.setEditable(false);
        jTextLinhaFn.setColumns(5);
        jTextLinhaFn.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextLinhaFn.setText("00000");
        jTextLinhaFn.setFocusable(false);
        jPanelCodigoLinha.add(jTextLinhaFn, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, -1, -1));

        jLabelLinhaSh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLinhaSh.setText("SH (6)");
        jPanelCodigoLinha.add(jLabelLinhaSh, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 60, 20));

        jLabelLinhaFn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLinhaFn.setText("Fn (6)");
        jLabelLinhaFn.setToolTipText("");
        jPanelCodigoLinha.add(jLabelLinhaFn, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 60, 20));

        jTextLinhaSh.setEditable(false);
        jTextLinhaSh.setColumns(5);
        jTextLinhaSh.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextLinhaSh.setText("00000");
        jTextLinhaSh.setFocusable(false);
        jPanelCodigoLinha.add(jTextLinhaSh, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, -1));

        jTextLinhaIme.setEditable(false);
        jTextLinhaIme.setColumns(5);
        jTextLinhaIme.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextLinhaIme.setText("00000");
        jTextLinhaIme.setFocusable(false);
        jPanelCodigoLinha.add(jTextLinhaIme, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 180, -1));

        jLabelLinhaIme.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLinhaIme.setText("IME (16)");
        jLabelLinhaIme.setToolTipText("");
        jPanelCodigoLinha.add(jLabelLinhaIme, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 60, 20));

        jTextLinhaAddress.setEditable(false);
        jTextLinhaAddress.setColumns(5);
        jTextLinhaAddress.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextLinhaAddress.setText("00000");
        jTextLinhaAddress.setFocusable(false);
        jPanelCodigoLinha.add(jTextLinhaAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 310, -1));

        jLabelLinhaAddress.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLinhaAddress.setText("ADDRESS (26)");
        jLabelLinhaAddress.setToolTipText("");
        jPanelCodigoLinha.add(jLabelLinhaAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 100, 20));

        jPanel2.add(jPanelCodigoLinha, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 660, 460, 200));

        jLabelImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mips.png"))); // NOI18N
        jPanel2.add(jLabelImagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, -60, 1180, 1000));

        jTextAreaConsole.setColumns(20);
        jTextAreaConsole.setFont(new java.awt.Font("Dank Mono", 2, 18)); // NOI18N
        jTextAreaConsole.setRows(5);
        jScrollPane1.setViewportView(jTextAreaConsole);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 440, 330));

        jTextLinhaLida.setFont(new java.awt.Font("Dank Mono", 2, 18)); // NOI18N
        jPanel2.add(jTextLinhaLida, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 440, 37));
        jTextLinhaLida.getAccessibleContext().setAccessibleName("Linha lida do comando");

        jButton_clock_up.setFont(new java.awt.Font("JetBrains Mono", 1, 11)); // NOI18N
        jButton_clock_up.setText("Subir Clock (ler)");
        jButton_clock_up.setActionCommand("jButton_clock_up");
        jButton_clock_up.setBorder(null);
        jButton_clock_up.setBorderPainted(false);
        jButton_clock_up.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_clock_up.setFocusPainted(false);
        jButton_clock_up.setFocusable(false);
        jButton_clock_up.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_clock_up.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_clock_upAction(evt);
            }
        });
        jPanel2.add(jButton_clock_up, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 450, 132, 42));

        jButton_clock_down.setFont(new java.awt.Font("JetBrains Mono", 1, 11)); // NOI18N
        jButton_clock_down.setText("Descer Clock ");
        jButton_clock_down.setActionCommand("jButton_clock_down");
        jButton_clock_down.setBorder(null);
        jButton_clock_down.setBorderPainted(false);
        jButton_clock_down.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_clock_down.setFocusPainted(false);
        jButton_clock_down.setFocusable(false);
        jButton_clock_down.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_clock_down.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_clock_downAction(evt);
            }
        });
        jPanel2.add(jButton_clock_down, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 500, 132, 42));
        jButton_clock_down.getAccessibleContext().setAccessibleName("jButton_clock_down");
        jButton_clock_down.getAccessibleContext().setAccessibleDescription("Botão para descer clock  (escrever)");

        jButton_run.setFont(new java.awt.Font("JetBrains Mono", 1, 11)); // NOI18N
        jButton_run.setText("Run");
        jButton_run.setActionCommand("jButton_reset");
        jButton_run.setBorder(null);
        jButton_run.setBorderPainted(false);
        jButton_run.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_run.setFocusPainted(false);
        jButton_run.setFocusable(false);
        jButton_run.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_run.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_runAction(evt);
            }
        });
        jPanel2.add(jButton_run, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 132, 42));
        jButton_run.getAccessibleContext().setAccessibleName("Botão rodar");
        jButton_run.getAccessibleContext().setAccessibleDescription("Botão de compilar código");

        jButton_reset.setFont(new java.awt.Font("JetBrains Mono", 1, 11)); // NOI18N
        jButton_reset.setText("Resetar");
        jButton_reset.setActionCommand("jButton_reset");
        jButton_reset.setBorder(null);
        jButton_reset.setBorderPainted(false);
        jButton_reset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_reset.setFocusPainted(false);
        jButton_reset.setFocusable(false);
        jButton_reset.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_resetAction(evt);
            }
        });
        jPanel2.add(jButton_reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 132, 42));
        jButton_reset.getAccessibleContext().setAccessibleName("Limpar programa");

        jPanelEnderecos.setBackground(new java.awt.Color(255, 255, 255));
        jPanelEnderecos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelAdress.setBackground(new java.awt.Color(0, 153, 153));
        jLabelAdress.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        jLabelAdress.setForeground(new java.awt.Color(0, 153, 153));
        jLabelAdress.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAdress.setText("Address");
        jLabelAdress.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jTextAdress1.setBackground(new java.awt.Color(255, 255, 255));
        jTextAdress1.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTextAdress1.setForeground(new java.awt.Color(204, 204, 204));
        jTextAdress1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextAdress1.setText("0x00000000");
        jTextAdress1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 153, 153), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 255, 255)));
        jTextAdress1.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextAdress1.setEnabled(false);

        jTextAdress2.setBackground(new java.awt.Color(255, 255, 255));
        jTextAdress2.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTextAdress2.setForeground(new java.awt.Color(204, 204, 204));
        jTextAdress2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextAdress2.setText("0x00000004");
        jTextAdress2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 153, 153), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 255, 255)));
        jTextAdress2.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextAdress2.setEnabled(false);

        jTextAdress3.setBackground(new java.awt.Color(255, 255, 255));
        jTextAdress3.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTextAdress3.setForeground(new java.awt.Color(204, 204, 204));
        jTextAdress3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextAdress3.setText("0x00000008");
        jTextAdress3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 153, 153), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 255, 255)));
        jTextAdress3.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextAdress3.setEnabled(false);

        jTextAdress4.setBackground(new java.awt.Color(255, 255, 255));
        jTextAdress4.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTextAdress4.setForeground(new java.awt.Color(204, 204, 204));
        jTextAdress4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextAdress4.setText("0x0000000c");
        jTextAdress4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 153, 153), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 255, 255)));
        jTextAdress4.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextAdress4.setEnabled(false);

        jTextAdress5.setBackground(new java.awt.Color(255, 255, 255));
        jTextAdress5.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTextAdress5.setForeground(new java.awt.Color(204, 204, 204));
        jTextAdress5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextAdress5.setText("0x00000010");
        jTextAdress5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 153, 153), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 255, 255)));
        jTextAdress5.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextAdress5.setEnabled(false);

        jTextAdress6.setBackground(new java.awt.Color(255, 255, 255));
        jTextAdress6.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTextAdress6.setForeground(new java.awt.Color(204, 204, 204));
        jTextAdress6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextAdress6.setText("0x00000014");
        jTextAdress6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 153, 153), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 255, 255)));
        jTextAdress6.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextAdress6.setEnabled(false);

        jTextAdress7.setBackground(new java.awt.Color(255, 255, 255));
        jTextAdress7.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTextAdress7.setForeground(new java.awt.Color(204, 204, 204));
        jTextAdress7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextAdress7.setText("0x00000018");
        jTextAdress7.setToolTipText("");
        jTextAdress7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 153, 153), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 255, 255)));
        jTextAdress7.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextAdress7.setEnabled(false);

        jTextAdress8.setBackground(new java.awt.Color(255, 255, 255));
        jTextAdress8.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTextAdress8.setForeground(new java.awt.Color(204, 204, 204));
        jTextAdress8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextAdress8.setText("0x0000001c");
        jTextAdress8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 153, 153), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 255, 255)));
        jTextAdress8.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextAdress8.setEnabled(false);

        jLabelAdressValue.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        jLabelAdressValue.setForeground(new java.awt.Color(0, 153, 153));
        jLabelAdressValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAdressValue.setText("Value");
        jLabelAdressValue.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jTextAdressValue1.setBackground(new java.awt.Color(255, 255, 255));
        jTextAdressValue1.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTextAdressValue1.setForeground(new java.awt.Color(204, 204, 204));
        jTextAdressValue1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextAdressValue1.setText("0x00000000");
        jTextAdressValue1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 153, 153), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 255, 255)));
        jTextAdressValue1.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextAdressValue1.setEnabled(false);

        jTextAdressValue2.setBackground(new java.awt.Color(255, 255, 255));
        jTextAdressValue2.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTextAdressValue2.setForeground(new java.awt.Color(204, 204, 204));
        jTextAdressValue2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextAdressValue2.setText("0x00000000");
        jTextAdressValue2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 153, 153), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 255, 255)));
        jTextAdressValue2.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextAdressValue2.setEnabled(false);

        jTextAdressValue3.setBackground(new java.awt.Color(255, 255, 255));
        jTextAdressValue3.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTextAdressValue3.setForeground(new java.awt.Color(204, 204, 204));
        jTextAdressValue3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextAdressValue3.setText("0x00000000");
        jTextAdressValue3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 153, 153), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 255, 255)));
        jTextAdressValue3.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextAdressValue3.setEnabled(false);

        jTextAdressValue4.setBackground(new java.awt.Color(255, 255, 255));
        jTextAdressValue4.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTextAdressValue4.setForeground(new java.awt.Color(204, 204, 204));
        jTextAdressValue4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextAdressValue4.setText("0x00000000");
        jTextAdressValue4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 153, 153), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 255, 255)));
        jTextAdressValue4.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextAdressValue4.setEnabled(false);

        jTextAdressValue5.setBackground(new java.awt.Color(255, 255, 255));
        jTextAdressValue5.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTextAdressValue5.setForeground(new java.awt.Color(204, 204, 204));
        jTextAdressValue5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextAdressValue5.setText("0x00000000");
        jTextAdressValue5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 153, 153), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 255, 255)));
        jTextAdressValue5.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextAdressValue5.setEnabled(false);

        jTextAdressValue6.setBackground(new java.awt.Color(255, 255, 255));
        jTextAdressValue6.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTextAdressValue6.setForeground(new java.awt.Color(204, 204, 204));
        jTextAdressValue6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextAdressValue6.setText("0x00000000");
        jTextAdressValue6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 153, 153), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 255, 255)));
        jTextAdressValue6.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextAdressValue6.setEnabled(false);

        jTextAdressValue7.setBackground(new java.awt.Color(255, 255, 255));
        jTextAdressValue7.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTextAdressValue7.setForeground(new java.awt.Color(204, 204, 204));
        jTextAdressValue7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextAdressValue7.setText("0x00000000");
        jTextAdressValue7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 153, 153), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 255, 255)));
        jTextAdressValue7.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextAdressValue7.setEnabled(false);

        jTextAdressValue8.setBackground(new java.awt.Color(255, 255, 255));
        jTextAdressValue8.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTextAdressValue8.setForeground(new java.awt.Color(204, 204, 204));
        jTextAdressValue8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextAdressValue8.setText("0x00000000");
        jTextAdressValue8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 153, 153), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 255, 255), new java.awt.Color(204, 255, 255)));
        jTextAdressValue8.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextAdressValue8.setEnabled(false);

        javax.swing.GroupLayout jPanelEnderecosLayout = new javax.swing.GroupLayout(jPanelEnderecos);
        jPanelEnderecos.setLayout(jPanelEnderecosLayout);
        jPanelEnderecosLayout.setHorizontalGroup(
            jPanelEnderecosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEnderecosLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanelEnderecosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextAdress1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextAdress2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextAdress3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextAdress4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextAdress5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextAdress6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextAdress7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextAdress8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelEnderecosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelAdressValue, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextAdressValue1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextAdressValue2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextAdressValue3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextAdressValue4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextAdressValue5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextAdressValue6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextAdressValue7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextAdressValue8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(211, 211, 211))
        );
        jPanelEnderecosLayout.setVerticalGroup(
            jPanelEnderecosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEnderecosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelEnderecosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelAdress)
                    .addComponent(jLabelAdressValue))
                .addGap(1, 1, 1)
                .addGroup(jPanelEnderecosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextAdress1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextAdressValue1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanelEnderecosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextAdress2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextAdressValue2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanelEnderecosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextAdress3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextAdressValue3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanelEnderecosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextAdress4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextAdressValue4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanelEnderecosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextAdress5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextAdressValue5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanelEnderecosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextAdress6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextAdressValue6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanelEnderecosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextAdress7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextAdressValue7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanelEnderecosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextAdress8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextAdressValue8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanelEnderecos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 590, 210, -1));

        jPanelRegistradores.setBackground(new java.awt.Color(231, 254, 254));
        jPanelRegistradores.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextS1.setBackground(new java.awt.Color(240, 240, 240));
        jTextS1.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        jTextS1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextS1.setText("0x00000000");
        jTextS1.setToolTipText("");
        jTextS1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(101, 251, 210), new java.awt.Color(203, 232, 233), new java.awt.Color(203, 232, 233), new java.awt.Color(203, 232, 233)));
        jTextS1.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jPanelRegistradores.add(jTextS1, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 331, 93, -1));

        jTextS2.setBackground(new java.awt.Color(240, 240, 240));
        jTextS2.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        jTextS2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextS2.setText("0x00000000");
        jTextS2.setToolTipText("");
        jTextS2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(101, 251, 210), new java.awt.Color(203, 232, 233), new java.awt.Color(203, 232, 233), new java.awt.Color(203, 232, 233)));
        jTextS2.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jPanelRegistradores.add(jTextS2, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 359, 93, -1));

        jTextS3.setBackground(new java.awt.Color(240, 240, 240));
        jTextS3.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        jTextS3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextS3.setText("0x00000000");
        jTextS3.setToolTipText("");
        jTextS3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(101, 251, 210), new java.awt.Color(203, 232, 233), new java.awt.Color(203, 232, 233), new java.awt.Color(203, 232, 233)));
        jTextS3.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jPanelRegistradores.add(jTextS3, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 387, 93, -1));

        jTextS4.setBackground(new java.awt.Color(240, 240, 240));
        jTextS4.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        jTextS4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextS4.setText("0x00000000");
        jTextS4.setToolTipText("");
        jTextS4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(101, 251, 210), new java.awt.Color(203, 232, 233), new java.awt.Color(203, 232, 233), new java.awt.Color(203, 232, 233)));
        jTextS4.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jPanelRegistradores.add(jTextS4, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 415, 93, -1));

        jTextS5.setBackground(new java.awt.Color(240, 240, 240));
        jTextS5.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        jTextS5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextS5.setText("0x00000000");
        jTextS5.setToolTipText("");
        jTextS5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(101, 251, 210), new java.awt.Color(203, 232, 233), new java.awt.Color(203, 232, 233), new java.awt.Color(203, 232, 233)));
        jTextS5.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jPanelRegistradores.add(jTextS5, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 443, 93, -1));

        jTextS6.setBackground(new java.awt.Color(240, 240, 240));
        jTextS6.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        jTextS6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextS6.setText("0x00000000");
        jTextS6.setToolTipText("");
        jTextS6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(101, 251, 210), new java.awt.Color(203, 232, 233), new java.awt.Color(203, 232, 233), new java.awt.Color(203, 232, 233)));
        jTextS6.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jPanelRegistradores.add(jTextS6, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 471, 93, -1));

        jTextS7.setBackground(new java.awt.Color(240, 240, 240));
        jTextS7.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        jTextS7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextS7.setText("0x00000000");
        jTextS7.setToolTipText("");
        jTextS7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(101, 251, 210), new java.awt.Color(203, 232, 233), new java.awt.Color(203, 232, 233), new java.awt.Color(203, 232, 233)));
        jTextS7.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jPanelRegistradores.add(jTextS7, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 499, 93, -1));

        jTextS0.setBackground(new java.awt.Color(240, 240, 240));
        jTextS0.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        jTextS0.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextS0.setText("0x00000000");
        jTextS0.setToolTipText("");
        jTextS0.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(101, 251, 210), new java.awt.Color(203, 232, 233), new java.awt.Color(203, 232, 233), new java.awt.Color(203, 232, 233)));
        jTextS0.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jPanelRegistradores.add(jTextS0, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 303, 93, -1));

        jTextValueS0.setEditable(false);
        jTextValueS0.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jTextValueS0.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextValueS0.setText("16");
        jPanelRegistradores.add(jTextValueS0, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 303, 62, -1));

        jTextValueS1.setEditable(false);
        jTextValueS1.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jTextValueS1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextValueS1.setText("17");
        jPanelRegistradores.add(jTextValueS1, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 331, 62, -1));

        jTextValueS2.setEditable(false);
        jTextValueS2.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jTextValueS2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextValueS2.setText("18");
        jPanelRegistradores.add(jTextValueS2, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 359, 62, -1));

        jTextValueS3.setEditable(false);
        jTextValueS3.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jTextValueS3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextValueS3.setText("19");
        jPanelRegistradores.add(jTextValueS3, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 387, 62, -1));

        jTextValueS4.setEditable(false);
        jTextValueS4.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jTextValueS4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextValueS4.setText("20");
        jPanelRegistradores.add(jTextValueS4, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 415, 62, -1));

        jTextValueS5.setEditable(false);
        jTextValueS5.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jTextValueS5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextValueS5.setText("21");
        jPanelRegistradores.add(jTextValueS5, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 443, 62, -1));

        jTextValueS7.setEditable(false);
        jTextValueS7.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jTextValueS7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextValueS7.setText("23");
        jPanelRegistradores.add(jTextValueS7, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 499, 62, -1));

        jTextValueS6.setEditable(false);
        jTextValueS6.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jTextValueS6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextValueS6.setText("22");
        jTextValueS6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextValueS6ActionPerformed(evt);
            }
        });
        jPanelRegistradores.add(jTextValueS6, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 471, 62, -1));

        jTextValueT8.setEditable(false);
        jTextValueT8.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jTextValueT8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextValueT8.setText("24");
        jPanelRegistradores.add(jTextValueT8, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 527, 62, -1));

        jTextValueT9.setEditable(false);
        jTextValueT9.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jTextValueT9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextValueT9.setText("25");
        jPanelRegistradores.add(jTextValueT9, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 555, 62, -1));

        jTextT8.setBackground(new java.awt.Color(240, 240, 240));
        jTextT8.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        jTextT8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextT8.setText("0x00000000");
        jTextT8.setToolTipText("");
        jTextT8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(101, 251, 210), new java.awt.Color(203, 232, 233), new java.awt.Color(203, 232, 233), new java.awt.Color(203, 232, 233)));
        jTextT8.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jPanelRegistradores.add(jTextT8, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 527, 93, -1));

        jTextT9.setBackground(new java.awt.Color(240, 240, 240));
        jTextT9.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        jTextT9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextT9.setText("0x00000000");
        jTextT9.setToolTipText("");
        jTextT9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(101, 251, 210), new java.awt.Color(203, 232, 233), new java.awt.Color(203, 232, 233), new java.awt.Color(203, 232, 233)));
        jTextT9.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jPanelRegistradores.add(jTextT9, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 555, 93, -1));

        jLabelNomeRegistrador.setFont(new java.awt.Font("Dank Mono", 1, 14)); // NOI18N
        jLabelNomeRegistrador.setText("Nome");
        jPanelRegistradores.add(jLabelNomeRegistrador, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 62, -1));

        jLabelValorRegistrador.setFont(new java.awt.Font("Dank Mono", 1, 14)); // NOI18N
        jLabelValorRegistrador.setText("Valor");
        jPanelRegistradores.add(jLabelValorRegistrador, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 6, 93, -1));

        jTextNomeS0.setEditable(false);
        jTextNomeS0.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jTextNomeS0.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextNomeS0.setText("$s0");
        jTextNomeS0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNomeS0ActionPerformed(evt);
            }
        });
        jPanelRegistradores.add(jTextNomeS0, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 303, 62, -1));

        jTextNomeS1.setEditable(false);
        jTextNomeS1.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jTextNomeS1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextNomeS1.setText("$s1");
        jTextNomeS1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNomeS1ActionPerformed(evt);
            }
        });
        jPanelRegistradores.add(jTextNomeS1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 331, 62, -1));

        jTextNomeS2.setEditable(false);
        jTextNomeS2.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jTextNomeS2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextNomeS2.setText("$s2");
        jTextNomeS2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNomeS2ActionPerformed(evt);
            }
        });
        jPanelRegistradores.add(jTextNomeS2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 359, 62, -1));

        jTextNomeS3.setEditable(false);
        jTextNomeS3.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jTextNomeS3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextNomeS3.setText("$s3");
        jTextNomeS3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNomeS3ActionPerformed(evt);
            }
        });
        jPanelRegistradores.add(jTextNomeS3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 387, 62, -1));

        jTextNomeS4.setEditable(false);
        jTextNomeS4.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jTextNomeS4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextNomeS4.setText("$s4");
        jTextNomeS4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNomeS4ActionPerformed(evt);
            }
        });
        jPanelRegistradores.add(jTextNomeS4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 415, 62, -1));

        jTextNomeS5.setEditable(false);
        jTextNomeS5.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jTextNomeS5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextNomeS5.setText("$s5");
        jTextNomeS5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNomeS5ActionPerformed(evt);
            }
        });
        jPanelRegistradores.add(jTextNomeS5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 443, 62, -1));

        jTextNomeS6.setEditable(false);
        jTextNomeS6.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jTextNomeS6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextNomeS6.setText("$s6");
        jTextNomeS6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNomeS6ActionPerformed(evt);
            }
        });
        jPanelRegistradores.add(jTextNomeS6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 471, 62, -1));

        jTextNomeS7.setEditable(false);
        jTextNomeS7.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jTextNomeS7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextNomeS7.setText("$s7");
        jTextNomeS7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNomeS7ActionPerformed(evt);
            }
        });
        jPanelRegistradores.add(jTextNomeS7, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 499, 62, -1));

        jTextNomeT8.setEditable(false);
        jTextNomeT8.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jTextNomeT8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextNomeT8.setText("$t8");
        jTextNomeT8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNomeT8ActionPerformed(evt);
            }
        });
        jPanelRegistradores.add(jTextNomeT8, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 527, 62, -1));

        jTextNomeT9.setEditable(false);
        jTextNomeT9.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jTextNomeT9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextNomeT9.setText("$t9");
        jTextNomeT9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNomeT9ActionPerformed(evt);
            }
        });
        jPanelRegistradores.add(jTextNomeT9, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 555, 62, -1));

        jTextNomeT0.setEditable(false);
        jTextNomeT0.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jTextNomeT0.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextNomeT0.setText("$t0");
        jTextNomeT0.setToolTipText("");
        jTextNomeT0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNomeT0ActionPerformed(evt);
            }
        });
        jPanelRegistradores.add(jTextNomeT0, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 65, 62, -1));

        jTextValueT0.setEditable(false);
        jTextValueT0.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jTextValueT0.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextValueT0.setText("8");
        jPanelRegistradores.add(jTextValueT0, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 65, 62, -1));

        jTextT0.setBackground(new java.awt.Color(240, 240, 240));
        jTextT0.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        jTextT0.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextT0.setText("0x00000000");
        jTextT0.setToolTipText("");
        jTextT0.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(101, 251, 210), new java.awt.Color(203, 232, 233), new java.awt.Color(203, 232, 233), new java.awt.Color(203, 232, 233)));
        jTextT0.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jPanelRegistradores.add(jTextT0, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 65, 93, -1));

        jTextT1.setBackground(new java.awt.Color(240, 240, 240));
        jTextT1.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        jTextT1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextT1.setText("0x00000000");
        jTextT1.setToolTipText("");
        jTextT1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(101, 251, 210), new java.awt.Color(203, 232, 233), new java.awt.Color(203, 232, 233), new java.awt.Color(203, 232, 233)));
        jTextT1.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jPanelRegistradores.add(jTextT1, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 95, 93, -1));

        jTextValueT1.setEditable(false);
        jTextValueT1.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jTextValueT1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextValueT1.setText("9");
        jPanelRegistradores.add(jTextValueT1, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 95, 62, -1));

        jTextNomeT1.setEditable(false);
        jTextNomeT1.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jTextNomeT1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextNomeT1.setText("$t1");
        jTextNomeT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNomeT1ActionPerformed(evt);
            }
        });
        jPanelRegistradores.add(jTextNomeT1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 95, 62, -1));

        jTextNomeT2.setEditable(false);
        jTextNomeT2.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jTextNomeT2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextNomeT2.setText("$t2");
        jTextNomeT2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNomeT2ActionPerformed(evt);
            }
        });
        jPanelRegistradores.add(jTextNomeT2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 125, 62, -1));

        jTextT2.setBackground(new java.awt.Color(240, 240, 240));
        jTextT2.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        jTextT2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextT2.setText("0x00000000");
        jTextT2.setToolTipText("");
        jTextT2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(101, 251, 210), new java.awt.Color(203, 232, 233), new java.awt.Color(203, 232, 233), new java.awt.Color(203, 232, 233)));
        jTextT2.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jPanelRegistradores.add(jTextT2, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 125, 93, -1));

        jTextValueT2.setEditable(false);
        jTextValueT2.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jTextValueT2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextValueT2.setText("10");
        jPanelRegistradores.add(jTextValueT2, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 125, 62, -1));

        jTextNomeT3.setEditable(false);
        jTextNomeT3.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jTextNomeT3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextNomeT3.setText("$t3");
        jTextNomeT3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNomeT3ActionPerformed(evt);
            }
        });
        jPanelRegistradores.add(jTextNomeT3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 155, 62, -1));

        jTextT3.setBackground(new java.awt.Color(240, 240, 240));
        jTextT3.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        jTextT3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextT3.setText("0x00000000");
        jTextT3.setToolTipText("");
        jTextT3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(101, 251, 210), new java.awt.Color(203, 232, 233), new java.awt.Color(203, 232, 233), new java.awt.Color(203, 232, 233)));
        jTextT3.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jPanelRegistradores.add(jTextT3, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 155, 93, -1));

        jTextValueT3.setEditable(false);
        jTextValueT3.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jTextValueT3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextValueT3.setText("11");
        jPanelRegistradores.add(jTextValueT3, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 155, 62, -1));

        jTextT4.setBackground(new java.awt.Color(240, 240, 240));
        jTextT4.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        jTextT4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextT4.setText("0x00000000");
        jTextT4.setToolTipText("");
        jTextT4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(101, 251, 210), new java.awt.Color(203, 232, 233), new java.awt.Color(203, 232, 233), new java.awt.Color(203, 232, 233)));
        jTextT4.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jPanelRegistradores.add(jTextT4, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 185, 93, -1));

        jTextValueT4.setEditable(false);
        jTextValueT4.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jTextValueT4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextValueT4.setText("12");
        jPanelRegistradores.add(jTextValueT4, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 185, 62, -1));

        jTextNomeT4.setEditable(false);
        jTextNomeT4.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jTextNomeT4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextNomeT4.setText("$t4");
        jTextNomeT4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNomeT4ActionPerformed(evt);
            }
        });
        jPanelRegistradores.add(jTextNomeT4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 185, 62, -1));

        jTextNomeT5.setEditable(false);
        jTextNomeT5.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jTextNomeT5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextNomeT5.setText("$t5");
        jTextNomeT5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNomeT5ActionPerformed(evt);
            }
        });
        jPanelRegistradores.add(jTextNomeT5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 215, 62, -1));

        jTextValueT5.setEditable(false);
        jTextValueT5.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jTextValueT5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextValueT5.setText("13");
        jPanelRegistradores.add(jTextValueT5, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 215, 62, -1));

        jTextT5.setBackground(new java.awt.Color(240, 240, 240));
        jTextT5.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        jTextT5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextT5.setText("0x00000000");
        jTextT5.setToolTipText("");
        jTextT5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(101, 251, 210), new java.awt.Color(203, 232, 233), new java.awt.Color(203, 232, 233), new java.awt.Color(203, 232, 233)));
        jTextT5.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jPanelRegistradores.add(jTextT5, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 215, 93, -1));

        jTextValueT6.setEditable(false);
        jTextValueT6.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jTextValueT6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextValueT6.setText("14");
        jPanelRegistradores.add(jTextValueT6, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 245, 62, -1));

        jTextNomeT6.setEditable(false);
        jTextNomeT6.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jTextNomeT6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextNomeT6.setText("$t6");
        jTextNomeT6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNomeT6ActionPerformed(evt);
            }
        });
        jPanelRegistradores.add(jTextNomeT6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 245, 62, -1));

        jTextT6.setBackground(new java.awt.Color(240, 240, 240));
        jTextT6.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        jTextT6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextT6.setText("0x00000000");
        jTextT6.setToolTipText("");
        jTextT6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(101, 251, 210), new java.awt.Color(203, 232, 233), new java.awt.Color(203, 232, 233), new java.awt.Color(203, 232, 233)));
        jTextT6.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jPanelRegistradores.add(jTextT6, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 245, 93, -1));

        jTextNomeT7.setEditable(false);
        jTextNomeT7.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jTextNomeT7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextNomeT7.setText("$t7");
        jTextNomeT7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNomeT7ActionPerformed(evt);
            }
        });
        jPanelRegistradores.add(jTextNomeT7, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 275, 62, -1));

        jTextValueT7.setEditable(false);
        jTextValueT7.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jTextValueT7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextValueT7.setText("15");
        jPanelRegistradores.add(jTextValueT7, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 275, 62, -1));

        jTextT7.setBackground(new java.awt.Color(240, 240, 240));
        jTextT7.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        jTextT7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextT7.setText("0x00000000");
        jTextT7.setToolTipText("");
        jTextT7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(101, 251, 210), new java.awt.Color(203, 232, 233), new java.awt.Color(203, 232, 233), new java.awt.Color(203, 232, 233)));
        jTextT7.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jPanelRegistradores.add(jTextT7, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 275, 93, -1));

        jLabelNumeroRegistrador.setFont(new java.awt.Font("Dank Mono", 1, 14)); // NOI18N
        jLabelNumeroRegistrador.setText("Número");
        jPanelRegistradores.add(jLabelNumeroRegistrador, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 6, 62, -1));

        jTextNomeZero.setEditable(false);
        jTextNomeZero.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jTextNomeZero.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextNomeZero.setText("$zero");
        jTextNomeZero.setToolTipText("");
        jTextNomeZero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNomeZeroActionPerformed(evt);
            }
        });
        jPanelRegistradores.add(jTextNomeZero, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 35, 62, -1));

        jTextValueZero.setEditable(false);
        jTextValueZero.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jTextValueZero.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextValueZero.setText("0");
        jPanelRegistradores.add(jTextValueZero, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 35, 62, -1));

        jTextZero.setBackground(new java.awt.Color(240, 240, 240));
        jTextZero.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        jTextZero.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextZero.setText("0x00000000");
        jTextZero.setToolTipText("");
        jTextZero.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(101, 251, 210), new java.awt.Color(203, 232, 233), new java.awt.Color(203, 232, 233), new java.awt.Color(203, 232, 233)));
        jTextZero.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextZero.setEnabled(false);
        jTextZero.setSelectionColor(new java.awt.Color(255, 255, 255));
        jPanelRegistradores.add(jTextZero, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 35, 93, -1));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1650, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelRegistradores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelRegistradores, javax.swing.GroupLayout.PREFERRED_SIZE, 878, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 24, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_clock_downAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_clock_downAction
        // TODO add your handling code here:
        jButton_clock_down.setEnabled(false);
        if(PC > (codigoCompilado.size()-1)) 
            jButton_clock_up.setEnabled(false);
        else 
            jButton_clock_up.setEnabled(true);
        // Impedindo erro
        if(this.PC <= codigoCompilado.size()-1)
            this.memoriaInstrucao.lerLinha(codigoCompilado.get(PC));
        PC++;
        jLabelPC.setText(""+PC);
    }//GEN-LAST:event_jButton_clock_downAction

    private void jButton_clock_upAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_clock_upAction
        this.limpaLinhaBlocos();
        jButton_clock_up.setEnabled(false);
        jButton_clock_down.setEnabled(true);
        System.out.println(PC);
        if(PC > codigoCompilado.size()-1) { 
            jButton_clock_up.setEnabled(false);
            return;
        }
        jTextLinhaLida.setText(codigoCompilado.get(PC));
        this.resetarCoresRegisters();
        this.sumirComLabels();
        
    }//GEN-LAST:event_jButton_clock_upAction

    private void jTextNomeT9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNomeT9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNomeT9ActionPerformed

    private void jTextNomeT8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNomeT8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNomeT8ActionPerformed

    private void jTextNomeS7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNomeS7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNomeS7ActionPerformed

    private void jTextNomeS6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNomeS6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNomeS6ActionPerformed

    private void jTextNomeS5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNomeS5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNomeS5ActionPerformed

    private void jTextNomeS4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNomeS4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNomeS4ActionPerformed

    private void jTextNomeS3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNomeS3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNomeS3ActionPerformed

    private void jTextNomeS2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNomeS2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNomeS2ActionPerformed

    private void jTextNomeS1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNomeS1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNomeS1ActionPerformed

    private void jTextNomeS0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNomeS0ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNomeS0ActionPerformed

    private void jTextValueS6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextValueS6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextValueS6ActionPerformed

    private void jTextNomeT0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNomeT0ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNomeT0ActionPerformed

    private void jTextNomeT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNomeT1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNomeT1ActionPerformed

    private void jTextNomeT2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNomeT2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNomeT2ActionPerformed

    private void jTextNomeT3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNomeT3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNomeT3ActionPerformed

    private void jTextNomeT4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNomeT4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNomeT4ActionPerformed

    private void jTextNomeT5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNomeT5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNomeT5ActionPerformed

    private void jTextNomeT6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNomeT6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNomeT6ActionPerformed

    private void jTextNomeT7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNomeT7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNomeT7ActionPerformed

    private void jTextNomeZeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNomeZeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNomeZeroActionPerformed

    private void jButton_resetAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_resetAction
        // TODO add your handling code here:
        codigoCompilado.clear();
        jButton_run.setEnabled(true);
        jTextLinhaLida.setText("");
        jLabelPC.setText("0");
        PC = 0;
        habilitaRegisters();
        jButton_clock_up.setEnabled(false);
        jButton_clock_down.setEnabled(false);
        jTextAreaConsole.setEnabled(true);
        this.resetarCoresRegisters();
        this.limparValorDosRegistradoresNaInterface();
        this.sumirComLabels();
    }//GEN-LAST:event_jButton_resetAction

    private void jButton_runAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_runAction
        // TODO add your handling code here:
        jTextAreaConsole.setEnabled(false);
        for(String linha : this.jTextAreaConsole.getText().split("\n")) {
            codigoCompilado.add(linha);
        }
        codigoCompilado = new Formatar(codigoCompilado).formatarCodigo();

        if(PC > (codigoCompilado.size()-1))
            jButton_clock_up.setEnabled(false);
        else 
            jButton_clock_up.setEnabled(true);
        jButton_run.setEnabled(false);
        desabilitaRegisters();
        this.pegarValorDosRegistradoresNaInterface();
    }//GEN-LAST:event_jButton_runAction

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MipsSimulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MipsSimulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MipsSimulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MipsSimulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MipsSimulator().setVisible(true);
            }
        });
    }

    public void limpaLinhaBlocos(){
        this.jTextRs.setText("-------");
        this.jTextRs.setBackground(Color.white);
        this.jTextRt.setText("-------");
        this.jTextRt.setBackground(Color.white);
        this.jTextRd.setText("-------");
        this.jTextRd.setBackground(Color.white);
        this.jTextFn.setText("-------");
        this.jTextFn.setBackground(Color.white);
        this.jTextIme.setText("-------");
        this.jTextIme.setBackground(Color.white);
    }

    public void sumirComLabels () {
        this.jTextDadosEscrita_MemoriaDeDados.setVisible(false);
        this.jTextALUZero.setVisible(false);
        this.jTextSaidaALU.setVisible(false);
        this.jTextDadosParaEscrita.setVisible(false);
        this.jTextALUDadosLeitura1.setVisible(false);
        this.jTextALUDadosLeitura2.setVisible(false);
        this.jTextLinhaRd.setVisible(false);
        this.jLabelLinhaRd.setVisible(false);
        this.jTextLinhaRt.setVisible(false);
        this.jLabelLinhaRt.setVisible(false);
        this.jTextLinhaRs.setVisible(false);
        this.jLabelLinhaRs.setVisible(false);
        this.jTextLinhaIme.setVisible(false);
        this.jLabelLinhaIme.setVisible(false);
        this.jTextLinhaAddress.setVisible(false);
        this.jLabelLinhaAddress.setVisible(false);
        this.jTextLinhaSh.setVisible(false);
        this.jLabelLinhaSh.setVisible(false);
        this.jTextLinhaFn.setVisible(false);
        this.jLabelLinhaFn.setVisible(false);
    }

    public void resetarCoresRegisters() {
        this.jTextZero.setBackground(Color.LIGHT_GRAY);
        this.jTextS0.setBackground(Color.LIGHT_GRAY);
        this.jTextS1.setBackground(Color.LIGHT_GRAY);
        this.jTextS2.setBackground(Color.LIGHT_GRAY);
        this.jTextS3.setBackground(Color.LIGHT_GRAY);
        this.jTextS4.setBackground(Color.LIGHT_GRAY);
        this.jTextS5.setBackground(Color.LIGHT_GRAY);
        this.jTextS6.setBackground(Color.LIGHT_GRAY);
        this.jTextS7.setBackground(Color.LIGHT_GRAY);
        this.jTextT0.setBackground(Color.LIGHT_GRAY);
        this.jTextT1.setBackground(Color.LIGHT_GRAY);
        this.jTextT2.setBackground(Color.LIGHT_GRAY);
        this.jTextT3.setBackground(Color.LIGHT_GRAY);
        this.jTextT4.setBackground(Color.LIGHT_GRAY);
        this.jTextT5.setBackground(Color.LIGHT_GRAY);
        this.jTextT6.setBackground(Color.LIGHT_GRAY);
        this.jTextT7.setBackground(Color.LIGHT_GRAY);
        this.jTextT8.setBackground(Color.LIGHT_GRAY);
        this.jTextT9.setBackground(Color.LIGHT_GRAY);
        this.jTextAdressValue1.setBackground(Color.white);
        this.jTextAdressValue2.setBackground(Color.white);
        this.jTextAdressValue3.setBackground(Color.white);
        this.jTextAdressValue4.setBackground(Color.white);
        this.jTextAdressValue5.setBackground(Color.white);
        this.jTextAdressValue6.setBackground(Color.white);
        this.jTextAdressValue7.setBackground(Color.white);
        this.jTextAdressValue8.setBackground(Color.white);
        this.jTextAdress1.setBackground(Color.white);
        this.jTextAdress2.setBackground(Color.white);
        this.jTextAdress3.setBackground(Color.white);
        this.jTextAdress4.setBackground(Color.white);
        this.jTextAdress5.setBackground(Color.white);
        this.jTextAdress6.setBackground(Color.white);
        this.jTextAdress7.setBackground(Color.white);
        this.jTextAdress8.setBackground(Color.white);
    }

    public void desabilitaRegisters() {
        this.jTextS0.setEnabled(false);
        this.jTextS1.setEnabled(false);
        this.jTextS2.setEnabled(false);
        this.jTextS3.setEnabled(false);
        this.jTextS4.setEnabled(false);
        this.jTextS5.setEnabled(false);
        this.jTextS6.setEnabled(false);
        this.jTextS7.setEnabled(false);
        this.jTextT0.setEnabled(false);
        this.jTextT1.setEnabled(false);
        this.jTextT2.setEnabled(false);
        this.jTextT3.setEnabled(false);
        this.jTextT4.setEnabled(false);
        this.jTextT5.setEnabled(false);
        this.jTextT6.setEnabled(false);
        this.jTextT7.setEnabled(false);
        this.jTextT8.setEnabled(false);
        this.jTextT9.setEnabled(false);
        this.jTextZero.setEnabled(false);
    }
    public void habilitaRegisters() {
        this.jTextS0.setEnabled(true);
        this.jTextS1.setEnabled(true);
        this.jTextS2.setEnabled(true);
        this.jTextS3.setEnabled(true);
        this.jTextS4.setEnabled(true);
        this.jTextS5.setEnabled(true);
        this.jTextS6.setEnabled(true);
        this.jTextS7.setEnabled(true);
        this.jTextT0.setEnabled(true);
        this.jTextT1.setEnabled(true);
        this.jTextT2.setEnabled(true);
        this.jTextT3.setEnabled(true);
        this.jTextT4.setEnabled(true);
        this.jTextT5.setEnabled(true);
        this.jTextT6.setEnabled(true);
        this.jTextT7.setEnabled(true);
        this.jTextT8.setEnabled(true);
        this.jTextT9.setEnabled(true);
        // this.jTextZero.setEnabled(true);
    }

    public void pegarValorDosRegistradoresNaInterface () {
        this.$zero = Convercao.hex0xToBin(this.jTextZero.getText());
        this.$s0 = Convercao.hex0xToBin(this.jTextS0.getText());
        this.$s1 = Convercao.hex0xToBin(this.jTextS1.getText());
        this.$s2 = Convercao.hex0xToBin(this.jTextS2.getText());
        this.$s3 = Convercao.hex0xToBin(this.jTextS3.getText());
        this.$s4 = Convercao.hex0xToBin(this.jTextS4.getText());
        this.$s5 = Convercao.hex0xToBin(this.jTextS5.getText());
        this.$s6 = Convercao.hex0xToBin(this.jTextS6.getText());
        this.$s7 = Convercao.hex0xToBin(this.jTextS7.getText());
        this.$t0 = Convercao.hex0xToBin(this.jTextT0.getText());
        this.$t1 = Convercao.hex0xToBin(this.jTextT1.getText());
        this.$t2 = Convercao.hex0xToBin(this.jTextT2.getText());
        this.$t3 = Convercao.hex0xToBin(this.jTextT3.getText());
        this.$t4 = Convercao.hex0xToBin(this.jTextT4.getText());
        this.$t5 = Convercao.hex0xToBin(this.jTextT5.getText());
        this.$t6 = Convercao.hex0xToBin(this.jTextT6.getText());
        this.$t7 = Convercao.hex0xToBin(this.jTextT7.getText());
        this.$t8 = Convercao.hex0xToBin(this.jTextT8.getText());
        this.$t9 = Convercao.hex0xToBin(this.jTextT9.getText());
    }
    public void limparValorDosRegistradoresNaInterface () {
        this.jTextZero.setText(this.VALOR_PADRAO);
        this.jTextS0.setText(this.VALOR_PADRAO);
        this.jTextS1.setText(this.VALOR_PADRAO);
        this.jTextS2.setText(this.VALOR_PADRAO);
        this.jTextS3.setText(this.VALOR_PADRAO);
        this.jTextS4.setText(this.VALOR_PADRAO);
        this.jTextS5.setText(this.VALOR_PADRAO);
        this.jTextS6.setText(this.VALOR_PADRAO);
        this.jTextS7.setText(this.VALOR_PADRAO);
        this.jTextT0.setText(this.VALOR_PADRAO);
        this.jTextT1.setText(this.VALOR_PADRAO);
        this.jTextT2.setText(this.VALOR_PADRAO);
        this.jTextT3.setText(this.VALOR_PADRAO);
        this.jTextT4.setText(this.VALOR_PADRAO);
        this.jTextT5.setText(this.VALOR_PADRAO);
        this.jTextT6.setText(this.VALOR_PADRAO);
        this.jTextT7.setText(this.VALOR_PADRAO);
        this.jTextT8.setText(this.VALOR_PADRAO);
        this.jTextT9.setText(this.VALOR_PADRAO);
        this.jTextAdressValue1.setText(this.VALOR_PADRAO);
        this.jTextAdressValue2.setText(this.VALOR_PADRAO);
        this.jTextAdressValue3.setText(this.VALOR_PADRAO);
        this.jTextAdressValue4.setText(this.VALOR_PADRAO);
        this.jTextAdressValue5.setText(this.VALOR_PADRAO);
        this.jTextAdressValue6.setText(this.VALOR_PADRAO);
        this.jTextAdressValue7.setText(this.VALOR_PADRAO);
        this.jTextAdressValue8.setText(this.VALOR_PADRAO);
        this.jTextDadosParaEscrita.setText(this.VALOR_PADRAO);
        this.jTextALUDadosLeitura1.setText(this.VALOR_PADRAO);
        this.jTextALUDadosLeitura2.setText(this.VALOR_PADRAO);
        this.jTextALUZero.setText("0");
        this.pegarValorDosRegistradoresNaInterface(); // Para limpar as variáveis também
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_clock_down;
    private javax.swing.JButton jButton_clock_up;
    private javax.swing.JButton jButton_reset;
    private javax.swing.JButton jButton_run;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelAdress;
    private javax.swing.JLabel jLabelAdressValue;
    private javax.swing.JLabel jLabelImagem;
    private javax.swing.JLabel jLabelLinhaAddress;
    private javax.swing.JLabel jLabelLinhaFn;
    private javax.swing.JLabel jLabelLinhaIme;
    private javax.swing.JLabel jLabelLinhaOp;
    private javax.swing.JLabel jLabelLinhaRd;
    private javax.swing.JLabel jLabelLinhaRs;
    private javax.swing.JLabel jLabelLinhaRt;
    private javax.swing.JLabel jLabelLinhaSh;
    private javax.swing.JLabel jLabelNomeRegistrador;
    private javax.swing.JLabel jLabelNumeroRegistrador;
    private javax.swing.JLabel jLabelPC;
    private javax.swing.JLabel jLabelValorRegistrador;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelCodigoLinha;
    private javax.swing.JPanel jPanelEnderecos;
    private javax.swing.JPanel jPanelRegistradores;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextALUDadosLeitura1;
    private javax.swing.JTextField jTextALUDadosLeitura2;
    private javax.swing.JTextField jTextALUZero;
    private javax.swing.JTextField jTextAdress1;
    private javax.swing.JTextField jTextAdress2;
    private javax.swing.JTextField jTextAdress3;
    private javax.swing.JTextField jTextAdress4;
    private javax.swing.JTextField jTextAdress5;
    private javax.swing.JTextField jTextAdress6;
    private javax.swing.JTextField jTextAdress7;
    private javax.swing.JTextField jTextAdress8;
    private javax.swing.JTextField jTextAdressValue1;
    private javax.swing.JTextField jTextAdressValue2;
    private javax.swing.JTextField jTextAdressValue3;
    private javax.swing.JTextField jTextAdressValue4;
    private javax.swing.JTextField jTextAdressValue5;
    private javax.swing.JTextField jTextAdressValue6;
    private javax.swing.JTextField jTextAdressValue7;
    private javax.swing.JTextField jTextAdressValue8;
    private javax.swing.JTextArea jTextAreaConsole;
    private javax.swing.JTextField jTextControleDescricao;
    private javax.swing.JTextField jTextControleValor;
    private javax.swing.JTextField jTextDadosEscrita_MemoriaDeDados;
    private javax.swing.JTextField jTextDadosParaEscrita;
    private javax.swing.JTextField jTextEnderecoDeLeitura;
    private javax.swing.JTextField jTextFn;
    private javax.swing.JTextField jTextIme;
    private javax.swing.JTextField jTextLinhaAddress;
    private javax.swing.JTextField jTextLinhaFn;
    private javax.swing.JTextField jTextLinhaIme;
    private javax.swing.JTextField jTextLinhaLida;
    private javax.swing.JTextField jTextLinhaOp;
    private javax.swing.JTextField jTextLinhaRd;
    private javax.swing.JTextField jTextLinhaRs;
    private javax.swing.JTextField jTextLinhaRt;
    private javax.swing.JTextField jTextLinhaSh;
    private javax.swing.JTextField jTextNomeS0;
    private javax.swing.JTextField jTextNomeS1;
    private javax.swing.JTextField jTextNomeS2;
    private javax.swing.JTextField jTextNomeS3;
    private javax.swing.JTextField jTextNomeS4;
    private javax.swing.JTextField jTextNomeS5;
    private javax.swing.JTextField jTextNomeS6;
    private javax.swing.JTextField jTextNomeS7;
    private javax.swing.JTextField jTextNomeT0;
    private javax.swing.JTextField jTextNomeT1;
    private javax.swing.JTextField jTextNomeT2;
    private javax.swing.JTextField jTextNomeT3;
    private javax.swing.JTextField jTextNomeT4;
    private javax.swing.JTextField jTextNomeT5;
    private javax.swing.JTextField jTextNomeT6;
    private javax.swing.JTextField jTextNomeT7;
    private javax.swing.JTextField jTextNomeT8;
    private javax.swing.JTextField jTextNomeT9;
    private javax.swing.JTextField jTextNomeZero;
    private javax.swing.JTextField jTextPC;
    private javax.swing.JTextField jTextRd;
    private javax.swing.JTextField jTextRs;
    private javax.swing.JTextField jTextRt;
    private javax.swing.JTextField jTextS0;
    private javax.swing.JTextField jTextS1;
    private javax.swing.JTextField jTextS2;
    private javax.swing.JTextField jTextS3;
    private javax.swing.JTextField jTextS4;
    private javax.swing.JTextField jTextS5;
    private javax.swing.JTextField jTextS6;
    private javax.swing.JTextField jTextS7;
    private javax.swing.JTextField jTextSaidaALU;
    private javax.swing.JTextField jTextT0;
    private javax.swing.JTextField jTextT1;
    private javax.swing.JTextField jTextT2;
    private javax.swing.JTextField jTextT3;
    private javax.swing.JTextField jTextT4;
    private javax.swing.JTextField jTextT5;
    private javax.swing.JTextField jTextT6;
    private javax.swing.JTextField jTextT7;
    private javax.swing.JTextField jTextT8;
    private javax.swing.JTextField jTextT9;
    private javax.swing.JTextField jTextValueS0;
    private javax.swing.JTextField jTextValueS1;
    private javax.swing.JTextField jTextValueS2;
    private javax.swing.JTextField jTextValueS3;
    private javax.swing.JTextField jTextValueS4;
    private javax.swing.JTextField jTextValueS5;
    private javax.swing.JTextField jTextValueS6;
    private javax.swing.JTextField jTextValueS7;
    private javax.swing.JTextField jTextValueT0;
    private javax.swing.JTextField jTextValueT1;
    private javax.swing.JTextField jTextValueT2;
    private javax.swing.JTextField jTextValueT3;
    private javax.swing.JTextField jTextValueT4;
    private javax.swing.JTextField jTextValueT5;
    private javax.swing.JTextField jTextValueT6;
    private javax.swing.JTextField jTextValueT7;
    private javax.swing.JTextField jTextValueT8;
    private javax.swing.JTextField jTextValueT9;
    private javax.swing.JTextField jTextValueZero;
    private javax.swing.JTextField jTextZero;
    // End of variables declaration//GEN-END:variables
}
