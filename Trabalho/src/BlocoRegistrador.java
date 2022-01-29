public class BlocoRegistrador {
  
  MipsSimulator mips;
  String op = "";
  String rs = "";
  String rt = "";
  String rd = "";
  String sh = "";
  String fn = ""; // Operação da ALU
  String ime = "";
  String adrs = "";

  BlocoRegistrador(MipsSimulator mips) {
    this.mips = mips;
  }

  public void tipoInstrucao (String func) {
    if(func.equals("add") || func.equals("sub") || func.equals("and") || func.equals("or") || func.equals("slt")) {
       this.mips.setInterface("rs", this.rs);
       this.mips.setInterface("rt", this.rt);
       this.mips.setInterface("rd", this.rd);
       this.mips.setInterface("fn", this.fn);
       String nomeReg = Registradores.numeroRegParaNome(this.rd);
       String resultado = new ALU(this).alu(func); // Troco o valor de RD, do número para o valor real
       this.mips.setRegistrador(nomeReg, resultado);
       // Após ter mudado para o valor real dentro
       this.mips.setInterface("rsValue", this.rs);
       this.mips.setInterface("rtValue", this.rt);
       this.mips.setInterface("rdValue", this.rd);
       this.mips.setInterface("dadosLeitura1", this.rs);
       this.mips.setInterface("dadosLeitura2", this.rt);
      }
    else if (func.equals("lw")) {
      this.mips.setInterface("rs", this.rs);
      this.mips.setInterface("rd", this.rt); // De propósito
      this.mips.setInterface("ime", this.ime);
    }
    else if (func.equals("sw")) {
      this.mips.setInterface("rs", this.rs);
      this.mips.setInterface("rt", this.rt);
      this.mips.setInterface("ime", this.ime);
    } 
    else if (func.equals("beq")) {
      this.mips.setInterface("rs", this.rs);
      this.mips.setInterface("rt", this.rt);
      this.mips.setInterface("ime", this.ime);
    } 
    else if (func.equals("j")) {
    } 
  }

  public static void main(String args[]) {

  }
}
