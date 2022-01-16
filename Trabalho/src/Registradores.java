public class Registradores {
	
	public static String registradores(String reg) {
		
		//O intuito dessa classe é retornar, a partir de um registrador recebido por parâmetro, o 'NUMBER' do mesmo
		
		String padrao = "";
		
		if (reg.equals("zero")) {
			padrao = "00000";
		}else if (reg.equals("s0")) {
			padrao = "10000";
		}else if (reg.equals("s1")) {
			padrao = "10001";
		}else if (reg.equals("s2")) {
			padrao = "10010";
		}else if (reg.equals("s3")) {
			padrao = "10011";
		}else if (reg.equals("s4")) {
			padrao = "10100";
		}else if (reg.equals("s5")) {
			padrao = "10101";
		}else if (reg.equals("s6")) {
			padrao = "10110";
		}else if (reg.equals("s7")) {
			padrao = "10111";
		}else if (reg.equals("t0")) {
			padrao = "01000";
		}else if (reg.equals("t1")) {
			padrao = "01001";
		}else if (reg.equals("t2")) {
			padrao = "01010";
		}
		return padrao;

	}

}
