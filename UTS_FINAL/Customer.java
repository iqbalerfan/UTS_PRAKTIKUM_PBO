/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UTS_FINAL;

/**
 *
 * @author iqbal
 */
public class Customer implements User {
    private String nama;          // Nama customer
    private Reservasi reservasi; // Menyimpan reservasi yang dimiliki customer

    // Konstruktor
    public Customer(String nama) {
        this.nama = nama;
        this.reservasi = null; // Tidak ada reservasi pada awalnya
    }

    // Getter untuk nama customer
    public String getNama() {
        return nama;
    }

    // Metode untuk memesan kamar
    public void pesanKamar(Kamar kamar) {
        if (kamar.isTersedia()) {
            reservasi = new Reservasi(kamar, this); // Membuat objek reservasi baru
            kamar.setTersedia(false); // Mengupdate status kamar menjadi tidak tersedia
            System.out.println("Kamar berhasil dipesan.");
        } else {
            System.out.println("Kamar tidak tersedia.");
        }
    }

    // Metode untuk melihat reservasi
    public void lihatReservasi() {
        System.out.println("Reservasi yang dimiliki oleh " + nama + ":");
        if (reservasi == null) {
            System.out.println("Anda belum memiliki reservasi."); // Jika belum ada reservasi
        } else {
            System.out.println("Kamar Nomor: " + reservasi.getKamar().getNomorKamar() + " - Harga: Rp" + reservasi.getKamar().getHarga());
        }
    }

    // Metode untuk mengakses menu customer
    @Override
    public void aksesMenu() {
        System.out.println("Menu untuk Customer:");
        System.out.println("1. Lihat Reservasi");
        System.out.println("2. Pesan Kamar");
        System.out.println("0. Keluar");
    }
}