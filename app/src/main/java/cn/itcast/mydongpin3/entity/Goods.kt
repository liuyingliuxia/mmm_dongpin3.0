package cn.itcast.mydongpin3.entity

import java.io.Serializable

class Goods :Serializable {
    var imgPath : String = " "
    var goodsName :String = " "
    var goodsSpecifi = " "
    var goodsPrice = " "
    var pageView = " "

    constructor(
        imgPath: String,
        goodsName: String,
        goodsSpecifi: String,
        goodsPrice: String,
        pageView: String
    ) {
        this.imgPath = imgPath
        this.goodsName = goodsName
        this.goodsSpecifi = goodsSpecifi
        this.goodsPrice = goodsPrice
        this.pageView = pageView
    }
    constructor(
    ) {
    }

    override fun toString(): String {
        return "goods(imgPath='$imgPath', goodsName='$goodsName', goodsSpecifi='$goodsSpecifi', goodsPrice='$goodsPrice', pageView='$pageView')"
    }
}