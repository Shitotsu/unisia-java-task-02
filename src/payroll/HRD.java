package payroll;

public class HRD extends Employee {
    public HRD(String id, String name, boolean married, int childCount) {
        super(id, name, married, childCount);
    }

    @Override public String getRoleCode() { return "HRD"; }
    @Override public long getBaseSalary() { return 5_000_000L; }

    // Sesuai soal: 750.000.000 (kalau typo, tinggal ubah jadi 750_000)
    @Override public long getTransport() { return 750_000_000L; }

    @Override public long getOvertimeRate() { return 7_500L; }
    @Override public long getWifeAllowance() { return 250_000L; }

    @Override
    public long getChildAllowance(int childCount) {
        if (childCount <= 0) return 0;
        if (childCount == 1) return 90_000L;
        return 190_000L;
    }
}

