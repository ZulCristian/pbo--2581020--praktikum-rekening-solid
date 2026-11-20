public class BankSolid {
    public static void main(String[] args) {
        Tabungan ani   = new Tabungan(101, "Ani", 1_000_000, 2.5);
        Tabungan citra = new Tabungan(102, "Citra", 300_000, 2.0);
        Giro budi      = new Giro(201, "Budi", 200_000, 500_000);
        Deposito dewi  = new Deposito(301, "Dewi", 5_000_000, 4.0);

        Rekening[] semua    = { ani, citra, budi, dewi };
        BerBunga[] berbunga = { ani, citra, dewi };

        ProsesAkhirBulan proses = new ProsesAkhirBulan();
        LaporanBank laporan = new LaporanBank();

        laporan.cetakDaftar("REKENING AWAL", semua);
        laporan.barisKosong();

        laporan.cetakJudul("AKHIR BULAN");
        proses.potongBiayaAdmin(semua);
        proses.tambahBunga(berbunga);
        proses.autodebet(semua, 50_000);
        laporan.barisKosong();

        laporan.cetakDaftar("REKENING AKHIR", semua);
        laporan.cetakTotal(semua);
    }
}