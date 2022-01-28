public class Registradores {
	
	public static String registradores(String reg) {
		
		
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
		}
		return padrao;

	}

}
