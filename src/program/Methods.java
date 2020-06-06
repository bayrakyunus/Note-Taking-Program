package program;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;


public class Methods
{

    public int dosyaOlustur(String txtNotAdiGetText,String txtNotDetayGetText)
    {
        if (!txtNotAdiGetText.equals("") && !txtNotDetayGetText.equals(""))
        {
            try {
                FileWriter fileWriter = new FileWriter("notes/"+txtNotAdiGetText,true);
                fileWriter.write(txtNotDetayGetText);
                fileWriter.close();
            } catch (Exception e) {JOptionPane.showMessageDialog(null, e+"");}
            return 1;
        }
        else
            return -1;
    }

    public DefaultListModel listNotlar()
    {
        DefaultListModel dlm = new DefaultListModel();
        
        // notes/ konumundaki dosyaları tarayıp txt uzantılı olanları listeye ekliyor.
        String files = null;
        File folder = new File("notes");
        File[] listOfFiles = folder.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                files = listOfFiles[i].getName();
                if (files.endsWith(".txt") || files.endsWith(".TXT")) {
                    dlm.addElement(files);
                }
            }
        }// Tarama Bitti txt uzantılı dosyalar listeye eklendi.
        return dlm;
    }
    
    public String notDetayGoster(String data){
        String metin = "";
        try {
            File file = new File ("notes/"+data);
            Scanner read = new Scanner(file);
            while (read.hasNextLine()) {
                String line = read.nextLine();
                metin+=line;
                metin+="\n";
            }
            read.close();
        } catch (Exception e){JOptionPane.showMessageDialog(null, e+"");}

        return metin;
    }

}
