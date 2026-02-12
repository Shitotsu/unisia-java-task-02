package payroll;

public class Technician extends Employee {
    public Technician(String id, String name, boolean married, int childCount) {
        super(id, name, married, childCount);
    }

    @Override public String getRoleCode() { return "TKN"; }
    @Override public long getBaseSalary() { return 3_000_000L; }
    @Override public long getTransport() { return 500_000L; }
    @Override public long getOvertimeRate() { return 5_000L; }
    @Override public long getWifeAllowance() { return 200_000L; }

    @Override
    public long getChildAllowance(int childCount) {
        if (childCount <= 0) return 0;
        if (childCount == 1) return 75_000L;
        return 150_000L;
    }
}

