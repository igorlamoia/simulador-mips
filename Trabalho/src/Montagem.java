import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Montagem {
	
	public static void paraHexadecimal(Path arquivoInicial, Path arquivoFormatado) throws IOException {
		
		List<String> codigo = new ArrayList<>();
		
		//Percorre todas as linhas do arquivo (cod_asm_formatado.txt)
		for (String linha : Files.readAllLines(arquivoInicial, StandardCharsets.UTF_8)) {
			//Para cada linha, após todo tratamento para transformá-la de código MIPS --> Hexadecimal
			//Atribuir a mesma no ArrayList 'codigo' 
			codigo.add(Infos.infos(linha));

		}
		
		//Enfim, escrever o resultado final no arquivo (cod_hexadecimal.txt)
		Files.write(arquivoFormatado, codigo);

    }

}
