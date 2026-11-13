public class BankPolimorfik {
    public static void main(String[] args) {
        Tabungan ani = new Tabungan("101", "Ani", 1_000_000, 2.5);
        Tabungan citra = new Tabungan("102", "Citra", 300_000, 2.0);
        Giro budi = new Giro("201", "Budi", 200_000, 500_000);

        Rekening[] semua = { ani, citra, budi };
        BerBunga[] berbunga = { ani, citra };

        // Rekening r = new Rekening("999", "Eko", 0);
        // Error: Rekening is abstract; cannot be instantiated

        System.out.println("========== REKENING AWAL ==========");
        for (Rekening r : semua) r.cetakInfo();

        System.out.println();
        System.out.println("========== AKHIR BULAN ============");
        for (Rekening r : semua) {
            System.out.printf("%s biaya admin  : %s%n",
                    r.getNomor(), Rekening.rupiah(r.potongBiayaAdmin()));
        }
        for (BerBunga b : berbunga) {
            System.out.printf("%s bunga        : %s%n",
                    b.getNomor(), Rekening.rupiah(b.tambahBunga()));
        }

        System.out.println();
        System.out.println("========== REKENING AKHIR =========");
        int total = 0;
        for (Rekening r : semua) {
            r.cetakInfo();
            total += r.getSaldo();
        }
        System.out.println("-----------------------------------");
        System.out.println("Total dana bank : " + Rekening.rupiah(total));
    }
}