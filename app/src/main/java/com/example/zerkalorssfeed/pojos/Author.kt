package com.example.zerkalorssfeed.pojos

import org.simpleframework.xml.Element
import org.simpleframework.xml.Namespace
import org.simpleframework.xml.Root

@Root(name = "author", strict = false)
@Namespace(reference = "http://www.w3.org/2005/Atom", prefix = "atom")
data class Author @JvmOverloads constructor(
    @field:Element(name = "name")
    var name: String? = null,
)
