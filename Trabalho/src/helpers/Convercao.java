package helpers;
import java.math.BigInteger;

public class Convercao {
  
  public static String binToHex(String binario)  {
    System.out.println("Oia o bicho: "+ binario);
    System.out.println("Tamanho do bicho: "+ binario.length());
    String hex = "";
    hex = Long.toString(Long.parseLong(binario, 2), 16);
      for(int i = hex.length(); i < 8; i++)
              hex = "0"+hex;
      return hex;
  }

  public static String binToHex0x(String binario)  {
      return "0x"+binToHex(binario);
  }
  
  public static String hexToBin(String hex) {
    return new BigInteger(hex, 16).toString(2);
  }
  public static String hexToBin32(String hex) {
    String bin = new BigInteger(hex, 16).toString(2);
    for(int i = bin.length(); i < 32; i ++)
      bin = "0"+bin;
    // System.out.println("Tamanho de Bin:"+bin.length());
    return bin;
  }
  public static String hex0xToBin(String hex) {
    hex = hex.split("0x")[1];
    // System.out.println("hexa: "+ hex);
    String bin = hexToBin32(hex);
    // System.out.println("Binario: "+ bin);
    return bin; 
  }

  public static String decimalToHex (int inteiro) {
    return Long.toString(inteiro, 16);
  }

  public static Long hexToDec (String hex) {
    return Long.parseLong(hex,16);
  }
}
