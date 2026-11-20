import java.util.Locale;

public class Deposito extends Rekening implements BerBunga {
    private final double bungaPersen;

    public Deposito(int nomor, String pemilik, long saldoAwal, double bungaPersen) {
        super(nomor, pemilik, saldoAwal);
        this.bungaPersen = bungaPersen;
    }

    // Deposito tidak bisa ditarik sebelum jatuh tempo: sesuai kontrak, kembalikan false
    @Override
    public boolean tarik(long jumlah) {
        return false;
    }

    @Override
    public long biayaAdmin() {
        return 0;
    }

    @Override
    public long hitungBunga() {
        return Math.round(saldo * bungaPersen / 100.0);
    }

    @Override
    public long tambahBunga() {
        long bunga = hitungBunga();
        saldo += bunga;
        return bunga;
    }

    @Override
    public String keterangan() {
        return String.format(Locale.US, "Deposito, bunga %.1f%% per bulan", bungaPersen);
    }
}