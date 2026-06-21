class Motor extends Kendaraan {

    public Motor(String nama, String noPolisi, double hargaSewa) {
        super(nama, noPolisi, hargaSewa);
    }

    @Override
    public void tampilInfo() {
        String namaFormat = String.format("%-18s", getNama());
        String noPolFormat = String.format("%-10s", getNoPolisi());

        System.out.println("Motor : " + namaFormat 
                + " [" + noPolFormat + "]" 
                + " | Harga/Hari : Rp" + getHargaSewa()
                + " | Status : "
                + (isTersedia() ? "Tersedia" : "Disewa"));
    }
}