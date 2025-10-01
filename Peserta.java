// File: KUIS_PBO1/Peserta.java
package KUIS_PBO1;

// Peserta.java
import java.util.ArrayList;

public class Peserta extends User {
    private String status;
    private ArrayList<Kursus> kursusTerdaftar;

    public Peserta(int id, String nama, String email, String password, String status) {
        super(id, nama, email, password);
        this.status = status;
        this.kursusTerdaftar = new ArrayList<>();
    }
    
    // Method untuk mendaftar ke sebuah kursus
    public void daftarKursus(Kursus k, Pembayaran p) {
        this.kursusTerdaftar.add(k);
        System.out.println("✅ Pendaftaran berhasil!");
        System.out.println("Peserta '" + this.nama + "' telah terdaftar di kursus '" + k.getJudul() + "'.");
        p.tampilInformasi();
    }
    
    @Override
    public void tampilkanProfil() {
        System.out.println("--- Profil Peserta ---");
        System.out.println("ID     : " + id);
        System.out.println("Nama   : " + nama);
        System.out.println("Email  : " + email);
        System.out.println("Status : " + status);
        System.out.println("----------------------");
    }
}