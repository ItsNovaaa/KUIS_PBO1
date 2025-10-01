package KUIS_PBO1;

// Artikel.java
// Artikel.java
public class Artikel extends Konten {
    private String teks;

    public Artikel(int id, String judul, String teks) {
        super(id, judul);
        this.teks = teks;
    }

    @Override
    public void tampilInformasi() {
        System.out.println(" Konten Artikel: " + super.getJudul());
        System.out.println("   Isi         : \"" + this.teks.substring(0, 30) + "...\"");
    }
}