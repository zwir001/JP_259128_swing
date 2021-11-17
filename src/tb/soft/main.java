package tb.soft;

/**
 * klasa główna zawierająca metodę statyczną main
 */
public class main {
    public static void main(String[] args) {
        try{
            Window window=new Window("Logowanie");
            window.setVisible(true);
        }
        catch(Exception e){
            e.printStackTrace(System.err);
        }
    }
}
