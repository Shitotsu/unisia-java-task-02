package payroll;

public class Staff extends Employee {
    public Staff(String id, String name, boolean married, int childCount) {
        super(id, name, married, childCount);
    }

    @Override public String getRoleCode() { return "KRY"; }
    @Override public long getBaseSalary() { return 1_500_000L; }
    @Override public long getTransport() { return 250_000L; }
    @Override public long getOvertimeRate() { return 5_000L; }
    @Override public long getWifeAllowance() { return 200_000L; }

    @Override
    public long getChildAllowance(int childCount) {
        if (childCount <= 0) return 0;
        if (childCount == 1) return 60_000L;
        return 130_000L;
    }
}

