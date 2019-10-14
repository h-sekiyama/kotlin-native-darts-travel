import com.github.kitwtnb.kotlinnativetutorial.model.api.ApiClient
import io.ktor.client.HttpClient
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get
import io.ktor.client.request.request
import io.ktor.http.ContentType.Application.Json
import model.Results
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

    val firstBytes = client.get<Station>("https://webservice.recruit.co.jp/manabi/station/v2?prefecture=13&key=3e2b4a21beb30b57&format=json&start=0")

    val secondBytes = JSON.stringify(firstBytes);
    val obj = JSON.parse(Station.serializer(), secondBytes)

    client.close()

//
//    val client = OkHttpClient()
//    val request = Request.Builder()
//        .url("https://api.cryptowat.ch/markets/coinbase-pro/btcusd/ohlc")
//        .build()
//    val response= client.newCall(request).execute()
//    println(response.body())

    return obj.results.api_version

//    return "unko"
}
