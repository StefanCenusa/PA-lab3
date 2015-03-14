
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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
        boolean found = false;
        if (arguments.equals(".")) arguments = System.getProperty("user.dir");

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
                        found = true;
                        System.out.println(name);
                    }
                }
            }
        }
        if (!found){
            System.out.println("Niciun fisier audio!");
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

    public void cd(String directory_name)
    {
        File directory;

        directory = new File(directory_name).getAbsoluteFile();
        if (directory.exists() || directory.mkdirs()) {
            System.setProperty("user.dir", directory.getAbsolutePath());
        }
        pwd();
    }

    public void search (Pattern p, String pDir){
        File dir = new File (pDir);

        File[] files = dir.listFiles();
        if (files == null) return;
        for (int i = 0; i < files.length; i++) {
            String x = files[i].getName();
            if (".".equals(x)) continue;
            if ("..".equals(x)) continue;

            Matcher m = p.matcher(x);
            if (m.matches()) {
                System.out.println(x);
            }
            if (files[i].isDirectory ()) {
                search(p, pDir + File.separator + x);
            }
        }
    }

    public void rename(String oldname, String newname){
        // File (or directory) with old name
        File file = new File(oldname);

        // File (or directory) with new name
        File file2 = new File(newname);
        if(file2.exists()) try {
            throw new IOException("file exists");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // Rename file (or directory)
        boolean success = file.renameTo(file2);
        if (!success) {
            throw new IllegalArgumentException("Eroare la redenumire!");
        }
    }

    public void pwd(){
        System.out.println("Working Directory: "+ System.getProperty("user.dir"));
    }
}