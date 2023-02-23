package com.rafaelqueiroz

import org.scalatest.funsuite.AnyFunSuite

class FormattingTextSuite extends AnyFunSuite {
    private val expected = "In 1991, while studying computer science\nat University of Helsinki, Linus\nTorvalds began a project that later\nbecame the Linux kernel. He wrote the\nprogram specifically for the hardware he\nwas using and independent of an\noperating system because he wanted to\nuse the functions of his new PC with an\n80386 processor. Development was done on\nMINIX using the GNU C Compiler."

    test("Result format is equals to expected text") {
        val formattedText = FormattingText.formatText(FormattingText.TEXT, 40)
        assert(formattedText.equals(expected))
    }

    test("Result lines are lesser than limit") {
        val formattedText = FormattingText.formatText(FormattingText.TEXT, 40)
        assert(formattedText.indexOf("\n") <= 40)
    }
}
