package KUIS_PBO1;

// Video.java
// Video.java
public class Video extends Konten {
    private String url; // 'teks' di UML saya interpretasikan sebagai URL

    public Video(int id, String judul, String url) {
        super(id, judul);
        this.url = url;
    }

    @Override
    public void tampilInformasi() {
        System.out.println(" Konten Video: " + super.getJudul());
        System.out.println("   Tonton di : " + this.url);
    }
}