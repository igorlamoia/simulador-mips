import helpers.Convercao;

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
    //TIPO R
    if(func.equals("add") || func.equals("sub") || func.equals("and") || func.equals("or") || func.equals("slt")) {
      this.bloco.op = instrucao.substring(0,6);
      this.bloco.rs = instrucao.substring(6,11);
      this.bloco.rt = instrucao.substring(11,16);
      this.bloco.rd = instrucao.substring(16,21);
      this.bloco.sh = instrucao.substring(21,26);
      this.bloco.fn = instrucao.substring(26,32);
      this.mips.setTipoLinha("rs", this.bloco.rs);
      this.mips.setTipoLinha("rt", this.bloco.rt);
      this.mips.setTipoLinha("rd", this.bloco.rd);
      this.mips.setTipoLinha("sh", this.bloco.sh);
      this.mips.setTipoLinha("fn", this.bloco.fn);
      new Controle(this.mips).controleInstrucao31_26(this.bloco.op, func);
      this.mips.setInterface("enderecoDeLeitura", Converter.binParaHexa(instrucao));
      this.bloco.tipoInstrucao(func);

    }
    else if (func.equals("lw")) {
      this.bloco.op = instrucao.substring(0,6);
      this.bloco.rs = instrucao.substring(6,11);
      this.bloco.rt = instrucao.substring(11,16);
      this.bloco.ime = instrucao.substring(16,32);
      this.mips.setTipoLinha("rs", this.bloco.rs);
      this.mips.setTipoLinha("rt", this.bloco.rt);
      this.mips.setTipoLinha("ime", this.bloco.ime);
      new Controle(this.mips).controleInstrucao31_26(this.bloco.op, func);
      this.mips.setInterface("enderecoDeLeitura", Converter.binParaHexa(instrucao));
      this.bloco.tipoInstrucao(func);
    } 
    else if (func.equals("sw")) {
      this.bloco.op = instrucao.substring(0,6);
      this.bloco.rs = instrucao.substring(6,11);
      this.bloco.rt = instrucao.substring(11,16);
      this.bloco.ime = instrucao.substring(16,32);
      this.mips.setTipoLinha("rs", this.bloco.rs);
      this.mips.setTipoLinha("rt", this.bloco.rt);
      this.mips.setTipoLinha("ime", this.bloco.ime);
      new Controle(this.mips).controleInstrucao31_26(this.bloco.op, func);
      this.mips.setInterface("enderecoDeLeitura", Converter.binParaHexa(instrucao));
      this.bloco.tipoInstrucao(func);
    } 
    else if (func.equals("beq")) {
      this.bloco.op = instrucao.substring(0,6);
      this.bloco.rs = instrucao.substring(6,11);
      this.bloco.rt = instrucao.substring(11,16);
      this.bloco.ime = instrucao.substring(16,32);
      this.mips.setTipoLinha("rs", this.bloco.rs);
      this.mips.setTipoLinha("rt", this.bloco.rt);
      this.mips.setTipoLinha("ime", this.bloco.ime);
      new Controle(this.mips).controleInstrucao31_26(this.bloco.op, func);
      this.mips.setInterface("enderecoDeLeitura", Converter.binParaHexa(instrucao));
      this.bloco.tipoInstrucao(func);
    } 
    else if (func.equals("j")) {
      this.bloco.op = instrucao.substring(0,6);
      this.bloco.adrs = instrucao.substring(6,32);
      this.mips.setTipoLinha("address", this.bloco.adrs);
      new Controle(this.mips).controleInstrucao31_26(this.bloco.op, func);
      this.mips.setInterface("enderecoDeLeitura", Converter.binParaHexa(instrucao));
      this.mips.PC = Convercao.binToDec(this.bloco.adrs)-1;
    } 
    this.mips.setInterface("pcHexa", Convercao.binToHex0x(Long.toString(this.mips.PC * 4, 2)));
    return "";
    // return controleInstrucao31_26("ssss", Infos.instrucaoDaLinha(linha));
  }

  
}
