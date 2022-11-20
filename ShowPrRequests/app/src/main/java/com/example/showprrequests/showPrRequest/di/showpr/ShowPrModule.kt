package com.example.showprrequests.showPrRequest.di.showpr

import androidx.lifecycle.ViewModelProvider
import com.example.showprrequests.showPrRequest.domain.ShowPrListRepository
import com.example.showprrequests.showPrRequest.domain.ShowPrListRepositoryImpl
import com.example.showprrequests.showPrRequest.domain.ShowPrListService
import com.example.showprrequests.showPrRequest.domain.ShowPrListUseCase
import com.example.showprrequests.showPrRequest.presentation.ShowPrVmFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module(subcomponents = [ShowPrComponent::class])
class ShowPrModule {

  @Provides
  fun providesShowPrService(retrofit: Retrofit): ShowPrListService {
      return retrofit.create(ShowPrListService::class.java)
  }

  @Provides
  fun providesViewModelFactory(viewModeUseCase: ShowPrListUseCase):ViewModelProvider.Factory{
       return ShowPrVmFactory(viewModeUseCase)
  }

  @Provides
  fun providesPrListUseCase( showPrListRepository: ShowPrListRepository):ShowPrListUseCase{
      return ShowPrListUseCase(showPrListRepository)
  }

  @Provides
  fun providesShowPrListRepository(showPrListService: ShowPrListService):ShowPrListRepository{
      return ShowPrListRepositoryImpl(showPrListService)
  }

}