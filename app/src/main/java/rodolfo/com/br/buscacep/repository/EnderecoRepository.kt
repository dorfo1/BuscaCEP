package rodolfo.com.br.buscacep.repository

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import rodolfo.com.br.buscacep.api.getEnderecoAPI
import rodolfo.com.br.buscacep.model.Endereco

class EnderecoRepository{
    fun buscar(cep:String, onComplete:(Endereco?) -> Unit, onError:(Throwable?) -> Unit){
        getEnderecoAPI().buscarCEP(cep)
                .enqueue(object : Callback<Endereco>{
                    override fun onFailure(call: Call<Endereco>?, t: Throwable?) {
                      onError(t)
                    }

                    override fun onResponse(call: Call<Endereco>?, response: Response<Endereco>?) {
                        if(response?.isSuccessful == true){
                            onComplete(response?.body())
                        }else{
                            onError(Throwable("Não foi possivel buscar o CEP"))
                        }
                    }

                })
    }
}