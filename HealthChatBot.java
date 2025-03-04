import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HealthChatBot {

    // Map to store disease data (disease name -> DiseaseInfo)
    private static Map<String, DiseaseInfo> diseaseDatabase = new HashMap<>();

    public static void main(String[] args) {
        // Initialize the disease database with sample data
        initializeDatabase();

        // Scanner for taking user input
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Health Chatbot!");
        System.out.println("You can enter the name of a disease to get information on curing methods and health improvement.");
        System.out.println("Type 'exit' to stop the conversation.");

        while (true) {
            // Ask user for the disease name
            System.out.print("\nEnter disease name: ");
            String diseaseName = scanner.nextLine().toLowerCase(); // Convert input to lowercase

            // Exit condition if user types 'exit'
            if (diseaseName.equals("exit")) {
                System.out.println("Goodbye!");
                break;
            }

            // Fetch the disease information from the database
            DiseaseInfo diseaseInfo = diseaseDatabase.get(diseaseName);

            // If disease exists, provide information; otherwise, show an error message
            if (diseaseInfo != null) {
                System.out.println("\nDisease: " + diseaseName);
                System.out.println("Symptoms: " + diseaseInfo.getSymptoms());
                System.out.println("Curing Methods: " + diseaseInfo.getCuringMethods());
                System.out.println("Health Improvement Methods: " + diseaseInfo.getHealthImprovementMethods());
            } else {
                System.out.println("\nSorry, we don't have information for this disease. Try another one.");
            }
        }

        scanner.close();
    }

    // Method to initialize the database with diseases
    private static void initializeDatabase() {
        // Adding diseases including Cancer, Diabetes, and others

        // Sample data for various diseases
        diseaseDatabase.put("cough", new DiseaseInfo(
                "Symptoms: Dry throat, persistent coughing, sore throat.",
                "Curing Methods: Rest, drink plenty of fluids, honey, ginger, and cough suppressants.",
                "Health Improvement: Stay hydrated, eat nutritious food, get adequate sleep."
        ));

        diseaseDatabase.put("fever", new DiseaseInfo(
                "Symptoms: High body temperature, chills, fatigue, headache.",
                "Curing Methods: Take fever-reducing medication like paracetamol, stay hydrated, rest.",
                "Health Improvement: Maintain a comfortable temperature, eat light meals, stay hydrated."
        ));

        diseaseDatabase.put("headache", new DiseaseInfo(
                "Symptoms: Pain in the head, sensitivity to light and sound, dizziness.",
                "Curing Methods: Rest, over-the-counter painkillers like ibuprofen, hydration.",
                "Health Improvement: Stay stress-free, practice relaxation techniques, maintain good posture."
        ));

        diseaseDatabase.put("cold", new DiseaseInfo(
                "Symptoms: Sneezing, runny nose, sore throat, mild cough.",
                "Curing Methods: Rest, hydration, vitamin C, nasal decongestants.",
                "Health Improvement: Consume a balanced diet, keep the body warm, and avoid stress."
        ));

        // Adding more diseases
        diseaseDatabase.put("cancer", new DiseaseInfo(
                "Symptoms: Unexplained weight loss, fatigue, pain, changes in skin, coughing or difficulty breathing.",
                "Curing Methods: Treatment options include chemotherapy, radiation therapy, surgery, targeted therapy, and immunotherapy depending on the type of cancer.",
                "Health Improvement: Maintain a healthy lifestyle, manage stress, eat a balanced diet, and stay active. Follow treatment plans as prescribed by your doctor."
        ));

        diseaseDatabase.put("diabetes", new DiseaseInfo(
                "Symptoms: Increased thirst, frequent urination, extreme fatigue, blurred vision.",
                "Curing Methods: Type 1 diabetes requires insulin injections, while Type 2 diabetes can be managed with lifestyle changes, medications, and possibly insulin.",
                "Health Improvement: Regular exercise, healthy eating, monitor blood sugar levels, and manage stress."
        ));

        diseaseDatabase.put("asthma", new DiseaseInfo(
                "Symptoms: Shortness of breath, wheezing, chest tightness, coughing, especially at night or early morning.",
                "Curing Methods: Use of inhalers, bronchodilators, and corticosteroids. Avoid triggers and seek medical advice.",
                "Health Improvement: Maintain a healthy lifestyle, avoid smoking, keep airways clear, and monitor your condition regularly."
        ));

        diseaseDatabase.put("arthritis", new DiseaseInfo(
                "Symptoms: Joint pain, swelling, stiffness, and decreased range of motion.",
                "Curing Methods: Medications such as anti-inflammatory drugs (NSAIDs), physical therapy, and in some cases, surgery.",
                "Health Improvement: Regular low-impact exercise, maintaining a healthy weight, and managing stress."
        ));

        diseaseDatabase.put("stroke", new DiseaseInfo(
                "Symptoms: Sudden numbness or weakness, confusion, trouble seeing, trouble walking.",
                "Curing Methods: Immediate medical attention, clot-busting medications, rehabilitation therapy after the stroke.",
                "Health Improvement: Healthy eating, physical rehabilitation, blood pressure management, and stress management."
        ));

        diseaseDatabase.put("heart disease", new DiseaseInfo(
                "Symptoms: Chest pain, shortness of breath, palpitations, dizziness.",
                "Curing Methods: Medications, lifestyle changes, surgery (such as angioplasty or bypass surgery), and heart transplant in extreme cases.",
                "Health Improvement: Healthy eating, regular exercise, stress management, and quitting smoking."
        ));

        diseaseDatabase.put("tuberculosis", new DiseaseInfo(
                "Symptoms: Coughing for weeks, chest pain, coughing up blood, weight loss, fatigue.",
                "Curing Methods: Antibiotic treatment (usually a combination of drugs for several months).",
                "Health Improvement: Follow treatment plan, rest, good nutrition, and prevent exposure to others."
        ));

        diseaseDatabase.put("hiv", new DiseaseInfo(
                "Symptoms: Rapid weight loss, recurring fever, tiredness, and unexplained rashes.",
                "Curing Methods: No cure, but antiretroviral therapy (ART) can help control the virus and improve quality of life.",
                "Health Improvement: Take ART medication consistently, avoid infections, maintain a healthy lifestyle."
        ));

        diseaseDatabase.put("malaria", new DiseaseInfo(
                "Symptoms: Fever, chills, sweats, fatigue, headache.",
                "Curing Methods: Antimalarial drugs such as chloroquine, artemisinin-based combination therapies (ACT).",
                "Health Improvement: Stay hydrated, get enough rest, and follow prescribed medication."
        ));

        diseaseDatabase.put("kalara", new DiseaseInfo(  // Kalara refers to Kala-azar (Leishmaniasis)
                "Symptoms: Fever, weight loss, swelling, enlarged spleen and liver, skin darkening.",
                "Curing Methods: Antileishmanial drugs like miltefosine or amphotericin B.",
                "Health Improvement: Good nutrition, maintain hygiene, and follow prescribed medication."
        ));

        diseaseDatabase.put("epilepsy", new DiseaseInfo(
                "Symptoms: Seizures, confusion, loss of consciousness, muscle spasms.",
                "Curing Methods: Anticonvulsant medications to manage seizures. In some cases, surgery may be considered.",
                "Health Improvement: Regular sleep, avoiding triggers, and maintaining a healthy lifestyle."
        ));

        diseaseDatabase.put("parkinson's", new DiseaseInfo(
                "Symptoms: Tremors, stiffness, slowness of movement, and balance problems.",
                "Curing Methods: Medications like levodopa, deep brain stimulation surgery in some cases.",
                "Health Improvement: Regular physical activity, balanced diet, and emotional support."
        ));

        diseaseDatabase.put("alzheimer's", new DiseaseInfo(
                "Symptoms: Memory loss, confusion, difficulty in thinking and decision-making.",
                "Curing Methods: No cure, but medications like donepezil can help manage symptoms.",
                "Health Improvement: Cognitive stimulation, emotional support, and a structured environment."
        ));

        // Additional diseases

        diseaseDatabase.put("stomach flu", new DiseaseInfo(
                "Symptoms: Vomiting, diarrhea, stomach cramps, nausea.",
                "Curing Methods: Hydration (oral rehydration salts), rest, anti-nausea medications.",
                "Health Improvement: Eat small, bland meals, stay hydrated, and avoid heavy foods."
        ));

        diseaseDatabase.put("allergy", new DiseaseInfo(
                "Symptoms: Sneezing, itching, runny nose, watery eyes.",
                "Curing Methods: Antihistamines, decongestants, avoiding allergens.",
                "Health Improvement: Try to avoid triggers, maintain a clean environment, and manage stress."
        ));

        diseaseDatabase.put("hypertension", new DiseaseInfo(
                "Symptoms: Often no symptoms, sometimes headaches or dizziness.",
                "Curing Methods: Medication (diuretics, ACE inhibitors), lifestyle changes (diet, exercise).",
                "Health Improvement: Regular exercise, reducing salt intake, reducing stress."
        ));

        diseaseDatabase.put("depression", new DiseaseInfo(
                "Symptoms: Persistent sadness, loss of interest in activities, fatigue, difficulty sleeping.",
                "Curing Methods: Therapy (Cognitive Behavioral Therapy), antidepressant medications.",
                "Health Improvement: Exercise, socializing, relaxation techniques, balanced diet."
        ));

        diseaseDatabase.put("copd", new DiseaseInfo(
                "Symptoms: Shortness of breath, chronic cough, wheezing, chest tightness.",
                "Curing Methods: Bronchodilators, corticosteroids, oxygen therapy.",
                "Health Improvement: Avoid smoking, regular exercise, and a nutritious diet."
        ));

    }
}

// A class to store disease-related information
class DiseaseInfo {
    private String symptoms;
    private String curingMethods;
    private String healthImprovementMethods;

    // Constructor
    public DiseaseInfo(String symptoms, String curingMethods, String healthImprovementMethods) {
        this.symptoms = symptoms;
        this.curingMethods = curingMethods;
        this.healthImprovementMethods = healthImprovementMethods;
    }

    // Getter methods
    public String getSymptoms() {
        return symptoms;
    }

    public String getCuringMethods() {
        return curingMethods;
    }

    public String getHealthImprovementMethods() {
        return healthImprovementMethods;
    }
}