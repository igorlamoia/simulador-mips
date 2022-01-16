import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Formatar {
	private Path arquivoInicial = null;
	private Path arquivoFormatado = null;
	private int contador = 0;
	private List<String> codigo = new ArrayList<>();
	private List<String> codigoFormatado = new ArrayList<>();
	private Map<String, Integer> labels = new HashMap<>(); // label => Posição
	private Map<Integer, String> branchs = new HashMap<>(); // numeroLinha => string linha
	private Map<Integer, String> jumps = new HashMap<>(); // numeroLinha => string linha

	public Formatar (Path arquivoInicial, Path arquivoFormatado) throws IOException {
		this.arquivoInicial = arquivoInicial;
		this.arquivoFormatado = arquivoFormatado;
		this.formatarArquivo();
	}

	private void formatarArquivo () throws IOException {
		for (String linha : Files.readAllLines(this.arquivoInicial, StandardCharsets.UTF_8)) {
			linha = linha.split("#")[0].trim(); // tudo que vem antes do comentário, ignorando o resto
			
			if(linha.contains(":"))
				linha = this.pegaLabelRemoveLinha(linha);
			
			this.verificarJump(linha);
			this.verificarBranch(linha);
			this.adicionarLinhaValida(linha);
		}

		this.trocarBranchsJumpsPorNumero();

		Files.write(this.arquivoFormatado, this.codigoFormatado);
	}

	// Se contem labels put(chave: nome da lavel, valor: numero da linha atual)
	private String pegaLabelRemoveLinha(String linha) {
		this.labels.put(linha.substring(0, linha.indexOf(":")).trim(), this.contador); 
		linha = ""; // Limpando a linha pois a label deve sair
		return linha;
	}

	// Somente se a linha for preenchida com código iremos adicionar 
	private void adicionarLinhaValida (String linha) {
		if(! linha.isBlank()) {
			this.codigo.add(linha);
			this.contador++;
		}
	}

	// O this.contador já pulou a linha, agr sim, verifico se era branch (sempre uma instrução a  frente)
	// Se contem branchs put(chave: nome da label de destino, valor: numero linha atual)
	private void verificarBranch (String linha) {
		if(linha.contains("beq") || linha.contains("bne"))
			this.branchs.put(this.contador, linha.split(",")[2].trim());
	}

	private void verificarJump (String linha) {
		if(linha.contains("j "))
			this.jumps.put(this.contador, linha.split(" ")[1].trim());
	}

	private void trocarBranchsJumpsPorNumero () {
		String label = null;
		String metadeEsquerdaDaLabelBranch = null;
		this.contador = 0;
		int deslocamento = 0;
		for(String linha : this.codigo) {
			if(this.branchs.containsKey(this.contador)){
				label = this.branchs.get(this.contador).trim(); 
				metadeEsquerdaDaLabelBranch = linha.split(label)[0].trim();
				deslocamento = ((this.labels.get(label.trim())) - this.contador)-1; 
				linha = metadeEsquerdaDaLabelBranch + " 0x"  + Integer.toHexString(deslocamento).toUpperCase();
			}
			else if (this.jumps.containsKey(this.contador)){
				linha = linha.split(" ")[0].trim();
				linha = linha + " 0x" + Integer.toHexString(this.labels.get(this.jumps.get(this.contador))).toUpperCase();
			}
			this.codigoFormatado.add(linha);
			this.contador++;
		}
	}



}
