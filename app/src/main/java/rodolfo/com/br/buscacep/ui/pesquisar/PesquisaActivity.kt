package rodolfo.com.br.buscacep.ui.pesquisar

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_pesquisa.*
import rodolfo.com.br.buscacep.model.Endereco
import rodolfo.com.br.buscacep.R
import rodolfo.com.br.buscacep.repository.EnderecoRepository


class PesquisaActivity : AppCompatActivity() {

    lateinit var pesquisaViewModel: PesquisaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesquisa)

        Picasso.get().load("https://upload.wikimedia.org/wikipedia/commons/thumb/5/53/Google_%22G%22_Logo.svg/512px-Google_%22G%22_Logo.svg.png").into(iv_logo)

        pesquisaViewModel = ViewModelProviders.of(this).get(PesquisaViewModel::class.java)



        btn_buscar.setOnClickListener{
           pesquisaViewModel.buscar(et_cep.text.toString())
        }

        pesquisaViewModel.endereco.observe(this, Observer {
            tv_dados.text = it.toString()
        })

        pesquisaViewModel.mensagemErro.observe(this, Observer {
            if(!it.equals(""))
            Toast.makeText(this,it,Toast.LENGTH_SHORT).show()
        })

        pesquisaViewModel.isLoading.observe(this, Observer {isLoading ->
            if(isLoading==true){
                loading.visibility = View.VISIBLE
            }else{
                loading.visibility = View.GONE
            }
        })


    }





}
