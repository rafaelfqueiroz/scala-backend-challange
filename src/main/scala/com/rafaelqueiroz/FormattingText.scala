package com.rafaelqueiroz

object FormattingText {

    private val SPLITERATOR = " "
    val TEXT = "In 1991, while studying computer science at University of Helsinki, Linus Torvalds began a project that later became the Linux kernel. He wrote the program specifically for the hardware he was using and independent of an operating system because he wanted to use the functions of his new PC with an 80386 processor. Development was done on MINIX using the GNU C Compiler."

    private def appendLine(words: Array[String], index: Int, line: String, accumulator: String, limit: Int): String = {
        if (index == words.length) {
            return accumulator+line
        }

        val word = words(index)
        val tempLine =
            if (line.isEmpty)
                word
            else
                line + " " + word

        val next = index+1
        if (tempLine.length <= limit) {
            appendLine(words, next, tempLine, accumulator, limit)
        } else {
            appendLine(words, index, "", accumulator+line+"\n", limit)
        }
    }

    def formatText(text: String, limit: Int) = {
        val accumulator: String = ""
        val line: String = ""

        val allWords = text.split(SPLITERATOR)

        val index = 0
        val formattedText = appendLine(allWords, index, line, accumulator, limit)

        formattedText
    }

}
