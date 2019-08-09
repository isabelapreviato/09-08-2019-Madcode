package br.com.isabela.preferenciacompartilhada

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    // Declarar
    // Elementos para o editor de gravação de preferências
    lateinit var minhaPreferencia: SharedPreferences
    lateinit var meuEditor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Vincular ou instanciar
        minhaPreferencia = getSharedPreferences("meusDados", Context.MODE_PRIVATE)
        meuEditor = minhaPreferencia.edit()
    }

    fun gravar(view: View){
        val texto = edtTexto.editableText.toString().trim()
        if(texto.isEmpty()){
            Toast.makeText(this, "Digite um texto", Toast.LENGTH_LONG).show()
        }
        else{
            meuEditor.putString("textoDigitado", texto).commit()
            Toast.makeText(this, "Texto gravado", Toast.LENGTH_LONG).show()
            edtTexto.editableText.clear()
        }
    }

    fun recuperar(view: View){
        txvResultado.text = minhaPreferencia.getString("textoDigitado","Erro")
    }

}

