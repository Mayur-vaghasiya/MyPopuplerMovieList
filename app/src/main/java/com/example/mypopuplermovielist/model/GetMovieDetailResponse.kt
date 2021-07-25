package com.example.mypopuplermovielist.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


class GetMovieDetailResponse : Serializable {
    @SerializedName("adult")
    @Expose
    private var adult = false

    @SerializedName("backdrop_path")
    @Expose
    private var backdropPath: String? = null

    @SerializedName("belongs_to_collection")
    @Expose
    private var belongsToCollection: Any? = null

    @SerializedName("budget")
    @Expose
    private var budget = 0

    @SerializedName("genres")
    @Expose
    private var genres: List<Genre?>? = null

    @SerializedName("homepage")
    @Expose
    private var homepage: String? = null

    @SerializedName("id")
    @Expose
    private var id = 0

    @SerializedName("imdb_id")
    @Expose
    private var imdbId: String? = null

    @SerializedName("original_language")
    @Expose
    private var originalLanguage: String? = null

    @SerializedName("original_title")
    @Expose
    private var originalTitle: String? = null

    @SerializedName("overview")
    @Expose
    private var overview: String? = null

    @SerializedName("popularity")
    @Expose
    private var popularity = 0f

    @SerializedName("poster_path")
    @Expose
    private var posterPath: String? = null

    @SerializedName("production_companies")
    @Expose
    private var productionCompanies: List<ProductionCompany?>? = null

    @SerializedName("production_countries")
    @Expose
    private var productionCountries: List<ProductionCountry?>? = null

    @SerializedName("release_date")
    @Expose
    private var releaseDate: String? = null

    @SerializedName("revenue")
    @Expose
    private var revenue = 0

    @SerializedName("runtime")
    @Expose
    private var runtime = 0

    @SerializedName("spoken_languages")
    @Expose
    private var spokenLanguages: List<SpokenLanguage?>? = null

    @SerializedName("status")
    @Expose
    private var status: String? = null

    @SerializedName("tagline")
    @Expose
    private var tagline: String? = null

    @SerializedName("title")
    @Expose
    private var title: String? = null

    @SerializedName("video")
    @Expose
    private var video = false

    @SerializedName("vote_average")
    @Expose
    private var voteAverage = 0f

    @SerializedName("vote_count")
    @Expose
    private var voteCount = 0
    private val serialVersionUID = 3641062122858162672L

    fun isAdult(): Boolean {
        return adult
    }

    fun setAdult(adult: Boolean) {
        this.adult = adult
    }

    fun getBackdropPath(): String? {
        return backdropPath
    }

    fun setBackdropPath(backdropPath: String?) {
        this.backdropPath = backdropPath
    }

    fun getBelongsToCollection(): Any? {
        return belongsToCollection
    }

    fun setBelongsToCollection(belongsToCollection: Any?) {
        this.belongsToCollection = belongsToCollection
    }

    fun getBudget(): Int {
        return budget
    }

    fun setBudget(budget: Int) {
        this.budget = budget
    }

    fun getGenres(): List<Genre?>? {
        return genres
    }

    fun setGenres(genres: List<Genre?>?) {
        this.genres = genres
    }

    fun getHomepage(): String? {
        return homepage
    }

    fun setHomepage(homepage: String?) {
        this.homepage = homepage
    }

    fun getId(): Int {
        return id
    }

    fun setId(id: Int) {
        this.id = id
    }

    fun getImdbId(): String? {
        return imdbId
    }

    fun setImdbId(imdbId: String?) {
        this.imdbId = imdbId
    }

    fun getOriginalLanguage(): String? {
        return originalLanguage
    }

    fun setOriginalLanguage(originalLanguage: String?) {
        this.originalLanguage = originalLanguage
    }

    fun getOriginalTitle(): String? {
        return originalTitle
    }

    fun setOriginalTitle(originalTitle: String?) {
        this.originalTitle = originalTitle
    }

    fun getOverview(): String? {
        return overview
    }

    fun setOverview(overview: String?) {
        this.overview = overview
    }

    fun getPopularity(): Float {
        return popularity
    }

    fun setPopularity(popularity: Float) {
        this.popularity = popularity
    }

    fun getPosterPath(): String? {
        return posterPath
    }

    fun setPosterPath(posterPath: String?) {
        this.posterPath = posterPath
    }

    fun getProductionCompanies(): List<ProductionCompany?>? {
        return productionCompanies
    }

    fun setProductionCompanies(productionCompanies: List<ProductionCompany?>?) {
        this.productionCompanies = productionCompanies
    }

    fun getProductionCountries(): List<ProductionCountry?>? {
        return productionCountries
    }

    fun setProductionCountries(productionCountries: List<ProductionCountry?>?) {
        this.productionCountries = productionCountries
    }

    fun getReleaseDate(): String? {
        return releaseDate
    }

    fun setReleaseDate(releaseDate: String?) {
        this.releaseDate = releaseDate
    }

    fun getRevenue(): Int {
        return revenue
    }

    fun setRevenue(revenue: Int) {
        this.revenue = revenue
    }

    fun getRuntime(): Int {
        return runtime
    }

    fun setRuntime(runtime: Int) {
        this.runtime = runtime
    }

    fun getSpokenLanguages(): List<SpokenLanguage?>? {
        return spokenLanguages
    }

    fun setSpokenLanguages(spokenLanguages: List<SpokenLanguage?>?) {
        this.spokenLanguages = spokenLanguages
    }

    fun getStatus(): String? {
        return status
    }

    fun setStatus(status: String?) {
        this.status = status
    }

    fun getTagline(): String? {
        return tagline
    }

    fun setTagline(tagline: String?) {
        this.tagline = tagline
    }

    fun getTitle(): String? {
        return title
    }

    fun setTitle(title: String?) {
        this.title = title
    }

    fun isVideo(): Boolean {
        return video
    }

    fun setVideo(video: Boolean) {
        this.video = video
    }

    fun getVoteAverage(): Float {
        return voteAverage
    }

    fun setVoteAverage(voteAverage: Float) {
        this.voteAverage = voteAverage
    }

    fun getVoteCount(): Int {
        return voteCount
    }

    fun setVoteCount(voteCount: Int) {
        this.voteCount = voteCount
    }

    class Genre : Serializable {
        @SerializedName("id")
        @Expose
        var id = 0

        @SerializedName("name")
        @Expose
        var name: String? = null
    }

    class ProductionCompany : Serializable {
        @SerializedName("id")
        @Expose
        var id = 0

        @SerializedName("logo_path")
        @Expose
        var logoPath: String? = null

        @SerializedName("name")
        @Expose
        var name: String? = null

        @SerializedName("origin_country")
        @Expose
        var originCountry: String? = null
    }

    class ProductionCountry : Serializable {
        @SerializedName("iso_3166_1")
        @Expose
        var iso31661: String? = null

        @SerializedName("name")
        @Expose
        var name: String? = null
    }

    class SpokenLanguage : Serializable {
        @SerializedName("english_name")
        @Expose
        var englishName: String? = null

        @SerializedName("iso_639_1")
        @Expose
        var iso6391: String? = null

        @SerializedName("name")
        @Expose
        var name: String? = null
    }
}