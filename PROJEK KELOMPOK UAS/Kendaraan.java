abstract class Kendaraan {

    private String nama;
    private String noPolisi; // Tambahan Baru
    private double hargaSewa;
    private boolean tersedia;

    // Modifikasi Constructor untuk menerima noPolisi
    public Kendaraan(String nama, String noPolisi, double hargaSewa) {
        this.nama = nama;
        this.noPolisi = noPolisi;
        this.hargaSewa = hargaSewa;
        this.tersedia = true;
    }

    public String getNama() {
        return nama;
    }

    // Tambahan Getter Baru
    public String getNoPolisi() {
        return noPolisi;
    }

    public double getHargaSewa() {
        return hargaSewa;
    }

    public boolean isTersedia() {
        return tersedia;
    }

    public void setTersedia(boolean tersedia) {
        this.tersedia = tersedia;
    }

    public abstract void tampilInfo();
}