import Input.Companion.capitalizeFirstLetter

class Notes {


    companion object {

        fun newSetCollection() {
            println("Задайте название Архиву:")
            var name = Input.userInputString()
            data.setOfNotes.put(key = name.lowercase(), mutableMapOf())
            println("Архив: ${name.lowercase().capitalizeFirstLetter()} добавлен")
        }


        fun showNotesList() {
            println("Список архивов:")
            for (i in data.setOfNotes) {
                println("[${i.key.lowercase().capitalizeFirstLetter()}]")
            }
        }

        fun newNote(choseArrNote: String) {
            if (!data.setOfNotes.containsKey(choseArrNote)) {data.setOfNotes[choseArrNote] = mutableMapOf() }
            var checkNames = true
            while (checkNames) {
                println("Введите название новой заметки:")
                val nameKey = Input.userInputString()
                var noteExists: Boolean = false
                if (data.setOfNotes[choseArrNote]!!.containsKey(nameKey)) {
                    noteExists = true
                }
                if (noteExists) {
                    println("Такое название заметки уже используется! Введите новое название:")
                } else {
                    println("Введите заметку:")
                    val fillNote = Input.ignoreCaseUserInputString()
                    val newNote = mutableMapOf(nameKey.lowercase() to fillNote)
                    data.setOfNotes[choseArrNote]!!.putAll(newNote)
                    println(
                        "Заметка '${
                            nameKey.lowercase().capitalizeFirstLetter()
                        }' добавлена в коллекцию '$choseArrNote'!\n"
                    )
                    checkNames = false
                }
            }
        }



        fun choseShowNote(choseArrNote: String) {
            val chosenCollection = data.setOfNotes[choseArrNote]
            if (chosenCollection != null && chosenCollection.isNotEmpty()) {
                while (true) {
                    println("Напишите название заметки для просмотра:")
                    val namesUser = Input.userInputString()
                    val getCollection = data.setOfNotes[choseArrNote]

                    if (!getCollection.isNullOrEmpty()) {
                        var noteFound = false
                        for (note in getCollection) {
                            if (!note.equals(namesUser)) {
                                println(
                                    "Имя заметки: ${namesUser.capitalizeFirstLetter()}\nСодержание: ${chosenCollection[namesUser].toString().capitalizeFirstLetter()}"
                                )
                                noteFound = true
                                break
                            }
                        }
                        if (noteFound) {
                            break
                        } else {
                            println("Неверный ввод, введите название заметки:")
                            displayNotes(choseArrNote)
                        }
                    }
                }
            } else {
                println("В этой коллекции нет заметок!\n")
            }
        }

        fun removeNote(choseArrNote: String) {
            while (true) {
                if (data.setOfNotes.keys.isNullOrEmpty()) {
                    println("Заметок в архиве, нет!")
                    break
                }
                println("Введите название заметки для удаления:")
                displayNotes(choseArrNote)
                var nameNotes = Input.userInputString()

                if (data.setOfNotes.get(choseArrNote)!!.containsKey(nameNotes)) {
                    data.setOfNotes.getValue(choseArrNote).remove(nameNotes)
                    println("Заметка ${nameNotes.lowercase().capitalizeFirstLetter()} удалена")
                    break
                } else {
                    println("Такой заметки в архиве нет!")
                }
            }
        }

        fun displayNotes(choseArrNote: String) {
            val chosenCollection = data.setOfNotes[choseArrNote]
            if (chosenCollection.isNullOrEmpty()) {
                println("В этом наборе нет заметок!\n")
            }
            if (chosenCollection != null && !chosenCollection.isNullOrEmpty()!!) {
                println("Список заметок в коллекции \"${choseArrNote.capitalizeFirstLetter()}\": ")
                for (note in chosenCollection.keys) {
                    println("[${note.capitalizeFirstLetter()}]")
                }

            }
        }

        fun choseArrBoolean(choseArrNote: String): Boolean {
            if (data.setOfNotes.containsKey(choseArrNote)) {
                return true
            } else {
                return false
            }
        }

    }
}

