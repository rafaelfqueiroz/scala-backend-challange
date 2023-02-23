package com.rafaelqueiroz

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.must.Matchers.be
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

class FormattingTextSpec extends AnyFunSpec {
    private val expected = "In 1991, while studying computer science\nat University of Helsinki, Linus\nTorvalds began a project that later\nbecame the Linux kernel. He wrote the\nprogram specifically for the hardware he\nwas using and independent of an\noperating system because he wanted to\nuse the functions of his new PC with an\n80386 processor. Development was done on\nMINIX using the GNU C Compiler."

    describe("Formatting text") {
        it("Should be equals expected") {
            val formattedText = FormattingText.formatText(FormattingText.TEXT, 40)
            assertResult(formattedText)(expected)
        }

        it("Should have lines lesser than limit") {
            val formattedText = FormattingText.formatText(FormattingText.TEXT, 40)

            formattedText.indexOf("\n") should be <= 40
        }
    }

}
