package helpers;

public class Convercao {
  public static String binParaHexa8(String binario) {
    String hex = Integer.toString(Integer.parseInt(binario, 2), 16);
    for(int i = hex.length(); i < 8; i++)
            hex = "0"+hex;
    return "0x"+hex;
}
}
