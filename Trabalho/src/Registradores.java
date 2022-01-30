public class Registradores {
	
	public static String registradores(String reg) {
		
		
		String padrao = "";
		
		switch (reg) {
			case "zero":
				padrao = "00000";
				break;	
			case "s0": 
				padrao = "10000";
				break;
			case "s1": 
				padrao = "10001";
				break;
			case "s2": 
				padrao = "10010";
				break;
			case "s3": 
				padrao = "10011";
				break;
			case "s4": 
				padrao = "10100";
					break;    
			case "s5": 
				padrao = "10101";
			break;
			case "s6": 
				padrao = "10110";
			break;
			case "s7": 
				padrao = "10111";
			break;
			case "t0": 
				padrao = "01000";
			break;
			case "t1": 
				padrao = "01001";
			break;
			case "t2": 
				padrao = "01010";
			break;
			case "t3": 
				padrao = "01011";
			break;
			case "t4": 
				padrao = "01100";
			break;
			case "t5": 
				padrao = "01101";
			break;
			case "t6": 
				padrao = "01110";
			break;
			case "t7": 
				padrao = "01111";
			break;
			case "t8": 
				padrao = "11000";
			break;
			case "t9":
				padrao = "11001";
				break;
			default:
				System.out.println("Registrador não existe!");
		}

		return padrao;

	}

	public static String numeroRegParaNome(String reg) {
		
		
		String padrao = "";
		
		if (reg.equals("00000")) {
			padrao = "$zero";
		}else if (reg.equals("10000")) {
			padrao = "$s0";
		}else if (reg.equals("10001")) {
			padrao = "$s1";
		}else if (reg.equals("10010")) {
			padrao = "$s2";
		}else if (reg.equals("10011")) {
			padrao = "$s3";
		}else if (reg.equals("10100")) {
			padrao = "$s4";
		}else if (reg.equals("10101")) {
			padrao = "$s5";
		}else if (reg.equals("10110")) {
			padrao = "$s6";
		}else if (reg.equals("10111")) {
			padrao = "$s7";
		}else if (reg.equals("01000")) {
			padrao = "$t0";
		}else if (reg.equals("01001")) {
			padrao = "$t1";
		}else if (reg.equals("01010")) {
			padrao = "$t2";
		}else if (reg.equals("01011")) {
			padrao = "$t3";
		}else if (reg.equals("01100")) {
			padrao = "$t4";
		}else if (reg.equals("01101")) {
			padrao = "$t5";
		}else if (reg.equals("01110")) {
			padrao = "$t6";
		}else if (reg.equals("01111")) {
			padrao = "$t7";
		}else if (reg.equals("11000")) {
			padrao = "$t8";
		}else if (reg.equals("11001")) {
			padrao = "$t9";
		}
		return padrao;
	}

	public static String enderecoMemoriaParaNomeMemoria(String endereco){
		
		String nome = "";
		
		switch (endereco) {
			case "0x00000000":
				nome = "address1";
				break;
			case "0x00000004":
				nome = "address2";
				break;
			case "0x00000008":
				nome = "address3";
				break;
			case "0x0000000c":
				nome = "address4";
				break;
			case "0x00000010":
				nome = "address5";
				break;
			case "0x00000014":
				nome = "address6";
				break;
			case "0x00000018":
				nome = "address7";
				break;
			case "0x0000001c":
				nome = "address8";
				break;
			default:
				break;
		}
		return nome;
	}

}
