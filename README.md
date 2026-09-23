## Persiapan Praktik

1. Buka proyek Kotlin dengan Jetpack Compose di Android Studio.
2. Pastikan sinkronisasi Gradle selesai dan emulator atau perangkat Android siap.
3. Buka `MainActivity.kt` dan pertahankan deklarasi `package` milik proyek.
4. Gunakan kerangka berikut sebagai tempat demonstrasi.

```kotlin
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DemoKotlin()
        }
    }
}

@Composable
fun DemoKotlin() {
    Text(
        text = "Belajar Dasar Kotlin",
        modifier = Modifier.padding(32.dp)
    )
}
```

> **Cara memakai contoh:** ganti kode tahap sebelumnya, bukan menempelkan seluruh potongan sekaligus. Hindari deklarasi `DemoKotlin()` atau variabel dengan nama sama berulang dalam scope yang sama. Fungsi logika diletakkan di luar class `MainActivity` dan di luar `DemoKotlin()`.

> Compose digunakan sebagai tempat menampilkan hasil. Pembahasan utama sesi ini adalah dasar Kotlin; Activity, lifecycle, dan UI Compose dibahas lebih lanjut pada materi berikutnya.

---

## Bagian 1 — Kotlin dalam pengembangan Android

**Tujuan:** mahasiswa membedakan bahasa, IDE, SDK, platform, dan UI toolkit.

| Istilah | Peran |
| --- | --- |
| Kotlin | Bahasa untuk menulis instruksi dan data aplikasi |
| Android Studio | IDE untuk menulis, mengelola, dan menjalankan proyek |
| Android SDK | Kumpulan alat dan API untuk pengembangan Android |
| Android | Platform tempat aplikasi berjalan |
| Jetpack Compose | Toolkit untuk membuat UI menggunakan Kotlin |

**Pembuka:** “Kita akan membuat aplikasi yang menyimpan nama dan nilai mahasiswa, menentukan grade serta kelulusan, lalu menampilkan hasilnya.”

**Live coding:** ganti teks awal menjadi `"Aplikasi Nilai Mahasiswa"`, lalu jalankan aplikasi. Jelaskan bahwa `Text` menampilkan hasil dan `setContent` menetapkan konten Compose. Detail Activity dibahas pada sesi berikutnya.

**Analogi:** Kotlin adalah bahasa instruksi; Android Studio adalah ruang kerja; SDK adalah perangkat pengembangan; Compose menyediakan komponen tampilan.

**Transisi:** “Judul sudah muncul. Sekarang, bagaimana cara menyimpan nama dan nilai mahasiswa?”

---

## Bagian 2 — Struktur program, variabel, dan tipe data

**Tujuan:** mahasiswa memahami `val`, `var`, tipe data, type inference, dan string template.

Kenalkan dahulu bentuk program Kotlin konsol:

```kotlin
fun main() {
    println("Hello Android!")
}
```

Program konsol menggunakan `main()` sebagai entry point. Pada praktik Android ini, sistem mengaktifkan Activity dan hasil ditampilkan melalui `Text`. Tidak perlu menambahkan `main()` ke alur UI Android.

**Live coding di dalam `DemoKotlin()`:**

```kotlin
val nama = "Titin"
val nilai = 85

Text(
    text = "Nama: $nama\nNilai: $nilai",
    modifier = Modifier.padding(32.dp)
)
```

Lanjutkan secara bertahap:

1. Tambahkan tipe eksplisit: `val nama: String = "Titin"` dan `val nilai: Int = 85`.
2. Jelaskan bahwa tipe tetap ada meskipun tidak ditulis; compiler menyimpulkannya dari nilai awal.
3. Coba reassignment `nilai = 90` pada `val`, tunjukkan error, lalu ganti menjadi `var`.
4. Kenalkan `Boolean`, `Double`, `Float`, `Long`, dan `Char` dengan contoh singkat. Tekankan `'A'` adalah Char, sedangkan `"A"` adalah String.
5. Jelaskan `$nama`, `${nilai + 5}`, dan `\n`.

**Analogi:** variabel seperti kotak berlabel; tipe menentukan jenis nilai yang boleh disimpan.

**Cek pemahaman:** apakah `var nilai = 85` boleh diubah menjadi `"Bagus"`? Tidak, karena tipe variabel tetap `Int`.

**Catatan:** reassignment sebelum `Text` dijalankan membuat hasil akhir langsung tampil. Ini belum demonstrasi state interaktif. `val` membatasi reassignment, bukan menjamin seluruh isi objek tidak dapat berubah.

