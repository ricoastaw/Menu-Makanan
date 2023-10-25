
package tugasoop;
/**
 *
 * @author FSD_Rico A W
 */
import java.util.ArrayList; // Mengimpor kelas ArrayList dari library-nya Java
import java.util.List; // Mengimpor kelas List dari library-nya Java
import java.util.Scanner; // Mengimpor kelas Scanner dari library-nya Java

abstract class MenuMakanan { // Mendefinisikan kelas abstrak MenuMakanan
    //deklarasi atibut yang dimiliki sup-class MenuMakanan
    private int id; 
    private String nama; 
    private double harga; 
    private boolean tersedia; 

    public MenuMakanan(int id, String nama, double harga, boolean tersedia) { // constructor untuk MenuMakanan
        //inisialisasi atribut
        this.id = id; 
        this.nama = nama;
        this.harga = harga;
        this.tersedia = tersedia;
    }
    //setter & getter
    public int getId() { // method untuk mengambil nilai atribut id
        return id;
    }

    public void setId(int id) { // method untuk mengatur nilai atribut id
        this.id = id;
    }

    public String getNama() { // method untuk mengambil nilai atribut nama
        return nama;
    }

    public void setNama(String nama) { // method untuk mengatur nilai atribut nama
        this.nama = nama;
    }

    public double getHarga() { // method untuk mengambil nilai atribut harga
        return harga;
    }

    public void setHarga(double harga) { // method untuk mengatur nilai atribut harga
        this.harga = harga;
    }

    public boolean isTersedia() { // method untuk mengambil nilai atribut tersedia
        return tersedia;
    }

    public void setTersedia(boolean tersedia) { // method untuk mengatur nilai atribut tersedia
        this.tersedia = tersedia;
    }

    public abstract void tampilInfoMenu(); // deklarasi method abstrak tampilInfoMenu
}

class SideDish extends MenuMakanan { // deklarasi kelas SideDish yang merupakan subclass dari MenuMakanan
    private int jumlahPorsiTersedia; // deklarasi atribut jumlahPorsiTersedia

    public SideDish(int id, String nama, double harga, boolean tersedia, int jumlahPorsiTersedia) { // constructor untuk SideDish
        super(id, nama, harga, tersedia); // memanggil konstruktor superclass MenuMakanan
        this.jumlahPorsiTersedia = jumlahPorsiTersedia; // Menginisialisasi atribut jumlahPorsiTersedia
    }

    public int getJumlahPorsiTersedia() { // method untuk mengambil nilai atribut jumlahPorsiTersedia
        return jumlahPorsiTersedia;
    }

    public void setJumlahPorsiTersedia(int jumlahPorsiTersedia) { // method untuk mengatur nilai atribut jumlahPorsiTersedia
        this.jumlahPorsiTersedia = jumlahPorsiTersedia;
    }

    @Override
    public void tampilInfoMenu() { // implementasi method tampilInfoMenu yang dioverride
        
        System.out.println("***************************************");
        System.out.println("Side Dish:"); // menampilkan judul "Side Dish"
        System.out.println("id: " + getId()); // menampilkan nilai atribut id
        System.out.println("Nama: " + getNama()); // menampilkan nilai atribut nama
        System.out.println("Harga: Rp. " + getHarga() + " K"); // menampilkan nilai atribut harga
        System.out.println("Tersedia: " + (isTersedia() ? "Ya" : "Tidak")); // menampilkan ketersediaan
        System.out.println("Jumlah Porsi Tersedia: " + jumlahPorsiTersedia); // menampilkan jumlah porsi tersedia
        System.out.println("***************************************");
        System.out.println("\n");
    }
}

public class TugasOOP { // Mendefinisikan kelas TugasOOP
    private static List<SideDish> sideDishes = new ArrayList<>(); // deklarasi list sideDishes sebagai ArrayList
    private static Scanner sc = new Scanner(System.in); // Membuat objek Scanner untuk input

    public static void main(String[] args) { // method main program
        tambahSideDish(new SideDish(12, "Kentang Goreng", 12.9, true, 20)); // Menambahkan side dish awal
        tambahSideDish(new SideDish(13, "Cireng", 25.9, false, 0)); // Menambahkan side dish awal

        while (true) { //looping while
            System.out.println("***************************************");
            System.out.println("Menu:"); // menampilkan menu
            System.out.println("1. Tampilkan Side Dish"); // Opsi 1: Menampilkan daftar side dish
            System.out.println("2. Filter Side Dish yang Tersedia"); // Opsi 2: Filter side dish yang tersedia
            System.out.println("3. Tambah Side Dish Baru"); // Opsi 3: Tambah side dish baru
            System.out.println("4. Edit Side Dish"); // Opsi 4: Edit side dish
            System.out.println("5. Hapus Side Dish"); // Opsi 5: Hapus side dish
            System.out.println("6. Keluar"); // Opsi 6: Keluar dari program
            System.out.print("Pilih menu (1-6): "); // Meminta user untuk memilih opsi
      
 

            int pilihan = sc.nextInt(); // membaca pilihan user
            sc.nextLine(); // membersihkan newline

            switch (pilihan) { // memroses pilihan user menggunakan switchcase
                case 1:
                    tampilkanSideDish(); // memanggil method tampilkanSideDish()
                    break;
                case 2:
                    filterSideDishTersedia(); // memanggil method filterSideDishTersedia()
                    break;
                case 3:
                    tambahSideDishDariInput(); // memanggil method tambahSideDishDariInput()
                    break;
                case 4:
                    editSideDish(); // memanggil method editSideDish()
                    break;
                case 5:
                    hapusSideDish(); // memanggil method hapusSideDish()
                    break;
                case 6:
                    System.out.println("Terima kasih! Keluar dari program."); // menampilkan pesan keluar
                    return; // Keluar dari program
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih lagi."); // Pesan jika pilihan tidak valid
                    break;
            }
        }
    }

