import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Patient class with added prescriptions and medical records
class Patient {
    int id;
    String name;
    String email;
    String phone;
    List<String> healthConditions;
    List<String> prescriptions; // Added prescriptions
    List<String> medicalRecords; // Added medical records

    public Patient(int id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.healthConditions = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
        this.medicalRecords = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Email: " + email + ", Phone: " + phone;
    }

    public void addHealthCondition(String condition) {
        this.healthConditions.add(condition);
    }

    public void addPrescription(String prescription) {
        this.prescriptions.add(prescription);
    }

    public List<String> getHealthConditions() {
        return healthConditions;
    }

    public List<String> getPrescriptions() {
        return prescriptions;
    }

    public List<String> getMedicalRecords() {
        return medicalRecords;
    }

    public void addMedicalRecord(String record) {
        this.medicalRecords.add(record);
    }
}

// Appointment class with consultation link for video/audio consultation
class Appointment {
    int id;
    int patientId;
    String date;
    String time;
    String consultationLink;

    public Appointment(int id, int patientId, String date, String time) {
        this.id = id;
        this.patientId = patientId;
        this.date = date;
        this.time = time;
        this.consultationLink = "https://video.consultation.link/" + id; // Simulated video/audio link
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Patient ID: " + patientId + ", Date: " + date + ", Time: " + time + ", Link: " + consultationLink;
    }
}

// Remote Monitoring class to simulate vital stats tracking
class RemoteMonitoring {
    public void monitorVitals(Patient patient) {
        // Simulate vital stats (e.g., heart rate, blood pressure)
        double heartRate = 75 + Math.random() * 20;
        double bloodPressure = 120 + Math.random() * 20;

        System.out.println("Monitoring vitals for patient: " + patient.name);
        System.out.println("Heart Rate: " + heartRate + " bpm");
        System.out.println("Blood Pressure: " + bloodPressure + " mmHg");
    }
}

// AI Health Analytics class for personalized insights
class AIHealthAnalytics {
    public void analyzeHealthData(Patient patient) {
        System.out.println("Analyzing health data for patient: " + patient.name);
        // Provide health insights based on conditions and trends
        if (patient.getHealthConditions().contains("Hypertension")) {
            System.out.println("AI Insight: The patient has Hypertension. Regular monitoring of blood pressure is recommended.");
        }
    }
}

// E-prescription system for generating prescriptions
class EPrescriptionSystem {
    public void issueEPrescription(Patient patient, String medicine, String instructions) {
        String prescription = "Medicine: " + medicine + ", Instructions: " + instructions;
        patient.addPrescription(prescription);
        System.out.println("E-Prescription issued: " + prescription);
    }
}

// Chatbot class to assist patients
class Chatbot {
    public void assistPatient(Patient patient) {
        System.out.println("Chatbot: How can I assist you today, " + patient.name + "?");
        // Retrieve previous health records (simulated)
        System.out.println("Chatbot: Here are your previous diagnoses: " + String.join(", ", patient.getHealthConditions()));
    }
}

