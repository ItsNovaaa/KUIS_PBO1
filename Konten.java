package KUIS_PBO1;

public abstract class Konten {
    protected int id;
    protected String judul;

    public Konten(int id, String judul) {
        this.id = id;
        this.judul = judul;
    }

    public String getJudul() {
        return judul;
    }

    // Setiap jenis konten akan memiliki cara sendiri untuk menampilkan informasinya
    public abstract void tampilInformasi();
}