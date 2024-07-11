
fun main() {
    while (true) {
        ShowChoseWay.choseWay1Gen()
        when (Input.userInputInteger()) {
            1 -> {
                Notes.showNotesList()
                if (data.setOfNotes.isNullOrEmpty()) {
                    println("Список архивов пуст! Сначала добавьте, архив!")
                } else {
                    ShowChoseWay.choseWayPreGen()
                    while (true) {
                        var choseArrNote: String = Input.userInputString()
                        if (choseArrNote.contains("2")) {
                            break
                        }
                        while (true) {
                            when (choseArrNote.lowercase()) {
                                in data.setOfNotes.keys -> {
                                    var checkWay = true
                                    if (checkWay) {
                                        ShowChoseWay.choseWay2Gen()
                                        when (Input.userInputInteger()) {
                                            1 -> Notes.newNote(choseArrNote)
                                            2 -> Notes.removeNote(choseArrNote)
                                            3 -> {
                                                Notes.displayNotes(choseArrNote)
                                                Notes.choseShowNote(choseArrNote)
                                            }

                                            4 -> {
                                                ShowChoseWay.choseWayPreGen()
                                                checkWay == false
                                                break

                                            }
                                        }
                                    }
                                }

                                "2" -> break
                                else -> {
                                    if (!Notes.choseArrBoolean(choseArrNote)) {
                                        println("Такого набора заметок нет! Либо некорректный ввод!")
                                        choseArrNote = Input.userInputString()
                                    }
                                }
                            }
                        }
                        break
                    }
                }
            }

            2 -> {
                Notes.showNotesList()
                Notes.newSetCollection()
            }

            3 -> break
            else -> continue
        }
    }
}