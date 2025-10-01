// File: KUIS_PBO1/Instruktur.java
package KUIS_PBO1;

// Instruktur.java
public class Instruktur extends User {
    private String spesialisasi;

    public Instruktur(int id, String nama, String email, String password, String spesialisasi) {
        super(id, nama, email, password);
        this.spesialisasi = spesialisasi;
    }

    public void buatKursus(String judul, String deskripsi) {
        // Logika untuk membuat kursus baru dan menyimpannya di database
        System.out.println("Instruktur " + this.nama + " berhasil membuat kursus baru: '" + judul + "'.");
    }

    @Override
    public void tampilkanProfil() {
        System.out.println("--- Profil Instruktur ---");
        System.out.println("ID     : " + id);
        System.out.println("Nama   : " + nama);
        System.out.println("Email  : " + email);
        System.out.println("Spesialisasi : " + spesialisasi);
        System.out.println("-------------------------");
    }
}