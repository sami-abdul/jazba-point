package com.expendive.jazbapoint.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ProductSelf {
    @SerializedName("href")
    @Expose
    var href: String? = null
}

class MetaDatum {
    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("key")
    @Expose
    var key: String? = null
    @SerializedName("value")
    @Expose
    var value: String? = null
}

class ProductLinks {
    @SerializedName("self")
    @Expose
    var self: List<Self>? = null
    @SerializedName("collection")
    @Expose
    var collection: List<Collection>? = null
}

class ProductCollection {
    @SerializedName("href")
    @Expose
    var href: String? = null
}

class ProductImage {
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
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("alt")
    @Expose
    var alt: String? = null
    @SerializedName("position")
    @Expose
    var position: Int? = null
}

class ProductCategory {
    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("slug")
    @Expose
    var slug: String? = null

    override fun toString(): String {
        return "ProductCategory(id=$id, name=$name, slug=$slug)"
    }
}

class Dimensions {
    @SerializedName("length")
    @Expose
    var length: String? = null
    @SerializedName("width")
    @Expose
    var width: String? = null
    @SerializedName("height")
    @Expose
    var height: String? = null
}

class Product {
    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("slug")
    @Expose
    var slug: String? = null
    @SerializedName("permalink")
    @Expose
    var permalink: String? = null
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
    @SerializedName("type")
    @Expose
    var type: String? = null
    @SerializedName("status")
    @Expose
    var status: String? = null
    @SerializedName("featured")
    @Expose
    var featured: Boolean = false
    @SerializedName("catalog_visibility")
    @Expose
    var catalogVisibility: String? = null
    @SerializedName("description")
    @Expose
    var description: String? = null
    @SerializedName("short_description")
    @Expose
    var shortDescription: String? = null
    @SerializedName("sku")
    @Expose
    var sku: String? = null
    @SerializedName("price")
    @Expose
    var price: String? = null
    @SerializedName("regular_price")
    @Expose
    var regularPrice: String? = null
    @SerializedName("sale_price")
    @Expose
    var salePrice: String? = null
    @SerializedName("date_on_sale_from")
    @Expose
    var dateOnSaleFrom: Any? = null
    @SerializedName("date_on_sale_from_gmt")
    @Expose
    var dateOnSaleFromGmt: Any? = null
    @SerializedName("date_on_sale_to")
    @Expose
    var dateOnSaleTo: Any? = null
    @SerializedName("date_on_sale_to_gmt")
    @Expose
    var dateOnSaleToGmt: Any? = null
    @SerializedName("price_html")
    @Expose
    var priceHtml: String? = null
    @SerializedName("on_sale")
    @Expose
    var onSale: Boolean? = null
    @SerializedName("purchasable")
    @Expose
    var purchasable: Boolean? = null
    @SerializedName("total_sales")
    @Expose
    var totalSales: Int? = null
    @SerializedName("virtual")
    @Expose
    var virtual: Boolean? = null
    @SerializedName("downloadable")
    @Expose
    var downloadable: Boolean? = null
    @SerializedName("downloads")
    @Expose
    var downloads: List<Any>? = null
    @SerializedName("download_limit")
    @Expose
    var downloadLimit: Int? = null
    @SerializedName("download_expiry")
    @Expose
    var downloadExpiry: Int? = null
    @SerializedName("external_url")
    @Expose
    var externalUrl: String? = null
    @SerializedName("button_text")
    @Expose
    var buttonText: String? = null
    @SerializedName("tax_status")
    @Expose
    var taxStatus: String? = null
    @SerializedName("tax_class")
    @Expose
    var taxClass: String? = null
    @SerializedName("manage_stock")
    @Expose
    var manageStock: Boolean? = null
    @SerializedName("stock_quantity")
    @Expose
    var stockQuantity: Any? = null
    @SerializedName("in_stock")
    @Expose
    var inStock: Boolean = true
    @SerializedName("backorders")
    @Expose
    var backorders: String? = null
    @SerializedName("backorders_allowed")
    @Expose
    var backordersAllowed: Boolean? = null
    @SerializedName("backordered")
    @Expose
    var backordered: Boolean? = null
    @SerializedName("sold_individually")
    @Expose
    var soldIndividually: Boolean? = null
    @SerializedName("weight")
    @Expose
    var weight: String? = null
    @SerializedName("dimensions")
    @Expose
    var dimensions: Dimensions? = null
    @SerializedName("shipping_required")
    @Expose
    var shippingRequired: Boolean? = null
    @SerializedName("shipping_taxable")
    @Expose
    var shippingTaxable: Boolean? = null
    @SerializedName("shipping_class")
    @Expose
    var shippingClass: String? = null
    @SerializedName("shipping_class_id")
    @Expose
    var shippingClassId: Int? = null
    @SerializedName("reviews_allowed")
    @Expose
    var reviewsAllowed: Boolean? = null
    @SerializedName("average_rating")
    @Expose
    var averageRating: String? = null
    @SerializedName("rating_count")
    @Expose
    var ratingCount: Int? = null
    @SerializedName("related_ids")
    @Expose
    var relatedIds: List<Int>? = null
    @SerializedName("upsell_ids")
    @Expose
    var upsellIds: List<Any>? = null
    @SerializedName("cross_sell_ids")
    @Expose
    var crossSellIds: List<Any>? = null
    @SerializedName("parent_id")
    @Expose
    var parentId: Int? = null
    @SerializedName("purchase_note")
    @Expose
    var purchaseNote: String? = null
    @SerializedName("categories")
    @Expose
    var categories: List<ProductCategory>? = null
    @SerializedName("tags")
    @Expose
    private var tags: List<Any>? = null
    @SerializedName("images")
    @Expose
    private var images: List<ProductImage>? = null
    @SerializedName("attributes")
    @Expose
    private var attributes: List<Any>? = null
    @SerializedName("default_attributes")
    @Expose
    private var defaultAttributes: List<Any>? = null
    @SerializedName("variations")
    @Expose
    private var variations: List<Any>? = null
    @SerializedName("grouped_products")
    @Expose
    private var groupedProducts: List<Any>? = null
    @SerializedName("menu_order")
    @Expose
    private var menuOrder: Int? = null
    @SerializedName("_links")
    @Expose
    private var links: Links? = null

