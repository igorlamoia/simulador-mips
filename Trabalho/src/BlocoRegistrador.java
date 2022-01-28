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
       String resultado = new ALU(this).alu(func);
       String nomeReg = Registradores.numeroRegParaNome(this.rd);
       this.mips.setRegistrador(nomeReg, resultado);
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
