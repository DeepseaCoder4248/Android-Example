package com.puresoftware.aacmvvm

import android.util.Log

class ModelDatabase {

    // Model들의 List
    private var modelList = ArrayList<Model>()

    // 기본 Sample
    init {
        modelList.add(Model("Raychell", "25", "female"))
        modelList.add(Model("Mike", "19", "male"))
        modelList.add(Model("Pikachu", "un", "un"))
    }

    // 리스트 통째로 가져오기
    fun getList(): ArrayList<Model> {
        return modelList
    }

    // 리스트 통째로 등록하기
    fun setList(modelList: ArrayList<Model>) {
        this.modelList = modelList
    }

    // 리스트에 모델 추가하기
    fun addModel(model: Model) {
        modelList.add(model)
    }

    // 리스트에 모델 빼기
    fun removeModel(num: Int) {
        modelList.removeAt(num)
    }
}