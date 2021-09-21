package com.example.zerkalorssfeed.pojos

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Entity(
    tableName = "rss_item",
    indices = [Index(value = ["title"], unique = true), Index(value = ["id"], unique = true)]
)
@Root(name = "item", strict = false)
data class Item @JvmOverloads constructor(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,

    @field:Element(name = "title")
    var title: String? = null,

    @field:Element(name = "link")
    var link: String? = null,

    @field:Element(name = "description")
    var descriptionWithImage: String? = null,

    var description: String? = null,


    @field:ElementList(inline = true, required = false)
    var authorList: MutableList<Author>? = null,

    @field:Element(name = "pubDate")
    var pubDate: String? = null,

    @field:Element(name = "category")
    var category: String? = null,

    var section: String? = null,

    var timeStamp: Long? = null,

    var isRead: Boolean = false
)