package ru.aurorahost

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.koin.java.KoinJavaComponent.inject
import ru.aurorahost.models.ApiResponse
import ru.aurorahost.models.Hotel
import kotlin.test.Test
import kotlin.test.assertEquals
import ru.aurorahost.repositories.HotelRepository
import ru.aurorahost.repositories.NEXT_PAGE_KEY
import ru.aurorahost.repositories.PREVIOUS_PAGE_KEY

class ApplicationTest {
    private val hotelRepository: HotelRepository by inject(HotelRepository::class.java)

    @Test
    fun `access root endpoint, assert correct information`() {
        withTestApplication(moduleFunction = Application::module) {
            handleRequest(HttpMethod.Get, "/").apply {
                assertEquals(
                    expected = HttpStatusCode.OK,
                    actual = response.status()
                )
                assertEquals(
                    expected = "Welcome to StayRater API!",
                    actual = response.content
                )
            }
        }
    }

    @ExperimentalSerializationApi
    @Test
    fun `access all hotels endpoint, query all pages, assert correct information`() {
        withTestApplication(moduleFunction = Application::module) {
            val pages = 1..5
            val hotels = listOf(
                hotelRepository.page1,
                hotelRepository.page2,
                hotelRepository.page3,
                hotelRepository.page4,
                hotelRepository.page5
            )
            pages.forEach { page ->
                handleRequest(HttpMethod.Get, "/hotels?page=$page").apply {
                    assertEquals(
                        expected = HttpStatusCode.OK,
                        actual = response.status()
                    )
                    val actual = Json.decodeFromString<ApiResponse>(response.content.toString())
                    val expected = ApiResponse(
                        success = true,
                        message = "ok",
                        prevPage = calculatePage(page = page)["prevPage"],
                        nextPage = calculatePage(page = page)["nextPage"],
                        hotels = hotels[page - 1],
                        lastUpdated = actual.lastUpdated
                    )
                    assertEquals(
                        expected = expected,
                        actual = actual
                    )
                }
            }
        }
    }

    @ExperimentalSerializationApi
    @Test
    fun `access all hotels endpoint, query non existing page number, assert error`() {
        withTestApplication(moduleFunction = Application::module) {
            handleRequest(HttpMethod.Get, "/hotels?page=6").apply {
                assertEquals(
                    expected = HttpStatusCode.NotFound,
                    actual = response.status()
                )
                val expected = ApiResponse(
                    success = false,
                    message = "Hotels not Found."
                )
                val actual = Json.decodeFromString<ApiResponse>(response.content.toString())
                assertEquals(
                    expected = expected,
                    actual = actual
                )
            }
        }
    }

    @ExperimentalSerializationApi
    @Test
    fun `access all hotels endpoint, query invalid page number, assert error`() {
        withTestApplication(moduleFunction = Application::module) {
            handleRequest(HttpMethod.Get, "/hotels?page=invalid").apply {
                assertEquals(
                    expected = HttpStatusCode.BadRequest,
                    actual = response.status()
                )
                val expected = ApiResponse(
                    success = false,
                    message = "Only Numbers Allowed."
                )
                val actual = Json.decodeFromString<ApiResponse>(response.content.toString())
                assertEquals(
                    expected = expected,
                    actual = actual
                )
            }
        }
    }

    @ExperimentalSerializationApi
    @Test
    fun `access search hotels endpoint, query hotel name, assert single hotel result`() {
        withTestApplication(moduleFunction = Application::module) {
            handleRequest(HttpMethod.Get, "/search?name=oasis").apply {
                assertEquals(expected = HttpStatusCode.OK, actual = response.status())
                val actual = Json.decodeFromString<List<Hotel>>(response.content.toString())
                    .size
                assertEquals(expected = 1, actual = actual)
            }
        }
    }

    @ExperimentalSerializationApi
    @Test
    fun `access search hotels endpoint, query hotel name, assert multiple hotels result`() {
        withTestApplication(moduleFunction = Application::module) {
            handleRequest(HttpMethod.Get, "/search?name=hotel").apply {
                assertEquals(expected = HttpStatusCode.OK, actual = response.status())
                val actual = Json.decodeFromString<List<Hotel>>(response.content.toString())
                    .size
                assertEquals(expected = 3, actual = actual)
            }
        }
    }

    @ExperimentalSerializationApi
    @Test
    fun `access search hotels endpoint, query an empty text, assert empty list as a result`() {
        withTestApplication(moduleFunction = Application::module) {
            handleRequest(HttpMethod.Get, "/search?name=").apply {
                assertEquals(expected = HttpStatusCode.OK, actual = response.status())
                val actual = Json.decodeFromString<List<Hotel>>(response.content.toString())
                assertEquals(expected = emptyList(), actual = actual)
            }
        }
    }

    @ExperimentalSerializationApi
    @Test
    fun `access search hotels endpoint, query non existing hotel, assert empty list as a result`() {
        withTestApplication(moduleFunction = Application::module) {
            handleRequest(HttpMethod.Get, "/search?name=unknown").apply {
                assertEquals(expected = HttpStatusCode.OK, actual = response.status())
                val actual = Json.decodeFromString<List<Hotel>>(response.content.toString())
                assertEquals(expected = emptyList(), actual = actual)
            }
        }
    }

    @ExperimentalSerializationApi
    @Test
    fun `access non existing endpoint,assert not found`() {
        withTestApplication(moduleFunction = Application::module) {
            handleRequest(HttpMethod.Get, "/unknown").apply {
                assertEquals(expected = HttpStatusCode.NotFound, actual = response.status())
                assertEquals(expected = "Page not Found.", actual = response.content)
            }
        }
    }

}

private fun calculatePage(page: Int): Map<String, Int?> {
    var prevPage: Int? = page
    var nextPage: Int? = page
    if (page in 1..4) {
        nextPage = nextPage?.plus(1)
    }
    if (page in 2..5) {
        prevPage = prevPage?.minus(1)
    }
    if (page == 1) {
        prevPage = null
    }
    if (page == 5) {
        nextPage = null
    }
    return mapOf(PREVIOUS_PAGE_KEY to prevPage, NEXT_PAGE_KEY to nextPage)
}
