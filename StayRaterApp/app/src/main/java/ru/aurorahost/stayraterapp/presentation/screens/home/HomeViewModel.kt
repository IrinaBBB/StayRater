package ru.aurorahost.stayraterapp.presentation.screens.home
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.aurorahost.stayraterapp.domain.use_cases.UseCases
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    useCases: UseCases
): ViewModel() {
    val getAllHotels = useCases.getAllHotelsUseCase()
}