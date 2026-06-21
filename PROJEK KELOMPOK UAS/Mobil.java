class Mobil extends Kendaraan {

    public Mobil(String nama, String noPolisi, double hargaSewa) {
        super(nama, noPolisi, hargaSewa);
    }

    @Override
    public void tampilInfo() {
        // %-18s artinya string nama akan memakan space 18 karakter rata kiri
        // %-10s artinya string nomor polisi akan memakan space 10 karakter rata kiri
        String namaFormat = String.format("%-18s", getNama());
        String noPolFormat = String.format("%-10s", getNoPolisi());

        System.out.println("Mobil : " + namaFormat 
                + " [" + noPolFormat + "]" 
                + " | Harga/Hari : Rp" + getHargaSewa()
                + " | Status : "
                + (isTersedia() ? "Tersedia" : "Disewa"));
    }
}