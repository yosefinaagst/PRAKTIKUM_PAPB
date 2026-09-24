package com.example.papbmodul

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.papbmodul.ui.theme.PAPBModulTheme

class MainActivity : ComponentActivity() {
    val tag: String = "DEVELOPER TAG"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(tag, "Oncreate Terpanggil")
        enableEdgeToEdge()
        setContent {

            DemoKotlin()
        }

    }
}

@Composable
fun DemoKotlin() {
    val murid = DataStudent(
        name = "Odellia",
        score = 90
    )
//    val hasilObject ;
//    val hasil ;
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Hasil Student Object",
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = "",
            modifier = Modifier.padding(8.dp)
        )
        Spacer(Modifier.height(16.dp))
        Text(
            text = "Hasil Student nama dan score",
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = "",
            modifier = Modifier.padding(8.dp)
        )
    }
}

//bentuk kode keseluruhan
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

// data, class, collection
class auth() {
    fun login() {
        println("login cuy")
    }

    fun logout() {
        println("sudah ter-logout")
    }
}


class Student(
    val name: String,
    val score: Int,
)

data class DataStudent(val name: String, val score: Int)

fun main() {
    //data class
    val data = DataStudent(
        name = "Bigmo",
        score = 75
    )


    val students = listOf<DataStudent>(
        DataStudent("Espi", 90),
        DataStudent("Adeyemi", 88),
        DataStudent("Alvarez", 78),
        DataStudent("Halland", 77),
        DataStudent("Mbappe", 99),
        DataStudent("Bellingham", 92),
        DataStudent("Olise", 78),
        DataStudent("Cunha", 70),
    )

    for (x in students) {
        var msg: String;
        val status: String = tentukanGrade(x.score)
        if (status == "A") msg = "Good Job"
        else msg = "Study More!!!"
        println("${x.name} nilainya dapet ${x.score} nilai akhir ${status}, $msg")
    }

    hasilStudent(
        name = data.name,
        score = data.score,
    )

}

fun getGrade(score: Int): String = when {
    score >= 80 -> "A"
    score >= 70 -> "B"
    score >= 60 -> "C"
    else -> "D"
}

fun getStatus(score: Int): String =
    if (score >= 60) "Lulus" else "Tidak Lulus"

fun hasilStudent(
    name: String,
    score: Int,
): String {

    val grade = getGrade(score)
    val status = getStatus(score)

    return "${name} | ${score} | $grade | $status |"
}

fun hasilStudentObject(
    student: DataStudent,
): String {

    val grade = getGrade(student.score)
    val status = getStatus(student.score)

    return "${student.name} | ${student.score} | $grade | $status |"
}