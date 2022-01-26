public class ALU {
  
  MipsSimulator mips;
  int zero = 0;
  public ALU (MipsSimulator mips) {
    this.mips = mips;
  }

  public static void main(String args[]) {

  }


  // 
  public String alu(String valor_alu1, String valor_alu2, String instrucao5_0, String operacao, String aluOp) {
    int valor = 0;
    // valor_alu1 = Integer.parseInt(valor_alu1, 16);  
    // valor_alu2 = Integer.parseInt(valor_alu2, 16);
    // valor_alu2 = Integer.toString(Integer.parseInt(valor_alu2, 2), 16);

    if(aluOp.equals("10")) { // TIPO R
      switch (instrucao5_0) {
        case "100000":
        // valor = valor_alu1 + valor_alu2;
        break;
        case "100010":
        // valor = valor_alu1 - valor_alu2;
        break;
        case "100100":
        // valor = valor_alu1 AND valor_alu2
        break;
        case "100101":
        // valor = valor_alu1 OR valor_alu2
        break;
        case "101010":
        // valor = valor_alu1 SLT valor_alu2
          break;
        default:
          break;
      }
    } else if (aluOp.equals("01")) { // Branch
      
    } else if (aluOp.equals("00")) { // LW SW

    }
    // if(Infos.)
    return "";
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
