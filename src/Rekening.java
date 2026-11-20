import java.util.Locale;

public abstract class Rekening {
    private final int nomor;
    private final String pemilik;
    protected long saldo;

    public Rekening(int nomor, String pemilik, long saldoAwal) {
        this.nomor = nomor;
        this.pemilik = pemilik;
        this.saldo = saldoAwal;
    }

    public int getNomor()      { return nomor; }
    public String getPemilik() { return pemilik; }
    public long getSaldo()     { return saldo; }

    public void setor(long jumlah) {
        if (jumlah > 0) {
            saldo += jumlah;
        }
    }

    //Kontrak tarik:
    //true kalau berhasil, false kalau gagal, tidak pernah melempar exception.
    public abstract boolean tarik(long jumlah);

    public abstract long biayaAdmin();

    // Baris kedua laporan, misalnya "Tabungan, bunga 2.5% per bulan".
    public abstract String keterangan();

    // Biaya admin dipotong paksa (bukan penarikan), jadi tidak lewat tarik().
    public void kenakanBiaya(long jumlah) {
        saldo -= jumlah;
    }

    public static String rupiah(long nilai) {
        return "Rp" + String.format(Locale.US, "%,d", nilai).replace(',', '.');
    }
}