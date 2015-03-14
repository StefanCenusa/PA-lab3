import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Console con = new Console();
        con.printWelcome();
        while (true) {
            String[] commandParts = con.readCommand().split(" ");
            try {
                if (commandParts[0].equals("list")) {
                    if (commandParts.length == 1) {
                        con.list(System.getProperty("user.dir"));
                        continue;
                    } else if (commandParts.length == 2) {
                        con.list(commandParts[1]);
                        continue;
                    } else throw new IllegalArgumentException("Pathul nu trebuie sa contina spatii!");
                }
                if (commandParts[0].equals("play")) {
                    if (commandParts.length == 2) {
                        con.play(commandParts[1]);
                        continue;
                    } else if (commandParts.length == 1)
                        throw new IllegalArgumentException("Nu ati specificat fisierul!");
                    else
                        throw new IllegalArgumentException("Pathul nu trebuie sa contina spatii!");
                }
                if (commandParts[0].equals("cd")) {
                    if (commandParts.length == 2) {
                        con.cd(commandParts[1]);
                        continue;
                    } else if (commandParts.length == 1)
                        throw new IllegalArgumentException("Nu ati specificat directorul!");
                    else
                        throw new IllegalArgumentException("Pathul nu trebuie sa contina spatii!");
                }
                if (commandParts[0].equals("search")) {
                    if (commandParts.length == 3) {
                        Pattern p = Pattern.compile(commandParts[1]);
                        con.search(p, commandParts[2]);
                        continue;
                    } else if (commandParts.length == 2)
                        throw new IllegalArgumentException("Nu ati specificat fisierul sau directorul!");
                    else
                        throw new IllegalArgumentException("Pathul nu trebuie sa contina spatii!");
                }
                if (commandParts[0].equals("rename")) {
                    if (commandParts.length == 3) {
                        con.rename(commandParts[1], commandParts[2]);
                        continue;
                    } else if (commandParts.length == 2)
                        throw new IllegalArgumentException("Numar de parametrii invalid!");
                    else
                        throw new IllegalArgumentException("Pathul nu trebuie sa contina spatii!");
                }
                throw new IllegalArgumentException("Comanda invalida!");
            } catch (IllegalArgumentException e) {
                //e.printStackTrace();
                System.out.println(e.getMessage());
            }

        }
    }
}
