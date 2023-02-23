package com.rafaelqueiroz

object WordAppender {

    def apply(accumulator: String, word: String, limit: Int): String = {
        val lineLength = accumulator.length - (accumulator.lastIndexOf("\n") + 1)

        val nextLength = lineLength + word.length + 1

        if (accumulator.isEmpty) {
            word
        } else if (nextLength <= limit) {
            accumulator + " " + word
        } else {
            accumulator + "\n" + word
        }
    }

}
