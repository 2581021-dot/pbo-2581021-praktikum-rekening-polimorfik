public class Tabungan extends Rekening implements BerBunga {
    private double bunga; // persen per bulan

    public Tabungan(String nomor, String pemilik, int saldo, double bunga) {
        super(nomor, pemilik, saldo);
        this.bunga = bunga;
    }

    @Override
    public int biayaAdminBulanan() {
        return saldo >= 1_000_000 ? 0 : 5_000;
    }

    @Override
    public int tambahBunga() {
        int nilai = (int) Math.round(saldo * bunga / 100);
        saldo += nilai;
        return nilai;
    }

    @Override
    public void cetakInfo() {
        super.cetakInfo();
        System.out.println("      Tabungan, bunga " + bunga + "% per bulan");
    }
}