public class MemoriaInstrucao {
  
  MipsSimulator mips;
  BlocoRegistrador bloco;
  int zero = 0;
  
  public MemoriaInstrucao (MipsSimulator mips) {
    this.mips = mips;
    this.bloco = new BlocoRegistrador(mips);
  }

  public String lerLinha(String linha) {
    String func = Infos.instrucaoDaLinha(linha);
    String instrucao = Infos.linhaParaBinario(linha);
    // this.bloco.op = "";
    // this.bloco.rs = "";
    // this.bloco.rt = "";
    // this.bloco.rd = "";
    // this.bloco.sh = "";
    // this.bloco.fn = "";
    // this.bloco.ime = "";
    // this.bloco.adrs = "";
    //TIPO R
    if(func.equals("add") || func.equals("sub") || func.equals("and") || func.equals("or") || func.equals("slt")) {
      this.bloco.op = instrucao.substring(0,6);
      this.bloco.rs = instrucao.substring(6,11);
      this.bloco.rt = instrucao.substring(11,16);
      this.bloco.rd = instrucao.substring(16,21);
      this.bloco.sh = instrucao.substring(21,26);
      this.bloco.fn = instrucao.substring(26,32);
      new Controle(this.mips).controleInstrucao31_26(this.bloco.op, func);
      this.mips.setInterface("enderecoDeLeitura", Converter.binParaHexa(instrucao));
      this.bloco.tipoInstrucao(func);

    }
    else if (func.equals("lw")) {
      this.bloco.op = instrucao.substring(0,6);
      this.bloco.rs = instrucao.substring(6,11);
      this.bloco.rt = instrucao.substring(11,16);
      this.bloco.ime = instrucao.substring(16,32);
      new Controle(this.mips).controleInstrucao31_26(this.bloco.op, func);
      this.mips.setInterface("enderecoDeLeitura", Converter.binParaHexa(instrucao));
      this.bloco.tipoInstrucao(func);
    } 
    else if (func.equals("sw")) {
      this.bloco.op = instrucao.substring(0,6);
      this.bloco.rs = instrucao.substring(6,11);
      this.bloco.rt = instrucao.substring(11,16);
      this.bloco.ime = instrucao.substring(16,32);
      new Controle(this.mips).controleInstrucao31_26(this.bloco.op, func);
      this.mips.setInterface("enderecoDeLeitura", Converter.binParaHexa(instrucao));
      this.bloco.tipoInstrucao(func);
    } 
    else if (func.equals("beq")) {
      this.bloco.op = instrucao.substring(0,6);
      this.bloco.rs = instrucao.substring(6,11);
      this.bloco.rt = instrucao.substring(11,16);
      this.bloco.ime = instrucao.substring(16,32);
      new Controle(this.mips).controleInstrucao31_26(this.bloco.op, func);
      this.mips.setInterface("enderecoDeLeitura", Converter.binParaHexa(instrucao));
      this.bloco.tipoInstrucao(func);
    } 
    else if (func.equals("j")) {
      this.bloco.op = instrucao.substring(0,6);
      this.bloco.adrs = instrucao.substring(6,32);
      new Controle(this.mips).controleInstrucao31_26(this.bloco.op, func);
      this.mips.setInterface("enderecoDeLeitura", Converter.binParaHexa(instrucao));
    } 
    this.mips.setInterface("pcHexa", Integer.toString(this.mips.PC * 4, 16));
    return "";
    // return controleInstrucao31_26("ssss", Infos.instrucaoDaLinha(linha));
  }

  
}
