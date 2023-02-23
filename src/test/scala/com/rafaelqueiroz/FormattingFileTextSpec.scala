package com.rafaelqueiroz

import org.scalatest.funspec.AnyFunSpec

class FormattingFileTextSpec extends AnyFunSpec {

    describe("Given an input file path") {
        val resourcePath = "src/test/resources/"
        it("Should format inside text according to limit lines") {
            val formatter = new FormattingFileText(40)
            formatter.format(resourcePath+"input.txt", resourcePath+"output.txt")
        }
    }

}
