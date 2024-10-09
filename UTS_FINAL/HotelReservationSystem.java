/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package UTS_FINAL;

/**
 *
 * @author iqbal
 */
import java.util.Scanner;

public class HotelReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inisialisasi kamar
        Kamar kamar1 = new Kamar(101, 500000.0);
        Kamar kamar2 = new Kamar(102, 750000.0);
        Kamar kamar3 = new Kamar(103, 1000000.0);

        System.out.println("Selamat datang di Sistem Reservasi Hotel!");
        System.out.print("Masukkan nama Anda: ");
        String nama = scanner.nextLine();

        System.out.print("Masuk sebagai (1. Admin, 2. Customer): ");
        int pilihan = scanner.nextInt();
        scanner.nextLine(); 

        if (pilihan == 1) {
            // Menu untuk Admin
            Admin admin = new Admin(nama, kamar1, kamar2, kamar3);
            int menuAdmin;
            do {
                admin.aksesMenu();
                System.out.print("Pilih menu (0 untuk keluar): ");
                menuAdmin = scanner.nextInt();
                scanner.nextLine(); 

                switch (menuAdmin) {
                    case 1:
                        admin.cekKetersediaan();
                        break;
                    case 2:
                        // Pesan kamar untuk customer
                        System.out.print("Masukkan nama customer: ");
                        String customerNama = scanner.nextLine();
                        Customer customer = new Customer(customerNama);
                        System.out.println("Pilih kamar yang ingin dipesan untuk " + customer.getNama() + ":");
                        admin.cekKetersediaan(); // Menampilkan ketersediaan kamar
                        System.out.print("Masukkan nomor kamar yang ingin dipesan: ");
                        int nomorKamar = scanner.nextInt();
                        scanner.nextLine(); 

                        if (nomorKamar == 101) {
                            admin.pesanKamar(customer, kamar1);
                        } else if (nomorKamar == 102) {
                            admin.pesanKamar(customer, kamar2);
                        } else if (nomorKamar == 103) {
                            admin.pesanKamar(customer, kamar3);
                        } else {
                            System.out.println("Nomor kamar tidak valid.");
                        }
                        break;
                    case 3:
                        // Melihat reservasi customer
                        admin.lihatReservasiCustomer();
                        break;
                    case 0:
                        System.out.println("Keluar dari sistem.");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            } while (menuAdmin != 0);

        } else if (pilihan == 2) {
            // Menu untuk Customer
            Customer customer = new Customer(nama);
            int menuCustomer;
            do {
                customer.aksesMenu();
                System.out.print("Pilih menu (0 untuk keluar): ");
                menuCustomer = scanner.nextInt();
                scanner.nextLine(); 

                switch (menuCustomer) {
                    case 1:
                        customer.lihatReservasi(); // Lihat reservasi customer
                        break;
                    case 2:
                        // Pesan kamar
                        System.out.println("Pilih kamar yang ingin dipesan:");
                        System.out.println("Kamar Nomor: " + kamar1.getNomorKamar() + " - Harga: Rp" + kamar1.getHarga());
                        System.out.println("Kamar Nomor: " + kamar2.getNomorKamar() + " - Harga: Rp" + kamar2.getHarga());
                        System.out.println("Kamar Nomor: " + kamar3.getNomorKamar() + " - Harga: Rp" + kamar3.getHarga());
                        System.out.print("Masukkan nomor kamar yang ingin dipesan: ");
                        int nomorKamarCustomer = scanner.nextInt();
                        scanner.nextLine(); 

                        if (nomorKamarCustomer == 101) {
                            customer.pesanKamar(kamar1);
                        } else if (nomorKamarCustomer == 102) {
                            customer.pesanKamar(kamar2);
                        } else if (nomorKamarCustomer == 103) {
                            customer.pesanKamar(kamar3);
                        } else {
                            System.out.println("Nomor kamar tidak valid.");
                        }
                        break;
                    case 0:
                        System.out.println("Keluar dari sistem.");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            } while (menuCustomer != 0);

        } else {
            System.out.println("Pilihan tidak valid.");
        }

        scanner.close();
    }
}