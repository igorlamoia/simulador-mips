public class Converter {
	
	//Recebe um n�mero bin�rio armazenado no formato de string
	//Retorna o n�mero hexadecimal referente, tamb�m no formato de string
	
	public static String binParaHexa(String binario) {
		
		String hexa = "0x";
		String p1 = binario.substring(0, 4);
		String p2 = binario.substring(4, 8);
		String p3 = binario.substring(8, 12);
		String p4 = binario.substring(12, 16);
		String p5 = binario.substring(16, 20);
		String p6 = binario.substring(20, 24);
		String p7 = binario.substring(24, 28);
		String p8 = binario.substring(28, 32);
		
		p1 = Integer.toString(Integer.parseInt(p1, 2), 16);
		p2 = Integer.toString(Integer.parseInt(p2, 2), 16);
		p3 = Integer.toString(Integer.parseInt(p3, 2), 16);
		p4 = Integer.toString(Integer.parseInt(p4, 2), 16);
		p5 = Integer.toString(Integer.parseInt(p5, 2), 16);
		p6 = Integer.toString(Integer.parseInt(p6, 2), 16);
		p7 = Integer.toString(Integer.parseInt(p7, 2), 16);
		p8 = Integer.toString(Integer.parseInt(p8, 2), 16);
		
		hexa = hexa.concat(p1);
		hexa = hexa.concat(p2);
		hexa = hexa.concat(p3);
		hexa = hexa.concat(p4);
		hexa = hexa.concat(p5);
		hexa = hexa.concat(p6);
		hexa = hexa.concat(p7);
		hexa = hexa.concat(p8);

		return hexa;
		
	}
	
	//Recebe um n�mero hexadecimal armazenado no formato de string
	//Retorna o n�mero bin�rio referente tamb�m no formato de string, caso necess�rio, completa o n�mero bin�rio de modo a ter 16 bits ao final
	
	public static String hexaParaBin_16bits(String hexa) {
		String bin = "";
		hexa = hexa.toUpperCase();
		
		for (int i=(4-hexa.length()) ; i>0 ; i--) {
			bin = bin.concat("0000");
		}
		
		return stringHexParaBin(bin, hexa);
	}
	
	//Recebe um n�mero hexadecimal armazenado no formato de string
	//Retorna o n�mero bin�rio referente tamb�m no formato de string, caso necess�rio, completa o n�mero bin�rio de modo a ter 26 bits ao final
	//Usado para o 'j'

	public static String hexaParaBin_26bits(String hexa) {
	
		String bin = "00";
		hexa = hexa.toUpperCase();
		
		for (int i=(6-hexa.length()) ; i > 0 ; i--)
			bin = bin.concat("0000");
	
		return stringHexParaBin(bin, hexa);
	}
	
	//Recebe um n�mero hexadecimal armazenado no formato de string
	//Retorna o n�mero bin�rio referente tamb�m no formato de string, caso necess�rio, completa o n�mero bin�rio de modo a ter 5 bits ao final
	//Usado para o 'SHAMT' presente em algumas instru��es


	public static String hexaParaBin_5bits(String hexa) {
		String bin = "";
		hexa = hexa.toUpperCase();
		int i=0;
	
		if (hexa.length() == 1) {
			bin = bin.concat("0");
		}else if (hexa.length() == 2) {
			bin = bin.concat("1");
			i++;
		}
		
		for ( ; i<hexa.length() ; i++)
			bin = switchCharHexParaBin(hexa.charAt(i), bin);
		
		return bin;
		
	}
	
	public static String stringHexParaBin(String bin, String hexa) {
		for (int i=0 ; i<hexa.length() ; i++)
			bin = switchCharHexParaBin(hexa.charAt(i), bin);
		return bin;
	}

	public static String switchCharHexParaBin(char digito, String bin) {
		switch (digito) {
			case '0':
				bin = bin.concat("0000");
				break;
			case '1':
				bin = bin.concat("0001");
				break;
			case '2':
				bin = bin.concat("0010");
				break;
			case '3':
				bin = bin.concat("0011");
				break;
			case '4':
				bin = bin.concat("0100");
				break;
			case '5':
				bin = bin.concat("0101");
				break;
			case '6':
				bin = bin.concat("0110");
				break;
			case '7':
				bin = bin.concat("0111");
				break;
			case '8':
				bin = bin.concat("1000");
				break;
			case '9':
				bin = bin.concat("1001");
				break;
			case 'A':
				bin = bin.concat("1010");
				break;
			case 'B':
				bin = bin.concat("1011");
				break;
			case 'C':
				bin = bin.concat("1100");
				break;
			case 'D':
				bin = bin.concat("1101");
				break;
			case 'E':
				bin = bin.concat("1110");
				break;
			case 'F':
				bin = bin.concat("1111");
				break;
			default:
				break;
		}
		return bin;
	}

}
