import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Dicionario {

    private String palavra;
    private String traducao;
    private TipoDicionario tipoDicionario;
    private List<Dicionario> listaDePalavras = new ArrayList<>();

    public Dicionario() {
    }

    private Dicionario(String palavra, String traducao, TipoDicionario tipoDicionario) {
        this.palavra = palavra;
        this.traducao = traducao;
        this.tipoDicionario = tipoDicionario;
    }

    public void adicionarPalavra(String palavra, String traducao, TipoDicionario tipoDicionario){
        Dicionario dicionario = new Dicionario(palavra.toUpperCase(), traducao, tipoDicionario);
        listaDePalavras.add(dicionario);
    }

    public String traduzir(String palavra, TipoDicionario tipoDicionario){
        Dicionario palavra_nao_encontrada = this.listaDePalavras.stream().filter(p -> p.getPalavra().equals(palavra.toUpperCase()) && p.getTipoDicionario().getIdioma().equals(tipoDicionario.getIdioma())).findFirst().orElseThrow(() -> new PalavraNaoEncontradaException("Palavra nao encontrada"));
        return palavra_nao_encontrada.getTraducao();
    }

    private String getPalavra() {
        return palavra;
    }

    private String getTraducao() {
        return traducao;
    }

    private TipoDicionario getTipoDicionario() {
        return tipoDicionario;
    }
}
