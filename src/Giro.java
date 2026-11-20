public class Giro extends Rekening {
    private final long batasOverdraft;

    public Giro(int nomor, String pemilik, long saldoAwal, long batasOverdraft) {
        super(nomor, pemilik, saldoAwal);
        this.batasOverdraft = batasOverdraft;
    }

    @Override
    public boolean tarik(long jumlah) {
        if (jumlah <= 0 || saldo - jumlah < -batasOverdraft) {
            return false;
        }
        saldo -= jumlah;
        return true;
    }

    @Override
    public long biayaAdmin() {
        return 15_000;
    }

    @Override
    public String keterangan() {
        return "Giro, batas overdraft " + rupiah(batasOverdraft);
    }
}