**Transisi:** “Bagaimana kalau data nama belum tersedia?”

---

## Bagian 3 — Null safety

**Tujuan:** mahasiswa memahami nullable type, safe call, Elvis operator, dan risiko `!!`.

**Urutan live coding:**

1. Coba `val nama: String = null` untuk menunjukkan error tipe.
2. Perbaiki menjadi `val nama: String? = null`.
3. Tambahkan fallback dan safe call:

```kotlin
val nama: String? = null
val namaTampilan = nama ?: "Guest"
val panjangNama = nama?.length ?: 0

Text(
    text = "Nama: $namaTampilan\nJumlah huruf: $panjangNama",
    modifier = Modifier.padding(32.dp)
)
```

| Nilai `nama` | `namaTampilan` | `panjangNama` |
| --- | --- | --- |
| `"Titin"` | `Titin` | `5` |
| `null` | `Guest` | `0` |
| `""` | String kosong | `0` |

- `String?`: boleh berupa String atau `null`.
- `?.`: akses properti hanya jika nilai tidak `null`; jika `null`, hasil ekspresi ini `null`.
- `?:`: memilih nilai pengganti ketika sisi kiri `null`.
- `!!`: menganggap nilai tidak `null`; terjadi `NullPointerException` jika anggapan salah.

**Analogi:** jika nama pengunjung belum tersedia, gunakan sebutan “Guest”. String kosong berbeda dari data yang tidak tersedia.

**Cek pemahaman:** apakah `"" ?: "Guest"` menghasilkan Guest? Tidak.

**Transisi:** “Nama sudah aman ditampilkan. Sekarang kita tentukan hasil berdasarkan nilai.”

---

## Bagian 4 — Operator dan control flow

**Tujuan:** mahasiswa dapat menelusuri perhitungan, percabangan, dan perulangan.

**Tahap A — perhitungan dan keputusan:**

```kotlin
val nilaiAwal = 75
val bonus = 5
val nilaiAkhir = nilaiAwal + bonus

val status = if (nilaiAkhir >= 60) "Lulus" else "Tidak Lulus"

val grade = when {
    nilaiAkhir >= 80 -> "A"
    nilaiAkhir >= 70 -> "B"
    nilaiAkhir >= 60 -> "C"
    else -> "D"
}
```

Tampilkan `namaTampilan`, `nilaiAkhir`, `grade`, dan `status` melalui satu `Text`. Uji nilai 59, 60, 74, dan 80 dengan bonus 0.
Tekankan bahwa `if` dapat menghasilkan nilai dan `when` memilih cabang pertama yang benar. Untuk kondisi ambang pada contoh ini, urutkan dari nilai tertinggi.

**Tahap B — pengenalan operator:**

| Kelompok | Contoh | Penjelasan |
| --- | --- | --- |
| Aritmatika | `+`, `-`, `*`, `/`, `%` | Perhitungan; `5 / 2` menghasilkan 2, sedangkan `5 / 2.0` menghasilkan 2.5 |
| Perbandingan | `==`, `!=`, `>`, `<`, `>=`, `<=` | Menghasilkan Boolean; bedakan assignment `=` dan perbandingan `==` |
| Logika | `&&`, `\|\|`, `!` | Kedua kondisi benar, minimal satu kondisi benar, dan membalik Boolean |

Contoh variasi: `nilaiAkhir >= 60 && kehadiran >= 75`. Aturan kelulusan utama latihan tetap berdasarkan nilai agar konsisten dengan modul.

**Tahap C — perulangan:** sementara ganti isi `DemoKotlin()` dengan demonstrasi berikut.

```kotlin
var daftarLatihan = ""
for (nomor in 1..3) {
    daftarLatihan += "Latihan ke-$nomor\n"
}

Text(
    text = daftarLatihan,
    modifier = Modifier.padding(32.dp)
)
```

Tunjukkan versi `while` sebagai pengganti loop `for`:

```kotlin
var nomor = 1
while (nomor <= 3) {
    daftarLatihan += "Latihan ke-$nomor\n"
    nomor++
}
```

Mulai ulang `daftarLatihan` dari string kosong sebelum menjalankan versi `while`. Kenalkan pula `1..5 step 2` dan `3 downTo 1`. Jangan menjalankan loop tanpa akhir pada UI.

**Analogi:** percabangan adalah pemeriksaan syarat; perulangan adalah menjalankan pekerjaan serupa untuk setiap item.

**Cek pemahaman:** mengapa nilai 90 menghasilkan C jika kondisi `>= 60` ditempatkan pertama? Mengapa `while` memerlukan perubahan kondisi?

