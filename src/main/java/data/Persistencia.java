package data;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Persistencia {

  public static ArrayList<Autor> loadAutores() {

    ArrayList<Autor> autores = new ArrayList<Autor>();

    try {
      File file = new File("autores.txt");

      Scanner data = new Scanner(file);

      while (data.hasNextLine()) {

        String nome = data.nextLine();
        autores.add(new Autor(nome));

      }

      data.close();

    } catch (IOException e) {
      e.printStackTrace();
    }

    return autores;
  }

  public static ArrayList<Editora> loadEditoras() {

    ArrayList<Editora> editoras = new ArrayList<Editora>();

    try {
      File file = new File("editoras.txt");

      Scanner data = new Scanner(file);

      while (data.hasNextLine()) {

        String nome = data.nextLine();
        editoras.add(new Editora(nome));

      }

      data.close();

    } catch (IOException e) {
      e.printStackTrace();
    }

    return editoras;
  }

  public static Autor findAutor(ArrayList<Autor> autores, String nome) {

    for (Autor autor : autores) {
      if (nome.equals(autor.getNome())) {
        return autor;
      }
    }

    return null;
  }

  public static Editora findEditora(ArrayList<Editora> editoras, String nome) {

    for (Editora editora : editoras) {

      if (nome.equals(editora.getNome())) {
        return editora;
      }

    }

    return null;
  }

  public static ArrayList<Livro> loadLivros(ArrayList<Autor> autores, ArrayList<Editora> editoras) {

    ArrayList<Livro> livros = new ArrayList<Livro>();

    try {

      File file = new File("livros.txt");

      Scanner data = new Scanner(file);

      while (data.hasNextLine()) {

        String[] elements = data.nextLine().split("@");

        if (elements.length == 3) {

          livros.add(
              findAutor(autores, elements[1]).adicionarLivroEditora(elements[0], findEditora(editoras, elements[2])));

        }

        else if (elements.length == 2) {

          livros.add(findAutor(autores, elements[1]).adicionarLivro(elements[0]));

        }
      }

      data.close();

    } catch (IOException e) {
      e.printStackTrace();
    }

    return livros;

  }

  public static void saveAutores(ArrayList<Autor> autores) {

    try {

      PrintWriter writer = new PrintWriter(new File("autores.txt"));
      writer.append("");
      writer.flush();
      writer.close();

    } catch (FileNotFoundException e) {

      e.printStackTrace();

    }

    String escrever = "";

    for (Autor a : autores) {

      escrever += a.getNome() + "\n";

    }

    try {

      FileWriter writer = new FileWriter("autores.txt");
      writer.write(escrever);
      writer.close();

    } catch (IOException e) {

      e.printStackTrace();

    }
  }

  public static void saveLivros(ArrayList<Livro> livros) {
		
		try {
			
			PrintWriter writer = new PrintWriter(new File("livros.txt"));
			writer.append("");
		    writer.flush();
		    writer.close();
		    
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		}
		
		String escrever = "";
		
		for (Livro b : livros) {
			
			escrever += b.getTitulo() + "@";
				
			if(b.getEditora() == null) {
					
				escrever += b.getAutor().getNome() + "\n";
				
			}
				
			else {
					
				escrever += b.getAutor().getNome() + "@";
				escrever += b.getEditora().getNome() + "\n";
					
			}
		}
		
		try {
		
			FileWriter writer = new FileWriter("livros.txt");
			writer.write(escrever);
			writer.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
	}

  public static void saveEditoras(ArrayList<Editora> editoras) {

    try {

      PrintWriter writer = new PrintWriter(new File("editoras.txt"));
      writer.append("");
      writer.flush();
      writer.close();

    } catch (FileNotFoundException e) {

      e.printStackTrace();

    }

    String escrever = "";

    for (Editora a : editoras) {

      escrever += a.getNome() + "\n";

    }

    try {

      FileWriter writer = new FileWriter("editoras.txt");
      writer.write(escrever);
      writer.close();

    } catch (IOException e) {

      e.printStackTrace();

    }
  }
}
