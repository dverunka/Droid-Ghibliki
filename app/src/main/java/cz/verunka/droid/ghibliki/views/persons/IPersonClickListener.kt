package cz.verunka.droid.ghibliki.views.persons

import cz.verunka.droid.ghibliki.db.model.Person

interface IPersonClickListener {

    fun onItemClick(person: Person)
}