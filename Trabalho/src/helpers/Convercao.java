package helpers;
import java.math.BigInteger;

public class Convercao {
  
  public static String binToHex(String binario) {
    String hex = Integer.toString(Integer.parseInt(binario, 2), 16);
    for(int i = hex.length(); i < 8; i++)
            hex = "0"+hex;
    return hex;
  }
  
  public static String hexToBin(String hex) {
    return new BigInteger(hex.split("0x")[1], 16).toString(2);
  }

  public static String decimalToHex (int inteiro) {
    return Integer.toString(inteiro, 16);
  }

  public static int hexToDec (String hex) {
    return Integer.parseInt(hex,16);
  }
}
