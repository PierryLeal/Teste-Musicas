import java.util.ArrayList;
import java.util.Scanner;
import Atividade.Album;
import Atividade.Tarefas;
import Returns.FuncoesAlbum;
import Returns.funcaoMusica;

public class Sistema {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		new ArrayList<>();

		boolean rodando = true;

		while (rodando) {
			System.out.println("======== MENU ========");
			System.out.println("1 - Cadastrar �lbum");
			System.out.println("2 - Pesquisar �lbum");
			System.out.println("3 - Pesquisar M�sica");
			System.out.println("4 - Gerar Playlist");
			System.out.println("5 - Sair\n");
			System.out.println("======================");
			System.out.println("Escolha sua op��o: ");
			String opcao = sc.nextLine();

			switch (opcao) {
			case "1": {
				System.out.println("====== CADASTRAR �LBUM =======");

				FuncoesAlbum lista = Tarefas.adicionarAlbum();
				ArrayList<funcaoMusica> listaMusica = Album.adicionarMusica(lista.getTitulo());

				break;
			}
			case "2": {
				System.out.println("====== PESQUISAR �LBUM =======");

				System.out.println("Forne�a a palavra chave de busca: ");
				String chave = sc.nextLine();
				ArrayList<FuncoesAlbum> lista = Tarefas.pesquisarAlbum(chave);
				for (FuncoesAlbum album : lista) {
					System.out.println("# O �lbum " + album.getTitulo() + " (" + album.getAno() + ") da banda "
							+ album.getBanda());
					ArrayList<funcaoMusica> musicas = Album.buscarMusicaPorAlbum(album.getTitulo());
					for (funcaoMusica musica : musicas) {
						System.out.println("   - " + musica.getTitulo());
					}
				}

				break;
			}
			case "3": {
				System.out.println("====== PESQUISAR M�SICA =======");
				System.out.println("Deseja pesquisar por <1>t�tulo | <2>banda: ");
				int tituloBanda = Integer.parseInt(sc.nextLine());

				if (tituloBanda == 1) {
					System.out.println("Forne�a a palavra chave de busca: ");
					String chave = sc.nextLine();
					ArrayList<funcaoMusica> listaMusica = Album.buscarMusicaPorTitulo(chave);

					if (listaMusica == null) {
						System.out.println("N�o possui nenhuma m�sica cadastrada");
					} else {
						for (funcaoMusica musica : listaMusica) {
							System.out.println(
									"   - \"" + musica.getTitulo() + "\" com dura��o de (" + musica.getDuracao() + ")");
						}
					}

				} else if (tituloBanda == 2) {
					System.out.println("Forne�a a palavra chave de busca: ");
					String chave = sc.nextLine();
					ArrayList<FuncoesAlbum> lista = Tarefas.pesquisarBanda(chave);
					if (lista == null) {
						System.out.println("N�o possui nenhuma m�sica cadastrada");
					} else {
						for (FuncoesAlbum album : lista) {
							ArrayList<funcaoMusica> musicas = Album.buscarMusicaPorAlbum(album.getTitulo());
							for (funcaoMusica musica : musicas) {
								System.out.println("   - \"" + musica.getTitulo() + "\" com dura��o de ("
										+ musica.getDuracao() + ")");
							}
						}
					}

				} else {
					System.out.println("N�o pertence a nenhuma op��o....");
				}

				break;
			}
			case "4": {
				System.out.println("====== GERAR PLAYLIST ALEAT�RIA =======");

				ArrayList<funcaoMusica> listaMusicaFavorita = Album.adicionarPlaylistFavorita();
				ArrayList<funcaoMusica> listaMusicaRandom = Album.adicionarPlaylistRandom();

				for (funcaoMusica musica : listaMusicaFavorita) {

					System.out.println("   ->\"" + musica.getTitulo() + "\" - " + musica.getDuracao() + " minutos");
				}

				for (funcaoMusica musica : listaMusicaRandom) {

					System.out.println("   ->\"" + musica.getTitulo() + "\" - " + musica.getDuracao() + " minutos");
				}

				break;
			}
			case "5": {
				System.out.println("Saindo.....");
				rodando = false;
				break;
			}
			}

		}

	}

}
