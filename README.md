# Proyek Kalkulator Fisika: Gaya Gravitasi

Proyek ini adalah aplikasi Java sederhana berbasis konsol (OOP) yang menghitung gaya gravitasi antara dua objek berdasarkan hukum gravitasi universal Newton.

## Fitur
- Menghitung gaya gravitasi antara dua massa.
- Meminta input pengguna untuk massa kedua objek (dalam kilogram) dan jarak di antara keduanya (dalam meter).
- Validasi input untuk memastikan nilai massa dan jarak positif.
- Menampilkan hasil perhitungan gaya gravitasi dalam Newton (N) dengan notasi ilmiah.

## Struktur Proyek

```
project/
├── src/
│   └── com/
│       └── physics/
│           └── calculator/
│               ├── GravitationalForce.java  // Kelas untuk logika perhitungan gaya gravitasi
│               └── Main.java                // Kelas utama untuk interaksi pengguna dan menjalankan aplikasi
├── .gitignore
└── README.md
```

## Prasyarat
- Java Development Kit (JDK) versi 8 atau lebih tinggi.

## Cara Kompilasi dan Menjalankan

1.  **Kompilasi:**
    Buka terminal atau command prompt, navigasikan ke direktori `project/src`.
    Kemudian, kompilasi file Java:
    ```bash
    javac com/physics/calculator/GravitationalForce.java com/physics/calculator/Main.java
    ```
    Atau jika Anda berada di direktori `project`:
    ```bash
    javac src/com/physics/calculator/GravitationalForce.java src/com/physics/calculator/Main.java
    ```

2.  **Menjalankan:**
    Setelah kompilasi berhasil, jalankan kelas `Main` dari direktori `project/src`:
    ```bash
    java com.physics.calculator.Main
    ```
    Aplikasi akan meminta Anda untuk memasukkan nilai massa dan jarak.

    Contoh Interaksi:
    ```
    Selamat Datang di Kalkulator Gaya Gravitasi
    =============================================
    Masukkan massa objek 1 (kg): 5.972e24
    Masukkan massa objek 2 (kg): 7.348e22
    Masukkan jarak antara dua objek (meter): 3.844e8

    --- Hasil Perhitungan ---
    Detail Objek:
    - Massa Objek 1: 5.972E24 kg
    - Massa Objek 2: 7.348E22 kg
    - Jarak: 3.844E8 m
    Gaya Gravitasi antara dua objek adalah: 1.98e+20 N

    Terima kasih telah menggunakan kalkulator ini!
    ```

## Penilaian

Proyek ini dibuat untuk memenuhi kriteria tugas sebagai berikut:
- **Kreativitas dan orisinalitas:** Implementasi kalkulator gaya gravitasi dengan struktur OOP.
- **Kerapian dan struktur kode (OOP):** Kode diorganisir dalam kelas `GravitationalForce` (untuk logika inti) dan `Main` (untuk interaksi pengguna), mencerminkan prinsip enkapsulasi dan pemisahan tanggung jawab.
- **Fungsi program berjalan baik:** Termasuk validasi input dasar untuk mencegah error saat runtime dan memastikan perhitungan yang benar berdasarkan rumus yang diberikan.

## Catatan
- Proyek ini adalah contoh dasar. Anda dapat mengembangkannya lebih lanjut dengan menambahkan fitur lain seperti:
    - Kalkulator untuk rumus fisika lainnya.
    - Menu untuk memilih jenis perhitungan.
    - Penanganan error yang lebih canggih.
    - Jika menggunakan JavaFX, antarmuka pengguna grafis (GUI). # physics-project-java
