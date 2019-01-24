package rodolfo.com.br.buscacep.api

import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient<T>{
    fun getClient(c: Class<T>): T{

        val okhttp = OkHttpClient.Builder()
                .addNetworkInterceptor(StethoInterceptor())
                .build();

        val retrofit = Retrofit.Builder().baseUrl("https://viacep.com.br/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okhttp)
                .build()

        return retrofit.create(c)
    }
}

fun getEnderecoAPI(): EnderecoAPI{
    return RetrofitClient<EnderecoAPI>().getClient(EnderecoAPI::class.java)
}