**Sebelum lanjut:** kembalikan tampilan ke aplikasi nilai. Demo loop adalah latihan terpisah, tidak wajib dipertahankan pada kode akhir sesi.

**Transisi:** “Aturan ini sudah berjalan. Bagaimana agar bisa dipakai ulang tanpa menyalin percabangannya?”

---

## Bagian 5 — Function

**Tujuan:** mahasiswa memisahkan logika dan memahami parameter, argument, return, default argument, named argument, serta `Unit`.

Pindahkan aturan status ke fungsi biasa di luar `DemoKotlin()` dan di luar class `MainActivity`:

```kotlin
fun tentukanStatus(nilai: Int): String {
    return if (nilai >= 60) "Lulus" else "Tidak Lulus"
}
```

Di `DemoKotlin()`, panggil dengan `val status = tentukanStatus(nilaiAkhir)`. Lakukan hal yang sama untuk grade.

| Istilah | Contoh |
| --- | --- |
| Parameter | `nilai: Int` pada deklarasi fungsi |
| Argument | `85` pada `tentukanStatus(85)` |
| Return type | `: String` setelah daftar parameter |
| Return value | `"Lulus"` atau `"Tidak Lulus"` yang dikembalikan |

Tambahkan fungsi bonus untuk menunjukkan default dan named argument:

```kotlin
fun hitungNilaiAkhir(nilaiAwal: Int, bonus: Int = 0): Int {
    return nilaiAwal + bonus
}

// Contoh pemanggilan di dalam fungsi:
// hitungNilaiAkhir(75)                       menghasilkan 75
// hitungNilaiAkhir(75, 5)                    menghasilkan 80
// hitungNilaiAkhir(nilaiAwal = 75, bonus = 5) menghasilkan 80
```

Setelah bentuk panjang dipahami, tunjukkan bentuk single-expression:

```kotlin
fun hitungNilaiAkhir(nilaiAwal: Int, bonus: Int = 0): Int =
    nilaiAwal + bonus
```

Kedua bentuk adalah alternatif, bukan dua fungsi yang ditempel bersamaan.
Kenalkan `Unit` dengan fungsi tanpa hasil bermakna:

```kotlin
fun cetakPesan(): Unit {
    println("Perhitungan selesai")
}
```

Penulisan `: Unit` biasanya boleh dihilangkan. `println` mencetak keluaran, sedangkan `return` mengembalikan hasil yang dapat digunakan pemanggil. `println` tidak menampilkan teks pada UI Android.

**Analogi:** function seperti mesin yang menerima input, menjalankan aturan, dan menghasilkan output.

**Cek pemahaman:** apakah `tentukanStatus()` perlu `@Composable`? Tidak; fungsi ini hanya mengolah data. `DemoKotlin()` memakai `@Composable` karena memanggil UI Compose.

---

## Kode Akhir Bagian 1–5

Gunakan kerangka `MainActivity` dan import pada bagian persiapan. Ganti fungsi `DemoKotlin()` lama dengan kode berikut beserta fungsi logikanya. Semua fungsi di bawah diletakkan di luar class `MainActivity`.

```kotlin
fun hitungNilaiAkhir(nilaiAwal: Int, bonus: Int = 0): Int {
    return nilaiAwal + bonus
}

fun tentukanStatus(nilai: Int): String {
    return if (nilai >= 60) "Lulus" else "Tidak Lulus"
}

fun tentukanGrade(nilai: Int): String {
    return when {
        nilai >= 80 -> "A"
        nilai >= 70 -> "B"
        nilai >= 60 -> "C"
        else -> "D"
    }
}

@Composable
fun DemoKotlin() {
    val nama: String? = null
    val namaTampilan = nama ?: "Guest"

    val nilaiAkhir = hitungNilaiAkhir(
        nilaiAwal = 75,
        bonus = 5
    )

    val grade = tentukanGrade(nilaiAkhir)
    val status = tentukanStatus(nilaiAkhir)

    Text(
        text = "Nama: $namaTampilan\n" +
            "Nilai akhir: $nilaiAkhir\n" +
            "Grade: $grade\n" +
            "Status: $status",
        modifier = Modifier.padding(32.dp)
    )
}
```

Output yang diharapkan:

```text
Nama: Guest
Nilai akhir: 80
Grade: A
Status: Lulus
```

**Asumsi latihan:** nilai akhir berada dalam rentang 0–100. Validasi rentang belum diterapkan. Aturan grade mengikuti contoh modul, bukan pernyataan tentang aturan penilaian resmi kampus. Data masih tetap; belum ada form, tombol, atau state interaktif.