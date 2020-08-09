package br.com.qagile.qorder.config.retrofit

import br.com.qagile.qorder.api.service.IMenuService
import br.com.qagile.qorder.api.service.ITransacionService
import com.jakewharton.retrofit2.adapter.reactor.ReactorCallAdapterFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Configuration
class RetrofitConfig {

    @Value("\${transaction.service.base}")
    lateinit var transactionServiceBase: String

    @Value("\${menu.service.base}")
    lateinit var menuServiceBase: String

    @Bean
    fun createTransactionService(): ITransacionService =
            Retrofit.Builder()
                    .baseUrl(transactionServiceBase)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(ReactorCallAdapterFactory.create())
                    .build().create(ITransacionService::class.java)
    @Bean
    fun createMenuService(): IMenuService =
            Retrofit.Builder()
                    .baseUrl(menuServiceBase)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(ReactorCallAdapterFactory.create())
                    .build().create(IMenuService::class.java)

}