package com.forpost.testapp.domain.di

import com.forpost.testapp.data.RestClient
import com.forpost.testapp.data.UserService
import com.forpost.testapp.data.repostitory.UserRepository
import com.forpost.testapp.data.repostitory.UserRepositoryIml
import com.forpost.testapp.domain.usecase.UserListUseCase
import com.forpost.testapp.presentation.UserViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

object AppInjector {

    fun setup() {
        startKoin {
            modules(listOf(viewModelsModule, networkModule, repositoryModule))
        }
    }

    private val networkModule = module {
        single<UserService> { RestClient.provideRetrofit().create(UserService::class.java) }
    }


    private val repositoryModule = module {
        factory<UserRepository> { UserRepositoryIml(get()) }
    }

    private val viewModelsModule = module {
        viewModel {
            UserViewModel(
                UserListUseCase(get())
            )
        }
    }
}