package com.rafaelqueiroz

class FormattingTextSmoother(text: String, limit: Int) {

    def apply(): String = text.split(" ").foldLeft("")(WordAppender(_,_, limit))

}
