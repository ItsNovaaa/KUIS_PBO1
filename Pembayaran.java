package KUIS_PBO1;

// Pembayaran.java
public class Pembayaran {
    private int id;
    private double jumlah;
    private String metode;

    public Pembayaran(int id, double jumlah, String metode) {
        this.id = id;
        this.jumlah = jumlah;
        this.metode = metode;
    }

    public void tampilInformasi() {
        System.out.println("--- Detail Pembayaran ---");
        System.out.println("ID Transaksi : " + this.id);
        System.out.println("Jumlah       : Rp" + this.jumlah);
        System.out.println("Metode       : " + this.metode);
        System.out.println("-------------------------");
    }
}