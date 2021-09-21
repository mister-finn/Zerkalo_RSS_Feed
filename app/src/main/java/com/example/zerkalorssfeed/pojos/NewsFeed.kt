package com.example.zerkalorssfeed.pojos

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "rss", strict = false)
data class NewsFeed @JvmOverloads constructor(
    @field:Element(name = "channel")
    var channel: Channel? = null
)
