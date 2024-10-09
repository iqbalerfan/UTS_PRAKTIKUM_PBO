/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UTS_FINAL;

/**
 *
 * @author iqbal
 */
import java.util.ArrayList;
import java.util.List;

public class Admin implements User {
    private String nama;
    private Kamar kamar1;
    private Kamar kamar2;
    private Kamar kamar3;
    private List<Customer> customers; // Menyimpan daftar customer yang melakukan reservasi

    public Admin(String nama, Kamar kamar1, Kamar kamar2, Kamar kamar3) {
        this.nama = nama;
        this.kamar1 = kamar1;
        this.kamar2 = kamar2;
        this.kamar3 = kamar3;
        this.customers = new ArrayList<>(); // Inisialisasi daftar customer
    }

    public String getNama() {
        return nama;
    }

    public void cekKetersediaan() {
        System.out.println("Ketersediaan Kamar:");
        System.out.println("Kamar Nomor: " + kamar1.getNomorKamar() + " - " + (kamar1.isTersedia() ? "Tersedia" : "Tidak Tersedia"));
        System.out.println("Kamar Nomor: " + kamar2.getNomorKamar() + " - " + (kamar2.isTersedia() ? "Tersedia" : "Tidak Tersedia"));
        System.out.println("Kamar Nomor: " + kamar3.getNomorKamar() + " - " + (kamar3.isTersedia() ? "Tersedia" : "Tidak Tersedia"));
    }

    public void pesanKamar(Customer customer, Kamar kamar) {
        if (kamar.isTersedia()) {
            customer.pesanKamar(kamar);
            kamar.setTersedia(false); // Update status kamar
            System.out.println("Kamar berhasil dipesan untuk " + customer.getNama());
            if (!customers.contains(customer)) { // Tambahkan customer ke daftar jika belum ada
                customers.add(customer);
            }
        } else {
            System.out.println("Kamar tidak tersedia.");
        }
    }

    public void lihatReservasiCustomer() {
        System.out.println("Reservasi Customer:");
        for (Customer customer : customers) {
            customer.lihatReservasi(); // Tampilkan reservasi untuk setiap customer
        }
    }

    @Override
    public void aksesMenu() {
        System.out.println("Menu untuk Admin:");
        System.out.println("1. Cek Ketersediaan Kamar");
        System.out.println("2. Pesan Kamar untuk Customer");
        System.out.println("3. Lihat Reservasi Customer");
        System.out.println("0. Keluar");
    }
}