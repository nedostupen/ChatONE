package info.fandroid.chat.presentation.injection

import dagger.Module
import dagger.Provides
import info.fandroid.chat.BuildConfig
import info.fandroid.chat.data.account.AccountRemote
import info.fandroid.chat.remote.account.AccountRemoteImpl
import info.fandroid.chat.remote.core.Request
import info.fandroid.chat.remote.service.ApiService
import info.fandroid.chat.remote.service.ServiceFactory
import javax.inject.Singleton

@Module
class RemoteModule {

    @Singleton
    @Provides
    fun provideApiService(): ApiService = ServiceFactory.makeService(BuildConfig.DEBUG)

    @Singleton
    @Provides
    fun provideAccountRemote(request: Request, apiService: ApiService): AccountRemote {
        return AccountRemoteImpl(request, apiService)
    }
}