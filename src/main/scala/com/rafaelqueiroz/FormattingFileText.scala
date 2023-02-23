package com.rafaelqueiroz

import cats.effect.IO
import cats.effect.unsafe.implicits.global
import fs2.io.file.{Files, Path}
import fs2.{Stream, text}

class FormattingFileText(limit: Int) {

    def format(inputPath: String, outputPath: String): Unit =
        Files[IO]
            .readAll(Path(inputPath))
            .through(text.utf8.decode)
            .through(text.lines)
            .flatMap(line => Stream.apply(line.split(" ")))
            .map(_.foldLeft("")(WordAppender(_, _, limit)))
            .through(text.utf8.encode)
            .through(Files[IO].writeAll(Path(outputPath)))
            .compile
            .drain
            .unsafeRunSync()

}
