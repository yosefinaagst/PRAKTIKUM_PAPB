package com.example.papbmodul

import android.os.Bundle
import android.util.Log
import android.widget.Toast
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

//        Toast.makeText(
//            this,
//            "Halo! Ini contoh aja",
//            Toast.LENGTH_SHORT
//        ).show()

    }
}

fun main() {
    var sapaan = "halo"
    var umur = 20
        umur = 21

    println(sapaan)
}


//struktur main
//val var
//panggilan println, pake $, dan {}
//type interface / tipe eksplisit
//tipe data dasar
//null safety atau nullability

//? = boleh null
//?. = kalo null tulis null (safecall akses kalo hanya nilai tidak null)
//?: = berikan nilai pengganti kalo null
//bisa digabung
//assestion not null !! (ga yakin nilai ini tidak null)


fun main2() {
    val sapaan = "halo"
    var umur = 20
    umur = 21

    val status = if (umur >= 17) {
        "Memenuhi batas usia"
    } else {
        "Belum memenuhi batas usia"
    }
//    println(status)

//    val score = 75
//    val grade = when {
//        score >= 80 -> "A"
//        score >= 70 -> "B"
//        score >= 60 -> "C"
//        else -> "D"
//    }
//    println("Grade saya: $grade")

//    for (i in 1..3) {
//        println("Sapaan ke-$i: $sapaan")
//    }

    var daftarProdi = listOf("si", "tif", "pti", "tekkom", "ti")

    for(prodi in daftarProdi) {
        println(prodi)
    }
}

fun main3() {
//    fun calculateTotal(price: Int, qty: Int) = price * qty
//    fun sapaan(nama: String = "Guest") = "Halo, $nama!"
//
//    val total = calculateTotal(50000, 2)
//    val setelahDiskon = total - 10000
//
//    println(total)
//    println(setelahDiskon)
//    println(sapaan())
}





//@Composable
//fun DemoKotlin() {
//    Text(
//        text = "Belajar Dasar Kotlin",
//        modifier = Modifier.padding(32.dp)
//    )
//}

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