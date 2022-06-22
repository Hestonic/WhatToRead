package com.example.pd.data.repository

import android.util.Log
import com.example.pd.data.mapper.AuthorizationDtoMapperImpl
import com.example.pd.data.source.RemoteDataSource
import com.example.pd.domain.repository.AuthorizationRepository
import com.example.pd.ui.model.AuthorizationUiModel
import com.example.pd.ui.model.RegistrationUiModel
import org.json.JSONObject


@Suppress("UNREACHABLE_CODE")
class AuthorizationRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : AuthorizationRepository {
    
    override suspend fun login(authorizationUiModel: AuthorizationUiModel): String? {
        val authorizationDtoModel =
            AuthorizationDtoMapperImpl.mapAuthorizationUiModelToDto(authorizationUiModel)
        val response = remoteDataSource.login(authorizationDtoModel)
        Log.d("response", "response")
        return if (response.isSuccessful) {
            Log.d("response_success", "response_success")
            response.headers()["Authorization"]
        }
        else {
            Log.d("response_msg", response.message())
            Log.d("login_rep_error", response.errorBody().toString())
            response.message()
        }
        return "404"
    }
    
    override suspend fun registration(registrationUiModel: RegistrationUiModel): String? {
        val registrationDtoModel =
            AuthorizationDtoMapperImpl.mapRegistrationUiModelToDto(registrationUiModel)
        val response = remoteDataSource.registration(registrationDtoModel)
        return if (response.isSuccessful) response.headers()["Authorization"]
        else {
            Log.d("registration_rep_error", response.errorBody().toString())
            Log.d("response_msg", response.message())
            Log.d("login_rep_error", response.errorBody().toString())
            response.message()
        }
        return "404"
    }
    
}