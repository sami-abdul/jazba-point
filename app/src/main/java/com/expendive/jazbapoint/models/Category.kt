package com.expendive.jazbapoint.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Abdul Sami on 1/15/2018.
 */

class Category {
    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("slug")
    @Expose
    var slug: String? = null
    @SerializedName("parent")
    @Expose
    var parent: Int? = null
    @SerializedName("description")
    @Expose
    var description: String? = null
    @SerializedName("display")
    @Expose
    var display: String? = null
    @SerializedName("image")
    @Expose
    var image: CategoryImage? = null
    @SerializedName("menu_order")
    @Expose
    var menuOrder: Int? = null
    @SerializedName("count")
    @Expose
    var count: Int? = null
    @SerializedName("_links")
    @Expose
    var links: Links? = null

    override fun toString(): String {
        return "Category(id=$id, name=$name, slug=$slug, parent=$parent, description=$description, display=$display, image=$image, menuOrder=$menuOrder, count=$count, links=$links)"
    }
}

class CategoryImage {
    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("date_created")
    @Expose
    var dateCreated: String? = null
    @SerializedName("date_created_gmt")
    @Expose
    var dateCreatedGmt: String? = null
    @SerializedName("date_modified")
    @Expose
    var dateModified: String? = null
    @SerializedName("date_modified_gmt")
    @Expose
    var dateModifiedGmt: String? = null
    @SerializedName("src")
    @Expose
    var src: String? = null
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("alt")
    @Expose
    var alt: String? = null
}

class Collection {
    @SerializedName("href")
    @Expose
    var href: String? = null

    override fun toString(): String {
        return "Collection(href=$href)"
    }
}

class Links {
    @SerializedName("self")
    @Expose
    var self: List<Self>? = null
    @SerializedName("collection")
    @Expose
    var collection: List<Collection>? = null
    @SerializedName("up")
    @Expose
    var up: List<Up>? = null

    override fun toString(): String {
        return "Links(self=$self, collection=$collection, up=$up)"
    }
}

class Self {
    @SerializedName("href")
    @Expose
    var href: String? = null

    override fun toString(): String {
        return "Self(href=$href)"
    }
}

class Up {
    @SerializedName("href")
    @Expose
    var href: String? = null

    override fun toString(): String {
        return "Up(href=$href)"
    }
}