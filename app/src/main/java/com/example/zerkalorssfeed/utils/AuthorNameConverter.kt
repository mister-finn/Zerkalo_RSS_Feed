package com.example.zerkalorssfeed.utils

import androidx.room.TypeConverter
import com.example.zerkalorssfeed.pojos.Author

class AuthorNameConverter {
    @TypeConverter
    fun authorNamesToString(authorNames: MutableList<Author>?): String? =
        authorNames?.map { it.name }?.joinToString(",")

    @TypeConverter
    fun stringToAuthorNames(stringOfNames: String?): List<Author> {
        val result = mutableListOf<Author>()
        stringOfNames?.split(",")?.map { result.add(Author(it)) }
        return result
    }
}