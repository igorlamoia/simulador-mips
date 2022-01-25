public class Controle {
  
  MipsSimulator mips;

  public Controle (MipsSimulator mips) {
    this.mips = mips;
  }

  public String escreverLinha(String linha) {
    return controleInstrucao31_26("ssss", Infos.instrucaoDaLinha(linha));
  }

  public static void main(String args[]) {

  }

  public String controleInstrucao31_26(String function, String instrucao) {
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
      
      switch (function) {
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
    } 
    if (instrucao.equals("jump")) {
      this.mips.jump = "1";
    }
      
    

    // if (function.equals("100000") && operacao.equals("0010")) {
    //   return retorno;
    //   // return "0010";
    // }
    // else if (function.equals("100010") && operacao.equals("0110")) {
    //   // return "0110";
    //   return retorno;
    // }
    // else if (function.equals("100100") && operacao.equals("0000")) {
    //   // return "0000";
    //   return retorno;
    // }
    // else if (function.equals("100101") && operacao.equals("0001")) {
    //   // return "0001";
    //   return retorno;
    // }
    // else if (function.equals("101010") && operacao.equals("0111")) {
    //   // return "0111";
    //   return retorno;
    // }
    // else if (op_alu1 == 0 && op_alu2 == 0 && operacao.equals("0010")) {
    //   // return "0010";
    //   return retorno;
    // }
    // else if (op_alu1 == 0 && op_alu2 == 1 && operacao.equals("0110")) {
    //   // return "0110";
    //   return retorno;
    // } 
    // else {
    //   throw new Error("Errou!!");
    // }
    // TODO Resolver sapoha
    return "au au";
  }

  // private String paraOndeIr (String operacao) {
  //   switch (operacao) {
  //     case "0010":
  //       break;
  //     case "0110":
  //       break;
  //     case "0000":
  //       break;
  //     case "0001":
  //       break;
  //     case "0111":
  //       break;
  //     case "0010":
  //       break;
  //     case "0110":
  //       break;
  //   }
  // }
}
