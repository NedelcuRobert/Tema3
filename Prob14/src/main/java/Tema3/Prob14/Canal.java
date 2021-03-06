package Tema3.Prob14;

import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Canal extends Program {
	
    private String nume;
	private Program[] programe;
    private String frecventa;
    private int ziRevizie;
    
    public Canal() {}

	public Canal(String nume, Program[] programe, String frecventa, int ziRevizie) {
		super();
		this.nume = nume;
		this.programe = programe;
		this.frecventa = frecventa;
		this.ziRevizie = ziRevizie;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

    public Program[] getPrograme() {
		return programe;
	}

	public void setPrograme(Program[] programe) {
		this.programe = programe;
	}

	public String getFrecventa() {
		return frecventa;
	}

	public void setFrecventa(String frecventa) {
		this.frecventa = frecventa;
	}

	public int getZiRevizie() {
		return ziRevizie;
	}

	public void setZiRevizie(int ziRevizie) {
		this.ziRevizie = ziRevizie;
	}
	
	public void writeGson(Canal[] c) {
		
		try {	
		List <Canal> canale  = Arrays.asList(c[0]);
		
		    Gson gson = new GsonBuilder().setPrettyPrinting().create();

		    Writer writer = Files.newBufferedWriter(Paths.get(".\\jsonfiles\\canal.json"));

		    gson.toJson(canale, writer);

		    writer.close();

		} catch (Exception ex) {
		    ex.printStackTrace();
		}			
	}
	
   public void readGson() {
		
		try {
		
		    Gson gson = new Gson();

		    Reader reader = Files.newBufferedReader(Paths.get(".\\jsonfiles\\canal.json"));

		    List<Program> canale = Arrays.asList(gson.fromJson(reader, Canal[].class));

		    canale.forEach(System.out::println);

		    reader.close();

		} catch (Exception ex) {
		    ex.printStackTrace();
		}			
	}
	
	@Override
    public String toString() {
        return "Canal{" +
                "programe=" + Arrays.toString(programe) +
                ", frecventa='" + frecventa + '\'' +
                ", ziRevizie=" + ziRevizie +
                '}';
    }

}