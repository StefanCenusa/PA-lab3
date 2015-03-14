
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Console {
    static String[] fileTypes = {"mp3", "flac", "wav"};

    public void printWelcome() {
        System.out.println("Bine ati venit!");
    }

    public String readCommand() {
        try {
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
            String line = console.readLine();
            return line;
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void list(String arguments) {
        if (arguments == null) arguments = ".";
        File folder = new File(arguments);
        File[] fileList = folder.listFiles();
        if (fileList == null)
            throw new IllegalArgumentException("Folder gresit!");
        for (File fileEntry : fileList) {
            if (!fileEntry.isDirectory()) {
                String name = fileEntry.getName();
                if (name.contains(".")) {
                    String ext = name.substring(name.lastIndexOf('.')+1);
                    if (Arrays.asList(fileTypes).contains(ext.toLowerCase())) {
                        System.out.println(name);
                    }
                }
            }
        }
    }

    public void play(String arguments){
        try {
            //Runtime.getRuntime().exec("cmd.exe /c start " + arguments);
            java.awt.Desktop.getDesktop().open(new java.io.File(arguments));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}