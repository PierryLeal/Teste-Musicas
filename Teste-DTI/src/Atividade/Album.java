package Atividade;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import Returns.funcaoMusica;

public class Album {
	public static ArrayList<funcaoMusica> adicionarMusica(String albumNome) {

		Scanner sc = new Scanner(System.in);

		boolean limite = true;

		while (limite) {
			ArrayList<funcaoMusica> musica = new ArrayList<>();

			System.out.println("\n-------MÚSICA-------");
			System.out.println("Forneça o título da música: ");
			String titulo = sc.nextLine();
			System.out.println("forneça a duração da música em minutos: ");
			double duracao = Double.parseDouble(sc.nextLine());
			System.out.println("Se a música é uma favorita digite <s>Sim | <n>Não: ");
			String line = sc.nextLine().toLowerCase();

			boolean favorita = line.contains("s");

			funcaoMusica f = new funcaoMusica(albumNome, titulo, duracao, favorita);

			try {
				FileWriter fw = new FileWriter("Musica.txt", true);
				BufferedWriter bw = new BufferedWriter(fw);

				bw.write(albumNome + ":" + f.getTitulo() + ":" + f.getDuracao() + ":" + f.isFavorita());
				bw.write("\n");
				bw.flush();
				bw.close();
				fw.close();

			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			System.out.println("Para adicionar mais músicas <s>Sim | <n>Não: ");
			String adicionar = sc.nextLine().toLowerCase();

			limite = adicionar.contains("s");

		}
		return null;
	}

	public static ArrayList<funcaoMusica> lerDoAlbumMusica() {
		ArrayList<funcaoMusica> funcoes = new ArrayList<>();

		try {
			FileReader fr = new FileReader("Musica.txt");
			BufferedReader br = new BufferedReader(fr);

			String ler = br.readLine();

			while (ler != null) {
				String[] ler1 = ler.split(":");
				funcaoMusica a = new funcaoMusica(ler1[0], ler1[1], Double.parseDouble(ler1[2]),
						Boolean.parseBoolean(ler1[3]));
				funcoes.add(a);
				ler = br.readLine();
			}
			br.close();
			fr.close();
			return funcoes;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	public static ArrayList<funcaoMusica> buscarMusicaPorAlbum(String nomeAlbum) {

		ArrayList<funcaoMusica> musicas = lerDoAlbumMusica();
		ArrayList<funcaoMusica> musicasEncontradas = new ArrayList<>();

		System.out.println("As músicas encotrados foram: ");
		for (funcaoMusica musica : musicas) {
			if (musica.getAlbum().toLowerCase().contains(nomeAlbum.toLowerCase())) {
				musicasEncontradas.add(musica);
			}
		}
		return musicasEncontradas;
	}

	public static ArrayList<funcaoMusica> buscarMusicaPorTitulo(String chave) {

		ArrayList<funcaoMusica> musicas = lerDoAlbumMusica();
		ArrayList<funcaoMusica> musicasEncontradas = new ArrayList<>();

		System.out.println("As músicas encotrados foram: ");

		for (funcaoMusica musica : musicas) {
			if (musica.getTitulo().toLowerCase().contains(chave.toLowerCase())) {
				musicasEncontradas.add(musica);
			}
		}

		return musicasEncontradas;
	}

	public static ArrayList<funcaoMusica> adicionarPlaylistFavorita() {

		ArrayList<funcaoMusica> musicas = lerDoAlbumMusica();
		Collections.shuffle(musicas);
		ArrayList<funcaoMusica> musicasEncontradas = new ArrayList<>();

		double tempoTotal = 0;

		System.out.println("------Playlist Aleatória------ ");
		for (funcaoMusica musica : musicas) {
			if (musica.isFavorita() && musica.getDuracao() + tempoTotal < 30) {
				tempoTotal += musica.getDuracao();
				musicasEncontradas.add(musica);
			}
		}

		return musicasEncontradas;
	}

	public static ArrayList<funcaoMusica> adicionarPlaylistRandom() {

		ArrayList<funcaoMusica> musicas = lerDoAlbumMusica();
		Collections.shuffle(musicas);
		ArrayList<funcaoMusica> musicasEncontradas = new ArrayList<>();

		double tempoTotal = 0;

			for (funcaoMusica musica : musicas) {
				if (musica.isFavorita() == false && musica.getDuracao() + tempoTotal < 30) {
					tempoTotal += musica.getDuracao();
					musicasEncontradas.add(musica);
				}
			}
		
		return musicasEncontradas;
	}

}
