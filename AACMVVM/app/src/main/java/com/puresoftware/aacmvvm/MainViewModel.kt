package com.puresoftware.aacmvvm

import android.util.Log
import android.view.Display.Mode
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

// ViewModel
class MainViewModel : ViewModel() {

    // MutableData와 Database
    private var _data = MutableLiveData<String>() // View에 뿌리기 때문에 자료형임
    private var modelDatabase = ModelDatabase() // Model이 담긴 Database

    private var count = 0 // Button을 누르면 1씩 증가하는 것.

    // Get
    val info: LiveData<String> // View에 뿌리기 때문에 자료형임
        get() = _data // View에 뿌릴 것.

    // Set(Main에서 DB 받기)
    fun setDatabase(modelDatabase: ModelDatabase) {
        this.modelDatabase = modelDatabase
    }

    // Button으로 OnClick하면 작동되는 것.
    fun next() {
        var modelList = modelDatabase.getList()
        _data.value = modelList[count].getModelInfo()
        count = ++count

        // 만약 count가 modellist의 size보다 크게 된다면 오류가 발생하므로 0 처리.
        if (count > modelList.size - 1) {
            count = 0
        }
    }
}
// 다른 Class에서 접근하면 안되는 것들은 private를 붙여야 한다.
// next나 setDatabase info등은 어디에서 한번씩은 접근하므로 써야 한다.