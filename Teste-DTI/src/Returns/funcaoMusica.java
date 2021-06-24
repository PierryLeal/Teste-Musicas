package Returns;

public class funcaoMusica {
	String album;
	String titulo;
	double duracao;
	boolean favorita;
	
	
	public funcaoMusica(String album, String titulo, double duracao, boolean favorita) {
		this.album = album;
		this.titulo = titulo;
		this.duracao = duracao;
		this.favorita = favorita;
		
	}
	
	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public double getDuracao() {
		return duracao;
	}
	public void setDuracao(double duracao) {
		this.duracao = duracao;
	}
	public boolean isFavorita() {
		return favorita;
	}
	public void setFavorita(boolean favorita) {
		this.favorita = favorita;
	}

}
