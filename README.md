# Payroll OOP Java (Presensi + Lembur)

Program ini menghitung **total gaji pegawai** berdasarkan:
- Jabatan (SPV / HRD / TKN / KRY)
- Presensi (jam masuk & jam keluar)
- Status menikah (tunjangan istri)
- Jumlah anak (tunjangan anak)
- Lembur (jam keluar > 16)
- Potongan telat (masuk > 7)
- Potongan pulang cepat (keluar < 16)

---

## 1) Struktur Folder Project

Pastikan file-file berikut ada di folder `src/payroll/`:

```
src
└── payroll
    ├── Attendance.java
    ├── Employee.java
    ├── HRD.java
    ├── Main.java
    ├── PayrollService.java
    ├── SalaryRule.java
    ├── Staff.java
    ├── Supervisor.java
    └── Technician.java
```

Semua class menggunakan deklarasi:
- `package payroll;`

---

## 2) Aturan Perhitungan

- Jam valid: **1–24**
- Jam kerja normal: **masuk 07, pulang 16**
- Lembur: jika pulang **> 16**, lembur = `(pulang - 16)`
- Potongan telat: jika masuk **> 7**, potong gaji pokok = `100000 × (masuk - 7)`
- Potongan pulang cepat: jika pulang **< 16**, potong gaji pokok = `100000 × (16 - pulang)`

Rumus total gaji:

```

(gajiPokok - potonganTelat - potonganPulangCepat)

* transport
* tunjanganIstri (jika menikah)
* tunjanganAnak
* (lemburJam × tarifLembur)

````

---

## 3) Cara Compile (Terminal)

### Opsi A — Compile pakai `javac`

Masuk ke folder project (yang berisi folder `src`), lalu jalankan:

**Windows (PowerShell / CMD):**
```bash
javac -d out src\payroll\*.java
````

**Linux / macOS:**

```bash
javac -d out src/payroll/*.java
```

Keterangan:

* `-d out` artinya hasil `.class` disimpan ke folder `out/`

---

## 4) Cara Menjalankan Program

Setelah compile sukses, jalankan:

**Windows / Linux / macOS:**

```bash
java -cp out payroll.Main
```

Program akan menampilkan beberapa contoh slip gaji (dummy data) yang sudah disiapkan di `Main.java`.

Contoh Output:

```md
$ java -cp out payroll.Main
=== SLIP GAJI ===
ID        : E001
Nama      : Andi
Jabatan   : SPV
Masuk     : 8
Keluar    : 18
-----------------
Gaji Pokok         : Rp10.000.000,00
Potongan Telat     : Rp100.000,00
Potongan Pulang Cep: Rp0,00
Gaji Pokok (net)   : Rp9.900.000,00
Transport          : Rp1.000.000,00
Tunjangan Istri    : Rp300.000,00
Tunjangan Anak     : Rp200.000,00
Lembur (2 jam)     : Rp20.000,00
-----------------
TOTAL              : Rp11.420.000,00

=== SLIP GAJI ===
ID        : E002
Nama      : Budi
Jabatan   : TKN
Masuk     : 7
Keluar    : 16
-----------------
Gaji Pokok         : Rp3.000.000,00
Potongan Telat     : Rp0,00
Potongan Pulang Cep: Rp0,00
Gaji Pokok (net)   : Rp3.000.000,00
Transport          : Rp500.000,00
Tunjangan Istri    : Rp0,00
Tunjangan Anak     : Rp0,00
Lembur (0 jam)     : Rp0,00
-----------------
TOTAL              : Rp3.500.000,00

=== SLIP GAJI ===
ID        : E003
Nama      : Citra
Jabatan   : KRY
Masuk     : 9
Keluar    : 15
-----------------
Gaji Pokok         : Rp1.500.000,00
Potongan Telat     : Rp200.000,00
Potongan Pulang Cep: Rp100.000,00
Gaji Pokok (net)   : Rp1.200.000,00
Transport          : Rp250.000,00
Tunjangan Istri    : Rp200.000,00
Tunjangan Anak     : Rp60.000,00
Lembur (0 jam)     : Rp0,00
-----------------
TOTAL              : Rp1.710.000,00

=== SLIP GAJI ===
ID        : E004
Nama      : Dewi
Jabatan   : HRD
Masuk     : 7
Keluar    : 17
-----------------
Gaji Pokok         : Rp5.000.000,00
Potongan Telat     : Rp0,00
Potongan Pulang Cep: Rp0,00
Gaji Pokok (net)   : Rp5.000.000,00
Transport          : Rp750.000.000,00
Tunjangan Istri    : Rp250.000,00
Tunjangan Anak     : Rp190.000,00
Lembur (1 jam)     : Rp7.500,00
-----------------
TOTAL              : Rp755.447.500,00

```

---

## 5) Cara Menggunakan Program (Mengubah Input)

Saat ini input masih berupa **data contoh** di `Main.java`, misalnya:

```java
Employee e1 = new Supervisor("E001", "Andi", true, 2);
Attendance a1 = new Attendance(8, 18);
service.printSlip(e1, a1);
```

### A) Mengubah jabatan

Gunakan salah satu class berikut:

* `new Supervisor(...)`  untuk kode **SPV**
* `new HRD(...)`         untuk kode **HRD**
* `new Technician(...)`  untuk kode **TKN**
* `new Staff(...)`       untuk kode **KRY**

### B) Mengubah presensi

Ubah jam masuk & keluar dengan:

```java
Attendance a = new Attendance(jamMasuk, jamKeluar);
```

Contoh:

* `new Attendance(7, 16)`  → normal
* `new Attendance(9, 17)`  → telat 2 jam + lembur 1 jam
* `new Attendance(7, 15)`  → pulang cepat 1 jam

### C) Mengubah status menikah & jumlah anak

Parameter constructor Employee:

* parameter ke-3: `true/false` (menikah atau tidak)
* parameter ke-4: jumlah anak (0, 1, 2, dst)

Contoh:

```java
Employee e = new Staff("E010", "Rina", false, 0);
```

### D) Jalankan ulang

Setelah mengubah `Main.java`, lakukan:

1. Compile ulang
2. Run ulang

---

## 6) Contoh Skenario

### Contoh 1 (SPV)

* Masuk 08 (telat 1 jam)
* Keluar 18 (lembur 2 jam)
* Menikah, anak 2

```java
Employee e = new Supervisor("E001", "Andi", true, 2);
Attendance a = new Attendance(8, 18);
service.printSlip(e, a);
```

### Contoh 2 (KRY)

* Masuk 07
* Keluar 15 (pulang cepat 1 jam)
* Tidak menikah, anak 0

```java
Employee e = new Staff("E010", "Rina", false, 0);
Attendance a = new Attendance(7, 15);
service.printSlip(e, a);
```

---

## 7) Catatan Validasi

* Program menganggap presensi dalam **hari yang sama**, jadi `jamKeluar >= jamMasuk`.
* Jika jam di luar 1–24 atau `jamKeluar < jamMasuk`, program akan error (`IllegalArgumentException`).

---

