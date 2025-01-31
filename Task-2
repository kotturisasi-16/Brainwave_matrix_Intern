import java.util.*;

class Patient {
    private String patientName;
    private int patientId;
    private int age;
    private String disease;

    public Patient(int patientId, String patientName, int age, String disease) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.age = age;
        this.disease = disease;
    }

    public void displayPatientInfo() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Patient Name: " + patientName);
        System.out.println("Age: " + age);
        System.out.println("Disease: " + disease);
    }

    public int getPatientId() {
        return patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getDisease() {
        return disease;
    }
}

class Doctor {
    private String doctorName;
    private int doctorId;
    private String specialization;

    public Doctor(int doctorId, String doctorName, String specialization) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.specialization = specialization;
    }

    public void displayDoctorInfo() {
        System.out.println("Doctor ID: " + doctorId);
        System.out.println("Doctor Name: " + doctorName);
        System.out.println("Specialization: " + specialization);
    }

    public int getDoctorId() {
        return doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getSpecialization() {
        return specialization;
    }
}

class Appointment {
    private Patient patient;
    private Doctor doctor;
    private String appointmentDate;

    public Appointment(Patient patient, Doctor doctor, String appointmentDate) {
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentDate = appointmentDate;
    }

    public void displayAppointmentInfo() {
        System.out.println("Patient Name: " + patient.getPatientName());
        System.out.println("Disease: " + patient.getDisease());
        System.out.println("Doctor Name: " + doctor.getDoctorName());
        System.out.println("Specialization: " + doctor.getSpecialization());
        System.out.println("Appointment Date: " + appointmentDate);
    }
}

class Hospital {
    private ArrayList<Patient> patients;
    private ArrayList<Doctor> doctors;
    private ArrayList<Appointment> appointments;

    public Hospital() {
        patients = new ArrayList<>();
        doctors = new ArrayList<>();
        appointments = new ArrayList<>();
    }

    public void addPatient(Patient patient) {
        for (Patient p : patients) {
            if (p.getPatientId() == patient.getPatientId()) {
                System.out.println("Error: Patient ID already exists!\n");
                return;
            }
        }
        patients.add(patient);
        System.out.println("Patient added successfully!\n");
    }

    public void addDoctor(Doctor doctor) {
        for (Doctor d : doctors) {
            if (d.getDoctorId() == doctor.getDoctorId()) {
                System.out.println("Error: Doctor ID already exists!\n");
                return;
            }
        }
        doctors.add(doctor);
        System.out.println("Doctor added successfully!\n");
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
        System.out.println("Appointment added successfully!\n");
    }

    public void displayAllPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients found!\n");
            return;
        }
        System.out.println("Patient List:");
        for (Patient patient : patients) {
            patient.displayPatientInfo();
            System.out.println("-------------------------");
        }
    }

    public void displayAllDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors found!\n");
            return;
        }
        System.out.println("Doctor List:");
        for (Doctor doctor : doctors) {
            doctor.displayDoctorInfo();
            System.out.println("-------------------------");
        }
    }

    public void displayAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments found!\n");
            return;
        }
        System.out.println("Appointments List:");
        for (Appointment appointment : appointments) {
            appointment.displayAppointmentInfo();
            System.out.println("-------------------------");
        }
    }

    public Patient getPatientById(int id) {
        for (Patient patient : patients) {
            if (patient.getPatientId() == id) {
                return patient;
            }
        }
        return null;
    }

    public Doctor getDoctorById(int id) {
        for (Doctor doctor : doctors) {
            if (doctor.getDoctorId() == id) {
                return doctor;
            }
        }
        return null;
    }
}

public class Hospital_management {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hospital hospital = new Hospital();

        while (true) {
            System.out.println("\n=== Hospital Management System ===");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Add Appointment");
            System.out.println("4. View All Patients");
            System.out.println("5. View All Doctors");
            System.out.println("6. View Appointments");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Patient ID: ");
                    int patientId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Patient Name: ");
                    String patientName = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Disease: ");
                    String disease = scanner.nextLine();

                    if (patientName.isEmpty() || disease.isEmpty() || age <= 0) {
                        System.out.println("Error: Invalid input. Please try again.");
                        break;
                    }

                    hospital.addPatient(new Patient(patientId, patientName, age, disease));
                    break;

                case 2:
                    System.out.print("Enter Doctor ID: ");
                    int doctorId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Doctor Name: ");
                    String doctorName = scanner.nextLine();
                    System.out.print("Enter Specialization: ");
                    String specialization = scanner.nextLine();

                    if (doctorName.isEmpty() || specialization.isEmpty()) {
                        System.out.println("Error: Invalid input. Please try again.");
                        break;
                    }

                    hospital.addDoctor(new Doctor(doctorId, doctorName, specialization));
                    break;

                case 3:
                    System.out.print("Enter Patient ID: ");
                    int pId = scanner.nextInt();
                    System.out.print("Enter Doctor ID: ");
                    int dId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Appointment Date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();

                    Patient patient = hospital.getPatientById(pId);
                    Doctor doctor = hospital.getDoctorById(dId);

                    if (patient == null || doctor == null || date.isEmpty()) {
                        System.out.println("Error: Invalid input or IDs not found.");
                        break;
                    }

                    hospital.addAppointment(new Appointment(patient, doctor, date));
                    break;

                case 4:
                    hospital.displayAllPatients();
                    break;

                case 5:
                    hospital.displayAllDoctors();
                    break;

                case 6:
                    hospital.displayAppointments();
                    break;

                case 7:
                    System.out.println("Exiting... Thank you!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
