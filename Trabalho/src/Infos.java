public class Infos {

	MemoriaInstrucao memoria;
	public Infos (MemoriaInstrucao memoria) {
		this.memoria = memoria; 
	}

	public static String instrucaoDaLinha (String linha) {
		return linha.substring(0, linha.indexOf(" "));
	} 

	public String linhaParaBeq(String linha) {
		String aux = linha;
		String padraoBin = "";
		String padraoHexa = "";
		String regA = "";
		String regB = "";
		String regC = "";
		String imm = "";

		String instrucao = linha.substring(0, linha.indexOf(" "));
		aux = aux.substring(aux.indexOf("$")+1);
		regA = aux.substring(0, aux.indexOf(","));
		aux = aux.substring(aux.indexOf("$")+1);
		regB = aux.substring(0, aux.indexOf(","));
		aux = aux.substring(aux.indexOf("x")+1);
		imm = Converter.hexaParaBin_16bits(aux);
		this.memoria.immHex = aux;
		padraoBin = ("000100"+Registradores.registradores(regA)+Registradores.registradores(regB)+imm);
		return padraoBin;
	}

	public static String linhaParaBinario(String linha) {
		String aux = linha;
		String padraoBin = "";
		String padraoHexa = "";
		String regA = "";
		String regB = "";
		String regC = "";
		String imm = "";
		String instrucao = linha.substring(0, linha.indexOf(" "));
		
		//Cada instru��o tem seu pr�prio padr�o
		//Dentro de cada if est� sendo tratado cada particularidade de cada instru��o como, por exemplo, o posicionamento dos Registradores e as convers�es necess�rias de acordo com a quantidade de bits
		//Inicialmente, dentro do if ser� formado o n�mero bin�rio no formato de string da instru��o referente a linha que est� sendo trabalhada
		//A convers�o ser� feita e...
		//Por fim, ser� retornado um n�mero hexadecimal no formato de string referente a linha que est� sendo trabalhada

		if (instrucao.equals("or")) {
			aux = aux.substring(aux.indexOf("$")+1);
			regA = aux.substring(0, aux.indexOf(","));
			aux = aux.substring(aux.indexOf("$")+1);
			regB = aux.substring(0, aux.indexOf(","));
			aux = aux.substring(aux.indexOf("$")+1);
			regC = aux;
			padraoBin = ("000000"+Registradores.registradores(regB)+Registradores.registradores(regC)+Registradores.registradores(regA)+"00000100101");
			// padraoHexa = Converter.binParaHexa(padraoBin);
		} else if (instrucao.equals("add")) {
			aux = aux.substring(aux.indexOf("$")+1);
			regA = aux.substring(0, aux.indexOf(","));
			aux = aux.substring(aux.indexOf("$")+1);
			regB = aux.substring(0, aux.indexOf(","));
			aux = aux.substring(aux.indexOf("$")+1);
			regC = aux;
			padraoBin = ("000000"+Registradores.registradores(regB)+Registradores.registradores(regC)+Registradores.registradores(regA)+"00000100000");
			// padraoHexa = Converter.binParaHexa(padraoBin);
		} else if (instrucao.equals("sub")) {
			aux = aux.substring(aux.indexOf("$")+1);
			regA = aux.substring(0, aux.indexOf(","));
			aux = aux.substring(aux.indexOf("$")+1);
			regB = aux.substring(0, aux.indexOf(","));
			aux = aux.substring(aux.indexOf("$")+1);
			regC = aux;
			padraoBin = ("000000"+Registradores.registradores(regB)+Registradores.registradores(regC)+Registradores.registradores(regA)+"00000100010");
			// padraoHexa = Converter.binParaHexa(padraoBin);
		} else if (instrucao.equals("xor")) {
			aux = aux.substring(aux.indexOf("$")+1);
			regA = aux.substring(0, aux.indexOf(","));
			aux = aux.substring(aux.indexOf("$")+1);
			regB = aux.substring(0, aux.indexOf(","));
			aux = aux.substring(aux.indexOf("$")+1);
			regC = aux;
			padraoBin = ("000000"+Registradores.registradores(regB)+Registradores.registradores(regC)+Registradores.registradores(regA)+"00000100110");
			// padraoHexa = Converter.binParaHexa(padraoBin);
		}else if (instrucao.equals("and")) {
			aux = aux.substring(aux.indexOf("$")+1);
			regA = aux.substring(0, aux.indexOf(","));
			aux = aux.substring(aux.indexOf("$")+1);
			regB = aux.substring(0, aux.indexOf(","));
			aux = aux.substring(aux.indexOf("$")+1);
			regC = aux;
			padraoBin = ("000000"+Registradores.registradores(regB)+Registradores.registradores(regC)+Registradores.registradores(regA)+"00000100100");
			// padraoHexa = Converter.binParaHexa(padraoBin);
		} else if (instrucao.equals("slt")) {
			aux = aux.substring(aux.indexOf("$")+1);
			regA = aux.substring(0, aux.indexOf(","));
			aux = aux.substring(aux.indexOf("$")+1);
			regB = aux.substring(0, aux.indexOf(","));
			aux = aux.substring(aux.indexOf("$")+1);
			regC = aux;
			padraoBin = ("000000"+Registradores.registradores(regB)+Registradores.registradores(regC)+Registradores.registradores(regA)+"00000101010");
			// padraoHexa = Converter.binParaHexa(padraoBin);
		} else if (instrucao.equals("ori")) {
			aux = aux.substring(aux.indexOf("$")+1);
			regA = aux.substring(0, aux.indexOf(","));
			aux = aux.substring(aux.indexOf("$")+1);
			regB = aux.substring(0, aux.indexOf(","));
			aux = aux.substring(aux.indexOf("x")+1);
			imm = Converter.hexaParaBin_16bits(aux);
			padraoBin = ("001101"+Registradores.registradores(regB)+Registradores.registradores(regA)+imm);
			// padraoHexa = Converter.binParaHexa(padraoBin);
		} else if (instrucao.equals("addi")) {
			aux = aux.substring(aux.indexOf("$")+1);
			regA = aux.substring(0, aux.indexOf(","));
			aux = aux.substring(aux.indexOf("$")+1);
			regB = aux.substring(0, aux.indexOf(","));
			aux = aux.substring(aux.indexOf("x")+1);
			imm = Converter.hexaParaBin_16bits(aux);
			padraoBin = ("001000"+Registradores.registradores(regB)+Registradores.registradores(regA)+imm);
			// padraoHexa = Converter.binParaHexa(padraoBin);
		} else if (instrucao.equals("srl")) {
			aux = aux.substring(aux.indexOf("$")+1);
			regA = aux.substring(0, aux.indexOf(","));
			aux = aux.substring(aux.indexOf("$")+1);
			regB = aux.substring(0, aux.indexOf(","));
			aux = aux.substring(aux.indexOf("x")+1);
			imm = Converter.hexaParaBin_5bits(aux); //shamt
			padraoBin = ("000000"+"00000"+Registradores.registradores(regB)+Registradores.registradores(regA)+imm+"000010");
			// padraoHexa = Converter.binParaHexa(padraoBin);
		} else if (instrucao.equals("xori")) {
			aux = aux.substring(aux.indexOf("$")+1);
			regA = aux.substring(0, aux.indexOf(","));
			aux = aux.substring(aux.indexOf("$")+1);
			regB = aux.substring(0, aux.indexOf(","));
			aux = aux.substring(aux.indexOf("x")+1);
			imm = Converter.hexaParaBin_16bits(aux);
			padraoBin = ("001110"+Registradores.registradores(regB)+Registradores.registradores(regA)+imm);
			// padraoHexa = Converter.binParaHexa(padraoBin);
		} else if (instrucao.equals("andi")) {
			aux = aux.substring(aux.indexOf("$")+1);
			regA = aux.substring(0, aux.indexOf(","));
			aux = aux.substring(aux.indexOf("$")+1);
			regB = aux.substring(0, aux.indexOf(","));
			aux = aux.substring(aux.indexOf("x")+1);
			imm = Converter.hexaParaBin_16bits(aux);
			padraoBin = ("001100"+Registradores.registradores(regB)+Registradores.registradores(regA)+imm);
			// padraoHexa = Converter.binParaHexa(padraoBin);
		}else if (instrucao.equals("slti")) {
			aux = aux.substring(aux.indexOf("$")+1);
			regA = aux.substring(0, aux.indexOf(","));
			aux = aux.substring(aux.indexOf("$")+1);
			regB = aux.substring(0, aux.indexOf(","));
			aux = aux.substring(aux.indexOf("x")+1);
			imm = Converter.hexaParaBin_16bits(aux);
			padraoBin = ("001010"+Registradores.registradores(regB)+Registradores.registradores(regA)+imm);
			// padraoHexa = Converter.binParaHexa(padraoBin);
		} else if (instrucao.equals("sll")) {
			aux = aux.substring(aux.indexOf("$")+1);
			regA = aux.substring(0, aux.indexOf(","));
			aux = aux.substring(aux.indexOf("$")+1);
			regB = aux.substring(0, aux.indexOf(","));
			aux = aux.substring(aux.indexOf("x")+1);
			imm = Converter.hexaParaBin_5bits(aux); //shamt
			padraoBin = ("000000"+"00000"+Registradores.registradores(regB)+Registradores.registradores(regA)+imm+"000000");
			// padraoHexa = Converter.binParaHexa(padraoBin);
		} else if (instrucao.equals("sw")) {
			aux = aux.substring(aux.indexOf("$")+1);
			regA = aux.substring(0, aux.indexOf(","));
			aux = aux.substring(aux.indexOf("$")+1);
			regB = aux.substring(0, aux.indexOf(")"));
			imm = "0000000000000000";
			padraoBin = ("101011"+Registradores.registradores(regB)+Registradores.registradores(regA)+imm);
			// padraoHexa = Converter.binParaHexa(padraoBin);
		} else if (instrucao.equals("lw")) {
			aux = aux.substring(aux.indexOf("$")+1);
			regA = aux.substring(0, aux.indexOf(","));
			aux = aux.substring(aux.indexOf("$")+1);
			regB = aux.substring(0, aux.indexOf(")"));
			imm = "0000000000000000";
			padraoBin = ("100011"+Registradores.registradores(regB)+Registradores.registradores(regA)+imm);
			// padraoHexa = Converter.binParaHexa(padraoBin);
		} else if (instrucao.equals("beq")) {
			aux = aux.substring(aux.indexOf("$")+1);
			regA = aux.substring(0, aux.indexOf(","));
			aux = aux.substring(aux.indexOf("$")+1);
			regB = aux.substring(0, aux.indexOf(","));
			aux = aux.substring(aux.indexOf("x")+1);
			imm = Converter.hexaParaBin_16bits(aux);
			padraoBin = ("000100"+Registradores.registradores(regA)+Registradores.registradores(regB)+imm);
			// padraoHexa = Converter.binParaHexa(padraoBin);
		} else if (instrucao.equals("bne")) {
			aux = aux.substring(aux.indexOf("$")+1);
			regA = aux.substring(0, aux.indexOf(","));
			aux = aux.substring(aux.indexOf("$")+1);
			regB = aux.substring(0, aux.indexOf(","));
			aux = aux.substring(aux.indexOf("x")+1);
			imm = Converter.hexaParaBin_16bits(aux);
			padraoBin = ("000101"+Registradores.registradores(regA)+Registradores.registradores(regB)+imm);
			// padraoHexa = Converter.binParaHexa(padraoBin);
		} else if (instrucao.equals("j")) {
			aux = aux.substring(aux.indexOf("x")+1);
			imm = Converter.hexaParaBin_26bits(aux);
			padraoBin = ("000010"+imm);
			// padraoHexa = Converter.binParaHexa(padraoBin);
		}

		return padraoBin;
	
	}

}
