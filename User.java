// File: KUIS_PBO1/User.java
package KUIS_PBO1;

// User.java
public abstract class User {
    protected int id;
    protected String nama;
    protected String email; // Menggantikan 'item' agar lebih jelas
    protected String password;

    public User(int id, String nama, String email, String password) {
        this.id = id;
        this.nama = nama;
        this.email = email;
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public String email() {
        // Dalam sistem nyata, username bisa jadi atribut terpisah.
        // Di sini kita asumsikan email sebagai username untuk login.
        return email;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }
    
    // Method abstract untuk menampilkan profil, akan di-implementasikan oleh subclass
    public void tampilkanProfil() {
        System.out.println("ID     : " + id);
        System.out.println("Nama   : " + nama);
        System.out.println("Email  : " + email);
        // System.out.println("Status : " + status);
    };
}