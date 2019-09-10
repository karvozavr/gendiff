package ru.karvozavr.gendiff.app

import ru.karvozavr.gendiff.app.GenDiffApplication
import java.nio.file.Paths
import kotlin.system.exitProcess


fun main(argv: Array<String>) {
    if (argv.size != 2) {
        System.err.println("Usage: gendiff [source.java] [destination.java]")
        exitProcess(1)
    }

    val src = Paths.get(argv[0])
    val dst = Paths.get(argv[1])

    val application = GenDiffApplication(src, dst)
    application.run()
}

