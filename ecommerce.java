import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
// Aplikasi E-Commerce sederhana dengan fitur login, inventori, dan transaksi
public class ecommerce {
// Menyimpan username dan password
    private static Map<String, String> akunPengguna = new HashMap<>();
    // Menyimpan saldo untuk setiap user
    private static Map<String, Double> saldoPengguna = new HashMap<>();
    // Menyimpan daftar barang dan harganya
    private static Map<String, Double> daftarBarang = new HashMap<>();
    // Menyimpan inventori barang setiap user (format: username:namaBarang)
    private static Map<String, String> inventoriPengguna = new HashMap<>();

    // Method utama untuk menjalankan aplikasi
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        inisialisasiDataAwal();

        while (true) {
            System.out.println("\n+=================+");
            System.out.println("|    Menu Utama   |");
            System.out.println("+=================+");
            System.out.println("| 1. Login        |");
            System.out.println("| 2. Daftar       |");
            System.out.println("| 3. Keluar       |");
            System.out.println("+=================+");
            System.out.print("| Pilih: ");
            String pilihan = input.nextLine().trim();
            System.out.println("+=================+");
            
            // Cek apakah input adalah angka
            if (!isAngka(pilihan)) {
                System.out.println("\n[!] Masukkan angka yang valid");
                continue;
            }
            
            int menu = Integer.parseInt(pilihan);
            switch (menu) {
                case 1:
                    prosesLogin(input);
                    break;
                case 2:
                    buatAkunBaru(input);
                    break;
                case 3:
            System.out.println("\n+------------------+");
            System.out.println("| Terima kasih! â™¥  |");
            System.out.println("+------------------+");
                    System.exit(0);
                    break;
            default:
                System.out.println("\n[!] Pilihan tidak valid");
            }
        }
    }

    // Cek apakah string adalah angka
    private static boolean isAngka(String str) {
        if (str == null || str.isEmpty()) return false;
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    // Cek apakah string adalah angka desimal
    private static boolean isAngkaDesimal(String str) {
        if (str == null || str.isEmpty()) return false;
        try {
            Double.parseDouble(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Inisialisasi data awal untuk testing
    private static void inisialisasiDataAwal() {
        akunPengguna.put("admin", "admin123");
        akunPengguna.put("user1", "pass123");
        saldoPengguna.put("user1", 1000.0);
        daftarBarang.put("Laptop", 5000.0);
        daftarBarang.put("HP", 2000.0);
        daftarBarang.put("Tablet", 1500.0);
    }

    // Proses login user dan admin
    private static void prosesLogin(Scanner input) {
        System.out.println("\n+------------------------+");
        System.out.print("| Username: ");
        String username = input.nextLine().trim();
        System.out.print("| Password: ");
        String password = input.nextLine().trim();
        System.out.println("+------------------------+");

        if (akunPengguna.containsKey(username) && akunPengguna.get(username).equals(password)) {
            if (username.equals("admin")) menuAdmin(input);
            else menuPengguna(input, username);
        } else {
            System.out.println("\n[!] Username atau password salah");
        }
    }

    // Menu khusus admin untuk manajemen 
    private static void menuAdmin(Scanner input) {
        while (true) {
            System.out.println("\n*======================*");
            System.out.println("|      Menu Admin      |");
            System.out.println("*======================*");
            System.out.println("| 1. Tambah Barang     |");
            System.out.println("| 2. Lihat Barang      |");
            System.out.println("| 3. Hapus Barang      |");
            System.out.println("| 4. Hapus Akun User   |");
            System.out.println("| 5. Keluar            |");
            System.out.println("*======================*");
            System.out.print("| Pilih: ");
            String pilihan = input.nextLine().trim();
            System.out.println("*======================*");
            
            if (!isAngka(pilihan)) {
                System.out.println("\n[!] Masukkan angka yang valid");
                continue;
            }
            
            int menu = Integer.parseInt(pilihan);
            switch (menu) {
                case 1:
                    tambahBarang(input);
                    break;
                case 2:
                    lihatDaftarBarang();
                    break;
                case 3:
                    hapusBarang(input);
                    break;
                case 4:
                    hapusAkunPengguna(input);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Pilihan tidak valid");
            }
        }
    }

    // Menu user untuk transaksi dan manajemen inventori
    private static void menuPengguna(Scanner input, String username) {
        while (true) {
            System.out.println("\n~========================~");
            System.out.println("|     Menu Pengguna      |");
            System.out.println("~========================~");
            System.out.println("| 1. Lihat Saldo         |");
            System.out.println("| 2. Tambah Saldo        |");
            System.out.println("| 3. Beli Barang         |");
            System.out.println("| 4. Lihat Inventori     |");
            System.out.println("| 5. Jual Barang         |");
            System.out.println("| 6. Tambah Barang       |");
            System.out.println("| 7. Keluar              |");
            System.out.println("~========================~");
            System.out.print("| Pilih: ");
            String pilihan = input.nextLine().trim();
            System.out.println("~========================~");
            
            if (!isAngka(pilihan)) {
                System.out.println("\n[!] Masukkan angka yang valid");
                continue;
            }
            
            int menu = Integer.parseInt(pilihan);
            switch (menu) {
                case 1:
                    System.out.println("\n+----------------------+");
                    System.out.println("| Saldo: Rp" + String.format("%-11.2f", saldoPengguna.get(username)) + "|");
                    System.out.println("+----------------------+");
                    break;
                case 2:
                    tambahSaldo(input, username);
                    break;
                case 3:
                    beliBarang(input, username);
                    break;
                case 4:
                    lihatInventori(username);
                    break;
                case 5:
                    jualBarang(input, username);
                    break;
                case 6:
                    tambahBarangLangsung(input, username);
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Pilihan tidak valid");
            }
        }
    }

    // Registrasi akun baru dengan validasi
    private static void buatAkunBaru(Scanner input) {
        System.out.println("\n+------------------------+");
        System.out.print("| Username baru: ");
        String username = input.nextLine().trim();
        
        if (username.isEmpty() || akunPengguna.containsKey(username)) {
            System.out.println("\n[!] Username tidak valid atau sudah digunakan");
            return;
        }

        System.out.print("| Password (min 6 karakter): ");
        System.out.println("\n+------------------------+");
        String password = input.nextLine().trim();
        
        if (password.length() < 6) {
            System.out.println("\n[!] Password minimal 6 karakter");
            return;
        }

        akunPengguna.put(username, password);
        saldoPengguna.put(username, 0.0);
        System.out.println("\n+-------------------------+");
        System.out.println("| âœ“ Akun berhasil dibuat! |");
        System.out.println("+-------------------------+");
    }

    // Admin: Menambah barang baru ke daftar
    private static void tambahBarang(Scanner input) {
        System.out.println("\n+------------------------+");
        System.out.print("| Nama barang: ");
        String namaBarang = input.nextLine().trim();
        
        System.out.print("| Harga: Rp");
        System.out.println("+------------------------+");
        String inputHarga = input.nextLine().trim();
        
        if (!isAngkaDesimal(inputHarga)) {
            System.out.println("\n[!] Harga tidak valid");
            return;
        }
        
        double harga = Double.parseDouble(inputHarga);
        if (harga <= 0) {
            System.out.println("\n[!] Harga harus lebih dari 0");
            return;
        }
        
        daftarBarang.put(namaBarang, harga);
        System.out.println("\n+--------------------------------+");
        System.out.println("| âœ“ Barang berhasil ditambahkan! |");
        System.out.println("+--------------------------------+");
    }

    // Menampilkan semua barang yang tersedia
    private static void lihatDaftarBarang() {
        System.out.println("\n<====================>");
        System.out.println("|   Daftar Barang    |");
        System.out.println("<====================>");
        if (daftarBarang.isEmpty()) {
            System.out.println("| Tidak ada barang     |");
            System.out.println("<====================>");
            return;
        }
        daftarBarang.forEach((nama, harga) -> System.out.println("| " + nama + " - Rp" + harga));
        System.out.println("<====================>");
    }

    // Admin: Menghapus barang dari daftar
    private static void hapusBarang(Scanner input) {
        lihatDaftarBarang();
        System.out.println("\n+------------------------+");
        System.out.print("| Hapus barang: ");
        String namaBarang = input.nextLine().trim();
        
        if (daftarBarang.remove(namaBarang) != null) {
            System.out.println("\n+-----------------------------+");
            System.out.println("| âœ“ Barang berhasil dihapus! |");
            System.out.println("+-----------------------------+");
        } else {
            System.out.println("Barang tidak ditemukan");
        }
    }

    // User: Menambah saldo ke akun
    private static void tambahSaldo(Scanner input, String username) {
        System.out.println("\n+------------------------+");
        System.out.print("| Jumlah saldo: Rp");
        String inputJumlah = input.nextLine().trim();
        
        if (!isAngkaDesimal(inputJumlah)) {
            System.out.println("\n[!] Jumlah tidak valid");
            return;
        }
        
        double jumlah = Double.parseDouble(inputJumlah);
        if (jumlah <= 0) {
            System.out.println("\n[!] Jumlah harus lebih dari 0");
            return;
        }
        
        saldoPengguna.put(username, saldoPengguna.get(username) + jumlah);
        System.out.println("\n+--------------------------------+");
        System.out.println("| âœ“ Saldo berhasil ditambahkan   |");
        System.out.println("| Total: Rp" + String.format("%-19.2f", saldoPengguna.get(username)) + "|");
        System.out.println("+--------------------------------+");
    }

    // User: Membeli barang dan mengurangi saldo
    private static void beliBarang(Scanner input, String username) {
        lihatDaftarBarang();
        System.out.println("\n+------------------------+");
        System.out.print("| Beli barang: ");
        String namaBarang = input.nextLine().trim();
        
        if (!daftarBarang.containsKey(namaBarang)) {
            System.out.println("\n[!] Barang tidak ditemukan");
            return;
        }
        
        double hargaBarang = daftarBarang.get(namaBarang);
        double saldo = saldoPengguna.get(username);
        
        if (saldo < hargaBarang) {
            System.out.println("\n[!] Saldo tidak mencukupi");
            return;
        }
        
        saldoPengguna.put(username, saldo - hargaBarang);
        inventoriPengguna.put(username + ":" + namaBarang, namaBarang);
        System.out.println("\n+--------------------------------+");
        System.out.println("| âœ“ Pembelian berhasil!          |");
        System.out.println("| Sisa saldo: Rp" + String.format("%-16.2f", saldoPengguna.get(username)) + "|");
        System.out.println("+--------------------------------+");
    }

    // Menampilkan barang yang dimiliki user
    private static void lihatInventori(String username) {
        System.out.println("\n>=====================<");
        System.out.println("|     Inventori      |");
        System.out.println(">=====================<");
        boolean adaBarang = false;
        
        for (Map.Entry<String, String> item : inventoriPengguna.entrySet()) {
            if (item.getKey().startsWith(username + ":")) {
                System.out.println("| " + item.getValue());
                adaBarang = true;
            }
        }
        
        if (!adaBarang) {
            System.out.println("| Inventori kosong     |");
            System.out.println(">=====================<");
        }
    }

    // User: Menambah barang langsung ke inventori tanpa beli
    private static void tambahBarangLangsung(Scanner input, String username) {
        System.out.println("\n+------------------------+");
        System.out.print("| Nama barang: ");
        String namaBarang = input.nextLine().trim();
        
        if (namaBarang.isEmpty()) {
            System.out.println("\n[!] Nama barang tidak boleh kosong");
            return;
        }
        
        inventoriPengguna.put(username + ":" + namaBarang, namaBarang);
        System.out.println("Barang berhasil ditambahkan");
    }

    // Admin: Menghapus akun pengguna
    private static void hapusAkunPengguna(Scanner input) {
        System.out.println("\n-====================--");
        System.out.println("|   Daftar Pengguna   |");
        System.out.println("-====================--");
        for (String username : akunPengguna.keySet()) {
            if (!username.equals("admin")) {
                System.out.println("| - " + username);
            }
        }
        
        System.out.println("\n+--------------------------------+");
        System.out.print("| Masukkan username yang akan dihapus: ");
        String username = input.nextLine().trim();
        System.out.println("+--------------------------------+");
        
        if (username.equals("admin")) {
            System.out.println("\n[!] Tidak dapat menghapus akun admin!");
            return;
        }
        
        if (!akunPengguna.containsKey(username)) {
            System.out.println("\n[!] Username tidak ditemukan");
            return;
        }
        
        // Hapus data pengguna
        akunPengguna.remove(username);
        saldoPengguna.remove(username);
        
        // Hapus semua barang di inventori pengguna
        inventoriPengguna.entrySet().removeIf(entry -> entry.getKey().startsWith(username + ":"));
        
        System.out.println("\n+--------------------------------+");
        System.out.println("| âœ“ Akun pengguna berhasil dihapus! |");
        System.out.println("+--------------------------------+");
    }

    // User: Menjual barang dari inventori dan menambah saldo
    private static void jualBarang(Scanner input, String username) {
        lihatInventori(username);
        
        boolean adaBarang = inventoriPengguna.keySet().stream()
            .anyMatch(key -> key.startsWith(username + ":"));
            
        if (!adaBarang) {
            System.out.println("\n[!] Tidak ada barang untuk dijual");
            return;
        }

        System.out.println("\n+------------------------+");
        System.out.print("| Jual barang: ");
        String namaBarang = input.nextLine().trim();
        String kodeInventori = username + ":" + namaBarang;
        
        if (!inventoriPengguna.containsKey(kodeInventori)) {
            System.out.println("\n[!] Barang tidak ditemukan dalam inventori");
            return;
        }

        System.out.println("\n+------------------------+");
        System.out.print("| Harga jual: Rp");
        String inputHarga = input.nextLine().trim();
        System.out.println("+------------------------+");
        
        if (!isAngkaDesimal(inputHarga)) {
            System.out.println("\n[!] Harga tidak valid");
            return;
        }
        
        double hargaJual = Double.parseDouble(inputHarga);
        if (hargaJual <= 0) {
            System.out.println("\n[!] Harga harus lebih dari 0");
            return;
        }
        
        daftarBarang.put(namaBarang, hargaJual);
        inventoriPengguna.remove(kodeInventori);
        saldoPengguna.put(username, saldoPengguna.get(username) + hargaJual);
        System.out.println("\n+--------------------------------+");
        System.out.println("| âœ“ Penjualan berhasil!          |");
        System.out.println("| Saldo: Rp" + String.format("%-20.2f", saldoPengguna.get(username)) + "|");
        System.out.println("+--------------------------------+");
    }
}
