import java.util.Scanner;

public class Main {
    static Menu[] daftarMenu = {
            new Menu("Nasi Goreng", 20000, "Makanan"),
            new Menu("Ayam Bakar", 30000, "Makanan"),
            new Menu("Es Teh", 5000, "Minuman"),
            new Menu("Es Jeruk", 10000, "Minuman"),
    };

    public static void tampilkanMenu() {
        System.out.println("Menu Makanan:");
        for (Menu menu : daftarMenu) {
            if (menu.getKategori().equals("Makanan")) {
                menu.displayMenu();
            }
        }
        System.out.println("\nMenu Minuman:");
        for (Menu menu : daftarMenu) {
            if (menu.getKategori().equals("Minuman")) {
                menu.displayMenu();
            }
        }
    }

    public static double hitungTotalBiaya(double totalPesanan) {
        double pajak = 0.1 * totalPesanan;
        double biayaPelayanan = 20000;
        double totalSetelahPajak = totalPesanan + pajak + biayaPelayanan;

        if (totalSetelahPajak > 100000) {
            totalSetelahPajak *= 0.9;
        }
        return totalSetelahPajak;
    }

    public static void cetakStruk(String[] pesanan, int[] jumlah, double totalPesanan) {
        System.out.println("\n===== Struk Pesanan =====");
        for (int i = 0; i < pesanan.length; i++) {
            if (pesanan[i] != null) {
                System.out.println(pesanan[i] + " x" + jumlah[i]);
            }
        }
        System.out.println("Total Pesanan: Rp " + totalPesanan);
        double totalAkhir = hitungTotalBiaya(totalPesanan);
        System.out.println("Total Setelah Pajak dan Diskon : Rp " + totalAkhir);
        System.out.println("=========================");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        tampilkanMenu();

        String[] pesanan = new String[4];
        int[] jumlah = new int[4];
        double totalPesanan = 0;

        System.out.println("\n Masukkan Pesanan (maks 4):");
        for (int i = 0; i < 4; i++) {
            System.out.print("Nama menu (atau ketik 'selesai' untuk berhenti): ");
            String menuDipilih = scanner.nextLine();
            if (menuDipilih.equalsIgnoreCase("selesai")) {
                break;
            }

            System.out.print("Jumlah: ");
            jumlah[i] = scanner.nextInt();
            scanner.nextLine();

            for (Menu menu : daftarMenu) {
                if (menu.getNama().equalsIgnoreCase(menuDipilih)) {
                    pesanan[i] = menu.getNama();
                    totalPesanan += menu.getHarga() * jumlah[i];
                    break;
                }
            }
        }
        cetakStruk(pesanan, jumlah, totalPesanan);
        scanner.close();
    }
}
