package com.physics.calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selamat Datang di Kalkulator Gaya Gravitasi");
        System.out.println("=============================================");

        double mass1 = 0, mass2 = 0, distance = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Masukkan massa objek 1 (kg): ");
                mass1 = scanner.nextDouble();
                if (mass1 <= 0) {
                    System.out.println("Massa harus lebih besar dari nol. Silakan coba lagi.");
                } else {
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid. Harap masukkan angka. Silakan coba lagi.");
                scanner.next();
            }
        }

        validInput = false;
        while (!validInput) {
            try {
                System.out.print("Masukkan massa objek 2 (kg): ");
                mass2 = scanner.nextDouble();
                if (mass2 <= 0) {
                    System.out.println("Massa harus lebih besar dari nol. Silakan coba lagi.");
                } else {
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid. Harap masukkan angka. Silakan coba lagi.");
                scanner.next();
            }
        }

        validInput = false;
        while (!validInput) {
            try {
                System.out.print("Masukkan jarak antara dua objek (meter): ");
                distance = scanner.nextDouble();
                if (distance <= 0) {
                    System.out.println("Jarak harus lebih besar dari nol. Silakan coba lagi.");
                } else {
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid. Harap masukkan angka. Silakan coba lagi.");
                scanner.next();
            }
        }

        try {
            GravitationalForce calculator = new GravitationalForce(mass1, mass2, distance);
            double force = calculator.calculateForce();

            System.out.println("\n--- Hasil Perhitungan ---");
            System.out.println("Detail Objek:");
            System.out.println("- Massa Objek 1: " + calculator.getMass1() + " kg");
            System.out.println("- Massa Objek 2: " + calculator.getMass2() + " kg");
            System.out.println("- Jarak: " + calculator.getDistance() + " m");
            System.out.printf("Gaya Gravitasi antara dua objek adalah: %.2e N%n", force);

        } catch (IllegalArgumentException e) {
            System.out.println("\nError: " + e.getMessage());
        }

        scanner.close();
        System.out.println("\nTerima kasih telah menggunakan kalkulator ini!");
    }
} 