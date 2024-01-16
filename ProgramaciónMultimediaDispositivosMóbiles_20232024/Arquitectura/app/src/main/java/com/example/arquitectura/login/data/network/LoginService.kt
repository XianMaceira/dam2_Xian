package com.example.arquitectura.login.data.network

import com.example.arquitectura.core.network.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoginService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun doLogin(user:String, password:String): Boolean{
        return withContext(Dispatchers.IO){

            val response = retrofit.create(LoginClient::class.java).doLogin()
            response.body()?.success ?: false /*Devuelve false en caso de que no obtengamos respuesta*/

        }
    }
}