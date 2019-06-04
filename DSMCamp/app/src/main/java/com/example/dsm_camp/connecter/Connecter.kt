

//object Connecter{
//    var retrofit: Retrofit
//    var api: API
//    init {
//        val interceptor = HttpLoggingInterceptor()
//        interceptor.level = HttpLoggingInterceptor.Level.BODY
//        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
//        retrofit = Retrofit
//            .Builder()
//            .baseUrl("http://172.20.10.3:1212/api/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .client(client)
//            .build()
//
//        api = retrofit.create(API::class.java)
//    }
//
//    fun createAPI() = retrofit.create(API::class.java)
//}