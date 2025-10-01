package KUIS_PBO1;

// Kursus.java
import java.util.ArrayList;

public class Kursus {
    private int id;
    private String judul;
    private String deskripsi;
    private ArrayList<Konten> daftarKonten;

    public Kursus(int id, String judul, String deskripsi) {
        this.id = id;
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.daftarKonten = new ArrayList<>();
    }

    public String getJudul() {
        return judul;
    }
    
    public void tambahKonten(Konten konten) {
        this.daftarKonten.add(konten);
    }
    
    public void tampilkanDetailKursus() {
        System.out.println("\n===== Detail Kursus =====");
        System.out.println("Judul     : " + this.judul);
        System.out.println("Deskripsi : " + this.deskripsi);
        System.out.println("Materi di dalam kursus:");
        for(Konten k : daftarKonten) {
            k.tampilInformasi();
        }
        System.out.println("=========================");
    }
}