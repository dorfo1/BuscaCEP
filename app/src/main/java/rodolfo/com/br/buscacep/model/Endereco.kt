package rodolfo.com.br.buscacep.model

import com.google.gson.annotations.SerializedName

data class Endereco(
        val cep: String,
        val logradouro: String,
        val complemente : String,
        val bairro : String,
        val localidade : String,
        @SerializedName("uf")
        val estado : String
)