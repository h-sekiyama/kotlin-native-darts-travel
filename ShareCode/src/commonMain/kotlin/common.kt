import io.ktor.client.HttpClient
import io.ktor.client.request.get
import model.Station

expect fun platformName(): String

fun createApplicationScreenMessage(): String {
    return "ちんちん ${platformName()}"
}

suspend fun sequentialRequests() {
    val client = HttpClient()

    // Get the content of an URL.
    val firstBytes = client.get<ByteArray>("https://webservice.recruit.co.jp/manabi/station/v2?prefecture=13&key=3e2b4a21beb30b57&format=json&start=0")

    // Once the previous request is done, get the content of an URL.
    val secondBytes = client.get<ByteArray>("https://127.0.0.1:8080/b")
//
    val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    val adapter = moshi.adapter(Events::class.java)
    val res = adapter.fromJson(firstBytes)

    client.close()
}
