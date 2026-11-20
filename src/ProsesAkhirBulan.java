public class ProsesAkhirBulan {

    public void potongBiayaAdmin(Rekening[] semua) {
        for (Rekening r : semua) {
            long biaya = r.biayaAdmin();
            r.kenakanBiaya(biaya);
            System.out.printf("%d biaya admin  : %s%n", r.getNomor(), Rekening.rupiah(biaya));
        }
    }

    public void tambahBunga(BerBunga[] berbunga) {
        for (BerBunga b : berbunga) {
            long bunga = b.tambahBunga();
            System.out.printf("%d bunga        : %s%n", b.getNomor(), Rekening.rupiah(bunga));
        }
    }

    public void autodebet(Rekening[] semua, int jumlah) {
        for (Rekening r : semua) {
            if (r.tarik(jumlah)) {
                System.out.printf("%d autodebet    : %s%n", r.getNomor(), Rekening.rupiah(jumlah));
            } else {
                System.out.printf("%d autodebet    : gagal%n", r.getNomor());
            }
        }
    }
}