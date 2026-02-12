package payroll;

import java.text.NumberFormat;
import java.util.Locale;

public class PayrollService {
    private static final NumberFormat IDR = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));

    public void printSlip(Employee emp, Attendance att) {
        long latePenalty = 100_000L * att.getLateHours();
        long earlyPenalty = 100_000L * att.getEarlyLeaveHours();
        long overtimePay = emp.getOvertimeRate() * att.getOvertimeHours();
        long wifeAllowance = emp.isMarried() ? emp.getWifeAllowance() : 0;
        long childAllowance = emp.getChildAllowance(emp.getChildCount());

        long baseAfter = emp.getBaseSalary() - latePenalty - earlyPenalty;
        if (baseAfter < 0) baseAfter = 0;

        long total = emp.calculateTotalSalary(att);

        System.out.println("=== SLIP GAJI ===");
        System.out.println("ID        : " + emp.getId());
        System.out.println("Nama      : " + emp.getName());
        System.out.println("Jabatan   : " + emp.getRoleCode());
        System.out.println("Masuk     : " + att.getHourIn());
        System.out.println("Keluar    : " + att.getHourOut());
        System.out.println("-----------------");
        System.out.println("Gaji Pokok         : " + IDR.format(emp.getBaseSalary()));
        System.out.println("Potongan Telat     : " + IDR.format(latePenalty));
        System.out.println("Potongan Pulang Cep: " + IDR.format(earlyPenalty));
        System.out.println("Gaji Pokok (net)   : " + IDR.format(baseAfter));
        System.out.println("Transport          : " + IDR.format(emp.getTransport()));
        System.out.println("Tunjangan Istri    : " + IDR.format(wifeAllowance));
        System.out.println("Tunjangan Anak     : " + IDR.format(childAllowance));
        System.out.println("Lembur (" + att.getOvertimeHours() + " jam)     : " + IDR.format(overtimePay));
        System.out.println("-----------------");
        System.out.println("TOTAL              : " + IDR.format(total));
        System.out.println();
    }
}

