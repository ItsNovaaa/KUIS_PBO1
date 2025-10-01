package KUIS_PBO1;



public class Kuis extends Konten {
    private String[] soal;

    public Kuis(int id, String judul, String[] soal) {
        super(id, judul);
        this.soal = soal;
    }

    @Override
    public void tampilInformasi() {
        System.out.println(" Konten Kuis: " + super.getJudul());
        System.out.println("   Jumlah Soal: " + this.soal.length);
        System.out.println("   Soal 1     : " + this.soal[0]);
    }
}