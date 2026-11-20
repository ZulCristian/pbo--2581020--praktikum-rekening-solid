public class LaporanBank {

    public void cetakJudul(String judul) {
        String kiri = "========== " + judul + " ";
        StringBuilder sb = new StringBuilder(kiri);
        while (sb.length() < 46) {
            sb.append('=');
        }
        System.out.println(sb);
    }

    public void cetakDaftar(String judul, Rekening[] semua) {
        cetakJudul(judul);
        for (Rekening r : semua) {
            System.out.printf("%d | %-6s | %12s%n",
                    r.getNomor(), r.getPemilik(), Rekening.rupiah(r.getSaldo()));
            System.out.println("      " + r.keterangan());
        }
    }

    public void cetakTotal(Rekening[] semua) {
        long total = 0;
        for (Rekening r : semua) {
            total += r.getSaldo();
        }
        System.out.println("-----------------------------------");
        System.out.println("Total dana bank : " + Rekening.rupiah(total));
    }

    public void barisKosong() {
        System.out.println();
    }
}