package ru.karvozavr.gendiff.app

import ru.karvozavr.gendiff.generators.ASTGenerator
import ru.karvozavr.gendiff.generators.DiffGenerator
import java.nio.file.Files
import java.nio.file.Path

class GenDiffApplication(private val src: Path, private val dst: Path) {

    private val diffGenerator = DiffGenerator()
    private val treeGenerator = ASTGenerator()

    fun run() {
        if (Files.exists(src) && Files.exists(dst)) {
            printAst(src.toString())
            printAst(dst.toString())
            printDiff(src.toString(), dst.toString())
            diffGenerator.showHTMLDiff(src.toString(), dst.toString())
        } else {
            System.err.println("ERROR: file does not exist.")
        }
    }

    private fun printDiff(src: String, dst: String) {
        println("===== Diff of $src tree to $dst tree =====")
        diffGenerator.generateDiff(src, dst).forEach { println(it) }
        println()
    }

    private fun printAst(file: String) {
        println("===== AST of $file =====")
        println(treeGenerator.generate(file))
        println()
    }
}