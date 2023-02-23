package com.rafaelqueiroz

import org.scalatest.funspec.AnyFunSpec

class FormattingTextSmootherSpec extends AnyFunSpec {


    describe("Given text") {
        val expected = "In 1991, while studying computer science\nat University of Helsinki, Linus\nTorvalds began a project that later\nbecame the Linux kernel. He wrote the\nprogram specifically for the hardware he\nwas using and independent of an\noperating system because he wanted to\nuse the functions of his new PC with an\n80386 processor. Development was done on\nMINIX using the GNU C Compiler."
        val text = FormattingText.TEXT

        it("Should format breaking lines at limit length") {
            val formatter = new FormattingTextSmoother(text, 40)
            val result = formatter()

            println(result)

            assertResult(expected)(result)
        }

    }

}
