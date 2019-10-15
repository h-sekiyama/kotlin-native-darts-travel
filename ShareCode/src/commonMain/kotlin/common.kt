import com.github.kitwtnb.kotlinnativetutorial.model.api.ApiClient
import io.ktor.client.HttpClient
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get
import model.Station
import kotlinx.serialization.*
import kotlinx.serialization.json.JSON

expect fun platformName(): String

fun createApplicationScreenMessage(): String {
    return "ちんちん ${platformName()}"
}

@ImplicitReflectionSerializer
suspend fun sequentialRequests() :String {
    val client = HttpClient()

    val apiUrl = "https://webservice.recruit.co.jp/manabi/station/v2?prefecture=13&key=3e2b4a21beb30b57&format=json&start=0"
    val firstBytes = client.get<String>(apiUrl)

    val apiClient = ApiClient(
        baseUrl = apiUrl,
        serializer = KotlinxSerializer(JSON.nonstrict).also {
            it.setMapper(Station::class, Station.serializer())
        }
    )

    val secondBytes = apiClient.get<String>(apiUrl)


    // parsing data back
    val obj = JSON.parse(Station.serializer(), "firstBytes")

    return obj.results.api_version

//    return "unko"
}