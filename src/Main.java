import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.time.LocalTime;

// Superclass Musikal
abstract class Musikal {
    protected String judul;
    protected String komposer;
    protected int tahunRilis;

    public Musikal(String judul, String komposer, int tahunRilis) {
        this.judul = judul;
        this.komposer = komposer;
        this.tahunRilis = tahunRilis;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getKomposer() {
        return komposer;
    }

    public void setKomposer(String komposer) {
        this.komposer = komposer;
    }

    public int getTahunRilis() {
        return tahunRilis;
    }

    public void setTahunRilis(int tahunRilis) {
        this.tahunRilis = tahunRilis;
    }

    public abstract void tampilkanInfo();
}

// Subclass DramaMusikal
class DramaMusikal extends Musikal {
    private int durasi;

    public DramaMusikal(String judul, String komposer, int tahunRilis, int durasi) {
        super(judul, komposer, tahunRilis);
        this.durasi = durasi;
    }

    public int getDurasi() {
        return durasi;
    }

    public void setDurasi(int durasi) {
        this.durasi = durasi;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Drama Musikal - Judul: " + judul + ", Komposer: " + komposer + ", Tahun Rilis: " + tahunRilis + ", Durasi: " + durasi + " menit");
    }
}

// Subclass KonserMusikal
class KonserMusikal extends Musikal {
    private String lokasiRilis;

    public KonserMusikal(String judul, String komposer, int tahunRilis, String lokasiRilis) {
        super(judul, komposer, tahunRilis);
        this.lokasiRilis = lokasiRilis;
    }

    public String getLokasiRilis() {
        return lokasiRilis;
    }

