import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.http.ContentType.Application.Json
import model.Results
import model.Station
import kotlinx.serialization.*
import kotlinx.serialization.json.JSON

expect fun platformName(): String

fun createApplicationScreenMessage(): String {
    return "ちんちん ${platformName()}"
}

suspend fun sequentialRequests() :String {
    val client = HttpClient()

    // Get the content of an URL.
    val firstBytes = client.get<ByteArray>("https://webservice.recruit.co.jp/manabi/station/v2?prefecture=13&key=3e2b4a21beb30b57&format=json&start=0")

    // Once the previous request is done, get the content of an URL.
    val secondBytes = client.get<ByteArray>("https://127.0.0.1:8080/b")

    // parsing data back
    val obj = JSON.parse(Station.serializer(), """{"a":42}""")
    println(obj) // MyModel(a=42, b="42")

    client.close()

    return obj.results.api_version
}
