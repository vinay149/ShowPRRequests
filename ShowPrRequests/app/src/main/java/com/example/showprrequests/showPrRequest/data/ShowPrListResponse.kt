package com.example.showprrequests.showPrRequest.data

data class ShowPrListResponse(val created_at:String?=null,val title:String="",val closed_at:String?=null, val user: User?=null)

data class User(val login:String?=null,val avatar_url:String?=null)