public class TelehealthProgram11{
    private static List<Patient> patients = new ArrayList<>();
    private static List<Appointment> appointments = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Telehealth Program Menu:");
            System.out.println("1. Register Patient");
            System.out.println("2. Schedule Appointment");
            System.out.println("3. View Appointments");
            System.out.println("4. AI Health Analytics");
            System.out.println("5. Video/Audio Consultation");
            System.out.println("6. Remote Patient Monitoring");
            System.out.println("7. E-Prescriptions");
            System.out.println("8. Chatbot Assistance");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    registerPatient();
                    break;
                case 2:
                    scheduleAppointment();
                    break;
                case 3:
                    viewAppointments();
                    break;
                case 4:
                    aiHealthAnalytics();
                    break;
                case 5:
                    videoAudioConsultation();
                    break;
                case 6:
                    remotePatientMonitoring();
                    break;
                case 7:
                    ePrescriptions();
                    break;
                case 8:
                    chatbotAssistance();
                    break;
                case 9:
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void registerPatient() {
        System.out.print("Enter patient name: ");
        String name = scanner.nextLine();
        String email;

        // Email validation loop
        while (true) {
            System.out.print("Enter patient email: ");
            email = scanner.nextLine();
            if (isValidEmail(email)) {
                break;
            } else {
                System.out.println("Invalid email format. Please enter a valid email.");
            }
        }

        System.out.print("Enter patient phone: ");
        String phone = scanner.nextLine();

        int id = patients.size() + 1;
        Patient patient = new Patient(id, name, email, phone);
        patients.add(patient);
        System.out.println("Patient registered: " + patient);

        // Optionally, add health conditions during registration
        System.out.print("Would you like to add health conditions? (y/n): ");
        String response = scanner.nextLine();
        if (response.equalsIgnoreCase("y")) {
            while (true) {
                System.out.print("Enter health condition (or 'done' to finish): ");
                String condition = scanner.nextLine();
                if (condition.equalsIgnoreCase("done")) {
                    break;
                }
                patient.addHealthCondition(condition);
            }
        }
    }

    private static void scheduleAppointment() {
        System.out.print("Enter patient ID: ");
        int patientId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter appointment date (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        System.out.print("Enter appointment time (HH:MM): ");
        String time = scanner.nextLine();

        int id = appointments.size() + 1;
        Appointment appointment = new Appointment(id, patientId, date, time);
        appointments.add(appointment);
        System.out.println("Appointment scheduled: " + appointment);
    }

    private static void viewAppointments() {
        System.out.println("Appointments:");
        for (Appointment appointment : appointments) {
            System.out.println(appointment);
        }
    }

    private static void aiHealthAnalytics() {
        System.out.print("Enter patient ID to analyze health data: ");
        int patientId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Patient patient = findPatientById(patientId);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        System.out.println("Patient Health Conditions: " + patient.getHealthConditions());
        AIHealthAnalytics ai = new AIHealthAnalytics();
        ai.analyzeHealthData(patient);
    }

    private static void videoAudioConsultation() {
        System.out.print("Enter appointment ID to access consultation link: ");
        int appointmentId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Appointment appointment = findAppointmentById(appointmentId);
        if (appointment == null) {
            System.out.println("Appointment not found.");
            return;
        }

        System.out.println("Access your consultation here: " + appointment.consultationLink);
    }

    private static void remotePatientMonitoring() {
        System.out.print("Enter patient ID for remote monitoring: ");
        int patientId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Patient patient = findPatientById(patientId);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        RemoteMonitoring monitor = new RemoteMonitoring();
        monitor.monitorVitals(patient);
    }

    private static void ePrescriptions() {
        System.out.print("Enter patient ID for e-prescription: ");
        int patientId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Patient patient = findPatientById(patientId);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        System.out.print("Enter prescription medicine: ");
        String medicine = scanner.nextLine();
        System.out.print("Enter instructions: ");
        String instructions = scanner.nextLine();

        EPrescriptionSystem prescriptionSystem = new EPrescriptionSystem();
        prescriptionSystem.issueEPrescription(patient, medicine, instructions);
    }

    private static void chatbotAssistance() {
        System.out.print("Enter patient ID for chatbot assistance: ");
        int patientId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Patient patient = findPatientById(patientId);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        Chatbot chatbot = new Chatbot();
        chatbot.assistPatient(patient);
    }

    private static Patient findPatientById(int id) {
        for (Patient patient : patients) {
            if (patient.id == id) {
                return patient;
            }
        }
        return null;
    }

    private static Appointment findAppointmentById(int id) {
        for (Appointment appointment : appointments) {
            if (appointment.id == id) {
                return appointment;
            }
        }
        return null;
    }

    // Email validation method using regular expression
    private static boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
