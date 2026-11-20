import java.util.Locale;

public class Tabungan extends Rekening implements BerBunga {
    private final double bungaPersen;

    public Tabungan(int nomor, String pemilik, long saldoAwal, double bungaPersen) {
        super(nomor, pemilik, saldoAwal);
        this.bungaPersen = bungaPersen;
    }

    @Override
    public boolean tarik(long jumlah) {
        if (jumlah <= 0 || jumlah > saldo) {
            return false;
        }
        saldo -= jumlah;
        return true;
    }

    @Override
    public long biayaAdmin() {
        return saldo < 1_000_000 ? 5_000 : 0;
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
        return String.format(Locale.US, "Tabungan, bunga %.1f%% per bulan", bungaPersen);
    }
}