    override fun toString() =
            "Product(id=$id, name=$name, slug=$slug, permalink=$permalink, dateCreated=$dateCreated, dateCreatedGmt=$dateCreatedGmt, dateModified=$dateModified, dateModifiedGmt=$dateModifiedGmt, type=$type, status=$status, featured=$featured, catalogVisibility=$catalogVisibility, description=$description, shortDescription=$shortDescription, sku=$sku, price=$price, regularPrice=$regularPrice, salePrice=$salePrice, dateOnSaleFrom=$dateOnSaleFrom, dateOnSaleFromGmt=$dateOnSaleFromGmt, dateOnSaleTo=$dateOnSaleTo, dateOnSaleToGmt=$dateOnSaleToGmt, priceHtml=$priceHtml, onSale=$onSale, purchasable=$purchasable, totalSales=$totalSales, virtual=$virtual, downloadable=$downloadable, downloads=$downloads, downloadLimit=$downloadLimit, downloadExpiry=$downloadExpiry, externalUrl=$externalUrl, buttonText=$buttonText, taxStatus=$taxStatus, taxClass=$taxClass, manageStock=$manageStock, stockQuantity=$stockQuantity, inStock=$inStock, backorders=$backorders, backordersAllowed=$backordersAllowed, backordered=$backordered, soldIndividually=$soldIndividually, weight=$weight, dimensions=$dimensions, shippingRequired=$shippingRequired, shippingTaxable=$shippingTaxable, shippingClass=$shippingClass, shippingClassId=$shippingClassId, reviewsAllowed=$reviewsAllowed, averageRating=$averageRating, ratingCount=$ratingCount, relatedIds=$relatedIds, upsellIds=$upsellIds, crossSellIds=$crossSellIds, parentId=$parentId, purchaseNote=$purchaseNote, categories=$categories)"
}