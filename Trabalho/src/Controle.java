public class Controle {
  
  MipsSimulator mips;


  public Controle (MipsSimulator mips) {
    this.mips = mips;
  }

  public String pegarInstrucao(String linha) {
    return controleInstrucao31_26("ssss", Infos.instrucaoDaLinha(linha));
  }

  public static void main(String args[]) {

  }

  public String controleInstrucao31_26(String op, String instrucao) {
    String retorno = "";
    
    // TIPO R
    if(instrucao.equals("add") || instrucao.equals("sub") || instrucao.equals("and") || instrucao.equals("or") || instrucao.equals("slt")) {
      this.mips.regDST = "1";
      this.mips.jump = "0";
      this.mips.branch = "0";
      this.mips.memRead = "0";
      this.mips.memToReg = "0";
      this.mips.aluOp = "10";
      this.mips.memWrite = "0";
      this.mips.aluSRC = "0";
      this.mips.regWrite = "1";
      
      switch (op) {
        case "100000":
          this.mips.entradaDeControleALU = "0010"; // add
          break;
        case "100010":
          this.mips.entradaDeControleALU = "0110"; // sub
          break;
        case "100100":
          this.mips.entradaDeControleALU = "0000"; // and
          break;
        case "100101":
          this.mips.entradaDeControleALU = "0001"; // or
          break;
        case "101010":
          this.mips.entradaDeControleALU = "0111"; // Slt
          break;
        default:
          break;
      }

      this.mips.setInterface("controleValor", Converter.bin6ParaHexa(op));
      this.mips.setInterface("controleDescricao", "TIPO R");
      
    }
    // TIPO
    if (instrucao.equals("lw")) {
      this.mips.regDST = "0";
      this.mips.jump = "0";
      this.mips.branch = "0";
      this.mips.memRead = "1";
      this.mips.memToReg = "1";
      this.mips.aluOp = "00";
      this.mips.memWrite = "0";
      this.mips.aluSRC = "1";
      this.mips.regWrite = "1";
      this.mips.setInterface("controleValor", Converter.bin6ParaHexa(op));
      this.mips.setInterface("controleDescricao", "LW");
    } 
    if (instrucao.equals("sw")) {
      this.mips.regDST = "0";
      this.mips.jump = "0";
      this.mips.branch = "0";
      this.mips.memRead = "0";
      this.mips.memToReg = "0";
      this.mips.aluOp = "00";
      this.mips.memWrite = "1";
      this.mips.aluSRC = "1";
      this.mips.regWrite = "0";
      this.mips.setInterface("controleValor", Converter.bin6ParaHexa(op));
      this.mips.setInterface("controleDescricao", "SW");
    } 
    if (instrucao.equals("beq")) {
      this.mips.regDST = "0";
      this.mips.jump = "0";
      this.mips.branch = "1";
      this.mips.memRead = "0";
      this.mips.memToReg = "0";
      this.mips.aluOp = "01";
      this.mips.memWrite = "0";
      this.mips.aluSRC = "0";
      this.mips.regWrite = "0";
      this.mips.setInterface("controleValor", Converter.bin6ParaHexa(op));
      this.mips.setInterface("controleDescricao", "BRANCH");
    } 
    if (instrucao.equals("j")) {
      this.mips.jump = "1";
      this.mips.setInterface("controleValor", Converter.bin6ParaHexa(op));
      this.mips.setInterface("controleDescricao", "JUMP");
    }

    // TODO Resolver sapoha
    return "au au";
  }
}
