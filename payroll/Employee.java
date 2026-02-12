package payroll;

public abstract class Employee implements SalaryRule {
    private final String id;
    private final String name;
    private final boolean married;
    private final int childCount;

    protected Employee(String id, String name, boolean married, int childCount) {
        if (childCount < 0) throw new IllegalArgumentException("Jumlah anak tidak boleh negatif.");
        this.id = id;
        this.name = name;
        this.married = married;
        this.childCount = childCount;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public boolean isMarried() { return married; }
    public int getChildCount() { return childCount; }

    public long calculateTotalSalary(Attendance attendance) {
        long baseAfterPenalty = getBaseSalary() - calcLatePenalty(attendance) - calcEarlyLeavePenalty(attendance);
        if (baseAfterPenalty < 0) baseAfterPenalty = 0;

        long overtimePay = calcOvertimePay(attendance);
        long wifeAllowance = married ? getWifeAllowance() : 0;
        long childAllowance = getChildAllowance(childCount);

        return baseAfterPenalty
                + getTransport()
                + overtimePay
                + wifeAllowance
                + childAllowance;
    }

    protected long calcLatePenalty(Attendance attendance) {
        return 100_000L * attendance.getLateHours();
    }

    protected long calcEarlyLeavePenalty(Attendance attendance) {
        return 100_000L * attendance.getEarlyLeaveHours();
    }

    protected long calcOvertimePay(Attendance attendance) {
        return getOvertimeRate() * attendance.getOvertimeHours();
    }
}

