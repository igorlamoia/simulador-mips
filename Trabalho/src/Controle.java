public class Controle {
  
  MipsSimulator mips;

  public Controle (MipsSimulator mips) {
    this.mips = mips;
  }

  public static void main(String args[]) {

  }

  public String controleInstrucao31_26(String function, int op_alu1, int op_alu2, String operacao) {
    String retorno = "";
    if (op_alu1 == 1 && op_alu2 == 0 && function.equals("100000") && operacao.equals("0010")) {
      return retorno;
      // return "0010";
    }
    else if (op_alu1 == 1 && op_alu2 == 0 && function.equals("100010") && operacao.equals("0110")) {
      // return "0110";
      return retorno;
    }
    else if (op_alu1 == 1 && op_alu2 == 0 && function.equals("100100") && operacao.equals("0000")) {
      // return "0000";
      return retorno;
    }
    else if (op_alu1 == 1 && op_alu2 == 0 && function.equals("100101") && operacao.equals("0001")) {
      // return "0001";
      return retorno;
    }
    else if (op_alu1 == 1 && op_alu2 == 0 && function.equals("101010") && operacao.equals("0111")) {
      // return "0111";
      return retorno;
    }
    else if (op_alu1 == 0 && op_alu2 == 0 && operacao.equals("0010")) {
      // return "0010";
      return retorno;
    }
    else if (op_alu1 == 0 && op_alu2 == 1 && operacao.equals("0110")) {
      // return "0110";
      return retorno;
    } 
    else {
      throw new Error("Errou!!");
    }
    // TODO Resolver sapoha
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
