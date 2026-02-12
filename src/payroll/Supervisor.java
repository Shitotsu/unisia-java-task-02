package payroll;

public class Supervisor extends Employee {
    public Supervisor(String id, String name, boolean married, int childCount) {
        super(id, name, married, childCount);
    }

    @Override public String getRoleCode() { return "SPV"; }
    @Override public long getBaseSalary() { return 10_000_000L; }
    @Override public long getTransport() { return 1_000_000L; }
    @Override public long getOvertimeRate() { return 10_000L; }
    @Override public long getWifeAllowance() { return 300_000L; }

    @Override
    public long getChildAllowance(int childCount) {
        if (childCount <= 0) return 0;
        if (childCount == 1) return 100_000L;
        return 200_000L;
    }
}

