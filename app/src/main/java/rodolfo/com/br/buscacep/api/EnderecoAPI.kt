package rodolfo.com.br.buscacep.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import rodolfo.com.br.buscacep.model.Endereco

interface EnderecoAPI{
    @GET("ws/{cep}/json/")
    fun buscarCEP(@Path("cep") cep: String):Call<Endereco>
}