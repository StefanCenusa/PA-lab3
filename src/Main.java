
public class Main {
    public static void main(String[] args) {
        Console con = new Console();
        con.printWelcome();
        while (true) {
            String[] commandParts = con.readCommand().split(" ");
            try {
                if(commandParts[0].equals("list")){
                    if (commandParts.length < 2) {
                        con.list(null);
                        continue;
                    }
                    else
                        if (commandParts.length==2) {
                            con.list(commandParts[1]);
                            continue;
                        }
                        else throw new IllegalArgumentException("Pathul nu trebuie sa contina spatii!");
                }
                if(commandParts[0].equals("play")){
                    if (commandParts.length==2) {
                        con.play(commandParts[1]);
                        continue;
                    }
                    else
                        if (commandParts.length==1)
                            throw new IllegalArgumentException("Nu ati specificat fisierul!!");
                        else
                            throw new IllegalArgumentException("Pathul nu trebuie sa contina spatii!");
                }
            } catch (IllegalArgumentException e) {
                //e.printStackTrace();
                System.out.println(e.getMessage());
            }

        }
    }
}
