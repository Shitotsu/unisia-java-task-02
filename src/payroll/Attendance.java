package payroll;

public class Attendance {
    private final int hourIn;   // 1-24
    private final int hourOut;  // 1-24

    public Attendance(int hourIn, int hourOut) {
        this.hourIn = hourIn;
        this.hourOut = hourOut;
        validate();
    }

    private void validate() {
        if (hourIn < 1 || hourIn > 24 || hourOut < 1 || hourOut > 24) {
            throw new IllegalArgumentException("Jam harus 1-24.");
        }
        // Asumsi presensi dalam hari yang sama
        if (hourOut < hourIn) {
            throw new IllegalArgumentException("Jam keluar tidak boleh lebih kecil dari jam masuk (asumsi hari yang sama).");
        }
    }

    public int getHourIn() { return hourIn; }
    public int getHourOut() { return hourOut; }

    public int getLateHours() {
        return Math.max(0, hourIn - 7);
    }

    public int getEarlyLeaveHours() {
        return Math.max(0, 16 - hourOut);
    }

    public int getOvertimeHours() {
        return Math.max(0, hourOut - 16);
    }
}

