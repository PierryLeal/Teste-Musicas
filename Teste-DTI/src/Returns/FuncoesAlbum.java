package Returns;

public class FuncoesAlbum {
	public String titulo;
	public String ano;
	public String banda;
	
	public FuncoesAlbum(String titulo, String ano, String banda) {
		super();
		this.titulo = titulo;
		this.ano = ano;
		this.banda = banda;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getBanda() {
		return banda;
	}
	public void setBanda(String banda) {
		this.banda = banda;
	}
	
}
