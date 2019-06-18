package com.example.animalcare

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.animalcare.database.entities.ley_entity
import com.example.animalcare.database.entities.org_entity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModelRoom(context: Application): AndroidViewModel(context){
    private val repository: Repository
    init{
        val leyDao= RoomDB.getInstance(context).leyDao()
        val orgDao= RoomDB.getInstance(context).orgDao()
        repository=  Repository(orgDao, leyDao)
    }



    fun getLeyBy(ley: String): LiveData<ley_entity> {
        return  repository.getLey(ley)
    }


    fun getOrgBy(org: String): LiveData<org_entity> {
        return  repository.getorg(org)
    }

    fun getAllLeyes(): LiveData<List<ley_entity>>{
        return repository.getAllLeyes()
    }
    fun getAllOrgs(): LiveData<List<org_entity>> {
        return repository.getAllOrg()

    }
}
