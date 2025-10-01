package KUIS_PBO1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    // Database untuk menyimpan user, kursus, dan pembayaran
    private static ArrayList<User> userDatabase = new ArrayList<>();
    private static ArrayList<Kursus> kursusDatabase = new ArrayList<>();
    private static ArrayList<Pembayaran> pembayaranDatabase = new ArrayList<>(); // Ditambahkan
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    // Blok statis untuk mengisi data dummy
    static {
        // Data Instruktur dan Peserta
        Instruktur instrukturDummy = new Instruktur(101, "Budi Santoso", "budi@email.com", "pass123", "Java Programming");
        userDatabase.add(instrukturDummy);
        userDatabase.add(new Peserta(201, "Ani Lestari", "ani@email.com", "pass456", "Mahasiswa"));
        
        // Data Kursus Dummy agar bisa langsung dipilih oleh peserta
        Kursus kursusDummy = new Kursus(501, "Dasar-Dasar Java", "Pelajari fundamental Java dari nol.");
        kursusDummy.tambahKonten(new Artikel(1, "Instalasi JDK", "Langkah-langkah untuk menginstal Java Development Kit..."));
        kursusDummy.tambahKonten(new Video(2, "Hello World!", "https://youtu.be/12345"));
        kursusDatabase.add(kursusDummy);

        System.out.println("->> Data dummy berhasil dimuat (1 Instruktur, 1 Peserta, 1 Kursus).");
    }

    public static void main(String[] args) {
        // ... (Bagian main, registerFunction, dan loginFunction tetap sama) ...
        while (true) {
            System.out.println("\n===== APLIKASI KURSUS ONLINE =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Keluar");
            System.out.print("Pilihan Anda: ");

            int pilihan = -1;
            try {
                pilihan = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka!");
                continue;
            }

            switch (pilihan) {
                case 1:
                    registerFunction();
                    break;
                case 2:
                    loginFunction();
                    break;
                case 3:
                    System.out.println("Terima kasih! Sampai jumpa lagi.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    public static void registerFunction() {
        // ... (Tidak ada perubahan di sini) ...
        System.out.println("\n--- Halaman Registrasi ---");
        System.out.println("1. Daftar sebagai Peserta");
        System.out.println("2. Daftar sebagai Instruktur");
        System.out.print("Pilih peran: ");
        int peran = Integer.parseInt(scanner.nextLine());

        System.out.print("Masukkan Nama Lengkap: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Email: ");
        String email = scanner.nextLine();

        for (User user : userDatabase) {
            if (user.email().equalsIgnoreCase(email)) {
                System.out.println("\n[GAGAL] Email '" + email + "' sudah terdaftar.");
                return;
            }
        }

        System.out.print("Masukkan Password: ");
        String password = scanner.nextLine();
        int id = 1000 + random.nextInt(9000);

        User newUser = null;
        if (peran == 1) {
            System.out.print("Masukkan Status Anda (e.g., Mahasiswa, Umum): ");
            String status = scanner.nextLine();
            newUser = new Peserta(id, nama, email, password, status);
        } else if (peran == 2) {
            System.out.print("Masukkan Spesialisasi Anda (e.g., Java, Python): ");
            String spesialisasi = scanner.nextLine();
            newUser = new Instruktur(id, nama, email, password, spesialisasi);
        } else {
            System.out.println("Pilihan peran tidak valid.");
            return;
        }

        userDatabase.add(newUser);
        System.out.println("\n[BERHASIL] Registrasi berhasil!");
        newUser.tampilkanProfil();
    }

    public static void loginFunction() {
        // ... (Tidak ada perubahan di sini) ...
        System.out.println("\n--- Halaman Login ---");
        System.out.print("Email: ");
        String emailLogin = scanner.nextLine();
        System.out.print("Password: ");
        String passwordLogin = scanner.nextLine();

        User loggedInUser = null;
        for (User user : userDatabase) {
            if (user.email().equalsIgnoreCase(emailLogin) && user.checkPassword(passwordLogin)) {
                loggedInUser = user;
                break;
            }
        }

        if (loggedInUser != null) {
            System.out.println("\n[BERHASIL] Login sukses! Selamat datang, " + loggedInUser.getNama() + ".");
            if (loggedInUser instanceof Peserta) {
                showPesertaMenu((Peserta) loggedInUser);
            } else if (loggedInUser instanceof Instruktur) {
                showInstrukturMenu((Instruktur) loggedInUser);
            }
        } else {
            System.out.println("\n[GAGAL] Login gagal! Email atau password salah.");
        }
    }

    // Metode showInstrukturMenu tetap sama
    public static void showInstrukturMenu(Instruktur instruktur) {
        // ... (Tidak ada perubahan di sini) ...
        while (true) {
            System.out.println("\n-- Menu Instruktur --");
            System.out.println("1. Buat Kursus Baru");
            System.out.println("2. Lihat Profil Saya");
            System.out.println("3. Logout");
            System.out.print("Pilihan Anda: ");

            int pilihan = -1;
            try {
                pilihan = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid!");
                continue;
            }

            switch (pilihan) {
                case 1:
                    buatKursusBaru(instruktur);
                    break;
                case 2:
                    instruktur.tampilkanProfil();
                    break;
                case 3:
                    System.out.println("Anda telah logout.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    public static void showPesertaMenu(Peserta peserta) {
        while (true) {
            System.out.println("\n-- Menu Peserta --");
            System.out.println("1. Daftar ke Kursus Baru");
            System.out.println("2. Lihat Profil Saya");
            System.out.println("3. Logout");
            System.out.print("Pilihan Anda: ");

            int pilihan = -1;
            try {
                pilihan = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid!");
                continue;
            }

            switch (pilihan) {
                case 1:
                    menuDaftarKursus(peserta);
                    break;
                case 2:
                    peserta.tampilkanProfil();
                    break;
                case 3:
                    System.out.println("Anda telah logout.");
                    return; // Keluar dari showPesertaMenu
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    public static void menuDaftarKursus(Peserta peserta) {
        System.out.println("\n--- Daftar Kursus Tersedia ---");
        
        // Cek jika tidak ada kursus yang tersedia
        if (kursusDatabase.isEmpty()) {
            System.out.println("Maaf, belum ada kursus yang tersedia saat ini.");
            return;
        }

        // Tampilkan semua kursus yang ada di database
        for (int i = 0; i < kursusDatabase.size(); i++) {
            System.out.println((i + 1) + ". " + kursusDatabase.get(i).getJudul());
        }

        System.out.print("\nPilih nomor kursus yang ingin diikuti (atau 0 untuk batal): ");
        int pilihanKursus = Integer.parseInt(scanner.nextLine());

        if (pilihanKursus == 0) {
            System.out.println("Pendaftaran dibatalkan.");
            return;
        }

        // Validasi pilihan
        if (pilihanKursus < 1 || pilihanKursus > kursusDatabase.size()) {
            System.out.println("Nomor kursus tidak valid.");
            return;
        }

        // Ambil objek kursus yang dipilih
        Kursus kursusPilihan = kursusDatabase.get(pilihanKursus - 1);
        kursusPilihan.tampilkanDetailKursus(); // Tampilkan detailnya

        // Proses Pembayaran
        System.out.println("\n--- Proses Pembayaran ---");
        System.out.print("Masukkan jumlah pembayaran (e.g., 150000): Rp");
        double jumlah = Double.parseDouble(scanner.nextLine());
        System.out.print("Pilih metode pembayaran (e.g., Transfer Bank, E-Wallet): ");
        String metode = scanner.nextLine();
        
        // Buat objek pembayaran baru
        int idTransaksi = 2000 + random.nextInt(8000);
        Pembayaran pembayaran = new Pembayaran(idTransaksi, jumlah, metode);
        pembayaranDatabase.add(pembayaran);

        // Daftarkan peserta ke kursus dengan menyertakan bukti pembayaran
        peserta.daftarKursus(kursusPilihan, pembayaran);
    }
    
    // ... (Metode-metode untuk Instruktur tidak berubah) ...
    public static void buatKursusBaru(Instruktur instruktur) {
        System.out.println("\n--- Membuat Kursus Baru ---");
        System.out.print("ID Kursus: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Judul Kursus: ");
        String judul = scanner.nextLine();
        System.out.print("Deskripsi Kursus: ");
        String deskripsi = scanner.nextLine();

        Kursus kursusBaru = new Kursus(id, judul, deskripsi);
        kursusDatabase.add(kursusBaru);
        instruktur.buatKursus(judul, deskripsi);

        System.out.println("✅ Kursus berhasil dibuat! Sekarang tambahkan konten untuk kursus ini.");
        menuTambahKonten(kursusBaru);
    }

    public static void menuTambahKonten(Kursus kursus) {
        while (true) {
            System.out.println("\n-> Menambahkan Konten untuk Kursus: '" + kursus.getJudul() + "'");
            System.out.println("   1. Tambah Materi Artikel");
            System.out.println("   2. Tambah Materi Video");
            System.out.println("   3. Tambah Kuis");
            System.out.println("   4. Selesai & Kembali ke Menu Instruktur");
            System.out.print("   Pilihan Konten: ");

            int pilihan = Integer.parseInt(scanner.nextLine());

            switch (pilihan) {
                case 1:
                    tambahArtikel(kursus);
                    break;
                case 2:
                    tambahVideo(kursus);
                    break;
                case 3:
                    tambahKuis(kursus);
                    break;
                case 4:
                    System.out.println("Konten berhasil disimpan.");
                    kursus.tampilkanDetailKursus();
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    public static void tambahArtikel(Kursus kursus) {
        System.out.println("\n--- Menambah Artikel ---");
        System.out.print("ID Konten: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Judul Artikel: ");
        String judul = scanner.nextLine();
        System.out.print("Isi Teks Artikel: ");
        String teks = scanner.nextLine();
        
        kursus.tambahKonten(new Artikel(id, judul, teks));
        System.out.println("-> Artikel '" + judul + "' berhasil ditambahkan.");
    }

    public static void tambahVideo(Kursus kursus) {
        System.out.println("\n--- Menambah Video ---");
        System.out.print("ID Konten: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Judul Video: ");
        String judul = scanner.nextLine();
        System.out.print("URL Video (e.g., https://youtu.be/...): ");
        String url = scanner.nextLine();

        kursus.tambahKonten(new Video(id, judul, url));
        System.out.println("-> Video '" + judul + "' berhasil ditambahkan.");
    }

    public static void tambahKuis(Kursus kursus) {
        System.out.println("\n--- Menambah Kuis ---");
        System.out.print("ID Konten: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Judul Kuis: ");
        String judul = scanner.nextLine();

        ArrayList<String> daftarSoal = new ArrayList<>();
        while (true) {
            System.out.print("Masukkan Soal No. " + (daftarSoal.size() + 1) + ": ");
            daftarSoal.add(scanner.nextLine());
            System.out.print("Tambah soal lagi? (y/n): ");
            if (scanner.nextLine().equalsIgnoreCase("n")) {
                break;
            }
        }

        String[] soalArray = new String[daftarSoal.size()];
        soalArray = daftarSoal.toArray(soalArray);

        kursus.tambahKonten(new Kuis(id, judul, soalArray));
        System.out.println("-> Kuis '" + judul + "' dengan " + soalArray.length + " soal berhasil ditambahkan.");
    }
}