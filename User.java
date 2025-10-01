// File: KUIS_PBO1/User.java
package KUIS_PBO1;

// User.java
public abstract class User {
    protected int id;
    protected String nama;
    protected String email; 
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
        return email;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }
    
    public void tampilkanProfil() {
        System.out.println("ID     : " + id);
        System.out.println("Nama   : " + nama);
        System.out.println("Email  : " + email);
    };
}