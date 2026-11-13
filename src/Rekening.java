public abstract class Rekening {
    private String nomor;
    private String pemilik;
    protected int saldo;

    public Rekening(String nomor, String pemilik, int saldo) {
        this.nomor = nomor;
        this.pemilik = pemilik;
        this.saldo = saldo;
    }

    public String getNomor() { return nomor; }
    public String getPemilik() { return pemilik; }
    public int getSaldo() { return saldo; }

    public void setor(int jumlah) { saldo += jumlah; }

    public boolean tarik(int jumlah) {
        if (jumlah <= saldo) { saldo -= jumlah; return true; }
        return false;
    }

    public abstract int biayaAdminBulanan();

    public int potongBiayaAdmin() {
        int biaya = biayaAdminBulanan();
        saldo -= biaya;
        return biaya;
    }

    public static String rupiah(int n) {
        String s = String.format("%,d", Math.abs(n)).replace(',', '.');
        return (n < 0 ? "-Rp" : "Rp") + s;
    }

    public void cetakInfo() {
        System.out.printf("%s | %-6s | %12s%n", nomor, pemilik, rupiah(saldo));
    }
}