/**
 * @author github.com/jamesdeperio
 * @version codepocket template builder v1.0
 */
package io.github.jamesdeperio.architecture.integration.network

import android.content.Context
import com.google.gson.GsonBuilder
import com.tickaroo.tikxml.TikXml
import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory
import jdp.retrofitkit.RetrofitManager
import jdp.retrofitkit.SerializationFormatFactory
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class NetworkManager(context: Context) : RetrofitManager(context) {
    /*
     * Declare network repository just like this.
     */
    val restRepository:RestRepository = create(RestRepository::class.java) as RestRepository

    override fun initBaseURL(): String = "http://www.mocky.io/v2/"

    override fun initCacheSize(): Int = 0

    /*
     * MultipleConverterFactory (SerializationFormatFactory) was set so you need to identify each request which will return json and xml format bu using annotation(@JSONFormat or @XMLFormat).
     */
    override fun initConverterFactory(): Converter.Factory = SerializationFormatFactory.Builder()
            .setXMLConverterFactory(TikXmlConverterFactory.create(TikXml.Builder().exceptionOnUnreadXml(false).build()))
            .setJSONConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .build()


    /*
     * Set the callAdapterFactory (you can use rxjava or kotlinX)
     */
    override fun initCallAdapterFactory(): CallAdapter.Factory = RxJava2CallAdapterFactory.create()

    /*
     * Logs of Network request will be printed on the logcat
     */
    override fun isPrintLogEnabled(): Boolean = true
}
