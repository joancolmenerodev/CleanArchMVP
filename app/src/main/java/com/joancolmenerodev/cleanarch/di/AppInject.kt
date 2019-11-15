package com.joancolmenerodev.cleanarch.di

import com.joancolmenerodev.di.DataInject
import com.joancolmenerodev.di.DomainInject
import org.kodein.di.Kodein

object AppInject {

    fun modules() : List<Kodein.Module> = ArrayList<Kodein.Module>().apply {
        addAll(DataInject.modules())
        addAll(DomainInject.modules())
    }
}