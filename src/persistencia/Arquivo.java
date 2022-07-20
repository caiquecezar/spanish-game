package persistencia;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Arquivo {


    public ArrayList<String> carregarArquivo(String s) throws IOException, FileNotFoundException{
        FileInputStream stream = new FileInputStream(s);
        InputStreamReader streamReader = new InputStreamReader(stream);
        BufferedReader reader = new BufferedReader(streamReader);
        String linha;
        ArrayList<String> line = new ArrayList<String>();
        while((linha = reader.readLine()) != null)  {
            line.add(linha);
        }
        return line;
    }
	public void salvarArquivo(String line) throws IOException{
        line += "\r\n" ;
        File arquivo = new File("recordes.txt");
        FileOutputStream fos = new FileOutputStream(arquivo,true);
        fos.write(line.getBytes());
        fos.close();
		
	}
	public void limpaRecordes() throws IOException {
        String line = "" ;
        File arquivo = new File("recordes.txt");
        FileOutputStream fos = new FileOutputStream(arquivo,false);
        fos.write(line.getBytes());
        fos.close();
	}
   

}
    
