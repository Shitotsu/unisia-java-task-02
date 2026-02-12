package payroll;

public interface SalaryRule {
    String getRoleCode();
    long getBaseSalary();
    long getTransport();
    long getOvertimeRate();
    long getWifeAllowance();
    long getChildAllowance(int childCount);
}

