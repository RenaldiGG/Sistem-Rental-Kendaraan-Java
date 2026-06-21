class Rental implements Pembayaran {

    private String namaPenyewa;
    private Kendaraan kendaraan;
    private int lamaSewa;
    private String tanggalSewa;
    private String tanggalKembali;
    private double totalBiaya;
    
    // Tambahan Baru untuk Persyaratan Penyewa
    private String noTelpPenyewa;
    private String noTelpPenanggungJawab;
    private String alamatPenyewa;

    // Modifikasi Constructor untuk menerima tambahan data persyaratan
    public Rental(String namaPenyewa, String noTelpPenyewa, String alamatPenyewa, 
                  String noTelpPenanggungJawab, Kendaraan kendaraan, int lamaSewa, 
                  String tanggalSewa, String tanggalKembali) {

        this.namaPenyewa = namaPenyewa;
        this.noTelpPenyewa = noTelpPenyewa;
        this.alamatPenyewa = alamatPenyewa;
        this.noTelpPenanggungJawab = noTelpPenanggungJawab;
        this.kendaraan = kendaraan;
        this.lamaSewa = lamaSewa;
        this.tanggalSewa = tanggalSewa;
        this.tanggalKembali = tanggalKembali;
        this.totalBiaya = kendaraan.getHargaSewa() * lamaSewa;
    }

    @Override
    public void prosesPembayaran() {
        System.out.println("\n===== STRUK RENTAL =====");
        System.out.println("Nama Penyewa         : " + namaPenyewa);
        System.out.println("No. Telp Penyewa     : " + noTelpPenyewa);         // Menampilkan No Telp Penyewa
        System.out.println("Alamat Penyewa       : " + alamatPenyewa);         // Menampilkan Alamat
        System.out.println("No. Penaggung Jawab  : " + noTelpPenanggungJawab); // Menampilkan No Telp Penanggung Jawab
        System.out.println("----------------------------------------");
        System.out.println("Kendaraan            : " + kendaraan.getNama() + " [" + kendaraan.getNoPolisi() + "]");
        System.out.println("Tanggal Sewa         : " + tanggalSewa);
        System.out.println("Tanggal Kembali      : " + tanggalKembali);
        System.out.println("Lama Sewa            : " + lamaSewa + " Hari");
        System.out.println("Total Bayar          : Rp" + totalBiaya);
    }
}