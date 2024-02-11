package ru.aurorahost.stayraterapp.domain.use_cases

import ru.aurorahost.stayraterapp.domain.use_cases.get_all_hotels.GetAllHotelsUseCase
import ru.aurorahost.stayraterapp.domain.use_cases.read_onboarding.ReadOnBoardingUseCase
import ru.aurorahost.stayraterapp.domain.use_cases.save_onboarding.SaveOnBoardingUseCase

data class UseCases(
    val saveOnBoardingUseCase: SaveOnBoardingUseCase,
    val readOnBoardingUseCase: ReadOnBoardingUseCase,
    val getAllHotelsUseCase: GetAllHotelsUseCase
)