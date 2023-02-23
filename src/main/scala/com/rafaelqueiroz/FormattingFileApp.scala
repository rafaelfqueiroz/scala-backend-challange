package com.rafaelqueiroz

import cats.effect.{IO, IOApp}

object FormattingFileApp extends IOApp.Simple {

    override def run: IO[Unit] = {
        val formatter = new FormattingFileText(40)
        formatter
            .format("src/test/resources/input.txt", "src/test/resources/output.txt")
    }

}
