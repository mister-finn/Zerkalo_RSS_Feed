package com.example.zerkalorssfeed.pojos

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "channel", strict = false)
data class Channel @JvmOverloads constructor(
    @field:Element(name  = "lastBuildDate")
    var lastBuildDate : String? = null,
    @field:ElementList(inline = true)
    var itemList: List<Item>? = null
)