    public void setLokasiRilis(String lokasiRilis) {
        this.lokasiRilis = lokasiRilis;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Konser Musikal - Judul: " + judul + ", Komposer: " + komposer + ", Tahun Rilis: " + tahunRilis + ", Lokasi Rilis: " + lokasiRilis);
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {
        List<Musikal> daftarMusikal = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Input identitas pengguna
        System.out.println("Silahkan masukkan identitas Anda:");
        System.out.print("Nama    : ");
        String nama = scanner.nextLine();
        System.out.print("NIM     : ");
        String nim = scanner.nextLine();
        System.out.print("Jurusan : ");
        String jurusan = scanner.nextLine();

        // Menambahkan beberapa data musikal
        daftarMusikal.add(new DramaMusikal("Phantom of the Opera", "Andrew Lloyd Webber", 1986, 120));
        daftarMusikal.add(new KonserMusikal("Bohemian Rhapsody", "Queen", 1985, "Britania Raya"));
        daftarMusikal.add(new DramaMusikal("Les Misérables", "Claude-Michel Schönberg", 1985, 180));
        daftarMusikal.add(new KonserMusikal("The Lion King", "Elton John, Hans Zimmer", 1997, "New York"));
        daftarMusikal.add(new DramaMusikal("Chicago", "John Kander", 1975, 150));

        LocalTime waktuSekarang = LocalTime.now();
        String greeting;
        // Menentukan ucapan berdasarkan waktu
        if (waktuSekarang.isBefore(LocalTime.NOON)) {
            greeting = "Selamat Pagi";
        } else if (waktuSekarang.isBefore(LocalTime.of(12, 0))) {
            greeting = "Selamat Siang";
        } else if (waktuSekarang.isBefore(LocalTime.of(15, 0))) {
            greeting = "Selamat Sore";
        } else {
            greeting = "Selamat Malam";
        }

        // Validasi identitas pengguna
        System.out.println("\nApakah benar NIM Anda: " + nim + "? (benar/salah)");
        String validasiNim = scanner.nextLine();
        if (!validasiNim.equalsIgnoreCase("benar")) {
            System.out.print("Masukkan NIM baru: ");
            nim = scanner.nextLine(); // Mengedit NIM jika tidak valid
        }

        System.out.println("Apakah benar Jurusan Anda: " + jurusan + "? (benar/salah)");
        String validasiJurusan = scanner.nextLine();
        if (!validasiJurusan.equalsIgnoreCase("benar")) {
            System.out.print("Masukkan Jurusan baru: ");
            jurusan = scanner.nextLine(); // Mengedit jurusan jika tidak valid
        }

        
        System.out.println("\n==============================");
        System.out.println("Halo, "+ greeting +", " + nama + "!");
        System.out.println("==============================");

        // Header program
        System.out.println("\n*******************************");
        System.out.println("WELCOME TO THE MUSIC THEATRICAL");
        System.out.println("   BY SHOFIE ARDHYA SHAFINA    ");
        System.out.println("          INFORMATIKA          ");
        System.out.println("      24111814070/2024A        ");
        System.out.println("********************************");

        boolean continueSorting = true; // Menambahkan fitur sorting ulang

        // Inner class untuk operasi sorting
        class SortMusikal {
            void sortByJudul() {
                Collections.sort(daftarMusikal, Comparator.comparing(Musikal::getJudul));
            }

            void sortByKomposer() {
                Collections.sort(daftarMusikal, Comparator.comparing(Musikal::getKomposer));
            }

            void sortByTahunRilis() {
                Collections.sort(daftarMusikal, Comparator.comparingInt(Musikal::getTahunRilis));
            }

            void sortByDurasi() {
                Collections.sort(daftarMusikal, (m1, m2) -> {
                    if (m1 instanceof DramaMusikal && m2 instanceof DramaMusikal) {
                        return Integer.compare(((DramaMusikal) m1).getDurasi(), ((DramaMusikal) m2).getDurasi());
                    }
                    return 0;
                });
            }

            void sortByLokasiRilis() {
                Collections.sort(daftarMusikal, (m1, m2) -> {
                    if (m1 instanceof KonserMusikal && m2 instanceof KonserMusikal) {
                        return ((KonserMusikal) m1).getLokasiRilis().compareTo(((KonserMusikal) m2).getLokasiRilis());
                    }
                    return 0;
                });
            }
        }

        SortMusikal sorter = new SortMusikal();

        while (continueSorting) {
            // Meminta user memilih kriteria sorting
            System.out.println("\nSilahkan Pilih Identifikasi: ");
            System.out.println("1. Judul");
            System.out.println("2. Komposer");
            System.out.println("3. Tahun Rilis");
            System.out.println("4. Durasi (khusus DramaMusikal)");
            System.out.println("5. Lokasi Rilis (khusus KonserMusikal)");
            System.out.print("Masukkan pilihan anda (1-5): ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer

            switch (pilihan) {
                case 1:
                    sorter.sortByJudul();
                    System.out.println("\nDaftar Musikal Setelah Sorting Berdasarkan Judul:");
                    for (Musikal musikal : daftarMusikal) {
                        System.out.println(musikal.getJudul());
                    }
                    break;
                case 2:
                    sorter.sortByKomposer();
                    System.out.println("\nDaftar Musikal Setelah Sorting Berdasarkan Komposer:");
                    for (Musikal musikal : daftarMusikal) {
                        System.out.println(musikal.getKomposer());
                    }
                    break;
                case 3:
                    sorter.sortByTahunRilis();
                    System.out.println("\nDaftar Musikal Setelah Sorting Berdasarkan Tahun Rilis:");
                    for (Musikal musikal : daftarMusikal) {
                        System.out.println(musikal.getTahunRilis());
                    }
                    break;
                case 4:
                    sorter.sortByDurasi();
                    System.out.println("\nDaftar Musikal Setelah Sorting Berdasarkan Durasi (khusus DramaMusikal):");
                    for (Musikal musikal : daftarMusikal) {
                        if (musikal instanceof DramaMusikal) {
                            System.out.println(((DramaMusikal) musikal).getDurasi() + " menit");
                        }
                    }
                    break;
                case 5:
                    sorter.sortByLokasiRilis();
                    System.out.println("\nDaftar Musikal Setelah Sorting Berdasarkan Lokasi Rilis (khusus KonserMusikal):");
                    for (Musikal musikal : daftarMusikal) {
                        if (musikal instanceof KonserMusikal) {
                            System.out.println(((KonserMusikal) musikal).getLokasiRilis());
                        }
                    }
                    break;
                default:
                    System.out.println("Maaf, Pilihan tidak valid. Silahkan coba lagi.");
                    continue;
            }

            // Menanyakan apakah user ingin melakukan sorting lagi
            System.out.print("\nApakah Anda ingin melakukan sorting lagi? (ya/tidak): ");
            String jawab = scanner.nextLine();
            if (!jawab.equalsIgnoreCase("ya")) {
                continueSorting = false;
                System.out.println("Terima Kasih " + nama + ", Telah Menggunakan Sorting Ini!");
            }
        }

        scanner.close(); // Menutup Scanner
    }
}