import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Kendaraan> daftarKendaraan = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void tampilKendaraan() {
        System.out.println("\n===== DAFTAR KENDARAAN =====");
        if (daftarKendaraan.isEmpty()) {
            System.out.println("[Daftar Kendaraan Kosong]");
            return;
        }
        for (int i = 0; i < daftarKendaraan.size(); i++) {
            System.out.print((i + 1) + ". ");
            daftarKendaraan.get(i).tampilInfo();
        }
    }

    // --- FITUR BARU KELOLA KENDARAAN ---
    
    // 1. Tambah Kendaraan
    public static void tambahKendaraan() {
        System.out.println("\n===== TAMBAH KENDARAAN =====");
        System.out.println("1. Mobil");
        System.out.println("2. Motor");
        System.out.print("Pilih Jenis Kendaraan: ");
        int jenis = input.nextInt();
        input.nextLine(); // Clear buffer

        System.out.print("Nama Kendaraan    : ");
        String nama = input.nextLine();
        System.out.print("No. Polisi        : ");
        String noPolisi = input.nextLine();
        System.out.print("Harga Sewa / Hari : ");
        double harga = input.nextDouble();
        input.nextLine(); // Clear buffer

        if (jenis == 1) {
            daftarKendaraan.add(new Mobil(nama, noPolisi, harga));
            System.out.println("Mobil berhasil ditambahkan!");
        } else if (jenis == 2) {
            daftarKendaraan.add(new Motor(nama, noPolisi, harga));
            System.out.println("Motor berhasil ditambahkan!");
        } else {
            System.out.println("Jenis kendaraan tidak valid.");
        }
    }

    // 2. Hapus Kendaraan
    public static void hapusKendaraan() {
        System.out.println("\n===== HAPUS KENDARAAN =====");
        tampilKendaraan();
        if (daftarKendaraan.isEmpty()) return;

        System.out.print("\nPilih Nomor Kendaraan yang akan dihapus: ");
        int no = input.nextInt();
        input.nextLine(); // Clear buffer

        if (no > 0 && no <= daftarKendaraan.size()) {
            Kendaraan k = daftarKendaraan.remove(no - 1);
            System.out.println(k.getNama() + " berhasil dihapus!");
        } else {
            System.out.println("Nomor kendaraan tidak valid.");
        }
    }

    // 3. Edit Kendaraan
    public static void editKendaraan() {
        System.out.println("\n===== EDIT KENDARAAN =====");
        tampilKendaraan();
        if (daftarKendaraan.isEmpty()) return;

        System.out.print("\nPilih Nomor Kendaraan yang akan diedit: ");
        int no = input.nextInt();
        input.nextLine(); // Clear buffer

        if (no > 0 && no <= daftarKendaraan.size()) {
            Kendaraan k = daftarKendaraan.get(no - 1);
            
            System.out.println("\n--- Data Lama ---");
            k.tampilInfo();
            System.out.println("-----------------");

            System.out.print("Nama Baru (Isi - jika tidak ingin diubah): ");
            String namaBaru = input.nextLine();
            System.out.print("No Polisi Baru (Isi - jika tidak ingin diubah): ");
            String noPolBaru = input.nextLine();
            System.out.print("Harga Baru (Isi 0 jika tidak ingin diubah): ");
            double hargaBaru = input.nextDouble();
            input.nextLine(); // Clear buffer

            // Karena nama, noPolisi, dan hargaSewa di kelas Kendaraan bersifat private 
            // dan tidak memiliki setter (berdasarkan file Kendaraan.java kamu),
            // kita buat objek baru untuk menggantikan yang lama di posisi index tersebut.
            String namaFinal = namaBaru.equals("-") ? k.getNama() : namaBaru;
            String noPolFinal = noPolBaru.equals("-") ? k.getNoPolisi() : noPolBaru;
            double hargaFinal = hargaBaru == 0 ? k.getHargaSewa() : hargaBaru;

            if (k instanceof Mobil) {
                daftarKendaraan.set(no - 1, new Mobil(namaFinal, noPolFinal, hargaFinal));
            } else if (k instanceof Motor) {
                daftarKendaraan.set(no - 1, new Motor(namaFinal, noPolFinal, hargaFinal));
            }
            System.out.println("Data kendaraan berhasil diperbarui!");
        } else {
            System.out.println("Nomor kendaraan tidak valid.");
        }
    }

    // --- MENU UTAMA (SEWA & LIHAT) ---
    public static void menuUtamaRental() {
        int pilihUtama;
        do {
            System.out.println("\n===== MENU UTAMA RENTAL =====");
            System.out.println("1. Lihat Kendaraan");
            System.out.println("2. Sewa Kendaraan");
            System.out.println("3. Kembali ke Menu Kelola Admin");
            System.out.print("Pilih Menu : ");
            
            try {
                pilihUtama = input.nextInt();
                input.nextLine(); // Clear buffer

                switch (pilihUtama = pilihUtama) {
                    case 1:
                        tampilKendaraan();
                        break;
                    case 2:
                        tampilKendaraan();
                        if (daftarKendaraan.isEmpty()) break;
                        
                        System.out.print("\nPilih Kendaraan : ");
                        int no = input.nextInt();
                        input.nextLine(); // Clear buffer

                        if (no <= 0 || no > daftarKendaraan.size()) {
                            System.out.println("Nomor kendaraan tidak valid.");
                            break;
                        }

                        System.out.print("Nama Penyewa                      : ");
                        String penyewa = input.nextLine();
                        System.out.print("No. Telepon Penyewa               : ");
                        String telpPenyewa = input.nextLine();
                        System.out.print("Alamat Penyewa                    : ");
                        String alamat = input.nextLine();
                        System.out.print("No. Penanggung Jawab              : ");
                        String telpPJ = input.nextLine();
                        System.out.print("Lama Sewa (Hari)                  : ");
                        int hari = input.nextInt();
                        input.nextLine(); // Clear buffer
                        System.out.print("Tanggal Sewa (DD-MM-YYYY)         : ");
                        String tglSewa = input.nextLine();
                        System.out.print("Tanggal Dikembalikan (DD-MM-YYYY) : ");
                        String tglKembali = input.nextLine();

                        Kendaraan k = daftarKendaraan.get(no - 1);
                        if (!k.isTersedia()) {
                            System.out.println("Kendaraan sedang disewa!");
                            break;
                        }

                        k.setTersedia(false);
                        Rental rental = new Rental(penyewa, telpPenyewa, alamat, telpPJ, k, hari, tglSewa, tglKembali);
                        rental.prosesPembayaran();
                        break;
                    case 3:
                        System.out.println("Kembali ke menu pengelolaan...");
                        break;
                    default:
                        System.out.println("Menu tidak tersedia");
                }
            } catch (Exception e) {
                System.out.println("Input harus berupa angka!");
                input.nextLine();
                pilihUtama = 0;
            }
        } while (pilihUtama != 3);
    }

    public static void main(String[] args) {
        Admin admin = new Admin("admin", "123");

        // Data awal kendaraan
        daftarKendaraan.add(new Mobil("Toyota Alphard   ", "D 27 F    ", 900000));
        daftarKendaraan.add(new Mobil("BMW XM Label Red ", "D 1 FZ    ", 990000));
        daftarKendaraan.add(new Mobil("Honda Civic Turbo", "D 479 ZX  ", 850000));
        daftarKendaraan.add(new Motor("Yamaha NMAX      ", "D 5566 AUF", 150000));
        daftarKendaraan.add(new Motor("Harley Davidson  ", "D 10 ZDN  ", 700000));
        daftarKendaraan.add(new Motor("Kawasaki ZXR25   ", "D 7 HFZ   ", 900000));
        daftarKendaraan.add(new Motor("Suzuki GSXR150   ", "D 11 RMR  ", 500000));

        System.out.println("===== LOGIN ADMIN =====");
        System.out.print("Username : ");
        String user = input.nextLine();

        System.out.print("Password : ");
        String pass = input.nextLine();

        if (!admin.login(user, pass)) {
            System.out.println("Login Gagal!");
            return;
        }

        System.out.println("\nLogin Berhasil!");
        int pilihAdmin;

        // --- LOOP MENU UTAMA ADMIN (SETELAH LOGIN) ---
        do {
            System.out.println("\n===== MENU ADMIN =====");
            System.out.println("1. Tambah Kendaraan");
            System.out.println("2. Hapus Kendaraan");
            System.out.println("3. Edit Kendaraan");
            System.out.println("4. Lihat Kendaraan");
            System.out.println("5. Masuk ke Menu Utama Rental");
            System.out.println("6. Keluar Aplikasi");
            System.out.print("Pilih Kelola : ");

            try {
                pilihAdmin = input.nextInt();
                input.nextLine(); // Clear buffer

                switch (pilihAdmin) {
                    case 1:
                        tambahKendaraan();
                        break;
                    case 2:
                        hapusKendaraan();
                        break;
                    case 3:
                        editKendaraan();
                        break;
                    case 4:
                        tampilKendaraan();
                        break;
                    case 5:
                        menuUtamaRental(); // Masuk ke menu lihat & sewa kendaraan
                        break;
                    case 6:
                        System.out.println("Terima Kasih. Program keluar.");
                        break;
                    default:
                        System.out.println("Menu tidak tersedia");
                }
            } catch (Exception e) {
                System.out.println("Input harus berupa angka!");
                input.nextLine(); // Clear buffer jika error
                pilihAdmin = 0;
            }
        } while (pilihAdmin != 6);
    }
}