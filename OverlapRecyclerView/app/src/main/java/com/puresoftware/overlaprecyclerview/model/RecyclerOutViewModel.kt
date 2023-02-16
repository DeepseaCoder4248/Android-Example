package com.puresoftware.overlaprecyclerview.model

data class RecyclerOutViewModel(
    var title: String,
    var innerList: MutableList<RecyclerInViewModel>
) {
}