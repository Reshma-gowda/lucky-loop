import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

public class VideoConsultationApp1{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user to enter a consultation link
        System.out.print("Enter the consultation link (e.g., https://video.consultation.link/1): ");
        String consultationLink = scanner.nextLine();
        
        // Open the link in the browser
        openLinkInBrowser(consultationLink);
        
        scanner.close();
    }

    private static void openLinkInBrowser(String link) {
        if (Desktop.isDesktopSupported()) {
            try {
                // Create a URI object
                URI uri = new URI(link);
                
                // Open the default browser with the given URI
                Desktop.getDesktop().browse(uri);
                System.out.println("Opening the video consultation link in the browser...");
            } catch (IOException | URISyntaxException e) {
                System.out.println("Error opening the link: " + e.getMessage());
            }
        } else {
            System.out.println("Desktop is not supported. Cannot open the browser.");
        }
    }
}