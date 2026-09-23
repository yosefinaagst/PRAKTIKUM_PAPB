package com.example.papbmodul

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.papbmodul.ui.theme.PAPBModulTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
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

//@Composable
//fun DemoKotlin() {
//    Text(
//        text = "Aplikasi Nilai Mahasiswa",
//        modifier = Modifier.padding(32.dp)
//    )
//}

//@Composable
//fun DemoKotlin() {
//    val nama = "Titin"
//    val nilai = 85
//
//    Text(
//        text = "Nama: $nama\nNilai: $nilai",
//        modifier = Modifier.padding(32.dp)
//    )
//}

//var dan val
//val nilai = 85
//nilai = 90
//var nilai = 85
//nilai = 90

//null safety
//@Composable
//fun DemoKotlin() {
//    val nama: String? = null
//    val nilai = 85
//
//    val namaTampilan = nama ?: "Guest"
//
//    Text(
//        text = "Nama: $namaTampilan\nNilai: $nilai",
//        modifier = Modifier.padding(32.dp)
//    )
//}

//bentuk kode keseluruhan
//fun hitungNilaiAkhir(nilaiAwal: Int, bonus: Int = 0): Int {
//    return nilaiAwal + bonus
//}
//
//fun tentukanStatus(nilai: Int): String {
//    return if (nilai >= 60) "Lulus" else "Tidak Lulus"
//}
//
//fun tentukanGrade(nilai: Int): String {
//    return when {
//        nilai >= 80 -> "A"
//        nilai >= 70 -> "B"
//        nilai >= 60 -> "C"
//        else -> "D"
//    }
//}
//
//@Composable
//fun DemoKotlin() {
//    val nama: String? = null
//    val namaTampilan = nama ?: "Guest"
//
//    val nilaiAkhir = hitungNilaiAkhir(
//        nilaiAwal = 75,
//        bonus = 5
//    )
//
//    val grade = tentukanGrade(nilaiAkhir)
//    val status = tentukanStatus(nilaiAkhir)
//
//    Text(
//        text = "Nama: $namaTampilan\n" +
//                "Nilai akhir: $nilaiAkhir\n" +
//                "Grade: $grade\n" +
//                "Status: $status",
//        modifier = Modifier.padding(32.dp)
//    )
//}