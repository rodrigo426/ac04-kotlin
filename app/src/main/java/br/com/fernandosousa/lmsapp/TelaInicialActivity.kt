package br.com.fernandosousa.lmsapp

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.support.v7.widget.SearchView
import android.support.v7.widget.Toolbar
import android.widget.TextView
import android.widget.Toast


class TelaInicialActivity : DebugActivity() {

    private val context: Context get() = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)


        val args = intent.extras

        val nome = args.getString("nome")

        val numero = intent.getIntExtra("nome",0)

        Toast.makeText(context, "Parâmetro: $nome", Toast.LENGTH_LONG).show()
        Toast.makeText(context, "Numero: $numero", Toast.LENGTH_LONG).show()

        val mensagem = findViewById<TextView>(R.id.mensagemInicial)
        mensagem.text = "Bem vindo $nome"

        val botaoSair = findViewById<Button>(R.id.botaoSair)
        botaoSair.setOnClickListener {cliqueSair()}


        var toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.title = "Disciplinas"

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    fun cliqueSair() {
        val returnIntent = Intent();
        returnIntent.putExtra("result","Saída da tela inicial");
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_main, menu)

        (menu?.findItem(R.id.action_buscar)?.actionView as SearchView).setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {

                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {

                return false
            }

        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId
        if  (id == R.id.action_buscar) {
            Toast.makeText(context, "Botão de buscar", Toast.LENGTH_LONG).show()
        } else if (id == R.id.action_atualizar) {
            Toast.makeText(context, "Botão de atualizar", Toast.LENGTH_LONG).show()
        } else if (id == R.id.action_config) {
            Toast.makeText(context, "Botão de configuracoes", Toast.LENGTH_LONG).show()
        }
        // botão up navigation
        else if (id == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }


}
