public class ALU {
  
  MipsSimulator mips;
  BlocoRegistrador bloco;
  int zero = 0;
  String result = "";
  
  public ALU (MipsSimulator mips) {
    this.mips = mips;
  }
  
  public ALU (BlocoRegistrador bloco) {
    this.bloco = bloco;
  }
  // 
  public String alu(String func) {
    // Pegar valores dentro dos Registradores RS, RT, RD
    this.bloco.rs = this.bloco.mips.getRegistrador(Registradores.numeroRegParaNome(this.bloco.rs));
    System.out.println("Valor Atual antes da Alu RS"+this.bloco.rs);
    this.bloco.rt = this.bloco.mips.getRegistrador(Registradores.numeroRegParaNome(this.bloco.rt));
    System.out.println("Valor Atual antes da Alu RT"+this.bloco.rt);
    this.bloco.rd = this.bloco.mips.getRegistrador(Registradores.numeroRegParaNome(this.bloco.rd));
    System.out.println("Valor Atual antes da Alu RD"+this.bloco.rd);

     if(func.equals("add") || func.equals("sub") || func.equals("and") || func.equals("or") || func.equals("slt")) {
      switch (this.bloco.fn) {
        case "100000":
        // valor = valor_alu1 + valor_alu2;
        this.result = Long.toBinaryString((Long.parseLong(this.bloco.rs, 2) + Long.parseLong(this.bloco.rt, 2)));
        break;
        case "100010":
        // valor = valor_alu1 - valor_alu2;
          this.result = Long.toBinaryString((Long.parseLong(this.bloco.rs, 2) - Long.parseLong(this.bloco.rt, 2)));
        break;
        case "100100":
        // valor = valor_alu1 AND valor_alu2
          for (int i = 0; i < this.bloco.rs.length(); i++) {
            if( '1' == this.bloco.rs.charAt(i) &&  '1' == this.bloco.rt.charAt(i)) 
              this.result += '1';
            else 
              this.result += '0';
          }
          break;
        case "100101":
        // valor = valor_alu1 OR valor_alu2
          for (int i = 0; i < this.bloco.rs.length(); i++) {
            if( '1' == this.bloco.rs.charAt(i) || '1' == this.bloco.rt.charAt(i)) 
              this.result += '1';
            else 
              this.result += '0';
          }
        break;
        case "101010":
        // valor = valor_alu1 SLT valor_alu2
        if(Long.parseLong(this.bloco.rs, 2) < Long.parseLong(this.bloco.rt, 2))
          this.result = "1";
        else
          this.result = "0";
          break;
        default:
         break;
      }
    }
    else if (func.equals("lw")) {
      // this.bloco.setInterface("rs", this.bloco.rs);
      // this.bloco.setInterface("rd", this.bloco.rt); // De propósito
      // this.bloco.setInterface("ime", this.bloco.ime);
    }
    else if (func.equals("sw")) {
      // this.bloco.setInterface("rs", this.bloco.rs);
      // this.bloco.setInterface("rt", this.bloco.rt);
      // this.bloco.setInterface("ime", this.bloco.ime);
    } 
    else if (func.equals("beq")) {
      Long resultado = Long.parseLong(this.bloco.rs, 2) - Long.parseLong(this.bloco.rt, 2);
      System.out.println("Resultadooo: "+resultado);
      if(resultado == 0) {
        // this.bloco.mips.setInterface("rdValue", "1");
        this.bloco.mips.setInterface("ALUZero", "1");
        System.out.println("VAI POHA");
      }
      else
        this.bloco.mips.setInterface("ALUZero", "0");
        
      // this.bloco.setInterface("rs", this.rs);
      // this.bloco.setInterface("rt", this.rt);
      // this.bloco.setInterface("ime", this.ime);
    } 
    else if (func.equals("j")) {
    } 
    // int valor = 0;
    // valor_alu1 = Long.parseLong(valor_alu1, 16);  
    // valor_alu2 = Long.parseLong(valor_alu2, 16);
    // valor_alu2 = Long.toString(Long.parseLong(valor_alu2, 2), 16);

    // if(aluOp.equals("10")) { // TIPO R
    //    break;
    //   }
    // } 
    // else if (aluOp.equals("01")) { // Branch
      
    // } else if (aluOp.equals("00")) { // LW SW

    // }
    // // if(Infos.)
    return this.result;
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
