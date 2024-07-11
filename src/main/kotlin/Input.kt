
import java.util.Scanner

class Input {


    companion object {
        fun userInputString(): String {
            var input = Scanner(System.`in`).nextLine().lowercase().trim()
            while (input.isNullOrEmpty()) {
                if (!input.isNullOrEmpty()) {
                    continue
                } else {
                    println("Ввод не может быть пустым. Пожалуйста, введите хотя бы один символ.")
                    input = Scanner(System.`in`).nextLine()
                }
            }
            return input
        }

        fun ignoreCaseUserInputString(): String {
            var input = Scanner(System.`in`).nextLine().trim()
            while (input.isNullOrEmpty()) {
                if (!input.isNullOrEmpty()) {
                    continue
                } else {
                    println("Ввод не может быть пустым. Пожалуйста, введите хотя бы один символ.")
                    input = Scanner(System.`in`).nextLine()
                }
            }
            return input
        }

        fun userInputInteger(): Int {
            val scanner = Scanner(System.`in`)
            while (true) {
                print("Введите номер действия: ")
                val input = try {
                    scanner.nextInt()
                } catch (e: Exception) {
                    println("Ошибка ввода, пожалуйста, введите целое число.")
                    scanner.nextLine() // Очистка неверного ввода
                    continue
                }
                if (input in 1..4) {
                    return input
                } else if (input.toString().trim().isNullOrEmpty()) {
                    println("Введите корректное значение!")
                } else {
                    println("Вы ввели неверное значение, пожалуйста, введите число от 1 до 9.")
                }
            }
        }

        fun String.capitalizeFirstLetter(): String {
            if (this.isEmpty()) return this
            return this[0].uppercaseChar() + this.substring(1)
        }
    }
}