    private static void tampilkanSideDish() { // method untuk menampilkan semua side dish
        System.out.println("Daftar Side Dish:"); // menampilkan judul
        sideDishes.forEach(SideDish::tampilInfoMenu); // menggunakan forEach untuk menampilkan setiap side dish
    }

    private static void filterSideDishTersedia() { // method untuk menampilkan side dish yang tersedia
        System.out.println("Filter Side Dish yang Tersedia:"); // menampilkan judul
        List<SideDish> tersedia = sideDishes.stream()
                .filter(SideDish::isTersedia)
                .toList(); // menggunakan Java Stream API untuk menyaring side dish yang tersedia
        tersedia.forEach(SideDish::tampilInfoMenu); // menggunakan forEach untuk menampilkan side dish yang tersedia
    }

    private static void tambahSideDish(SideDish sideDish) { // method untuk menambah side dish ke dalam list
        sideDishes.add(sideDish); // Menambahkan side dish ke dalam list
        System.out.println("Side Dish telah ditambahkan."); // menampilkan pesan
    }

    private static void tambahSideDishDariInput() { // method untuk menambah side dish dari input user
        System.out.print("\n Masukkan ID: ");
        int id = sc.nextInt(); // membaca ID dari user
        sc.nextLine(); // membersihkan newline

        System.out.print("Masukkan Nama: ");
        String nama = sc.nextLine(); // membaca Nama dari user

        System.out.print("Masukkan Harga: ");
        double harga = sc.nextDouble(); // membaca Harga dari user

        System.out.print("Apakah Tersedia (true/false): ");
        boolean tersedia = sc.nextBoolean(); // membaca ketersediaan dari user

        int jumlahPorsiTersedia = tersedia ? 0 : 0; // mengatur jumlahPorsiTersedia menjadi 0 jika tersedia adalah false

        if (tersedia) { // jika tersedia adalah true, minta jumlah porsi tersedia
            System.out.print("Masukkan Jumlah Porsi Tersedia: ");
            jumlahPorsiTersedia = sc.nextInt();
        }

        tambahSideDish(new SideDish(id, nama, harga, tersedia, jumlahPorsiTersedia)); // memanggil method untuk menambahkan side dish
    }

    private static void editSideDish() { // method untuk mengedit side dish
        System.out.print("Masukkan ID Side Dish yang akan diedit: ");
        int id = sc.nextInt(); // membaca ID side dish yang akan diedit
        sc.nextLine(); // membersihkan newline

        SideDish sideDish = cariSideDish(id); // Mencari side dish berdasarkan ID
        if (sideDish == null) {
            System.out.println("Side Dish tidak ditemukan."); // Pesan jika side dish tidak ditemukan
            return;
        }   
        System.out.print("Masukkan Nama Baru: ");
        String nama = sc.nextLine(); // membaca Nama baru

        System.out.print("Masukkan Harga Baru: ");
        double harga = sc.nextDouble(); // membaca Harga baru

        System.out.print("Apakah Tersedia (true/false): ");
        boolean tersedia = sc.nextBoolean(); // membaca ketersediaan baru

        int jumlahPorsiTersedia = tersedia ? 0 : 0; // mengatur jumlahPorsiTersedia menjadi 0 jika tersedia adalah false

        if (tersedia) { // jika tersedia adalah true, minta jumlah porsi tersedia baru
            System.out.print("Masukkan Jumlah Porsi Tersedia Baru: ");
            jumlahPorsiTersedia = sc.nextInt();
        }

        sideDish.setNama(nama); // mengatur Nama side dish yang baru
        sideDish.setHarga(harga); // mengatur Harga side dish yang baru
        sideDish.setTersedia(tersedia); // mengatur ketersediaan side dish yang baru
        sideDish.setJumlahPorsiTersedia(jumlahPorsiTersedia); // mengatur jumlah porsi tersedia yang baru

        System.out.println("Side Dish telah diubah."); // menampilkan pesan bahwa side dish telah diubah
    }

    private static SideDish cariSideDish(int id) { // method untuk mencari side dish berdasarkan ID
        return sideDishes.stream()
                .filter(sideDish -> sideDish.getId() == id)
                .findFirst()
                .orElse(null); // menggunakan Java Stream API untuk mencari side dish
    }

    private static void hapusSideDish() { // method untuk menghapus side dish
        System.out.print("Masukkan ID Side Dish yang akan dihapus: ");
        int id = sc.nextInt(); // membaca ID sideDish yang akan dihapus
        sc.nextLine(); // membersihkan newline

        SideDish sideDish = cariSideDish(id); // Mencari side dish berdasarkan ID
        if (sideDish == null) {
            System.out.println("Side Dish tidak ditemukan."); // Pesan jika side dish tidak ditemukan
            return;
        }

        sideDishes.remove(sideDish); // Menghapus side dish dari list
        System.out.println("Side Dish telah dihapus."); // menampilkan pesan bahwa side dish telah dihapus
    }
}
