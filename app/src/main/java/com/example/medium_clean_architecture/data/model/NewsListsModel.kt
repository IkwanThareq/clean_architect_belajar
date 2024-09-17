package com.example.medium_clean_architecture.data.model

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class NewsListsModel(
    @SerializedName("articles") var newsModel: List<NewsModel>
) : Parcelable {

}
