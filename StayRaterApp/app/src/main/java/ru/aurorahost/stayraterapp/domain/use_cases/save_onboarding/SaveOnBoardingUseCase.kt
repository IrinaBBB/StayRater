package ru.aurorahost.stayraterapp.domain.use_cases.save_onboarding

import ru.aurorahost.stayraterapp.data.repository.Repository


class SaveOnBoardingUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(completed: Boolean) {
        repository.saveOnBoardingState(completed = completed)
    }
}