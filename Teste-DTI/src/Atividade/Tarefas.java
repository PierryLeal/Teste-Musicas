package Atividade;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import Returns.FuncoesAlbum;

public class Tarefas {
	public Scanner sc = new Scanner(System.in);

	public static FuncoesAlbum adicionarAlbum() {

		Scanner sc = new Scanner(System.in);
		ArrayList<FuncoesAlbum> funcoes = new ArrayList<>();

		System.out.println("\n-------ÁLBUM-------");
		System.out.println("Forneça o titulo do álbum: ");
		String titulo = sc.nextLine();
		System.out.println("Forneça o ano de lançamento do álbum: ");
		String ano = sc.nextLine();
		System.out.println("Forneça o nome da banda: ");
		String banda = sc.nextLine();

		FuncoesAlbum f = new FuncoesAlbum(titulo, ano, banda);

		try {
			FileWriter fw = new FileWriter("Album.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write(f.getTitulo() + ":" + f.getAno() + ":" + f.getBanda());
			bw.write("\n");
			bw.flush();
			bw.close();
			fw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return f;
	}

	private static ArrayList<FuncoesAlbum> lerDoArquivoAlbuns() {
		ArrayList<FuncoesAlbum> funcoes = new ArrayList<>();

		try {
			FileReader fr = new FileReader("Album.txt");
			BufferedReader br = new BufferedReader(fr);

			String ler = br.readLine();

			while (ler != null) {
				String[] ler1 = ler.split(":");
				FuncoesAlbum a = new FuncoesAlbum(ler1[0], ler1[1], ler1[2]);
				funcoes.add(a);

				ler = br.readLine();
			}
			br.close();
			fr.close();

			return funcoes;
		} catch (Exception e) {
			return null;
		}
	}

	public static ArrayList<FuncoesAlbum> pesquisarAlbum(String chave) {

		ArrayList<FuncoesAlbum> albunsSalvos = lerDoArquivoAlbuns();
		ArrayList<FuncoesAlbum> albunsEncontrados = new ArrayList<>();
		
		System.out.println("Os albuns encotrados foram: ");
		for (FuncoesAlbum album : albunsSalvos) {
			if (album.getTitulo().toLowerCase().contains(chave.toLowerCase())
					|| album.getAno().toLowerCase().contains(chave.toLowerCase())
					|| album.getBanda().toLowerCase().contains(chave.toLowerCase())) {
				albunsEncontrados.add(album);
			}

		}

		return albunsEncontrados;

	}
	
	public static ArrayList<FuncoesAlbum> pesquisarBanda(String chave) {

		ArrayList<FuncoesAlbum> albunsSalvos = lerDoArquivoAlbuns();
		ArrayList<FuncoesAlbum> albunsEncontrados = new ArrayList<>();
		
		System.out.println("As músicas encotrados foram: ");
		for (FuncoesAlbum album : albunsSalvos) {
			if (album.getBanda().toLowerCase().contains(chave.toLowerCase())) {
				albunsEncontrados.add(album);
			}

		}

		return albunsEncontrados;

	}
	
}
