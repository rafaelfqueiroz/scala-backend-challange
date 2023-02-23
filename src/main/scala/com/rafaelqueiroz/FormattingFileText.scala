package com.rafaelqueiroz

import cats.effect.IO
import cats.effect.unsafe.implicits.global
import fs2.io.file.{Files, Path}
import fs2.{Pipe, Stream, text}

class FormattingFileText(limit: Int) {

    def apply(inputPath: String, outputPath: String): Unit = {
        val source: Stream[IO, Byte] = Files[IO].readAll(Path(inputPath))

        val pipe: Pipe[IO, Byte, Byte] = src =>
                    src
                        .through(text.utf8.decode)
                        .through(text.lines)
                        .flatMap(line => Stream.apply(line.split(" ")))
                        .map(_.foldLeft("")(WordAppender(_, _, limit)))
                        .through(text.utf8.encode)

        val sink: Pipe[IO, Byte, Unit] = Files[IO].writeAll(Path(outputPath))

        source
            .through(pipe)
            .through(sink)
            .compile
            .drain
            .unsafeRunSync()
    }

}
