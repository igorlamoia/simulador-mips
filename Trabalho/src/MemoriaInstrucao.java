public class MemoriaInstrucao {
  
  MipsSimulator mips;
  int zero = 0;
  
  public MemoriaInstrucao (MipsSimulator mips) {
    this.mips = mips;
  }

  public String lerLinha(String linha) {
    String func = Infos.instrucaoDaLinha(linha);
    String instrucao = Infos.linhaParaBinario(linha);
    String op = "";
    String rs = "";
    String rt = "";
    String rd = "";
    String sh = "";
    String fn = "";
    String ime = "";
    String adrs = "";
    //TIPO R
    if(func.equals("add") || func.equals("sub") || func.equals("and") || func.equals("or") || func.equals("slt")) {
      op = instrucao.substring(0,6);
      rs = instrucao.substring(6,11);
      rt = instrucao.substring(11,16);
      rd = instrucao.substring(16,21);
      sh = instrucao.substring(21,26);
      fn = instrucao.substring(26,32);
      new Controle(this.mips).controleInstrucao31_26(op, func);
      this.mips.setInterface("enderecoDeLeitura", Converter.binParaHexa(instrucao));
    }
    else if (func.equals("lw")) {
      op = instrucao.substring(0,6);
      rs = instrucao.substring(6,11);
      rt = instrucao.substring(11,16);
      ime = instrucao.substring(16,32);
      new Controle(this.mips).controleInstrucao31_26(op, func);
      this.mips.setInterface("enderecoDeLeitura", Converter.binParaHexa(instrucao));
    } 
    else if (func.equals("sw")) {
      op = instrucao.substring(0,6);
      rs = instrucao.substring(6,11);
      rt = instrucao.substring(11,16);
      ime = instrucao.substring(16,32);
      new Controle(this.mips).controleInstrucao31_26(op, func);
      this.mips.setInterface("enderecoDeLeitura", Converter.binParaHexa(instrucao));
    } 
    else if (func.equals("beq")) {
      op = instrucao.substring(0,6);
      rs = instrucao.substring(6,11);
      rt = instrucao.substring(11,16);
      ime = instrucao.substring(16,32);
      new Controle(this.mips).controleInstrucao31_26(op, func);
      this.mips.setInterface("enderecoDeLeitura", Converter.binParaHexa(instrucao));
    } 
    else if (func.equals("j")) {
      op = instrucao.substring(0,6);
      adrs = instrucao.substring(6,32);
      new Controle(this.mips).controleInstrucao31_26(op, func);
      this.mips.setInterface("enderecoDeLeitura", Converter.binParaHexa(instrucao));
    } 

    return "";
    // return controleInstrucao31_26("ssss", Infos.instrucaoDaLinha(linha));
  }

  
}
