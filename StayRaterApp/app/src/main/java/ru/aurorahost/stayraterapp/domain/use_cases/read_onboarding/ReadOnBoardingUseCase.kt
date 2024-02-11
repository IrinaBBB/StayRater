package ru.aurorahost.stayraterapp.domain.use_cases.read_onboarding

import kotlinx.coroutines.flow.Flow
import ru.aurorahost.stayraterapp.data.repository.Repository

class ReadOnBoardingUseCase(
    private val repository: Repository
) {
    operator fun invoke(): Flow<Boolean> {
        return repository.readOnBoardingState()
    }
}