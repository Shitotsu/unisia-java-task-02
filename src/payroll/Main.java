package payroll;

public class Main {
    public static void main(String[] args) {
        PayrollService service = new PayrollService();

        // Polimorfisme: tipe Employee, objeknya bisa beda-beda
        Employee e1 = new Supervisor("E001", "Andi", true, 2);
        Employee e2 = new Technician("E002", "Budi", false, 0);
        Employee e3 = new Staff("E003", "Citra", true, 1);
        Employee e4 = new HRD("E004", "Dewi", true, 3);

        // Presensi
        Attendance a1 = new Attendance(8, 18); // telat 1 jam, lembur 2 jam
        Attendance a2 = new Attendance(7, 16); // normal
        Attendance a3 = new Attendance(9, 15); // telat 2 jam, pulang cepat 1 jam
        Attendance a4 = new Attendance(7, 17); // lembur 1 jam

        service.printSlip(e1, a1);
        service.printSlip(e2, a2);
        service.printSlip(e3, a3);
        service.printSlip(e4, a4);
    }
}

