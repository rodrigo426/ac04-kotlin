package br.com.fernandosousa.lmsapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.*

class MainActivity : DebugActivity() {

    private val context: Context get() = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)


        val imagem = findViewById<ImageView>(R.id.campo_imagem)
        imagem.setImageResource(R.drawable.spa)

        val botaoLogin = findViewById<Button>(R.id.botao_login)

        botaoLogin.setOnClickListener {onClickLogin() }

    }

    fun onClickLogin(){
        val campoUsuario = findViewById<EditText>(R.id.campo_usuario)
        val campoSenha = findViewById<EditText>(R.id.campo_senha)
        val valorUsuario = campoUsuario.text.toString()
        val valorSenha = campoSenha.text.toString()

        val intent = Intent(context, TelaInicialActivity::class.java)

        val params = Bundle()
        params.putString("nome", "$valorUsuario")
        intent.putExtras(params)


       // intent.putExtra("numero", 10)

        if ((campoUsuario.getText().toString().equals("aluno")) && (campoSenha.getText().toString().equals("impacta"))){
            Toast.makeText(getApplication(),
                    " Login efetuado ",
                    Toast.LENGTH_LONG).show();
            startActivityForResult(intent, 1)
        }else{
            Toast.makeText(getApplication(),
                " Erro ",
                Toast.LENGTH_LONG).show();
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 1) {
            val result = data?.getStringExtra("result")
            Toast.makeText(context, "$result", Toast.LENGTH_LONG).show()
        }
    }
}
