#include <iostream>
#include <sstream>
using namespace std;

int main() {
    string pembeli, namaBarang;
    long jumlahBarang, kuantitas, harga, kode;
    long totalHarga = 0, jumtotal = 0, jumbayar = 0, kembalian = 0, diskon = 0, totalBayar = 0;
    string daftarBarangGlobal;

    cout << "===== TOKO ELEKTRONIK =====" << endl << endl;
    cout << "Nama Pembeli    : ";
    getline(cin, pembeli);

    do {
        totalHarga = 0; 
        string daftarBarang; 

        cout << "\n====================================" << endl;
        cout << "Selamat datang di Toko Elektronik!" << endl;
        cout << "====================================" << endl;
        cout << "\nPilihan Barang Yang Tersedia:" << endl;
        cout << "001 - Smart TV Samsung 43'     - Rp4.000.000" << endl;
        cout << "002 - Smart TV Samsung 32'     - Rp3.000.000" << endl;
        cout << "003 - Smart TV Samsung 25'     - Rp2.500.000" << endl;
        cout << "004 - Kulkas Polytron 2 Pintu  - Rp2.500.000" << endl;
        cout << "005 - Kulkas Polytron 1 Pintu  - Rp1.500.000" << endl;
        cout << "006 - AC Daikin 2pk            - Rp5.000.000" << endl;
        cout << "007 - AC Daikin 1pk            - Rp3.000.000" << endl;

        cout << "\nMasukkan jumlah jenis barang elektronik yang ingin dibeli: ";
        cin >> jumlahBarang;

        for (int i = 1; i <= jumlahBarang; ++i) {
            bool valid = false;
            while (!valid) {
                cout << "\nMasukkan kode barang ke-" << i << ": ";
                cin >> kode;

                if (kode == 1) {
                    namaBarang = "Smart TV Samsung 43'";
                    harga = 4000000;
                    valid = true;
                } else if (kode == 2) {
                    namaBarang = "Smart TV Samsung 32'";
                    harga = 3000000;
                    valid = true;
                } else if (kode == 3) {
                    namaBarang = "Smart TV Samsung 25'";
                    harga = 2500000;
                    valid = true;
                } else if (kode == 4) {
                    namaBarang = "Kulkas Polytron 2 pintu";
                    harga = 2500000;
                    valid = true;
                } else if (kode == 5) {
                    namaBarang = "Kulkas Polytron 1 pintu";
                    harga = 1500000;
                    valid = true;
                } else if (kode == 6) {
                    namaBarang = "AC Daikin 2pk";
                    harga = 5000000;
                    valid = true;
                } else if (kode == 7) {
                    namaBarang = "AC Daikin 1pk";
                    harga = 3000000;
                    valid = true;
                } else {
                    cout << "Kode barang salah! Silakan coba lagi." << endl;
                }
            }

            cout << "Nama Barang		   	: " << namaBarang << endl;
            cout << "Harga Barang			: Rp" << harga << endl;

            cout << "Masukkan jumlah barang		: ";
            cin >> kuantitas;

            long totalPerBarang = harga * kuantitas;
            totalHarga += totalPerBarang;

            stringstream rincian;
            rincian << "- " << namaBarang << " (" << kuantitas << " x Rp" << harga
                    << ") = Rp" << totalPerBarang << "\n";
            daftarBarang += rincian.str();
        }

        jumtotal += totalHarga;
        daftarBarangGlobal += daftarBarang;

        cout << "\n" << daftarBarang;
        cout << "\nTotal harga untuk transaksi ini		: Rp" << totalHarga << endl;

        string jawab;
        cout << "\nApakah ingin membeli barang lain? (y/n): ";
        cin >> jawab;

        if (jawab != "y" && jawab != "Y") {
            break;
        }

    } while (true);

    // Menghitung diskon
    if (jumtotal > 10000000) {
        diskon = jumtotal * 0.15;
    } else if (jumtotal > 8000000) {
        diskon = jumtotal * 0.1;
    }

    totalBayar = jumtotal - diskon;

    cout << "\n\n================ RINCIAN PEMBAYARAN ================" << endl;
    cout << "Nama Pembeli          : " << pembeli << endl;
    cout << "\nDaftar Barang:\n" << daftarBarangGlobal; 
    cout << "\nTotal Semua Barang    : Rp" << jumtotal << endl;
    cout << "Diskon                : Rp" << diskon << endl;
    cout << "Total Bayar           : Rp" << totalBayar << endl;

    // Pembayaran
    do {
        cout << "Jumlah Uang Dibayar   : Rp";
        cin >> jumbayar;

        if (jumbayar >= totalBayar) {
            kembalian = jumbayar - totalBayar;
            cout << "Kembalian             : Rp" << kembalian << endl;
        } else {
            cout << "\nUang Anda tidak cukup! Mohon bayar sesuai jumlah total." << endl;
        }
    } while (jumbayar < totalBayar);

    cout << "====================================================" << endl;
    cout << "\nTerima kasih telah berbelanja di Toko Elektronik!" << endl;
    return 0;
}
